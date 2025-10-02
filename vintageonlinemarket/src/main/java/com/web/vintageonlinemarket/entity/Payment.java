package com.web.vintageonlinemarket.entity;



import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "payments")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long paymentId;
    private String cType;
    private String cardType;
    private String details;

    // Relationships
    @OneToOne
    @JoinColumn(name = "order_id")
    private Order order;
}
