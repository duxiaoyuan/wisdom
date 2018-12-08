package com.wisdom.entity.manager;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;


@Entity
@Table(name="module")
public class Module {
	
	 @Id
	 @GeneratedValue
	 private Integer id;

	 private Integer parentid;

	 @JsonProperty("text")
	 private String modulename;

	 private Integer moduleweight;

	 private String moduleurl;
	 
	 private Integer reservednum;
	    
	 private String ops;
	 
	 @Transient
	 private Boolean checked;
	 
	 @Transient
	 private List<Module> children;
	 
//	 @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
//	 private Timestamp modulecreatetime;
//
//	 @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
//	 private Date modulelastupdatetime;
	 
	 @Column(columnDefinition="int DEFAULT 1 comment '备注:是否可用' ")
	 private Integer status;
	 
//	 @JsonIgnore
//	 @ManyToMany(fetch = FetchType.LAZY,cascade=CascadeType.PERSIST)
//	 @JoinTable(name="role_module_tb",
//	 	joinColumns={@JoinColumn(name="moduleid",referencedColumnName="id")},
//		inverseJoinColumns={@JoinColumn(name="roleid",referencedColumnName="id")})
//	 @JsonIgnore
//	 @ManyToMany(mappedBy="moduleSet")
//	 private Set<Role> roleSet = new HashSet<>();

	@Override
	public String toString() {
		return "Module [id=" + id + ", parentid=" + parentid + ", modulename=" + modulename + ", moduleweight="
				+ moduleweight + ", moduleurl=" + moduleurl + ", reservednum=" + reservednum + ", ops=" + ops
				+ ", checked=" + checked + ", children=" + children + ", status=" + status + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getParentid() {
		return parentid;
	}

	public void setParentid(Integer parentid) {
		this.parentid = parentid;
	}

	public String getModulename() {
		return modulename;
	}

	public void setModulename(String modulename) {
		this.modulename = modulename;
	}

	public Integer getModuleweight() {
		return moduleweight;
	}

	public void setModuleweight(Integer moduleweight) {
		this.moduleweight = moduleweight;
	}

	public String getModuleurl() {
		return moduleurl;
	}

	public void setModuleurl(String moduleurl) {
		this.moduleurl = moduleurl;
	}

	public Integer getReservednum() {
		return reservednum;
	}

	public void setReservednum(Integer reservednum) {
		this.reservednum = reservednum;
	}

	public String getOps() {
		return ops;
	}

	public void setOps(String ops) {
		this.ops = ops;
	}

	public Boolean getChecked() {
		return checked;
	}

	public void setChecked(Boolean checked) {
		this.checked = checked;
	}

	public List<Module> getChildren() {
		return children;
	}

	public void setChildren(List<Module> children) {
		this.children = children;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	 
	 
}
