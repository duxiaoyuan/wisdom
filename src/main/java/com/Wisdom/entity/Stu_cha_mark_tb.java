package com.Wisdom.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OrderBy;
import javax.persistence.Table;

/**
 * 学生章节成绩表(stu_cha_mark_tb)
 * @author admin
 *
 */
@Entity
@Table(name="stu_cha_mark_tb")
public class Stu_cha_mark_tb implements Serializable {
	@Id
	@GeneratedValue
	@OrderBy
	@Column(columnDefinition="int unsigned NOT NULL comment '备注：自动编号'")
	private int id;
	@Column(columnDefinition="int NOT NULL comment '备注：学生id'")
	private  int stuId;
	@Column(columnDefinition="int NOT NULL comment '备注：章节id'")
	private int chapterId;
	@Column(columnDefinition="double comment '备注：成绩'")
	private Double score;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getStuId() {
		return stuId;
	}
	public void setStuId(int stuId) {
		this.stuId = stuId;
	}
	public int getChapterId() {
		return chapterId;
	}
	public void setChapterId(int chapterId) {
		this.chapterId = chapterId;
	}
	public Double getScore() {
		return score;
	}
	public void setScore(Double score) {
		this.score = score;
	}
	@Override
	public String toString() {
		return "Stu_cha_mark_tb [id=" + id + ", stuId=" + stuId + ", chapterId=" + chapterId + ", score=" + score + "]";
	}
	
	

}
