package com.eil.sms_backend.entities;


import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@AllArgsConstructor@NoArgsConstructor
@Setter@Getter
@Builder
public class Product {

    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String qrCode;

    private String label;

    private double price;

    @Temporal(TemporalType.DATE)
    private Date created_at;
}
