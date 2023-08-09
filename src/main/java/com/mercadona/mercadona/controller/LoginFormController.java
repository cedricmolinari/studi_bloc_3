package com.mercadona.mercadona.controller;

import com.mercadona.mercadona.core.entity.Utilisateur;
import com.mercadona.mercadona.core.service.UtilisateurService;
import com.mercadona.mercadona.form.LoginForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class LoginFormController {
    private final UtilisateurService utilisateurService;
    @Autowired
    public LoginFormController(UtilisateurService utilisateurService) { this.utilisateurService = utilisateurService; }
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Transactional
    @PostMapping("login")
    public String connexion(@Valid @ModelAttribute LoginForm form, BindingResult results, RedirectAttributes redirectAttributes) {
        if (results.hasErrors()) {
            return "login";
        }
        String nomUtilisateur = form.getUtilisateur();
        Utilisateur utilisateur = utilisateurService.findByUtilisateur(nomUtilisateur);

        if (utilisateur != null && passwordEncoder.matches(form.getPassword(), utilisateur.getPassword())) {
            redirectAttributes.addFlashAttribute("message", "Vous vous êtes identifiés avec succès.");
            return "redirect:/article"; // Rediriger si succès
        }

        // Si l'utilisateur n'est pas trouvé ou si le mot de passe ne correspond pas, retourner à la page de login
        redirectAttributes.addFlashAttribute("error", "Identifiant ou mot de passe incorrect.");
        return "login";
    }

}
