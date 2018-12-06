package com.wisdom.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.wisdom.entity.Classes;


public interface ClazzService {
	
	/**
	 * 添加/修改班级信息
	 * @param clazz
	 * @return
	 */
	Classes saveClazz(Classes clazz);
	
	/**
	 * 删除班级信息
	 * @param clazzId
	 * @return
	 */
	String deleteClazz(Integer clazzId);
	
	Page<Classes> findByName(String name,Pageable page);

}
