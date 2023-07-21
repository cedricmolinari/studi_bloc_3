package com.mercadona.mercadona;

import com.mercadona.mercadona.core.entity.Article;
import com.mercadona.mercadona.core.repository.ArticleRepositoryDatabase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;

import java.util.List;

@SpringBootApplication
@EnableJdbcRepositories
@ComponentScan(basePackages = "com.mercadona.mercadona.core.repository")
public class Bloc3StudiApplication implements CommandLineRunner {
//public class Bloc3StudiApplication {
	@Autowired
	private ArticleRepositoryDatabase articleRepositoryDatabase;

	public static void main(String[] args) {
		SpringApplication.run(Bloc3StudiApplication.class, args);
	}

	public void run(String... args) {
		List<Article> articles = articleRepositoryDatabase.list();
		for (Article article : articles) {
			System.out.println(article);
		}
	}
}
