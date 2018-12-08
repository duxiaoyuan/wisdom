package com.wisdom.service.manager;

import java.util.List;

import org.springframework.data.domain.Page;

import com.wisdom.entity.condittion.QueryRole;
import com.wisdom.entity.manager.Role;


public interface RoleService {
	
	public Page<Role> queryPages(QueryRole queryRole,Integer page,Integer rows);
	
	public Object saveRoles(Role role);
	
	public Object setRoleModule(Integer roleId,List<Integer> moduleIds);
	
	public List<Role> findByStatus(int status);
}
