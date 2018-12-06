package com.wisdom.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.wisdom.entity.Classes;
import com.wisdom.entity.Students;

public interface ClazzRepository extends JpaRepository<Classes, Integer>,JpaSpecificationExecutor<Students>{
	
	public Page<Classes> findByNameLike(String name,Pageable page);

}

