package com.wisdom.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import org.springframework.data.jpa.repository.Query;

import com.wisdom.entity.Teachers;


public interface TeacherRepository extends JpaRepository<Teachers, Integer>,JpaSpecificationExecutor<Teachers>{

    @Query("from Teachers where name = ?1 ")
    Teachers findTeacherByUserName(String name);
	
}
