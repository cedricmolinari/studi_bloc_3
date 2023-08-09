package com.mercadona.mercadona.config;

public class NomUtilisateurDejaExistantException extends RuntimeException {
    public NomUtilisateurDejaExistantException(String message) {
        super(message);
    }
}
