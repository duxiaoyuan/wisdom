package com.wisdom.service;

import java.util.List;

import com.wisdom.entity.TeachersTitle;

/**
 * 职称
 * @author 13926
 *
 */
public interface TeachersTitleService {


	/**
	 * 添加职称
	 * @return
	 */
	TeachersTitle addTtitle(TeachersTitle ttitle); 
	
	/**
	 * 查询所有职称
	 * @return
	 */
	List<TeachersTitle> getAll();
	
	/**
	 * 修改职称
	 * @return
	 */
	int updateTtitle(Integer id);
	
	/**
	 * 删除职称
	 * @return
	 */
	int deleteTtitle(Integer id);
}
