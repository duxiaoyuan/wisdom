package com.wisdom.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * 课程表(course)
 * @author admin
 *
 */
@Entity
@Table(name="course")
public class Course implements Serializable {
	/*@JsonIgnore
	@ManyToOne(targetEntity=Professional.class)
	
   
    @JoinColumn(name="Course_professional_id") */
	private Professional Professional;
	
	public Professional getProfessional() {
		return Professional;
	}
	public void setProfessional(Professional professional) {
		Professional = professional;
	}
	@Id
	@GeneratedValue
	@OrderBy
	@Column(columnDefinition="int unsigned NOT NULL comment '备注：自动编号'")
	private Integer id;
	@Column(columnDefinition="varchar (50) NOT NULL comment '备注：课程代码 '")
	private String courseNo;
	@Column(columnDefinition="varchar (50) NOT NULL comment '备注：课程名'")
	private String name;
	@Column(columnDefinition="varchar (50) NOT NULL comment '备注：课程描述 '")
	private String describes;
	@Column(columnDefinition = "dateTime comment '备注：开始时间'")
	private Date startTime;
	@Column(columnDefinition = "dateTime comment '备注：结束时间'")
	private Date endTime;
	@Column(columnDefinition="int    comment '备注：专业id'")
	private int professionId;
	@Column(columnDefinition="int NOT NULL comment '备注：学分'")
	private int credits;
	@Column(columnDefinition="double NOT NULL comment '备注：共多少学时'")
	private Double classHour;
	@Column(columnDefinition="int NOT NULL comment '备注：教师id'")
	private int teacherId;
	@Column(columnDefinition="int Default 1 comment '备注：报名通道是否开启1：开启0：未开启'")
	private int state;
	@Column(columnDefinition="varchar (50) comment '备注：备注 '")
	private String mark;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCourseNo() {
		return courseNo;
	}
	public void setCourseNo(String courseNo) {
		this.courseNo = courseNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescribes() {
		return describes;
	}
	public void setDescribes(String describes) {
		this.describes = describes;
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
	public int getProfessionId() {
		return professionId;
	}
	public void setProfessionId(int professionId) {
		this.professionId = professionId;
	}
	public int getCredits() {
		return credits;
	}
	public void setCredits(int credits) {
		this.credits = credits;
	}
	public Double getClassHour() {
		return classHour;
	}
	public void setClassHour(Double classHour) {
		this.classHour = classHour;
	}
	public int getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public String getMark() {
		return mark;
	}
	public void setMark(String mark) {
		this.mark = mark;
	}
	@Override
	public String toString() {
		return "Course [Professional=" + Professional + ", id=" + id + ", courseNo=" + courseNo + ", name=" + name
				+ ", describes=" + describes + ", startTime=" + startTime + ", endTime=" + endTime + ", professionId="
				+ professionId + ", credits=" + credits + ", classHour=" + classHour + ", teacherId=" + teacherId
				+ ", state=" + state + ", mark=" + mark + "]";
	}
	
	
	
	
}
