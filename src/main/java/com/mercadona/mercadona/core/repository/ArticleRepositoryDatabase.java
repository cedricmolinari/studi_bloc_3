package com.mercadona.mercadona.core.repository;

import com.mercadona.mercadona.core.entity.Article;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ArticleRepositoryDatabase {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ArticleRepositoryDatabase(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Article> list() {
        return jdbcTemplate.query("select * from \"Articles\";",
                (rs, rowNum) -> new Article(rs.getString("LIBELLE"),
                        rs.getString("DESCRIPTION"),
                        rs.getBigDecimal("PRIX")));
    }
}
