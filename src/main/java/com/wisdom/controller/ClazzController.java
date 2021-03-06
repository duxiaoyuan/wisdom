package com.wisdom.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wisdom.entity.Classes;
import com.wisdom.service.ClazzService;
import com.wisdom.tools.Result;

import javafx.scene.control.Pagination;

@RestController
@RequestMapping("clazz")
public class ClazzController {
	
	@Autowired
	private ClazzService service;
	
	/**
	 * 根据名字分页查询班级
	 * http://localhost:8080/Wisdom/clazz/selectAllClasses
	 * @param name  班级名称
	 * @param pageable  
	 * @param page  页数
	 * @param rows  条数
	 * @return map{"total":总条数,"rows":数据}
	 */
	@RequestMapping("/selectAllClasses")
	public Map<String, Object> selectAllClasses(String name,Pageable pageable,Integer page,Integer rows){
		Map<String, Object> map = new HashMap<String, Object>();
		Sort sort = new Sort(Direction.ASC	, "id");
		Pageable pager =  new PageRequest(page-1, rows, sort);
		Page<Classes> claPage = service.findByName("%"+name+"%",pager);
		map.put("total", claPage.getTotalElements());
		map.put("rows", claPage.getContent());
		return map;
	}
	@RequestMapping("/selectAll")
	public List<Classes> selectAll(){
//		Map<String, Object> map = new HashMap<String, Object>();
//		Sort sort = new Sort(Direction.ASC	, "id");
//		Pageable pager =  new PageRequest(page-1, rows, sort);
//		Page<Classes> claPage = service.findByName("%"+name+"%",pager);
//		map.put("total", claPage.getTotalElements());
//		map.put("rows", claPage.getContent());
		
		List<Classes> list= service.getAll();

		System.out.println("sdfsdf"+list);
		return list;
	}
	
	/**
	 * 添加/修改班级信息
	 * http://localhost:8080/Wisdom/clazz/addClass?
	 * @param clazz
	 * @return
	 */
	@RequestMapping("addClass")
	public Object addClass(Classes clazz) {
		System.out.println("clazz=>"+clazz);
		Map<String, Object> map = new HashMap<String, Object>();
		
		if(clazz.getName()==null) {
		
			Classes addClazz = service.saveClazz(clazz);
		}
		Classes addClazz = service.saveClazz(clazz);
		if (addClazz != null && !"".equals(addClazz)) {

			return new Result("操作成功", 1);

		} else {

			return new Result("操作失败", 0);

		}

	}
	
	/**
	 * 根据班级id删除班级信息
	 * http://localhost:8080/Wisdom/clazz/delClazz
	 * @param clazzId
	 * @return
	 */
	@RequestMapping("/delClazz")
	public Object deleteClazz(Integer id) {
		String clazz = service.deleteClazz(id);
		return"删除成功";
	}
	
	

	
}
