package com.tr.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "Employee")
public class Employee implements Serializable {

	private static final long serialVersionUID = -723583058586873479L;

	@Id
	@GenericGenerator(name = "generator", strategy = "increment")
	@GeneratedValue(generator = "generator")
	@Column(name = "empid")
	// , columnDefinition="serial")
	private Integer id;

	@Column(name = "empname")
	private String name;

	@Column(name = "lastname")
	private String lastname;

	@Column(name = "empaddress")
	private String address;

	@Column(name = "salary")
	private Long salary;

	@Column(name = "empAge")
	private Integer age;
	
	@Column(name="username")
	private String username;
	
	@Column(name="password")
	private String password;

	@OneToMany(targetEntity = Ticket.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "empid", table = "TICKET")
	public List<Ticket> getTicketList() {
		return getTicketList();
	}

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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Long getSalary() {
		return salary;
	}

	public void setSalary(Long salary) {
		this.salary = salary;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getLastname() {
		return lastname;
	}
}
