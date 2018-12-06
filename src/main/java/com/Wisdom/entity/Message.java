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
 * 消息表(message)
 * @author admin
 *
 */
@Entity
@Table(name="message")
public class Message implements Serializable {
	@Id
	@GeneratedValue
	@OrderBy
	@Column(columnDefinition="int unsigned NOT NULL comment '备注：自动编号'")
	private int id;
	@Column(columnDefinition="int NOT NULL comment '备注：发送人id'")
	private int sentUserId;
	@Column(columnDefinition="text NOT NULL comment '备注：消息内容 '")
	private String content;
	@Column(columnDefinition="int NOT NULL comment '备注：接收人id'")
	private int receiveId;
	@Column(columnDefinition="int Default 0 NOT NULL comment '备注：消息状态1已读未读'")
	private int type;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getSentUserId() {
		return sentUserId;
	}
	public void setSentUserId(int sentUserId) {
		this.sentUserId = sentUserId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getReceiveId() {
		return receiveId;
	}
	public void setReceiveId(int receiveId) {
		this.receiveId = receiveId;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "Message [id=" + id + ", sentUserId=" + sentUserId + ", content=" + content + ", receiveId=" + receiveId
				+ ", type=" + type + "]";
	}
	
	
	
	

}
