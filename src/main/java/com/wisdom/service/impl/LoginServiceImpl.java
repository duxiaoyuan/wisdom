package com.wisdom.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wisdom.common.Result;
import com.wisdom.dao.TeacherRepository;
import com.wisdom.entity.Teachers;
import com.wisdom.service.LoginService;


@Service
public class LoginServiceImpl implements LoginService{

	@Autowired
	private TeacherRepository rep;

	@Override
	public Teachers findTeacher(Integer id) {
	
		return rep.findOne(id);
	}

	@Override
	public Result login(Teachers teachers) {

		//根据用户名查询对应的账户
		Teachers formTeachers = rep.findTeacherByUserName(teachers.getName());

		if(formTeachers == null){
			return new Result(false,"用户名不存在");
		}

		if(!formTeachers.getPassword().equals(teachers.getPassword())){
			return new Result(false,"登录失败，密码错误");
		}

		return new Result(true,"登录成功");
	}

}
