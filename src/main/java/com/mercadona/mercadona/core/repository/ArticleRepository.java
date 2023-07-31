package com.mercadona.mercadona.core.repository;

import com.mercadona.mercadona.core.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ArticleRepository extends JpaRepository<Article, Long> {
    
}

