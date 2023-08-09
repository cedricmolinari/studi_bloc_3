package com.mercadona.mercadona.core.service;

import com.mercadona.mercadona.config.NomUtilisateurDejaExistantException;
import com.mercadona.mercadona.core.entity.Utilisateur;
import com.mercadona.mercadona.core.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UtilisateurService {
    @Autowired
    UtilisateurRepository utilisateurRepository;


    public Utilisateur findByUtilisateur(String utilisateur) {
        return utilisateurRepository.findByUtilisateur(utilisateur);
    }

    public void ajoutUtilisateur(Utilisateur utilisateur) {
        if (utilisateurRepository.existsByUtilisateur(utilisateur.getUtilisateur())) {
            throw new NomUtilisateurDejaExistantException("Le nom utilisateur choisi existe déjà.");
        }
        utilisateurRepository.save(utilisateur);
    }

}
