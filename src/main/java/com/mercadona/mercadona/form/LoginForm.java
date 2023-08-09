package com.mercadona.mercadona.form;

import javax.validation.constraints.NotBlank;

public class LoginForm {
    private Long id;
    @NotBlank(message = "Veuillez entrer votre identifiant")
    private String utilisateur;
    @NotBlank(message = "Veuillez entrer votre mot de passe")
    private String password;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(String utilisateur) {
        this.utilisateur = utilisateur;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
