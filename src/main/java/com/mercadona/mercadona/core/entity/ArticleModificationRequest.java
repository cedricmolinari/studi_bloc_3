package com.mercadona.mercadona.core.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
@Entity
@Table(name = "articles")
public class ArticleModificationRequest {
    @Id
    private Long id;
    @Column(name = "libelle")
    private String libelle;
    @Column(name = "description")
    private String description;
    @Column(name = "prix")
    private BigDecimal prix;

    // Getters, setters et constructeurs

    public ArticleModificationRequest(Long id, String libelle, String description, BigDecimal prix) {
        this.id = id;
        this.libelle = libelle;
        this.description = description;
        this.prix = prix;
    }

    public ArticleModificationRequest() {

    }

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
}

