package jp.co.rakus.java_marathon_middle.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jp.co.rakus.java_marathon_middle.domain.Article;
import jp.co.rakus.java_marathon_middle.domain.Comment;
import jp.co.rakus.java_marathon_middle.repository.ArticleRepsitory;
import jp.co.rakus.java_marathon_middle.repository.CommentRepositry;

/**
 * 記事関連サービスクラス.
 * 
 * @author toshiakisato
 *
 */
@Service
@Transactional
public class ArticlelService {

	@Autowired
	private ArticleRepsitory articlerepository;
	@Autowired
	private CommentRepositry commentrepository;

	/**
	 * 記事全件検索.
	 * 
	 * @return 記事全件リスト
	 *
	 */
	public List<Article> findAll() {
		return articlerepository.findAll();
	}

	/**
	 * 
	 * 引数でもらった記事を投稿する.
	 * 
	 * @param article
	 *            記事
	 * @return 投稿された記事
	 */
	public Article insert(Article article) {
		return articlerepository.insert(article);
	}

	
	/**
	 * 引数でもらったIDの記事についているコメント一覧を持ってくる.
	 * @param articleld
	 * コメント
	 * @return　コメント一覧
	 */
	public List<Comment> findAllByArtilcled(Integer articleld) {
		return commentrepository.findAllByArtilcled(articleld);
	}
	/**
	 * 
	 * 引数でもらっコメントを投稿する.
	 * 
	 * @param comment
	 *            コメント
	 * @return 投稿されたコメント
	 */
	public Comment insert(Comment comment) {
		return commentrepository.insert(comment);
	}
	public void deleteCommentByArticleId(Integer id){
		commentrepository.deleteByArticle(id);
	}
	
	public void deleteArticleById(Integer id){
		articlerepository.deleteById(id);
	}
}
