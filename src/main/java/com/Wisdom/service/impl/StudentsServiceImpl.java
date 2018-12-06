package com.Wisdom.service.impl;

import java.util.Date;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import com.Wisdom.controller.StudentsController;
import com.Wisdom.dao.StudentRepository;

import com.Wisdom.entity.Students;
import com.Wisdom.entity.condittion.StudentsCondittion;
import com.Wisdom.service.StudentsService;


@Service
public class StudentsServiceImpl implements StudentsService {

	@Autowired
	private StudentRepository studao;
	@Override
	/**
	 * 添加学生/编辑学生
	 */
	public Students addstu(Students stu) {
		// TODO Auto-generated method stub
		return studao.save(stu);
	}
	/**
	 * 查询学生
	 * 
	 */
	@Override
	public Page<Students> selectall(StudentsCondittion con, Integer page, Integer rows) {
	
		
		Pageable pa = new PageRequest(page, rows);
		return studao.findAll(this.getWhereClause(con), pa);
		
	}
	/**
	 * 删除学生
	 */
	@Override
	public String deletestu(Integer id) {
		// TODO Auto-generated method stub
		studao.delete(id);
		return "success";
	}

	/**
	 * 查询条件动态组装
	 * 
	 * @param con
	 * @return
	 */
	private Specification<Students> getWhereClause(final StudentsCondittion con) {

		return new Specification<Students>() {

			@Override
			public Predicate toPredicate(Root<Students> root, CriteriaQuery<?> query, CriteriaBuilder cb) {

				Predicate predicate = cb.conjunction();// 动态SQL表达式
				List<Expression<Boolean>> exList = predicate.getExpressions();// 动态sql表达式集合
				if (con.getName() != null && !"".equals(con.getName())) {

					exList.add(cb.like(root.<String>get("name"), "%" + con.getName() + "%"));
				}
//				if (con.getTelphone() != null) {
//
//					exList.add(cb.greaterThanOrEqualTo(root.<Date>get("userCreateTime"), con.getCreateTime()));
//				}
//				if (con.getEndTime() != null) {
//
//					exList.add(cb.lessThanOrEqualTo(root.get("userCreateTime").as(Date.class), con.getEndTime()));
//				}
				if (con.getTelphone() != null && !"".equals(con.getName())) {

					exList.add(cb.like(root.<String>get("telphone"), "%" + con.getTelphone() + "%"));
				}
				if (con.getStudentNo() != null && !"".equals(con.getName())) {

					exList.add(cb.like(root.<String>get("studentNo"), "%" + con.getStudentNo() + "%"));
				}
				return predicate;
			}
		};
	}
	/**
	 * 根据id查询学生
	 */
	@Override
	public Students selectById(Integer id) {
		// TODO Auto-generated method stub
		return studao.findOne(id);
	}
	/**
	 * 解锁用户
	 */
	@Override
	public int jie(Integer id) {
		// TODO Auto-generated method stub
		return studao.jie(id);
	}
	/**
	 * 锁定用户
	 */
	@Override
	public int suo(Integer id) {
		// TODO Auto-generated method stub
		return studao.suo(id);
	}

}
