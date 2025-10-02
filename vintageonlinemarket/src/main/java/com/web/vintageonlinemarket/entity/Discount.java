package com.web.vintageonlinemarket.entity;



import jakarta.persistence.*;
import lombok.*;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "discounts")
public class Discount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long discountId;
    private String code;
    private double percentage;
    private Date expiryDate;

    // Relationships
    @OneToMany(mappedBy = "discount")
    private List<Order> orders;
}
