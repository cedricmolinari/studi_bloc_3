package com.mercadona.mercadona;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleService {
    @Autowired
    ArticleRepository articleRepository;


    /*public ArticleService(ArticleRepository articleRepository) {

        this.articleRepository = articleRepository;
    }*/

    public List<Article> list() {

        List<Article> articles = articleRepository.findAll();
        return articles;
    }

    public void addArticle(Article nouvelArticle) {
        articleRepository.save(nouvelArticle);
    }
}

