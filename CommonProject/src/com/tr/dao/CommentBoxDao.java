package com.tr.dao;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.tr.model.CommentBox;
import com.tr.model.Inventory;
import com.tr.model.UserInfo;

@Transactional
public interface CommentBoxDao {

	public Inventory addComment(String bookname, String user, String comment,
			Inventory booktocomment, UserInfo commenter);

	public List<CommentBox> viewcomments(double isbn);

}
