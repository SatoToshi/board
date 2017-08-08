package jp.co.rakus.java_marathon_middle.domain;

import java.util.List;

/**
 * 記事を表すクラス.
 * 
 * @author toshiakisato
 *
 */
public class Article {
	/** ID */
	private Integer id;
	/** 投稿者名 */
	private String name;
	/** 投稿記事 */
	private String content;
	/** 投稿コメント一覧 */
	private List<Comment> commentList;

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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public List<Comment> getCommentList() {
		return commentList;
	}

	public void setCommentList(List<Comment> commentList) {
		this.commentList = commentList;
	}

}
