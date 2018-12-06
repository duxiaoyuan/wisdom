package com.wisdom.entity.condittion;

public class StudentsCondittion {

	private String name;
	private String telphone;
	private String studentNo;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTelphone() {
		return telphone;
	}
	public void setTelphone(String telphone) {
		this.telphone = telphone;
	}
	public String getStudentNo() {
		return studentNo;
	}
	public void setStudentNo(String studentNo) {
		this.studentNo = studentNo;
	}
	@Override
	public String toString() {
		return "StudentsCondittion [name=" + name + ", telphone=" + telphone + ", studentNo=" + studentNo + "]";
	}
	public StudentsCondittion(String name, String telphone, String studentNo) {
		super();
		this.name = name;
		this.telphone = telphone;
		this.studentNo = studentNo;
	}
	public StudentsCondittion() {
		super();
	}
	
	
}
