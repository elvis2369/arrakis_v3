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
    @Column(name = "id", nullable = false)
    private long id;
    @Column(name = "username", nullable = false)
    private String username;
    @Column(name = "email", nullable = false)
    private String email;
    @Column(name = "role", nullable = false)
    private String role;

    @Column(name = "password" , nullable = false)
    private String password;

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
