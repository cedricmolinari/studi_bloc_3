package com.mercadona.mercadona;

import com.mercadona.mercadona.api.ArticleRestController;
import com.mercadona.mercadona.core.entity.Article;
import com.mercadona.mercadona.core.entity.ArticleModificationRequest;
import com.mercadona.mercadona.core.service.ArticleService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import java.math.BigDecimal;

public class ArticleRestControllerTest {

    @Mock
    private ArticleService articleService;

    @InjectMocks
    private ArticleRestController articleRestController;

    private ArticleModificationRequest request;
    private Article article;

    @BeforeEach
    public void setUp() {
        // Ici, nous initialisons les mocks et créons des objets de test
        articleService = mock(ArticleService.class);
        articleRestController = new ArticleRestController(articleService);

        request = new ArticleModificationRequest();
        request.setId(1L);
        request.setLibelle("Libellé modifié");
        request.setDescription("Description modifiée");
        request.setPrix(new BigDecimal("10.50"));

        article = new Article();
        article.setId(1L);
        article.setLibelle("Libellé original");
        article.setDescription("Description originale");
        article.setPrix(new BigDecimal("9.99"));
    }

    @Test
    public void modifArticle_ArticleExists_ArticleModified() {
        // Simuler le comportement du service
        when(articleService.findById(request.getId())).thenReturn(article);

        ResponseEntity<Object> response = articleRestController.modifArticle(request);

        // Vérifier que la réponse est OK
        assertEquals(HttpStatus.OK, response.getStatusCode());

        // Vérifier que l'article a été mis à jour
        assertEquals(request.getLibelle(), article.getLibelle());
        assertEquals(request.getDescription(), article.getDescription());
        assertEquals(request.getPrix(), article.getPrix());

        // Vérifier que les méthodes appropriées du service ont été appelées
        verify(articleService).findById(request.getId());
        verify(articleService).updateArticle(article);
    }

    @Test
    public void modifArticle_ArticleNotFound_NotFoundResponse() {
        // Simuler le comportement du service lorsqu'aucun article n'est trouvé
        when(articleService.findById(request.getId())).thenReturn(null);

        ResponseEntity<Object> response = articleRestController.modifArticle(request);

        // Vérifier que la réponse est NOT_FOUND
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());

        // Vérifier que updateArticle n'a pas été appelée
        verify(articleService, never()).updateArticle(any());
    }
}
