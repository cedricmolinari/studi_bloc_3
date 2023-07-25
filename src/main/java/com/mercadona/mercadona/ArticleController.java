package com.mercadona.mercadona;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ArticleController {
    private final ArticleRepository articleRepository;

    @Autowired
    public ArticleController(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    @GetMapping("/article")
    public String displayHome(Model model){
        List<Article> articles = articleRepository.findAll();

        if (articles.isEmpty()) {
            // La liste des articles est vide. Traitez cette situation comme vous le souhaitez.
            // Par exemple, vous pourriez ajouter un message au modèle pour l'afficher dans la vue.
            model.addAttribute("articles", "Aucun article trouvé.");
        } else {
            // La liste des articles n'est pas vide. Ajoutez les articles au modèle comme d'habitude.
            model.addAttribute("articles", articles);
        }

        return "article";
    }

    /*@RequestMapping("/home")
    public String displayHome(){
        return "home";
    }*/
}
