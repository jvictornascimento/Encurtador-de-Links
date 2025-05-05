package com.jvictornascimento.urlshortene.repositories;

import com.jvictornascimento.urlshortene.models.ShortUrl;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShortUrlRepository extends JpaRepository<ShortUrl, Long> {
    @Transactional
    long deleteByHash(String hash);
}
