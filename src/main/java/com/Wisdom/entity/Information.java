package com.Wisdom.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OrderBy;
import javax.persistence.Table;

/**
 * 资料表(Information)
 * @author admin
 *
 */
@Entity
@Table(name="information")
public class Information implements Serializable {

	@Id
	@GeneratedValue
	@OrderBy
	@Column(columnDefinition="int unsigned NOT NULL comment '备注：自动编号'")
	private int id;
	@Column(columnDefinition="varchar (50) NOT NULL comment '备注：资料名称'")
	private String name;
	@Column(columnDefinition="varchar (50) NOT NULL comment '备注：资料类型'")
	private String type;
	@Column(columnDefinition="varchar (50) NOT NULL comment '备注：资源路径'")
	private String url;
	@Column(columnDefinition="int NOT NULL comment '备注：资料提供者'")
	private int teacherId;
	@Column(columnDefinition="datetime NOT NULL comment '备注：上传时间'")
	private Date uploadTime;
	@Column(columnDefinition="int NOT NULL comment '备注：章节id'")
	private int courseId;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public int getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}
	public Date getUploadTime() {
		return uploadTime;
	}
	public void setUploadTime(Date uploadTime) {
		this.uploadTime = uploadTime;
	}
	public int getCourseId() {
		return courseId;
	}
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	@Override
	public String toString() {
		return "Information [id=" + id + ", name=" + name + ", type=" + type + ", url=" + url + ", teacherId="
				+ teacherId + ", uploadTime=" + uploadTime + ", courseId=" + courseId + ", getId()=" + getId()
				+ ", getName()=" + getName() + ", getType()=" + getType() + ", getUrl()=" + getUrl()
				+ ", getTeacherId()=" + getTeacherId() + ", getUploadTime()=" + getUploadTime() + ", getCourseId()="
				+ getCourseId() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
	
	
}
