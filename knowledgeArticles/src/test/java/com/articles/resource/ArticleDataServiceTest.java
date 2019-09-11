package com.articles.resource;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.test.util.ReflectionTestUtils;

import com.articles.domain.Article;
import com.articles.resource.ArticleDataService;

public class ArticleDataServiceTest {
	private ArticleDataService testSubject = new ArticleDataService();
	private List<Article> articles = new ArrayList<>();
	private Article article = new Article();
	@Before
	public void setUp() throws Exception {
		
		article.setContent("content");
		article.setTitle("title");
		article.setDocId(1);
	}

	@Test
	public void testFindArticleById() {
		articles.add(article);
		ReflectionTestUtils.setField(testSubject, "articles", articles);
		
		Article result= testSubject.findAtricleById(1);
		assertThat(result.getContent(), is("content"));
		assertThat(result.getDocId(), is(1));
	}

	@Test
	public void testNotFoundArticleById() {
		articles.add(article);
		ReflectionTestUtils.setField(testSubject, "articles", articles);
		
		Article result= testSubject.findAtricleById(0);
		assertThat(result.getContent(), is(nullValue()));
	}
	
	@Test
	public void testSaveArticle() {
		Article article = new Article();
		article.setContent("content");
		article.setTitle("title");
		
		Article result= testSubject.saveArticle(article);
		assertThat(result.getContent(), is("content"));
		assertThat(result.getTitle(), is("title"));
		assertThat(result.getDocId(), is(notNullValue()));
	}

	@Test
	public void testUpdateArticle() {
		article.setTitle("new Title");
		articles.add(article);
		ReflectionTestUtils.setField(testSubject, "articles", articles);
		
		Article result= testSubject.updateAtricle(article);
		assertThat(result.getContent(), is("content"));
		assertThat(result.getTitle(), is("new Title"));
		assertThat(result.getDocId(), is(1));
	}

}
