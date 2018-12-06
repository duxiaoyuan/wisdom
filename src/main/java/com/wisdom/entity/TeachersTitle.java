package com.wisdom.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OrderBy;
import javax.persistence.Table;

@Entity
@Table(name="teachersTitle")
/**
 * 职称表(teachersTitle)
 * @author admin
 *
 */
public class TeachersTitle implements Serializable {

	@Id
	@GeneratedValue
	@OrderBy
	@Column(columnDefinition="int unsigned NOT NULL comment '备注：自动编号'")
	private Integer id;
	@Column(columnDefinition="varchar (50)  NOT NULL comment '备注：职称名'")
	private String title;
	@Column(columnDefinition="varchar (50)  comment '备注：备注'")
	private String mark;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getMark() {
		return mark;
	}
	public void setMark(String mark) {
		this.mark = mark;
	}
	@Override
	public String toString() {
		return "TeachersTitle [id=" + id + ", title=" + title + ", mark=" + mark + "]";
	}
	
	
}
