package com.mercadona.mercadona.core.service;

import com.mercadona.mercadona.core.entity.Article;
import com.mercadona.mercadona.core.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleService {
    @Autowired
    ArticleRepository articleRepository;

    public List<Article> list() {

        List<Article> articles = articleRepository.findAll();
        return articles;
    }

    public void addArticle(Article nouvelArticle) {
        articleRepository.save(nouvelArticle);
    }
}

