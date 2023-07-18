package com.mercadona.mercadona.core.entity;

import java.math.BigDecimal;

public class Article {
    private Long id;
    private String libelle;
    private String description;
    BigDecimal prix;

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

    public Article(Long id, String libelle, String description, BigDecimal prix) {
        this.id = id;
        this.libelle = libelle;
        this.description = description;
        this.prix = prix;
    }

    public Article(String libelle, String description, BigDecimal prix) {
        this.libelle = libelle;
        this.description = description;
        this.prix = prix;
    }

    public Article() {
    }
}
