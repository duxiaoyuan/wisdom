package com.wisdom.entity.condittion;

import java.util.Date;

public class QueryRole {
	
	private Integer Status; 
	private String rolename;
	public Integer getStatus() {
		return Status;
	}
	public void setStatus(Integer status) {
		Status = status;
	}
	public String getRolename() {
		return rolename;
	}
	public void setRolename(String rolename) {
		this.rolename = rolename;
	}
	@Override
	public String toString() {
		return "QueryRole [Status=" + Status + ", rolename=" + rolename + "]";
	}

}
