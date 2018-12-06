package com.wisdom.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wisdom.entity.TeachersTitle;
import com.wisdom.service.TeachersTitleService;

/**
 * 职称
 * @author 13926
 *
 */
@RestController
@RequestMapping("/teacherstitle")
public class TeachersTitleController {

	@Autowired
	private TeachersTitleService service;
	
	/**
	 * 添加职称
	 * http://localhost:8080/Wisdom/teacherstitle/addttitle
	 * @param ttitle
	 * @return
	 */
	@RequestMapping("/addttitle")
	public TeachersTitle addTtitle(TeachersTitle ttitle){	
	return service.addTtitle(ttitle);
		
	}
	
	/**
	 * 查询所有职称
	 * http://localhost:8080/Wisdom/teacherstitle/getall
	 * @return
	 */
	@RequestMapping("/getall")
	public List<TeachersTitle> getAll(){
		return service.getAll();
	}
	
	/**
	 * 修改职称名称
	 * http://localhost:8080/Wisdom/teacherstitle/updatettitle
	 * @return
	 */
	@RequestMapping("/updatettitle")
	public int updateTtitle(Integer id) {
		return service.updateTtitle(id);
	}
	
	/**
	 * 删除职称
	 * http://localhost:8080/Wisdom/teacherstitle/deletettitle
	 * @return
	 */
	@RequestMapping("/deletettitle")
	public int deleteTtitle(Integer id) {
		return service.deleteTtitle(id);
		
	}
}
