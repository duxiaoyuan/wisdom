package com.wisdom.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OrderBy;
import javax.persistence.Table;

/**
 * 评论表(comments)
 * @author admin
 *
 */
@Entity
@Table(name="comments")
public class Comments implements Serializable {
	
	@Id
	@GeneratedValue
	@OrderBy
	@Column(columnDefinition="int unsigned NOT NULL comment '备注：自动编号'")
	private int id;
	@Column(columnDefinition="int NOT NULL comment '备注：章节id'")
	private int chapterId;
	@Column(columnDefinition="text NOT NULL comment '备注：评论内容 '")
	private String content;
	@Column(columnDefinition="dateTime comment '备注：评论时间'")
	private Date commentTime;
	@Column(columnDefinition="int  NOT NULL comment '备注：评论人id'")
	private int userId;
	@Column(columnDefinition="int  NOT NULL comment '备注：评论父id'")
	private int parentId;
	@Column(columnDefinition="int Default 1 NOT NULL comment '备注：是否删除1已删除0未删除'")
	private int state;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getChapterId() {
		return chapterId;
	}
	public void setChapterId(int chapterId) {
		this.chapterId = chapterId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getCommentTime() {
		return commentTime;
	}
	public void setCommentTime(Date commentTime) {
		this.commentTime = commentTime;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getParentId() {
		return parentId;
	}
	public void setParentId(int parentId) {
		this.parentId = parentId;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	@Override
	public String toString() {
		return "Comments [id=" + id + ", chapterId=" + chapterId + ", content=" + content + ", commentTime="
				+ commentTime + ", userId=" + userId + ", parentId=" + parentId + ", state=" + state + "]";
	}
	
	
}
