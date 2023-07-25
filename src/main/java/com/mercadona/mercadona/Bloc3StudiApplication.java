package com.mercadona.mercadona;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.util.List;

@SpringBootApplication
public class Bloc3StudiApplication implements CommandLineRunner {
//public class Bloc3StudiApplication {
	@Autowired
	private ArticleRepository articleRepository;

	public static void main(String[] args) {
		SpringApplication.run(Bloc3StudiApplication.class, args);
	}

	public void run(String... args) {
		List<Article> articles = articleRepository.findAll();
		for (Article article : articles) {
			System.out.println(article);
		}
	}
}
