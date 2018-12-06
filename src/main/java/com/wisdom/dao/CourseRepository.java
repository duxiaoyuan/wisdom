package com.wisdom.dao;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.wisdom.entity.Course;
import com.wisdom.entity.Students;

public interface CourseRepository extends JpaRepository<Course, Integer>,JpaSpecificationExecutor<Students>{

	public Page<Course> findByCourseNoLikeAndNameLike(String courseNo,String name,/*Integer professionId,*/Pageable page);
	
	
	
}
