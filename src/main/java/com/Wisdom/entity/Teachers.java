package com.Wisdom.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OrderBy;
import javax.persistence.Table;

@Entity
@Table(name="Teachers")
/**
 * 教师表(Teachers)
 * @author admin
 *
 */
public class Teachers implements Serializable {
	@Id
	@GeneratedValue
	@OrderBy
	@Column(columnDefinition="int unsigned NOT NULL comment '备注：自动编号'")
	private int id;
	@Column(columnDefinition="varchar (50) NOT NULL comment '备注：教师名 '")
	private String name;
	@Column(columnDefinition="int NOT NULL comment '备注：职称id'")
	private int teacherTitleId;
	@Column(columnDefinition="varchar (50) NOT NULL comment '备注：教师号'")
	private String teacherNo;
	@Column(columnDefinition="varchar (50) NOT NULL comment '备注：密码'")
	private String password;
	@Column(columnDefinition="char comment '备注：性别'")
	private String sex;
	@Column(columnDefinition="dateTime comment '备注：生日'")
	private Date birthday;
	@Column(columnDefinition="varchar (50) comment '备注：联系电话'")
	private String telphone;
	@Column(columnDefinition="varchar (50) comment '备注：邮箱'")
	private String email;
	@Column(columnDefinition="varchar (50) comment '备注：家庭住址'")
	private String address;
	@Column(columnDefinition="int NOT NULL comment '备注：专业id'")
	private int professionalId;
	@Column(columnDefinition="int Default 1 comment '备注：是否在职1：在职2：未在职'")
	private int state;
	@Column(columnDefinition="int NOT NULL comment '备注：头像'")
	private int pictureId;
	@Column(columnDefinition="varchar (50) comment '备注：备注'")
	private String mark;
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
	public int getTeacherTitleId() {
		return teacherTitleId;
	}
	public void setTeacherTitleId(int teacherTitleId) {
		this.teacherTitleId = teacherTitleId;
	}
	public String getTeacherNo() {
		return teacherNo;
	}
	public void setTeacherNo(String teacherNo) {
		this.teacherNo = teacherNo;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getTelphone() {
		return telphone;
	}
	public void setTelphone(String telphone) {
		this.telphone = telphone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getProfessionalId() {
		return professionalId;
	}
	public void setProfessionalId(int professionalId) {
		this.professionalId = professionalId;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public int getPictureId() {
		return pictureId;
	}
	public void setPictureId(int pictureId) {
		this.pictureId = pictureId;
	}
	public String getMark() {
		return mark;
	}
	public void setMark(String mark) {
		this.mark = mark;
	}
	@Override
	public String toString() {
		return "Teachers [id=" + id + ", name=" + name + ", teacherTitleId=" + teacherTitleId + ", teacherNo="
				+ teacherNo + ", password=" + password + ", sex=" + sex + ", birthday=" + birthday + ", telphone="
				+ telphone + ", email=" + email + ", address=" + address + ", professionalId=" + professionalId
				+ ", state=" + state + ", pictureId=" + pictureId + ", mark=" + mark + "]";
	}
	
	
}
