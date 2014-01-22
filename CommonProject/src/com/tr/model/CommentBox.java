package com.tr.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "CP_COMMENTBOX")
public class CommentBox {

	private int commentBoxId;
	private UserInfo commenter;
	private Inventory book;
	private String commenter_comment;

	@Id
	@GenericGenerator(name = "COMMENT_BOX", strategy = "assigned")
	@GeneratedValue(generator = "COMMENT_BOX")
	@Column(name = "COMMENT_BOX_ID")
	public int getCommentBoxId() {
		return commentBoxId;
	}

	public void setCommentBoxId(int commentBoxId) {
		this.commentBoxId = commentBoxId;
	}

	@ManyToOne(cascade = CascadeType.ALL)
	public UserInfo getCommenter() {
		return commenter;
	}

	public void setCommenter(UserInfo commenter) {
		this.commenter = commenter;
	}

	@ManyToOne(cascade = CascadeType.ALL)
	public Inventory getBook() {
		return book;
	}

	public void setBook(Inventory book) {
		this.book = book;
	}

	@Column(name = "COMMENTS")
	public String getCommenter_comment() {
		return commenter_comment;
	}

	public void setCommenter_comment(String commenter_comment) {
		this.commenter_comment = commenter_comment;
	}

}
