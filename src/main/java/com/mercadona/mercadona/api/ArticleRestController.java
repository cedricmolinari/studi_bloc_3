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

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@RestController
@RequestMapping("/api/article")
public class ArticleRestController {
    private static final Logger LOGGER = LogManager.getLogger(ArticleRestController.class);

    private final ArticleService articleService;

    @Autowired
    public ArticleRestController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @PostMapping("/modif")
    public ResponseEntity<Object> modifArticle(@RequestBody ArticleModificationRequest request) {

        Long articleId = request.getId();
        LOGGER.info("Tentative de modification de l'article avec l'ID : {}", articleId);
        // Effectuez les opérations de modification de l'article ici en utilisant les informations du `request`
        // Par exemple :
        Article article = articleService.findById(request.getId());
        if (article == null) {
            LOGGER.warn("Aucun article trouvé avec l'ID : {}", articleId);
            return ResponseEntity.notFound().build();
        }

        LOGGER.debug("Article original : Libellé = {}, Description = {}, Prix = {}", article.getLibelle(), article.getDescription(), article.getPrix());

        article.setLibelle(request.getLibelle());
        article.setDescription(request.getDescription());
        article.setPrix(request.getPrix());

        articleService.updateArticle(article);
        LOGGER.info("Article avec l'ID {} a été mis à jour avec succès.", articleId);
        LOGGER.debug("Article mis à jour : Libellé = {}, Description = {}, Prix = {}", article.getLibelle(), article.getDescription(), article.getPrix());

        // Créer un objet JSON pour représenter la réponse
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Article modifié avec succès.");

        return ResponseEntity.ok(response);
    }
}

