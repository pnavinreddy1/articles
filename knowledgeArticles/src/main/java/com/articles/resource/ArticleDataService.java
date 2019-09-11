package com.articles.resource;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.stereotype.Service;

import com.articles.domain.Article;

@Service
public class ArticleDataService {
	private static List<Article> articles = new ArrayList<>();
	private static AtomicInteger at = new AtomicInteger(0);

	public int getNextCountValue() {
		return at.incrementAndGet();
	}

	public Article saveArticle(Article article) {
		article.setDocId(getNextCountValue());
		articles.add(article);
		return article;
	}

	public List<Article> getAtricles() {
		return articles;
	}

	public Article findAtricleById(int id) {
		return articles.stream()
				.filter(article -> article.getDocId()== id)
				.findAny().orElse(new Article());
	}

	public Article updateAtricle(Article inputArticle) {
		Article existingArticle = findAtricleById(inputArticle.getDocId());
		if(existingArticle.getTitle()!=null) {
			existingArticle.setTitle(inputArticle.getTitle());
			existingArticle.setContent(inputArticle.getContent());
		}
		return existingArticle;
	}

	public boolean deleteAtricleById(int id) {
		Article existingArticle = findAtricleById(id);
		if(existingArticle.getTitle()!=null) {
			articles.remove(existingArticle);
			return true;
		}
		return false;
	}
	
}
