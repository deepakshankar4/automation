package com.tr.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "Roles")
public class Roles implements Serializable {

	private static final long serialVersionUID = -723583058586873479L;

	@Id
	@GenericGenerator(name = "generator", strategy = "increment")
	@GeneratedValue(generator = "generator")
	@Column(name = "rid")
	private Integer rid;

	@Column(name = "authority")
	private String authority;

	@OneToOne
	@JoinColumn(name = "empid")
	private Employee employeeid;

	@OneToOne
	@JoinColumn(name = "pid")
	private Publisher pid;

	@OneToOne
	@JoinColumn(name = "user_identity")
	private UserInfo user_identity;

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	public Employee getEmployeeid() {
		return employeeid;
	}
	
	public void setEmployeeid(Employee employeeid) {
		this.employeeid = employeeid;
	}
	

	public Publisher getPid() {
		return pid;
	}

	public void setPid(Publisher pid) {
		this.pid = pid;
	}

	public Integer getRid() {
		return rid;
	}

	public void setRid(Integer rid) {
		this.rid = rid;
	}

	public UserInfo getUser_identity() {
		return user_identity;
	}

	public void setUser_identity(UserInfo user_identity) {
		this.user_identity = user_identity;
	}

}