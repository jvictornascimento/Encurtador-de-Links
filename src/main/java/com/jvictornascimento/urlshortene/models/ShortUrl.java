package com.jvictornascimento.urlshortene.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "TB_URL_SHORTENED", indexes = {
        @Index(name = "idx_hash", columnList = "hash", unique = true)
        })
public class ShortUrl {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String hash;

    @Column(nullable = false)
    private String originalUrl;

    private int clickCount;

    private LocalDateTime creationDate;

    private LocalDateTime expirationDate;

    @ManyToOne
    @JoinColumn(name = "userId", nullable = false)
    @JsonIgnore
    private UserModel user;

    public ShortUrl() {
    }

    public ShortUrl(Long id, String hash, String originalUrl, int clickCount, LocalDateTime creationDate, LocalDateTime expirationDate, UserModel user) {
        this.id = id;
        this.hash = hash;
        this.originalUrl = originalUrl;
        this.clickCount = clickCount;
        this.creationDate = creationDate;
        this.expirationDate = expirationDate;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public String getOriginalUrl() {
        return originalUrl;
    }

    public void setOriginalUrl(String originalUrl) {
        this.originalUrl = originalUrl;
    }

    public int getClickCount() {
        return clickCount;
    }

    public void setClickCount(int clickCount) {
        this.clickCount = clickCount;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public LocalDateTime getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDateTime expirationDate) {
        this.expirationDate = expirationDate;
    }

    public UserModel getUser() {
        return user;
    }

    public void setUser(UserModel userModel) {
        this.user = userModel;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ShortUrl shortUrl = (ShortUrl) o;
        return Objects.equals(hash, shortUrl.hash);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(hash);
    }

    @Override
    public String toString() {
        return "ShortUrl{" +
                "id=" + id +
                ", hash=" + hash +
                ", clickCount=" + clickCount +
                ", creationDate=" + creationDate +
                ", expirationDate=" + expirationDate +
                ", userModel=" + user +
                '}';
    }
}