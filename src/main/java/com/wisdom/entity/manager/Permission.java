package com.wisdom.entity.manager;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;


@Entity

@Table(name="permission")
public class Permission {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	private String value;
	
	private String module;
	
	private String name;
	
	private Timestamp permissionLastupdatetime;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getModule() {
		return module;
	}

	public void setModule(String module) {
		this.module = module;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Timestamp getPermissionLastupdatetime() {
		return permissionLastupdatetime;
	}

	public void setPermissionLastupdatetime(Timestamp permissionLastupdatetime) {
		this.permissionLastupdatetime = permissionLastupdatetime;
	}

	public Set<Role> getRoleSet() {
		return roleSet;
	}

	public void setRoleSet(Set<Role> roleSet) {
		this.roleSet = roleSet;
	}

	@ManyToMany(fetch = FetchType.EAGER,cascade=CascadeType.PERSIST)
    @JoinTable(name="role_permission_tb",
		joinColumns={@JoinColumn(name="permissionid",referencedColumnName="id")},
		inverseJoinColumns={@JoinColumn(name="roleid",referencedColumnName="id")})
	@NotFound(action = NotFoundAction.IGNORE)
	private Set<Role> roleSet = new HashSet<>();

}
