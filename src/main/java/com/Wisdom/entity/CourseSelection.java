package com.Wisdom.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OrderBy;
import javax.persistence.Table;

/**
 * 选课表(CourseSelection)
 * @author admin
 *
 */
@Entity
@Table(name="courseSelection")
public class CourseSelection implements Serializable {
	@Id
	@GeneratedValue
	@OrderBy
	@Column(columnDefinition="int unsigned NOT NULL comment '备注：自动编号'")
	private int id;
	@Column(columnDefinition="int NOT NULL comment '备注：学生id'")
	private int studentId;
	@Column(columnDefinition="int NOT NULL comment '备注：课程id'")
	private int courseId;
	@Column(columnDefinition="double comment '备注：总分'")
	private Double score;
	@Column(columnDefinition="int comment '备注：正在进行章节'")
	private int chapterId;
	@Column(columnDefinition="double comment '备注：学分'")
	private Double creadit;
	@Column(columnDefinition="varchar (50) comment '备注：备注'")
	private String mark;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public int getCourseId() {
		return courseId;
	}
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	public Double getScore() {
		return score;
	}
	public void setScore(Double score) {
		this.score = score;
	}
	public int getChapterId() {
		return chapterId;
	}
	public void setChapterId(int chapterId) {
		this.chapterId = chapterId;
	}
	public Double getCreadit() {
		return creadit;
	}
	public void setCreadit(Double creadit) {
		this.creadit = creadit;
	}
	public String getMark() {
		return mark;
	}
	public void setMark(String mark) {
		this.mark = mark;
	}
	@Override
	public String toString() {
		return "CourseSelection [id=" + id + ", studentId=" + studentId + ", courseId=" + courseId + ", score=" + score
				+ ", chapterId=" + chapterId + ", creadit=" + creadit + ", mark=" + mark + "]";
	}
	

}
