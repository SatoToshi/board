package jp.co.rakus.java_marathon_middle.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import jp.co.rakus.java_marathon_middle.domain.Article;

/**
 * articlesテーブル操作用のリポジトリクラス.
 * 
 * @author toshiakisato
 *
 */
@Repository
public class ArticleRepsitory {
	@Autowired
	private NamedParameterJdbcTemplate template;

	private static final RowMapper<Article> articleRowmapper = (rs, i) -> {
		Article article = new Article();
		article.setId(rs.getInt("id"));
		article.setName(rs.getString("name"));
		article.setContent(rs.getString("content"));
		return article;

	};

	/**
	 * 記事全件検索.
	 * 
	 * @return 記事一覧
	 */
	public List<Article> findAll() {
		String sql = "SELECT id,name,content FROM articles ";
		List<Article> articlelList = template.query(sql, articleRowmapper);
		return articlelList;
	}

	/**
	 * 記事投稿.
	 * 
	 * @param article
	 *            記事
	 * @return 投稿された記事
	 */
	public Article insert(Article article) {
		SqlParameterSource param = new BeanPropertySqlParameterSource(article);

		String insertSql = "INSERT INTO articles(name,content) VALUES(:name,:content)";
		template.update(insertSql, param);
		return article;
	}
	/**
	 * IDから投稿記事を削除する.
	 * @param id
	 */
	public void deleteById(Integer id){
		String deleteSql="DELETE FROM articles WHERE id=:id";
		
		SqlParameterSource param = new MapSqlParameterSource().addValue("id",id);
		
		template.update(deleteSql, param);
	}
}
