package com.jvictornascimento.urlshortene.models;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "TB_USER")

public class UserModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    private String name;

    private String email;

    private String password;

    private LocalDateTime creationDate;

    private LocalDateTime lastLogin;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ShortUrl> listURL;

    public UserModel() {
    }

    public UserModel(Long userId, String name, String email, String password, LocalDateTime creationDate, LocalDateTime lastLogin) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.password = password;
        this.creationDate = creationDate;
        this.lastLogin = lastLogin;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public LocalDateTime getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(LocalDateTime lastLogin) {
        this.lastLogin = lastLogin;
    }

    public List<ShortUrl> getListURL() {
        return listURL;
    }

    public void setListURL(List<ShortUrl> listURL) {
        this.listURL = listURL;
    }



    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        UserModel userModel = (UserModel) o;
        return Objects.equals(userId, userModel.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(userId);
    }

    @Override
    public String toString() {
        return "UserModel{" +
                "userId=" + userId +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", creationDate=" + creationDate +
                ", lastLogin=" + lastLogin +
                '}';
    }
}
