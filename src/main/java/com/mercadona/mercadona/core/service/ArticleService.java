package com.mercadona.mercadona.core.service;

import com.mercadona.mercadona.core.entity.Article;
import com.mercadona.mercadona.core.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ArticleService {
    @Autowired
    ArticleRepository articleRepository;

    public List<Article> list() {

        List<Article> articles = articleRepository.findAll();
        return articles;
    }

    public void addArticle(Article articleAAjouter) {
        articleRepository.save(articleAAjouter);
    }
    @Transactional
    public void updateArticle(Article article) {
        articleRepository.save(article);
    }
    public Article findById(Long id) {
        // Utilisez la méthode findById du ArticleRepository pour récupérer l'article par son identifiant
        return articleRepository.findById(id).orElse(null);
    }

    /*public void modifArticle(Article articleAModifier) { articleRepository.}*/

}

