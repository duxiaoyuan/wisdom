package com.Wisdom.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.Wisdom.entity.Classes;
import com.Wisdom.entity.Students;

public interface ClazzRepository extends JpaRepository<Classes, Integer>,JpaSpecificationExecutor<Students>{
	
	public Page<Classes> findByNameLike(String name,Pageable page);

}

