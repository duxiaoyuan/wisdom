package com.wisdom.service.impl.manager;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.wisdom.dao.manager.ModuleRepository;
import com.wisdom.entity.manager.Module;
import com.wisdom.service.manager.ModuleService;


@Service
public class ModuleServiceImpl implements ModuleService {

	@Autowired
	ModuleRepository moduleRepository;

	@Override
	public List<Module> findModuleByRoleId(Integer roleId) {
		
		return moduleRepository.findModuleByRoleId(roleId);
	}

	@Override
	public List<Module> findByParentidAndStatusOrderByModuleweightDesc(Integer id, Integer status) {
		
		return moduleRepository.findByParentidAndStatusOrderByModuleweightDesc(id, status);
	}

	@Override
	public List<Module> findByModulenameLikeAndStatus(String modulename, Integer status) {
		
		return moduleRepository.findByModulenameLikeAndStatus(modulename, status);
	}

	@Override
	public List<Module> findByIdInOrderByModuleweightDesc(Set<Integer> rootIds) {
		
		return moduleRepository.findByIdInOrderByModuleweightDesc(rootIds);
	}

	@Override
	public List<Module> findByParentidAndIdInOrderByModuleweightDesc(Integer id, Set<Integer> likeList) {
		
		return moduleRepository.findByParentidAndIdInOrderByModuleweightDesc(id, likeList);
	}

	@Override
	public List<Module> findModuleByRoleIds(List<Integer> roleIds) {
		
		return moduleRepository.findModuleByRoleIds(roleIds);
	}

	@Override
	public Module findByIdAndStatus(Integer moduleId, int i) {
	
		return moduleRepository.findByIdAndStatus(moduleId, i);
	}

	
	
}
