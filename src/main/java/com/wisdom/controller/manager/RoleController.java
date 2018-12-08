package com.wisdom.controller.manager;

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

import org.hibernate.annotations.AttributeAccessor;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wisdom.dao.manager.RoleRepository;
import com.wisdom.entity.condittion.QueryRole;
import com.wisdom.entity.manager.Role;
import com.wisdom.service.manager.RoleService;



@RestController
@RequestMapping(value="/roles",name="角色管理")
public class RoleController {
	
	@Autowired
	RoleRepository roleRepository;
	@Autowired
	RoleService roleService;
	/*@Autowired
	StudentRepository studentRepository;*/

	/**
	 * 多条件分页查询
	 * @param queryRole
	 * @param page
	 * @param rows
	 * @return
	 */
	@RequestMapping(value="/findRoles",name="角色管理")
	public Map findAll(QueryRole queryRole,Integer page,Integer rows) {
		Map<String,Object> map = new HashMap<>();
		Page<Role> pages = roleService.queryPages(queryRole, page, rows);
		long total = pages.getTotalElements();
		List<Role> list = pages.getContent();
		map.put("total", total);
		map.put("rows", list);
		return map;
				
	}
	
	/**
	 * 添加和修改角色
	 * http://localhost:8080/role/saveRole?rolecreatetime=2018-11-16 2014:57:00&roleexplain=阿萨德&rolename=咨询经理&id=1
	 * @param role
	 * @return
	 */
	@RequestMapping(value = "/saveRole",name="添加,修改角色")
	public Object saveRole(Role role) {
		return roleService.saveRoles(role);
	}
	
	/*@RequestMapping(value = "/findUser",name="删除角色前获判断角色是否有用户拥有")
	public Object findUser(Integer roleId) {
		List<User> user = userRepository.findByRoleId(roleId);
		System.out.println("user=>"+user);
		return user;
	}*/
	
	@RequestMapping(value = "/deleteRole",name="删除角色")
	public Object deleteRole(Role role) {
		Role js = roleRepository.findOne(role.getId());
		js.setStatus(role.getStatus());
		return roleRepository.save(js);
	}
	
	/*@RequestMapping(value = "/findAll",name="获取用户角色")
	public Map findAll(Integer userId){
		
		Map<String, Object> map = new HashMap<>();
		//获取用户所拥有的角色
		Set<Role> set = userRepository.findOne(userId).getRoleSet();
		//获取系统里所有可用的角色
		List<Role> list = roleService.findByStatus(1);
		//取差集,即为用户未拥有的角色
		list.removeAll(set);
		map.put("userExclusiveModules", list);
		map.put("userIncludeModules", userRepository.findOne(userId).getRoleSet());
		return map;
	}
*/
	
	/**
	 * 
	 * @param roleId
	 * @param moduleIds
	 * @return
	 */
	@RequestMapping(value = "setRoleModules", name = "给角色设置模块")
	public Object setRoleModules(@RequestParam(value = "roleId", required = false)Integer roleId,@RequestParam(value = "moduleIds", required = false) List<Integer> moduleIds) {
		
		return roleService.setRoleModule(roleId, moduleIds);
	}
	
}
