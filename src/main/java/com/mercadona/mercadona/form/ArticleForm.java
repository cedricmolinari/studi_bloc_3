package com.mercadona.mercadona.form;

import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.math.BigInteger;

public class ArticleForm {

    private Long id;
    @NotBlank(message = "Veuillez entrer un libellé")
    @Size(max = 20)
    private String libelle;
    @NotBlank(message = "Veuillez entrer une description")
    @Size(max = 255)
    private String description;
    @NotBlank(message = "Veuillez entrer un prix")
    private BigDecimal prix;

    private MultipartFile image;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrix() {
        return prix;
    }

    public void setPrix(BigDecimal prix) {
        this.prix = prix;
    }

    public MultipartFile getImage() {
        return image;
    }

    public void setImage(MultipartFile image) {
        this.image = image;
    }
}
