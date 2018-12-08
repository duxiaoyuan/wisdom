package com.wisdom.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.wisdom.dao.CollegeRepository;
import com.wisdom.entity.College;
import com.wisdom.service.CollegeService;

@Service
public class CollegeServiceImpl implements CollegeService{

	@Autowired
	private CollegeRepository rep;

	@Override
	public Page<College> selAllColleges(String name,String collegeNo,Pageable page) {
		// TODO Auto-generated method stub
		return rep.findByNameLikeAndCollegeNoLike("%"+name+"%", "%"+collegeNo+"%", page);
	}

	@Override
	public College addCollege(College college) {
		// TODO Auto-generated method stub
		return rep.save(college);
	}

	@Override
	public String delCollege(Integer id) {
		rep.delete(id);
		return "success";
	}

	

}
