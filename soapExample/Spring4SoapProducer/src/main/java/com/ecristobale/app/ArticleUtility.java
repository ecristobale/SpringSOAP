package com.ecristobale.app;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.ecristobal.article.ArticleInfo;

@Component
public class ArticleUtility {
	private Map<Integer, ArticleInfo> articleMap = new HashMap<Integer, ArticleInfo>();

	public ArticleUtility() {
		ArticleInfo a1 = new ArticleInfo();
		a1.setArticleId(1);
		a1.setCategory("photo");
		a1.setTitle("camera");
		articleMap.put(1, a1);
		ArticleInfo a2 = new ArticleInfo();
		a2.setArticleId(2);
		a2.setCategory("Book");
		a2.setTitle("Java");
		articleMap.put(2, a2);
	}

	public ArticleInfo getArticle(int articleId) {
		return articleMap.get(articleId);
	}
}
