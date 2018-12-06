package com.Wisdom.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OrderBy;
import javax.persistence.Table;

/**
 * 班级表(Classes)
 * @author admin
 *
 */
@Entity
@Table(name="Classes")
public class Classes implements Serializable {

	@Id
	@GeneratedValue
	@OrderBy
	@Column(columnDefinition="int unsigned NOT NULL comment '备注：自动编号'")
	private Integer id;
	@Column(columnDefinition="varchar (50) NOT NULL comment '备注:姓名 '")
	private String name;
	@Column(columnDefinition="int NOT NULL comment '备注：专业id'")
	private int professionId;
	@Column(columnDefinition="int NOT NULL comment '备注：教师id'")
	private int teacherId;
	@Column(columnDefinition="varchar (50) comment '备注:备注 '")
	private String mark;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Classes() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Classes(Integer id, String name, int professionId, int teacherId, String mark) {
		super();
		this.id = id;
		this.name = name;
		this.professionId = professionId;
		this.teacherId = teacherId;
		this.mark = mark;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getProfessionId() {
		return professionId;
	}
	public void setProfessionId(int professionId) {
		this.professionId = professionId;
	}
	public int getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}
	public String getMark() {
		return mark;
	}
	public void setMark(String mark) {
		this.mark = mark;
	}
	@Override
	public String toString() {
		return "Classes [id=" + id + ", name=" + name + ", professionId=" + professionId + ", teacherId=" + teacherId
				+ ", mark=" + mark + "]";
	}
	
}
