package com.db.grad.javaapi.model;

import lombok.*;

import javax.persistence.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue
    @Column(name = "id_user")
    int id_user;
    @Column(name = "password")
    String password;
    @Column(name = "role")
    String role;

    @Column(name = "email", unique = true)
    String email;

    @Column(name = "username", unique = true)
    String username;

    public User(String password, String role, String email) {
        this.password = password;
        this.role = role;
        this.email = email;
    }

    public boolean hasRole(String roleName) {
        if(role.equals(roleName)) {
            return true;
        }
        return false;
    }
}