package com.mercadona.mercadona.web.controller;

import com.mercadona.mercadona.core.entity.Article;
import com.mercadona.mercadona.core.repository.ArticleRepositoryDatabase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class HomeController {
    private final ArticleRepositoryDatabase articleRepositoryDatabase;

    @Autowired
    public HomeController(ArticleRepositoryDatabase articleRepositoryDatabase) {
        this.articleRepositoryDatabase = articleRepositoryDatabase;
    }

    @GetMapping("/home")
    public String displayHome(Model model){
        List<Article> articles = articleRepositoryDatabase.list();
        model.addAttribute("articles", articles);
        return "home";
    }
    /*@RequestMapping("/home")
    public String displayHome(){
        return "home";
    }*/
}
