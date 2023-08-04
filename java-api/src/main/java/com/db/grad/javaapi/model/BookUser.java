package com.db.grad.javaapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "book_user")
public class BookUser {

    @Column(name = "book_id")
    private int book_id;

    @Column(name = "user_id")
    private int user_id;
}
