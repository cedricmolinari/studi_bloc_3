package com.mercadona.mercadona.core.repository;

import com.mercadona.mercadona.core.entity.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {
    Utilisateur findByUtilisateur(String utilisateur);
    boolean existsByUtilisateur(String utilisateur);
}

