package com.wisdom.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OrderBy;
import javax.persistence.Table;

@Entity
@Table(name="college")
/**
 * 学院表(college)
 * @author admin
 *
 */
public class College implements Serializable {
	@Id
	@GeneratedValue
	@OrderBy
	@Column(columnDefinition="int unsigned NOT NULL comment '备注:自动编号'")
	private int id;
	@Column(columnDefinition="varchar (50) NOT NULL comment '备注:学院代码'")
	private String colegeNo;
	@Column(columnDefinition="varchar (50) NOT NULL comment '备注:学院名称'")
	private String name;
	@Column(columnDefinition="varchar (50) comment '备注:备注'")
	private String mark;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getColegeNo() {
		return colegeNo;
	}
	public void setColegeNo(String colegeNo) {
		this.colegeNo = colegeNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getmark() {
		return mark;
	}
	public void setmark(String mark) {
		mark = mark;
	}
	@Override
	public String toString() {
		return "College [id=" + id + ", colegeNo=" + colegeNo + ", name=" + name + ", mark=" + mark + "]";
	}
	
	
}
