package jp.co.rakus.java_marathon_middle.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import jp.co.rakus.java_marathon_middle.domain.Article;
import jp.co.rakus.java_marathon_middle.domain.Comment;
import jp.co.rakus.java_marathon_middle.service.ArticlelService;

/**
 * 記事関連処理コントローラー.
 * コントローラー
 * @author toshiakisato
 *
 */
@Controller
@RequestMapping("/article")
public class ArticleController {

	@Autowired
	private ArticlelService service;

	@ModelAttribute
	public ArticleForm setUpForm1() {
		return new ArticleForm();
	}
	@ModelAttribute
	public CommentForm setUpForm2() {
		return new CommentForm();
	}

	/**
	 * 初期表示.
	 * 
	 * @param model
	 *            モデル
	 * @return 掲示板画面
	 */
	@RequestMapping("/search")
	public String search(Model model) {
		
		List<Article> articleList = service.findAll();
		for (Article article :articleList) {
			article.setCommentList(service.findAllByArtilcled(article.getId()));
		}
		model.addAttribute("articleList", articleList);
		return "article";
	}

	/**
	 * 
	 * 記事追加.
	 * 
	 * @param articleForm
	 *            記事フォーム
	 * @param model
	 *            モデル
	 * @return 掲示板画面
	 */
	@RequestMapping("/add")
	public String add(ArticleForm articleForm, Model model) {
		Article article = new Article();
		BeanUtils.copyProperties(articleForm, article);
		service.insert(article);
		return "redirect:/article/search";
//		return search(model);
	}
	/**
	 * 
	 * コメント追加.
	 * 
	 * @param CommentForm
	 *            コメントフォーム
	 * @param model
	 *            モデル
	 * @return 掲示板画面
	 */
	@RequestMapping("/commentadd")
	public String commentadd(CommentForm commentForm, Model model) {
		Comment comment = new Comment();
		BeanUtils.copyProperties(commentForm, comment);
		service.insert(comment);
		return "redirect:/article/search";
	}
	/**
	 * Idから記事とコメントを削除する.
	 * @param id
	 */
	@RequestMapping("/deleteArticle")
	public String deleteArticle(Integer id){
		service.deleteCommentByArticleId(id);
		service.deleteArticleById(id);
		return "redirect:/article/search";
	}
	

}