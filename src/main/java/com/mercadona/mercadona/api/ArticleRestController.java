package com.mercadona.mercadona.api;

import com.mercadona.mercadona.core.entity.Article;
import com.mercadona.mercadona.core.service.ArticleService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ArticleRestController {
    /*private final ArticleService articleService;

    public ArticleRestController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @GetMapping("/article")
    public List<Article> getAllArticles() {
        return articleService.list();
    }*/

}

