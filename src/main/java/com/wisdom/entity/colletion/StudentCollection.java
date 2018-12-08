package com.wisdom.entity.colletion;

import java.util.Date;

import javax.persistence.Column;

import com.wisdom.entity.Students;

public class StudentCollection extends Students {
	
	private String name;
	private int age;
	private String sex;
	private Date birthday;
	private String address;
	private String studentNo;
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
	
	public StudentCollection() {
		super();
		// TODO Auto-generated constructor stub
	}
	public StudentCollection(String name, int age, String sex, Date birthday, String address, String studentNo) {
		super();
		this.name = name;
		this.age = age;
		this.sex = sex;
		this.birthday = birthday;
		this.address = address;
		this.studentNo = studentNo;
	}
	@Override
	public String toString() {
		return "StudentCollection [name=" + name + ", age=" + age + ", sex=" + sex + ", birthday=" + birthday
				+ ", address=" + address + ", studentNo=" + studentNo + "]";
	}
	
	

}
