package com.web.vintageonlinemarket.entity;



import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "admins")
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long aId;
    private String name;
    private String email;
    private String password;
    private String accessLevel;
}
