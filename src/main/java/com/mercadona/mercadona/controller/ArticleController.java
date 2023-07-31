package com.mercadona.mercadona.controller;

import com.mercadona.mercadona.core.entity.Article;
import com.mercadona.mercadona.core.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ArticleController {
    private final ArticleService articleService;
    @Autowired
    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }
    @GetMapping("/article")
    public String displayArticles(Model model) {
        List<Article> articles = articleService.list();
        model.addAttribute("articles", articles);
        return "article";
    }
}
