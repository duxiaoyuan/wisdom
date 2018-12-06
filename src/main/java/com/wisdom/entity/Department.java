package com.wisdom.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OrderBy;
import javax.persistence.Table;

@Entity
@Table(name="department")
/**
 * 系表(Department)
 * @author admin
 *
 */
public class Department implements Serializable {
	@Id
	@GeneratedValue
	@OrderBy
	@Column(columnDefinition="int unsigned NOT NULL comment '备注：自动编号'")
	private int id;
	@Column(columnDefinition="varchar  (50) NOT NULL comment '备注：院系代码'")
	private String departmentNo;
	@Column(columnDefinition="varchar (50) NOT NULL comment '备注：系名称'")
	private String name;
	@Column(columnDefinition="int NOT NULL comment '备注：学院id'")
	private int collegeId;
	@Column(columnDefinition="varchar(50)  comment '备注：备注'")
	private String mark;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDepartmentNo() {
		return departmentNo;
	}
	public void setDepartmentNo(String departmentNo) {
		this.departmentNo = departmentNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCollegeId() {
		return collegeId;
	}
	public void setCollegeId(int collegeId) {
		this.collegeId = collegeId;
	}
	public String getmark() {
		return mark;
	}
	public void setmark(String mark) {
		mark = mark;
	}
	@Override
	public String toString() {
		return "Department [id=" + id + ", departmentNo=" + departmentNo + ", name=" + name + ", collegeId=" + collegeId
				+ ", mark=" + mark + "]";
	}
	
	

}
