package com.tr.model;

import java.io.File;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "CP_USERINFO")
public class UserInfo {

	private int user_identity;
	private String username;
	private String password;
	private String email;
	private File profile_pic;
	private UserInfo referrer;

	public UserInfo() {

	}

	@Id
	@GenericGenerator(name = "USER_IDENTITY", strategy = "assigned")
	@GeneratedValue(generator = "USER_IDENTITY")
	@Column(name = "USER_IDENTITY")
	public int getUser_identity() {
		return user_identity;
	}

	public void setUser_identity(int user_identity) {
		this.user_identity = user_identity;
	}

	public void setUsername(String un) {
		this.username = un;
	}

	@Column(name = "USER_NAME")
	public String getUsername() {
		return username;
	}

	@Column(name = "PASSWORD")
	public String getPassword() {
		return password;
	}

	public void setPassword(String pw) {
		this.password = pw;
	}

	@Column(name = "EMAIL")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "PROFILE_PIC")
	public File getProfile_pic() {
		return profile_pic;
	}

	public void setProfile_pic(File profile_pic) {
		this.profile_pic = profile_pic;
	}

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "REFERRER")
	public UserInfo getReferrer() {
		return referrer;
	}

	public void setReferrer(UserInfo referrer) {
		this.referrer = referrer;
	}

}