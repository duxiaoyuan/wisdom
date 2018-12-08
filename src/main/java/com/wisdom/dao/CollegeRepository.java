package com.wisdom.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.wisdom.entity.College;


public interface CollegeRepository extends JpaRepository<College, Integer>,JpaSpecificationExecutor<College>{
	
	public Page<College> findByNameLikeAndCollegeNoLike(String name,String collegeNo, Pageable page);
	
}
