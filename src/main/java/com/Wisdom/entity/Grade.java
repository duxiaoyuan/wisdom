package com.Wisdom.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OrderBy;
import javax.persistence.Table;

/**
 * 评级(Grade)
 * @author admin
 *
 */
@Entity
@Table(name="Grade")
public class Grade implements Serializable {

	@Id
	@GeneratedValue
	@OrderBy
	@Column(columnDefinition="int unsigned NOT NULL comment '备注：自动编号'")
	private int id;
	@Column(columnDefinition="varchar (50) NOT NULL comment '备注：等级 '")
	private String name;
	@Column(columnDefinition="double NOT NULL comment '备注：系数 '")
	private Double Coefficient;
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
	public Double getCoefficient() {
		return Coefficient;
	}
	public void setCoefficient(Double coefficient) {
		Coefficient = coefficient;
	}
	@Override
	public String toString() {
		return "CourseSelection [id=" + id + ", name=" + name + ", Coefficient=" + Coefficient + "]";
	}
	
	
}
