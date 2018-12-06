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
 * 学生表(Students)
 * @author admin
 *
 */
@Entity
@Table(name="Students")
public class Students implements Serializable {

	@Id
	@GeneratedValue
	@OrderBy
	@Column(columnDefinition="int unsigned NOT NULL comment '备注：自动编号'")
	private Integer id;
	@Column(columnDefinition="varchar (50) NOT NULL comment '备注：姓名'")
	private String name;
	@Column(columnDefinition="int  comment '备注：年龄'")
	private int age;
	@Column(columnDefinition="char comment '备注：性别 '")
	private String sex;
	@Column(columnDefinition="datetime  comment '备注：生日'")
	private Date birthday;
	@Column(columnDefinition="varchar (50) comment '备注：家庭住址 '")
	private String address;
	@Column(columnDefinition="varchar (50) NOT NULL comment '备注：学号 '")
	private String studentNo;
	@Column(columnDefinition="varchar (50) NOT NULL comment '备注：密码 '")
	private String password;
	@Column(columnDefinition="varchar (50) comment '备注：手机号 '")
	private String telphone;
	@Column(columnDefinition="varchar (50) comment '备注：邮箱 '")
	private String email;
	@Column(columnDefinition="double Default 0 comment '备注：学分 '")
	private Double creadit;
	@Column(columnDefinition="int NOT NULL comment '备注：班级id'")
	private int classId;
	@Column(columnDefinition="int Default 1 comment '备注：是否锁定0：未锁定1：以锁定'")
	private int isLock;
	@Column(columnDefinition="int Default 1 comment '备注：是否毕业0：毕业1：正常2退学 '")
	private int state;
	@Column(columnDefinition="int NOT NULL comment '备注：头像 '")
	private int pictureId;
	@Column(columnDefinition="varchar (50) comment '备注：备注 '")
	private String mark;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getStudentNo() {
		return studentNo;
	}
	public void setStudentNo(String studentNo) {
		this.studentNo = studentNo;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
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
	public Double getCreadit() {
		return creadit;
	}
	public void setCreadit(Double creadit) {
		this.creadit = creadit;
	}
	public int getClassId() {
		return classId;
	}
	public void setClassId(int classId) {
		this.classId = classId;
	}
	public int getIsLock() {
		return isLock;
	}
	public void setIsLock(int isLock) {
		this.isLock = isLock;
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
		return "Students [id=" + id + ", name=" + name + ", age=" + age + ", sex=" + sex + ", birthday=" + birthday
				+ ", address=" + address + ", studentNo=" + studentNo + ", password=" + password + ", telphone="
				+ telphone + ", email=" + email + ", creadit=" + creadit + ", classId=" + classId + ", isLock=" + isLock
				+ ", state=" + state + ", pictureId=" + pictureId + ", mark=" + mark + "]";
	}

	
	
	
}
