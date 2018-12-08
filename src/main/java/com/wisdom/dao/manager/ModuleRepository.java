package com.wisdom.dao.manager;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.wisdom.entity.manager.Module;



public interface ModuleRepository extends JpaRepository<Module, Integer>{

	@Query(value="SELECT * FROM module WHERE id IN (SELECT DISTINCT moduleid FROM role_module_tb WHERE roleid = ?1) AND status = 1", nativeQuery = true)
	public List<Module> findModuleByRoleId(Integer roleId);

	public List<Module> findByParentidAndStatusOrderByModuleweightDesc(Integer id,Integer status);

	public List<Module> findByModulenameLikeAndStatus(String modulename,Integer status);

	public List<Module> findByIdInOrderByModuleweightDesc(Set<Integer> rootIds);

	public List<Module> findByParentidAndIdInOrderByModuleweightDesc(Integer id, Set<Integer> likeList);

	@Query(value="SELECT * FROM module WHERE id IN (SELECT DISTINCT moduleid FROM role_module_tb WHERE roleid IN (?1))", nativeQuery = true)
	public List<Module> findModuleByRoleIds(List<Integer> roleIds);

	public Module findByIdAndStatus(Integer moduleId, int i);
	
}
