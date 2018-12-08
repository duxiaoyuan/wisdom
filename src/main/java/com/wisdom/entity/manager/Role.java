package com.wisdom.entity.manager;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashSet;
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


@Entity
@Table(name="role")
public class Role {
	
	@Id
	@GeneratedValue
    private Integer id;

    private String rolename;

    @Column(columnDefinition="int DEFAULT 1 comment '备注:是否可用' ")
    private Integer status;
    
    private Integer reservednum;
    
    private String ops;
    
    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY,cascade=CascadeType.PERSIST)
    @JoinTable(name="role_module_tb",
		joinColumns={@JoinColumn(name="roleid",referencedColumnName="id")},
		inverseJoinColumns={@JoinColumn(name="moduleid",referencedColumnName="id")})
	@NotFound(action = NotFoundAction.IGNORE)
    private Set<Module> moduleSet = new HashSet<>();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRolename() {
		return rolename;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
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

	public Set<Module> getModuleSet() {
		return moduleSet;
	}

	public void setModuleSet(Set<Module> moduleSet) {
		this.moduleSet = moduleSet;
	}
    
 
//    @JsonIgnore
//    @ManyToMany(mappedBy="roleSet")
//    private Set<User> userSet = new HashSet();
    
//    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
//    private Date rolecreatetime;

//    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
//    private Timestamp rolelastupdatetime;
    
}