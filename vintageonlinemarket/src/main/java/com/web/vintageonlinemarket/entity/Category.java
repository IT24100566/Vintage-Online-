package com.web.vintageonlinemarket.entity;



import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long catId;
    private String name;
    private String description;

    // Relationships
    @OneToMany(mappedBy = "category")
    private List<Product> products;
}
