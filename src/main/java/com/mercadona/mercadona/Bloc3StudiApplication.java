package com.mercadona.mercadona;

import com.mercadona.mercadona.core.entity.Article;
import com.mercadona.mercadona.core.repository.ArticleRepositoryDatabase;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;

import java.util.List;

@SpringBootApplication
@EnableJdbcRepositories
public class Bloc3StudiApplication {

	public static void main(String[] args) {

		SpringApplication.run(Bloc3StudiApplication.class, args);

		ArticleRepositoryDatabase articleRepositoryDatabase = new ArticleRepositoryDatabase();

		List<Article> articles = articleRepositoryDatabase.list();
		for (Article article : articles) {
			System.out.println(article);
		}

	}


}
