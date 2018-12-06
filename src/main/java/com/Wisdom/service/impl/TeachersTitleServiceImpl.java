package com.Wisdom.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Wisdom.dao.TeachersTitleRepository;
import com.Wisdom.entity.TeachersTitle;
import com.Wisdom.service.TeachersTitleService;

@Service
public class TeachersTitleServiceImpl implements TeachersTitleService{

	@Autowired
	private TeachersTitleRepository dao;
	
	@Override
	public TeachersTitle addTtitle(TeachersTitle ttitle) {
		// TODO Auto-generated method stub
		return dao.save(ttitle);
	}

	@Override
	public List<TeachersTitle> getAll() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public int updateTtitle(Integer id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteTtitle(Integer id) {
		// TODO Auto-generated method stub
		return 0;
	}

	
}
