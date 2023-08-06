package com.mercadona.mercadona.api;

import com.mercadona.mercadona.core.entity.Article;
import com.mercadona.mercadona.core.entity.ArticleModificationRequest;
import com.mercadona.mercadona.core.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/article")
public class ArticleRestController {

    private final ArticleService articleService;

    @Autowired
    public ArticleRestController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @PostMapping("/modif")
    public ResponseEntity<Object> modifArticle(@RequestBody ArticleModificationRequest request) {

        Long articleId = request.getId();
        // Effectuez les opérations de modification de l'article ici en utilisant les informations du `request`
        // Par exemple :
        Article article = articleService.findById(request.getId());
        if (article == null) {
            return ResponseEntity.notFound().build();
        }

        article.setLibelle(request.getLibelle());
        article.setDescription(request.getDescription());
        article.setPrix(request.getPrix());

        articleService.updateArticle(article);
        System.out.println(article);

        // Créer un objet JSON pour représenter la réponse
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Article modifié avec succès.");

        return ResponseEntity.ok(response);
    }
}

