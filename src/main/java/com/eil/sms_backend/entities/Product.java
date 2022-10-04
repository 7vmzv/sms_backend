package com.eil.sms_backend.entities;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@AllArgsConstructor@NoArgsConstructor
@Setter@Getter
public class Product {

    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String qr_code;

    private String label;

    private double price;

    @Temporal(TemporalType.DATE)
    private Date created_at;
}
