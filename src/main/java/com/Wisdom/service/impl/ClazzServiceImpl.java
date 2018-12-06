package com.Wisdom.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.Wisdom.dao.ClazzRepository;
import com.Wisdom.entity.Classes;
import com.Wisdom.entity.Students;
import com.Wisdom.service.ClazzService;

@Service
public class ClazzServiceImpl implements ClazzService {

	@Autowired
	private ClazzRepository rep;
	@Override
	public Classes saveClazz(Classes clazz) {
		// TODO Auto-generated method stub
		return rep.save(clazz);
	}

	@Override
	public String deleteClazz(Integer clazzId) {
		// TODO Auto-generated method stub
		rep.delete(clazzId);
		return "success";
	}

	@Override
	public Page<Classes> findByName(String name,Pageable page) {
		// TODO Auto-generated method stub
		return rep.findByNameLike(name,page);
	}

}
