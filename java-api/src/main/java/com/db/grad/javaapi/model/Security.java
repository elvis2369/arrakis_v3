package com.db.grad.javaapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "security")
public class Security {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;
    @Column(name = "isin")
    private String isin;
    @Column(name = "cusip")
    private String cusip;
    @Column(name = "issuer_name")
    private String issuer_name;
    @Column(name = "maturity_date")
    private Date maturity_date;
    @Column(name = "coupon")
    private float coupon;
    @Column(name = "type")
    private String type;
    @Column(name = "face_value")
    private float face_value;
    @Column(name = "currency")
    private String currency;
    @Column(name = "status")
    private String status;
}
