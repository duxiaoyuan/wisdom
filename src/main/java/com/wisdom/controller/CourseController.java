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

import com.wisdom.entity.Classes;
import com.wisdom.entity.Course;
import com.wisdom.service.CourseService;
import com.wisdom.tools.Result;

@RestController
@RequestMapping("course")
public class CourseController {

	@Autowired
	private CourseService service;
	
	/**
	 * 课程的多条件分页检索
	 * http://localhost:8080/Wisdom/course/selCourse
	 * @param courseNo
	 * @param name
	 * @param professionId
	 * @param pageable
	 * @param page
	 * @param rows
	 * @return
	 */
	@RequestMapping("/selCourse")
	public Map<String, Object> selCourse(String courseNo,String name,/*Integer professionId,*/Pageable pageable,Integer page,Integer rows){
		Map<String, Object> map = new HashMap<String, Object>();
		Sort sort = new Sort(Direction.DESC	, "id");
		Pageable pager =  new PageRequest(page-1, rows, sort);
		Page<Course> couPage = service.find(courseNo, name,/* professionId,*/ pager);
		map.put("total", couPage.getTotalElements());
		map.put("rows", couPage.getContent());
		System.out.println(map);
		return map;
	}

	/**http://localhost:8080/Wisdom/course/addcourse
	 * 添加/修改课程信息
	 * @param course
	 * @return
	 */
	@RequestMapping("/addCourse")
	public Object addcourse(Course course) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		if(course.getName()==null) {
			course.setProfessionId(2);
			Course addCourse = service.insertCourse(course);
			
		}
		Course addCourse = service.insertCourse(course);
		if(addCourse!= null && !"".equals(addCourse)) {
			return new Result("操作成功", 1);

		} else {

			return new Result("操作失败", 0);

		}
		
	}
	/**
	 * 根据id删除课程
	 * http://localhost:8080/Wisdom/course/delCourse
	 * @param id
	 * @return
	 */
	@RequestMapping("/delCourse")
	public Object deleteCourse(Integer id) {
		
		String course = service.deleteCourse(id);
		return "删除成功";
		
	}
	
	
}	
