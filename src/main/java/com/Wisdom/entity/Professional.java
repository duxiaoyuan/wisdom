package com.Wisdom.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OrderBy;
import javax.persistence.Table;

@Entity
@Table(name="professional")
/**
 * 专业表
 * @author admin
 *
 */
public class Professional implements Serializable {
	@Id
	@GeneratedValue
	@OrderBy
	@Column(columnDefinition="int unsigned NOT NULL comment '备注：自动编号'")
	private int id;
	@Column(columnDefinition="varchar (50) NOT NULL comment '备注：专业代码'")
	private String professionNo;
	@Column(columnDefinition="varchar (50) NOT NULL comment '备注：专业名称'")
	private String name;
	@Column(columnDefinition="int NOT NULL comment '备注：院系id'")
	private int departmentId;
	@Column(columnDefinition="varchar (50) comment '备注：备注'")
	private String mark;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getProfessionNo() {
		return professionNo;
	}
	public void setProfessionNo(String professionNo) {
		this.professionNo = professionNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}
	public String getMark() {
		return mark;
	}
	public void setMark(String mark) {
		this.mark = mark;
	}
	@Override
	public String toString() {
		return "Professional [id=" + id + ", professionNo=" + professionNo + ", name=" + name + ", departmentId="
				+ departmentId + ", mark=" + mark + "]";
	}

	
}
