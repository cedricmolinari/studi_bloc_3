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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
public class ArticleFormController {
    private final ArticleService articleService;
    @Autowired
    public ArticleFormController(ArticleService articleService) {
        this.articleService = articleService;
    }
    @Transactional
    @PostMapping("article/form/ajout")
    public String ajouterArticle(@Valid @ModelAttribute ArticleForm form, BindingResult results, RedirectAttributes redirectAttributes) {
        if (results.hasErrors()) {
            return "ajoutArticle";
        }
        Article article = new Article();
        article.setLibelle(form.getLibelle());
        article.setDescription(form.getDescription());
        article.setPrix(form.getPrix());

        articleService.addArticle(article);

        // Ajouter un message de succès à l'objet RedirectAttributes
        redirectAttributes.addFlashAttribute("message", "L'article a été ajouté avec succès.");

        // Rediriger vers l'URL "/article" en utilisant une redirection temporaire (303)
        return "redirect:/article";
    }
}
