package com.db.grad.javaapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.annotation.sql.DataSourceDefinition;
import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "trade")
public class Trade {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;
    @Column(name = "book_id")
    private int book_id;
    @Column(name = "security_id")
    private int security_id  ;
    @Column(name = "counterparty_id")
    private int counterparty_id  ;
    @Column(name = "currency")
    private String  currency;
    @Column(name = "status")
    private String status;
    @Column(name = "quantity")
    private int quantity ;
    @Column(name = "unit_price")
    private float unit_price;
    @Column(name = "buy_sell")
    private String buy_sell;
    @Column(name = "trade_date")
    private Date trade_date;
    @Column(name = "settlement_date")
    private Date settlement_date;
}
