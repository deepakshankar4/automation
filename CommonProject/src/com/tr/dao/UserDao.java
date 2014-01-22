package com.tr.dao;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.tr.model.UserInfo;

@Transactional
public interface UserDao {
	public List<UserInfo> LoginDao(String un, String epw);

	public List<UserInfo> LoginDao(String gmail);

	

	public List<UserInfo> fetchUsers(String usr);
	
	public List<UserInfo> fetchUsers(int usr);
	

	public Integer regNewUser(String un, String pw, String email,
			String referrer);

}
