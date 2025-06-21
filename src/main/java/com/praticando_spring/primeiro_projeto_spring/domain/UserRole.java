package com.praticando_spring.primeiro_projeto_spring.domain;

public enum UserRole {
    ADMIN("admin"),
    USER("user");

    private String role;

    UserRole(String role) { this.role = role; }
    public String getRole() { return role; }
}
