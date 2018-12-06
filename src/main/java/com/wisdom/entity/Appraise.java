package com.wisdom.entity;



import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OrderBy;
import javax.persistence.Table;

/**
 * 评价表(appraise)
 * @author admin
 *
 */
@Entity
@Table(name="appraise")
public class Appraise implements Serializable {

	@Id
	@GeneratedValue
	@OrderBy
	@Column(columnDefinition="int unsigned NOT NULL comment '备注：自动编号'")
	private int id;
	@Column(columnDefinition="int NOT NULL comment '备注：课程id'")
	private int courseId;
	@Column(columnDefinition="int NOT NULL comment '备注：评价 等级'")
	private int level;
	@Column(columnDefinition="int NOT NULL comment '备注：学生id'")
	private int studentId;
	@Column(columnDefinition="int Default 0 NOT NULL comment '备注：点赞0：没有点赞1点赞'")
	private int  zan;
	@Column(columnDefinition="text NOT NULL comment '备注：评论内容 '")
	private String context;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCourseId() {
		return courseId;
	}
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public int getZan() {
		return zan;
	}
	public void setZan(int zan) {
		this.zan = zan;
	}
	public String getContext() {
		return context;
	}
	public void setContext(String context) {
		this.context = context;
	}
	@Override
	public String toString() {
		return "Appraise [id=" + id + ", courseId=" + courseId + ", level=" + level + ", studentId=" + studentId
				+ ", zan=" + zan + ", context=" + context + "]";
	}
	
}
