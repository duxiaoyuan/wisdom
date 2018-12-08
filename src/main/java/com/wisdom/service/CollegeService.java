package com.wisdom.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.wisdom.entity.College;

public interface CollegeService {

	
	public College addCollege(College college);
	public String delCollege(Integer id);
	public Page<College> selAllColleges(String name, String collegeNo, Pageable page);
}
