package com.wisdom.controller.manager;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wisdom.dao.manager.ModuleRepository;
import com.wisdom.entity.manager.Module;
import com.wisdom.service.manager.ModuleService;
import com.wisdom.tools.Result;


@RestController
@RequestMapping(value = "/module", name = "模块管理")
public class ModuleController {

	@Autowired
	ModuleRepository moduleRepository;

	@Autowired
	ModuleService moduleService;

	/**
	  *   添加和修改模块
	 * http://localhost:8080/module/saveModule?rolecreatetime=2018-11-16%2014:57:00&roleexplain=阿萨德&rolename=咨询经理&id=1
	 * 
	 * @param module
	 * @return
	 */
	@RequestMapping(value = "/saveModule", name = "添加和修改模块")
	public Object saveRole(Module module) {
		List<Module> moduleList = moduleRepository.findAll();
		for (Module m : moduleList) {
			if(m.getModulename().equals(module.getModulename())) {
				return new Result("模块已存在",0);
			}
		}
		if(module.getId() == null) {
			module.setStatus(1);
			return new Result(moduleRepository.save(module));
		}else {
			Module mod = moduleRepository.findOne(module.getId());
			mod.setModulename(module.getModulename());
			mod.setModuleurl(module.getModuleurl());
			mod.setModuleweight(module.getModuleweight());	
			return new Result(moduleRepository.save(mod));
		}
		
		
	}

	@RequestMapping(value = "/findModuleById", name = "根据id获取模块")
	public Object findModuleById(Integer id) {

		return moduleRepository.findOne(id);
	}

	// ^^^^^^^^^^^^^^^^^^^^^^^^module的级联删除^^^^^^^^^^^^^^^^^^^^^^^^^^

	@RequestMapping(value = "/deleteModule", name = "删除模块")
	public Object deleteModule(Module module) {

		Module mod = moduleRepository.findOne(module.getId());

		mod.setStatus(module.getStatus());

		this.deleteChildren(mod);
		return moduleRepository.save(mod);
	}

	private void deleteChildren(Module module) {

		List<Module> childrenList = new ArrayList<>();
		childrenList = moduleService.findByParentidAndStatusOrderByModuleweightDesc(module.getId(), 1);
		if (childrenList != null && !childrenList.isEmpty()) {
			module.setChildren(childrenList);
			for (Module m : childrenList) {
				this.deleteChildren(m);
				m.setStatus(0);
				System.out.println("this=>" + m);
				if (m.getParentid() == module.getId() && m.getChildren() == null) {
					moduleRepository.save(m);
				}
			}
		}

	}

	// ^^^^^^^^^^^^^^^^^^^^^^^^给模块管理的moduleTree^^^^^^^^^^^^^^^^^^^^^^^^^^
	
	Set<Integer> fatherIdsList = new HashSet();

	@RequestMapping(value = "/findAll", name = "获取所有模块")
	public Object findAll(String modulename, Integer page, Integer rows) {

		Set<Integer> rootIds = new HashSet();// 符合条件的根节点的id集合
		Set<Integer> moduleIds = new HashSet();// 角色拥有的模块id
		List<Module> rootList = new ArrayList();// 符合条件的根节点

		/* 所有符合条件的模块 */
		List<Module> moduleList = moduleService.findByModulenameLikeAndStatus("%" + modulename + "%",1);

		/* 获取符合条件的的模块的Id集合 */
		for (Module module : moduleList) {
			moduleIds.add(module.getId());
		}
		
		fatherIdsList.clear();//清空全局父id的集合
		
		/* 查询出所有满足条件的id的所有祖先id集合  */
		for (Integer id : moduleIds) {
			rootIds.add(this.queryParentIdById(id));
		}
		/* 根据根菜单的id集合获取所有符合条件的根节点  */
		rootList = moduleService.findByIdInOrderByModuleweightDesc(rootIds);

		/* 递归设置子节点并分页 */
        List pageList = new ArrayList<>();
        Integer start = (page-1)*rows;
        Integer end = (page-1)*rows+rows;
        if(end>rootList.size()) {
        	end = rootList.size();
        }     	
        pageList = rootList.subList(start, end);
		this.setTreeGridChildren(pageList, fatherIdsList);
		
		Map<String,Object> map = new HashMap();
		map.put("total", rootList.size());
		map.put("rows", pageList);	
		return map;
	}

	private void setTreeGridChildren(List<Module> parentList, Set<Integer> likeList) {
		for (Module m : parentList) {
			// 查询出子菜单
			List<Module> childrenList = moduleService.findByParentidAndIdInOrderByModuleweightDesc(m.getId(), likeList);
			// 如果没有子菜单则递归结束
			if (childrenList != null && !childrenList.isEmpty()) {// 有子菜单
				// 设置子菜单
				m.setChildren(childrenList);
				// 如果有子菜单则继续递归设置子菜单
				this.setTreeGridChildren(childrenList, likeList);
			}
		}
	}

	private Integer queryParentIdById(Integer moduleId) {
		Module module = moduleService.findByIdAndStatus(moduleId,1);// 查找父id
		fatherIdsList.add(moduleId);// 把低级节点的id存入集合
		if(module == null) {
			return moduleId;
		}else {
			Integer parentId = module.getParentid();
			if (parentId == 0) {
				fatherIdsList.add(moduleId) ;
				return moduleId;
			} else {
				return this.queryParentIdById(parentId);
			}
		}
	}


	// ^^^^^^^^^^^^^^^^^^^^^^^^给用角色设置模块的moduleTree^^^^^^^^^^^^^^^^^^^^^^^^^^

	@RequestMapping(value = "/findRoleModules", name = "获取角色模块")
	public Object findRoleModules(@RequestParam(value = "roleId", required = false) Integer roleId) {

		List<Integer> moduleIds = new ArrayList();// 角色拥有的模块id
		List<Module> rootList = new ArrayList();// 所有的根节点

		/* 获取角色拥有的模块 */
		List<Module> moduleList = moduleService.findModuleByRoleId(roleId);

		/* 获取角色拥有的moduleid */
		for (Module module : moduleList) {
			moduleIds.add(module.getId());
		}

		/* 获取所有根节点 */
		rootList = moduleService.findByParentidAndStatusOrderByModuleweightDesc(0, 1);
		this.setChildren(rootList, moduleIds);

		return rootList;
	}

	private void setChildren(List<Module> rootList, List<Integer> moduleIds) {

		for (Module module : rootList) {
			List<Module> childrenList = new ArrayList<>();
			childrenList = moduleService.findByParentidAndStatusOrderByModuleweightDesc(module.getId(), 1);
			if (childrenList != null && !childrenList.isEmpty()) {
				module.setChildren(childrenList);
				this.setChildren(childrenList, moduleIds);
				for (Module m : childrenList) {
					System.out.println("this=>" + m);
					if (moduleIds.contains(m.getId()) && m.getChildren() == null) {
						m.setChecked(true);
					}
				}
			}
		}
	}
	
	// ^^^^^^^^^^^^^^^^^^^^^^^^左侧菜单树^^^^^^^^^^^^^^^^^^^^^^^^^^
	
	@RequestMapping(value = "/findModuleTree", name = "左侧菜单树")
	public Object findModuleTree(@RequestParam(value = "roleIds", required = false) List<Integer> roleIds) {

		System.out.println("roleIds=>"+roleIds);
		Set<Integer> moduleIds = new HashSet();// 角色拥有的模块id
		List<Module> rootList = new ArrayList();// 所有的根节点
		Set<Integer> rootIds = new HashSet();// 符合条件的根节点的id集合
		if(roleIds.size()==0) {
			return rootList;
		}
		
		/* 获取角色拥有的模块 */
		List<Module> moduleList = moduleService.findModuleByRoleIds(roleIds);
		System.out.println("moduleList=>"+moduleList);
		
		/* 获取角色拥有的moduleid */
		for (Module module : moduleList) {
			moduleIds.add(module.getId());
		}
		
		/* 获取所有符合条件的根节点 */
		for (Integer id : moduleIds) {
			rootIds.add(this.queryParentIdById(id));
		}
		
		/* 根据根菜单的id集合获取所有符合条件的根节点  */
		rootList = moduleService.findByIdInOrderByModuleweightDesc(rootIds);

		this.setTreeGridChildren(rootList, moduleIds);

		return rootList;
	}

}
