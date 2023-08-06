package com.mercadona.mercadona.controller;

import com.mercadona.mercadona.core.entity.Article;
import com.mercadona.mercadona.core.service.ArticleService;
import com.mercadona.mercadona.form.ArticleForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
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

    @GetMapping("article/form")
    public String displayArticleForm(Model model) {
        model.addAttribute("articleForm", new ArticleForm());
        return "ajoutArticle";
    }

}
