package com.mercadona.mercadona.controller;

import com.mercadona.mercadona.config.NomUtilisateurDejaExistantException;
import com.mercadona.mercadona.core.entity.Utilisateur;
import com.mercadona.mercadona.core.service.UtilisateurService;
import com.mercadona.mercadona.form.InscriptionForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.ui.Model;

import javax.validation.Valid;

@Controller
public class InscriptionFormController {
    private final UtilisateurService utilisateurService;
    @Autowired
    public InscriptionFormController(UtilisateurService utilisateurService) {
        this.utilisateurService = utilisateurService;
    }

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Transactional
    @PostMapping("inscription")
    public String inscription(@Valid @ModelAttribute InscriptionForm form, BindingResult results, RedirectAttributes redirectAttributes, Model model) {
        if (results.hasErrors()) {
            return "inscription";
        }
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setUtilisateur(form.getUtilisateur());

        String hashedPassword = passwordEncoder.encode(form.getPassword());
        utilisateur.setPassword(hashedPassword);
        try {
            utilisateurService.ajoutUtilisateur(utilisateur);
        } catch (NomUtilisateurDejaExistantException e) {
            model.addAttribute("koInscription", e.getMessage());
            // Ajouter un message de succès à l'objet RedirectAttributes
            return "inscription";
        }

        // Ajouter un message de succès à l'objet RedirectAttributes
        redirectAttributes.addFlashAttribute("okInscription", "L'inscription a été faite avec succès.");

        // Rediriger vers l'URL "/login" en utilisant une redirection temporaire (303)
        return "redirect:/login";
    }
}
