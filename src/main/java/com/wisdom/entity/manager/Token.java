package com.wisdom.entity.manager;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;


@JsonInclude(Include.NON_NULL)
public class Token {
	
	private Integer userId;
	/**
	 * 角色Id集合
	 */
	private List<Integer> roleIdList;
	/**
	 * 用户拥有的权限集合
	 */
	private List<String> permissionValueList;
	
	public Token(Integer userId, List<Integer> roleIdList,
			List<String> permissionValueList) {
		super();
		this.userId = userId;
		this.roleIdList = roleIdList;
		this.permissionValueList = permissionValueList;
	}
	public Token(Integer userId, List<String> permissionValueList) {
		super();
		this.userId = userId;
		this.permissionValueList = permissionValueList;
	}
	public Token(List<String> permissionValueList) {
		super();
		this.permissionValueList = permissionValueList;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public List<Integer> getRoleIdList() {
		return roleIdList;
	}
	public void setRoleIdList(List<Integer> roleIdList) {
		this.roleIdList = roleIdList;
	}
	public List<String> getPermissionValueList() {
		return permissionValueList;
	}
	public void setPermissionValueList(List<String> permissionValueList) {
		this.permissionValueList = permissionValueList;
	}

}
