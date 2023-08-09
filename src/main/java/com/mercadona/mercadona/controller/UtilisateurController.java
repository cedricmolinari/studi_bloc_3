package com.mercadona.mercadona.controller;

import com.mercadona.mercadona.form.InscriptionForm;
import com.mercadona.mercadona.form.LoginForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UtilisateurController {
    @GetMapping("/login")
    public String displayLogin(Model model) {
        model.addAttribute("loginForm", new LoginForm());
        return "login";
    }
    @GetMapping("/inscription")
    public String displayInscription(Model model) {
        model.addAttribute("inscriptionForm", new InscriptionForm());
        return "inscription";
    }
}
