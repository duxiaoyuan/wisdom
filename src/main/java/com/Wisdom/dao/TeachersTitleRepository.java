package com.Wisdom.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.Wisdom.entity.TeachersTitle;

public interface TeachersTitleRepository extends JpaRepository<TeachersTitle, Integer>,JpaSpecificationExecutor<TeachersTitle> {

}

