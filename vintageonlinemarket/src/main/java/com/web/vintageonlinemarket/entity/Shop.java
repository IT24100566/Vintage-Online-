package com.web.vintageonlinemarket.entity;



import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "shops")
public class Shop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sid;
    private String shopName;

    // Relationships
    @OneToOne
    @JoinColumn(name = "seller_id")
    private User seller;
}