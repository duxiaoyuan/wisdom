package com.wisdom.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OrderBy;
import javax.persistence.Table;

/**
 * 章节表(Chapter)
 * @author admin
 *
 */
@Entity
@Table(name="Chapter")
public class Chapter implements Serializable {

	@Id
	@GeneratedValue
	@OrderBy
	@Column(columnDefinition="int unsigned NOT NULL comment '备注：自动编号'")
	private int id;
	@Column(columnDefinition="int NOT NULL comment '备注：课程id'")
	private int courseId;
	@Column(columnDefinition="varchar(50) NOT NULL comment '备注：章节标题'")
	private String title;
	@Column(columnDefinition="int NOT NULL comment '备注：章节父id'")
	private int parentId;
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
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getParentId() {
		return parentId;
	}
	public void setParentId(int parentId) {
		this.parentId = parentId;
	}
	@Override
	public String toString() {
		return "Chapter [id=" + id + ", courseId=" + courseId + ", title=" + title + ", parentId=" + parentId + "]";
	}
	
	
}
