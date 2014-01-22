package com.tr.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "CP_PUBLISHER")
public class Publisher {
	public int pid;
	private String publisherName;
	private String ownerName;
	private String password;

	@Id
	@GenericGenerator(name = "PID", strategy = "assigned")
	@GeneratedValue(generator = "PID")
	@Column(name = "PID")
	public int getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	@Column(name = "PUBLISHER_NAME")
	public String getPublisherName() {
		return publisherName;
	}

	public void setPublisherName(String publisherName) {
		this.publisherName = publisherName;
	}

	@Column(name = "OWNER_NAME")
	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	@Column(name = "PASSWORD")
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Publisher(String publisherName, String ownerName, String password) {

		this.publisherName = publisherName;
		this.ownerName = ownerName;
		this.password = password;
	}

	public Publisher() {
		// TODO Auto-generated constructor stub
	}

}
