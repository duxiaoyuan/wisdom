package com.wisdom.service.manager;

import java.util.List;
import java.util.Set;

import com.wisdom.entity.manager.Module;



public interface ModuleService {

	public List<Module> findModuleByRoleId(Integer roleId);

	public List<Module> findByParentidAndStatusOrderByModuleweightDesc(Integer id,Integer status);

	public List<Module> findByModulenameLikeAndStatus(String modulename,Integer status);

	public List<Module> findByIdInOrderByModuleweightDesc(Set<Integer> rootIds);

	public List<Module> findByParentidAndIdInOrderByModuleweightDesc(Integer id, Set<Integer> likeList);

	public List<Module> findModuleByRoleIds(List<Integer> roleIds);

	public Module findByIdAndStatus(Integer moduleId, int i);
}
