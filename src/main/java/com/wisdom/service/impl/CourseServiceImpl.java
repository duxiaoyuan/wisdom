package com.wisdom.service.impl;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.wisdom.dao.CourseRepository;
import com.wisdom.entity.Course;
import com.wisdom.service.CourseService;
@Service
public class CourseServiceImpl implements CourseService {

	@Autowired
	private CourseRepository rep;
	@Override
	public Page<Course> find(String courseNo,String name,/*Integer professionId,*/Pageable page) {
		// TODO Auto-generated method stub
		return rep.findByCourseNoLikeAndNameLike("%"+courseNo+"%", "%"+name+"%",/*professionId ,*/ page);
	}

	@Override
	public Course insertCourse(Course course) {
		// TODO Auto-generated method stub
		return rep.save(course);
	}

	@Override
	public String deleteCourse(Integer courseId) {
		rep.delete(courseId);
		return "success";
	}

}
