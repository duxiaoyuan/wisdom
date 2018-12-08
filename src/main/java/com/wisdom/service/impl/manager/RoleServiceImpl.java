package com.wisdom.service.impl.manager;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.wisdom.dao.manager.ModuleRepository;
import com.wisdom.dao.manager.RoleRepository;
import com.wisdom.entity.condittion.QueryRole;
import com.wisdom.entity.manager.Module;
import com.wisdom.entity.manager.Role;
import com.wisdom.service.manager.RoleService;
import com.wisdom.tools.Result;


@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	RoleRepository roleRepository;

	@Autowired
	ModuleRepository moduleRepository;
	@Override
	public Object setRoleModule(Integer roleId,List<Integer> moduleIds) {
		Module module = new Module();
		// System.out.println("moduleIds=>"+moduleIds);
		Role role = roleRepository.findOne(roleId);

		role.getModuleSet().removeAll(role.getModuleSet());

		for (Integer id : moduleIds) {
			module = moduleRepository.findOne(id);
			System.out.println("module=>" + module);
			role.getModuleSet().add(module);
		}

		return roleRepository.save(role);
	}

	@Override
	public List<Role> findByStatus(int status) {

		return roleRepository.findByStatus(status);
	}

	private Specification<Role> getWhereClause(final QueryRole queryRole) {
		return new Specification<Role>() {
			@Override
			public Predicate toPredicate(Root<Role> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				Predicate predicate = cb.conjunction();// 动态SQL表达式
				List<Expression<Boolean>> exList = predicate.getExpressions();// 动态SQL表达式集合
				if (queryRole.getRolename() != null && !"".equals(queryRole.getRolename())) {
					exList.add(cb.like(root.<String>get("rolename"), "%" + queryRole.getRolename() + "%"));
				}
//				if( queryUser.getUserislockout() != null ){
//					exList.add(cb.equal(root.<Integer>get("userislockout"),queryUser.getUserislockout()));
//				}
				if (queryRole.getStatus() != null) {
					exList.add(cb.equal(root.get("status").as(Integer.class), queryRole.getStatus()));
				}
//				if( queryUser.getStartTime() != null ){
//					exList.add(cb.greaterThanOrEqualTo(root.<Date>get("usercreatetime"),queryUser.getStartTime()));//大于等于起始日期
//				}
//				if( queryUser.getEndTime() != null ){
//					exList.add(cb.lessThanOrEqualTo(root.get("usercreatetime").as(Date.class),queryUser.getEndTime()));//小于等于截止日期
//				}
				return predicate;
			}
		};
	}

	@Override
	public Page<Role> queryPages(QueryRole queryRole, Integer page, Integer rows) {
		Sort sort = new Sort(Sort.Direction.DESC, "id");
		Pageable pageable = new PageRequest(page - 1, rows, sort);
		return roleRepository.findAll(this.getWhereClause(queryRole), pageable);
	}

	@Override
	public Object saveRoles(Role role) {
		List<Role> roleList = roleRepository.findAll();
		for (Role r : roleList) {
			if (r.getRolename().equals(role.getRolename())) {
				return new Result("角色已存在", 0);
			}
		}
		if (role.getId() == null) {
			role.setStatus(1);
			return new Result(roleRepository.save(role));
		} else {
			Role rol = roleRepository.findOne(role.getId());
			rol.setRolename(role.getRolename());
			return new Result(roleRepository.save(rol));
		}

	}

}
