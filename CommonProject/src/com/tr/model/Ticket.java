package com.tr.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "Ticket")
public class Ticket implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GenericGenerator(name = "generator", strategy = "increment")
	@GeneratedValue(generator = "generator")
	@Column(name = "ticketid")
	private Integer ticketid;

	@Column(name = "ticketname")
	private String ticketname;

	@OneToMany
	@OnDelete(action = OnDeleteAction.CASCADE)
	public List<Employee> getEmployeeList() {
		return getEmployeeList();
	}

	@Column(name = "empid")
	private Integer tempID;

	@Column(name = "service")
	private String service;

	public Integer getTicketid() {
		return ticketid;
	}

	public void setTicketid(Integer ticketid) {
		this.ticketid = ticketid;
	}

	public String getTicketname() {
		return ticketname;
	}

	public void setTicketname(String ticketname) {
		this.ticketname = ticketname;
	}

	public void setTempID(Integer tempID) {
		this.tempID = tempID;
	}

	public Integer getTempID() {
		return tempID;
	}

	public String getService() {
		return service;
	}

	public void setService(String service) {
		this.service = service;
	}
}
