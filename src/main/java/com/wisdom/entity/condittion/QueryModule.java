package com.wisdom.entity.condittion;

import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;


import com.fasterxml.jackson.annotation.JsonProperty;


public class QueryModule {

	private Integer modulename;
	private Integer status;
	public Integer getModulename() {
		return modulename;
	}
	public void setModulename(Integer modulename) {
		this.modulename = modulename;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "QueryModule [modulename=" + modulename + ", status=" + status + "]";
	}
	
}


