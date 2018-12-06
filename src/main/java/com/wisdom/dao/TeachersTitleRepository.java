package com.wisdom.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.wisdom.entity.TeachersTitle;

public interface TeachersTitleRepository extends JpaRepository<TeachersTitle, Integer>,JpaSpecificationExecutor<TeachersTitle> {

}

