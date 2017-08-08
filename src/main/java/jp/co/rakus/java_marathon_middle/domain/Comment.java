package jp.co.rakus.java_marathon_middle.domain;

public class Comment {
	/** コメントID */
	private Integer id;
	/** コメント者名 */
	private String name;
	/** コメント内容 */
	private String content;
	/** 投稿ID */
	private Integer article_id;

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

	public Integer getArticle_id() {
		return article_id;
	}

	public void setArticle_id(Integer article_id) {
		this.article_id = article_id;
	}

}
