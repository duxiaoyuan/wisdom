package com.wisdom.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wisdom.entity.College;
import com.wisdom.service.CollegeService;
import com.wisdom.tools.Result;

@RestController
@RequestMapping("college")
public class CollegeController {

	@Autowired
	private CollegeService service;

	/**
	 * 学院的多条件分页检索 http://localhost:8080/Wisdom/college/selAllColleges
	 * 
	 * @param name
	 * @param collegeNo
	 * @param pageable
	 * @param page
	 * @param rows
	 * @return
	 */
	@RequestMapping("/selAllColleges")
	public Map<String, Object> selAllColleges(String name, String collegeNo, Pageable pageable, Integer page,
			Integer rows) {
		Map<String, Object> map = new HashMap<String, Object>();
		Sort sort = new Sort(Direction.DESC, "id");
		Pageable pager = new PageRequest(page - 1, rows, sort);
		Page<College> colpage = service.selAllColleges(name, collegeNo, pager);
		map.put("total", colpage.getTotalElements());
		map.put("rows", colpage.getContent());
		System.out.println(map);
		return map;

	}

	/**
	 * http://localhost:8080/Wisdom/college/addCollege 
	 * 添加/修改学院信息
	 * 
	 * @param college
	 * @return
	 */
	@RequestMapping("/addCollege")
	public Object addCollege(College college) {
		Map<String, Object> map = new HashMap<String, Object>();
		if (college.getName() == null) {
			College addCollege = service.addCollege(college);
		}
		College addCollege = service.addCollege(college);
		System.out.println(college.getMark());
		if (addCollege != null && !"".equals(addCollege)) {
			return new Result("操作成功", 1);

		} else {

			return new Result("操作失败", 0);

		}

	}

	/**
	 * http://localhost:8080/Wisdom/college/delCollege 
	 * 根据id删除学院信息
	 * @param id
	 * @return
	 */
	@RequestMapping("/delCollege")
	public Object deleteCollege(Integer id) {
		Map<String, Object> map = new HashMap<String, Object>();

		String s = service.delCollege(id);
		map.put("success", true);
		map.put("message", "删除成功");
		return map;

	}
}
