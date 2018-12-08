package com.wisdom.dao.manager;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import com.wisdom.entity.manager.Role;


public interface RoleRepository extends JpaRepository<Role, Integer>,JpaSpecificationExecutor<Role>{
	
	@Query(value="SELECT * FROM role r WHERE r.status=1 AND r.id IN(SELECT roleid FROM role_user_tb WHERE userid=?1)",nativeQuery = true)
	public List<Role> selectRolesByUserId(Integer id);

	public List<Role> findByStatus(int status);

}
