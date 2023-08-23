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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Controller
public class ArticleFormController {
    private static final Logger logger = LogManager.getLogger(ArticleFormController.class);
    private final ArticleService articleService;
    @Autowired
    public ArticleFormController(ArticleService articleService) {
        this.articleService = articleService;
    }
    @Transactional
    @PostMapping("article/form/ajout")
    public String ajouterArticle(@Valid @ModelAttribute ArticleForm form, BindingResult results, RedirectAttributes redirectAttributes) {
        logger.info("Tentative d'ajout d'un article avec le libellé: {}", form.getLibelle());
        if (results.hasErrors()) {
            logger.warn("Erreur dans le formulaire d'ajout de l'article.");
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
    @PostMapping("article/upload")
    public String uploadArticle(@ModelAttribute ArticleForm form, BindingResult result, RedirectAttributes redirectAttributes) {
        MultipartFile imageFile = form.getImage();
        // Vérifier si le fichier est non vide
        if (imageFile.isEmpty()) {
            redirectAttributes.addFlashAttribute("selectionVide", "Veuillez sélectionner un fichier");
            return "redirect:/article";
        }

        // Sauvegarder l'image
        String fileName = saveImage(imageFile);
        System.out.println(fileName);
        // Enregistrer le chemin vers l'image dans la base de données
        Article article = new Article();
        // Set other fields of the article
        article.setCheminImage(fileName);
        articleService.save(article);

        redirectAttributes.addFlashAttribute("message", "L'image a été ajoutée avec succès");
        return "redirect:/article";
    }

    private String saveImage(MultipartFile file) {
        logger.debug("Sauvegarde de l'image: {}", file.getOriginalFilename());
        try {
            // Définir le chemin où vous souhaitez sauvegarder l'image
            String folder = "src/main/resources/static/";

            // Construire un nom de fichier unique pour éviter les collisions
            String originalFileName = file.getOriginalFilename();
            String fileName = UUID.randomUUID().toString() + "_" + originalFileName;

            // Créer le chemin du fichier
            Path path = Paths.get(folder + fileName);

            // Écrire le fichier sur le disque
            Files.write(path, file.getBytes());

            // Retourner seulement le nom du fichier (ou le chemin relatif)
            return fileName;
        } catch (IOException e) {
            // Gérer les exceptions comme vous le jugez approprié
            throw new RuntimeException("Échec de la sauvegarde de l'image", e);
        }
    }

}
