package jp.co.rakus.java_marathon_middle.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import jp.co.rakus.java_marathon_middle.domain.Comment;

/**
 * commentsテーブル操作用のリポジトリクラス.
 * 
 * @author toshiakisato
 *
 */
@Repository
public class CommentRepositry {
	@Autowired
	private NamedParameterJdbcTemplate template;

	private static final RowMapper<Comment> commentRowmapper = (rs, i) -> {
		Comment comment = new Comment();
		comment.setId(rs.getInt("id"));
		comment.setName(rs.getString("name"));
		comment.setContent(rs.getString("content"));
		comment.setArticle_id(rs.getInt("article_id"));
		return comment;

	};

	/**
	 * コメント全件検索.
	 * 
	 * @return コメント一覧
	 */
	public List<Comment> findAllByArtilcled(Integer article_id) {
		String sql = "SELECT id,name,content,article_id FROM comments WHERE article_id=:article_id";
		SqlParameterSource param = new MapSqlParameterSource().addValue("article_id", article_id);
		List<Comment> commentList = template.query(sql, param, commentRowmapper);
		return commentList;
	}

	/**
	 * コメント投稿.
	 * 
	 * @param comment
	 *            コメント
	 * @return 投稿されたコメント
	 */
	public Comment insert(Comment comment) {
		SqlParameterSource param = new BeanPropertySqlParameterSource(comment);

		String insertSql = "INSERT INTO comments(name,content,article_id) VALUES(:name,:content,:article_id)";
		template.update(insertSql, param);
		return comment;
	}
	/**
	 * IDからコメントを削除する.
	 * @param id
	 */
	public void deleteByArticle(Integer id){
		String deleteSql="DELETE FROM comments WHERE article_id=:id";
		
		SqlParameterSource param = new MapSqlParameterSource().addValue("id",id);
		
		template.update(deleteSql, param);
	}

}
