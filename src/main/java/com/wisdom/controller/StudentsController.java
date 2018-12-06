package com.wisdom.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wisdom.dao.StudentRepository;
import com.wisdom.entity.Students;
import com.wisdom.entity.condittion.StudentsCondittion;
import com.wisdom.service.StudentsService;

/**
 * 学生
 * 
 * @author admin
 *
 */
@RestController
@RequestMapping("/students")
public class StudentsController {

	@Autowired
	private StudentsService stuvice;
	@Autowired
	private StudentRepository studao;

	private Map<String, Object> map = new HashMap<String, Object>();

	/**
	 * 添加学生/编辑学生 http://localhost:8080/students/addstu?
	 * name=黄九&studentNo=123456&password=123456&classId=6&isLock=0&
	 * state=1&pictureId=1
	 */
	@RequestMapping("/addstu")
	public Map<String, Object> addstu(Students stu) {

		Students s = stuvice.addstu(stu);
		int a = s.getId();
		if (a > 0) {
			map.put("success", true);
			map.put("message", "添加成功");
			return map;
		} else {
			map.put("success", false);
			map.put("message", "添加失败");
			return map;
		}

	}

	/**
	 * 查询学生 http://localhost:8080/Wisdom/students/selectall
	 */
	@RequestMapping("/selectall")
	public Map<String, Object> selectall(StudentsCondittion stucon, Integer page, Integer rows) {

		// Pageable pg = new PageRequest(stucon,page-1, rows);
		Page<Students> userPage = stuvice.selectall(stucon, page - 1, rows);
		List<Students> list = userPage.getContent();
		map.put("total", userPage.getTotalElements());
		map.put("rows", list);
		System.out.println(list);
		return map;
	}

	/**
	 * 删除学生
	 */
	@RequestMapping("/deletestu")
	public Map<String, Object> deletestu(Integer id) {
		String s = stuvice.deletestu(id);
		map.put("success", true);
		map.put("message", "删除成功");
		return map;

	}

	/**
	 * 锁定用户
	 */
	@RequestMapping("/suo")
	public Map<String, Object> addlock(Integer id) {
		Students s = stuvice.selectById(id);//根据id获取用户信息
		if (s.getIsLock() == 1) {
			map.put("success", true);
			map.put("message", "已锁定，无需重复锁定");
			return map;
		} else {
			int a = stuvice.suo(id);//锁定用户
			if (a > 0) {
				map.put("success", true);
				map.put("message", "已成功锁定");
				return map;
			} else {
				map.put("success", false);
				map.put("message", "锁定失败");
				return map;
			}
		}
	}

	/**
	 * 解锁用户
	 */
	@RequestMapping("/jie")
	public Map<String, Object> dellock(Integer id) {
		Students s = stuvice.selectById(id);//根据id获取用户信息
		if (s.getIsLock() == 0) {
			map.put("success", true);
			map.put("message", "已解锁，无需重复解锁");
			return map;
		} else {
			int a = stuvice.jie(id);//解锁用户
			if (a > 0) {
				map.put("success", true);
				map.put("message", "已成功解锁");
				return map;
			} else {
				map.put("success", false);
				map.put("message", "解锁失败");
				return map;
			}
		}
	}
}
