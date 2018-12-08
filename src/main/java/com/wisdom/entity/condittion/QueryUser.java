package com.wisdom.entity.condittion;

import java.util.Date;
import java.util.Set;

import org.springframework.format.annotation.DateTimeFormat;


public class QueryUser {
	
	private String username;
	private Integer userislockout;
	private String orderby;
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date startTime;
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date endTime;
	private Integer status;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Integer getUserislockout() {
		return userislockout;
	}
	public void setUserislockout(Integer userislockout) {
		this.userislockout = userislockout;
	}
	public String getOrderby() {
		return orderby;
	}
	public void setOrderby(String orderby) {
		this.orderby = orderby;
	}
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "QueryUser [username=" + username + ", userislockout=" + userislockout + ", orderby=" + orderby
				+ ", startTime=" + startTime + ", endTime=" + endTime + ", status=" + status + "]";
	}

}
