package com.Wisdom.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.Wisdom.entity.Course;

public interface CourseService {

	public Page<Course> find(String courseNo, String name, /*Integer professionId,*/ Pageable page);

	Course insertCourse(Course course);

	String deleteCourse(Integer courseId);

}
