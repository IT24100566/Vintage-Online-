
/*package com.web.vintageonlinemarket.entity;

import java.util.*;

import jakarta.persistence.*;
import lombok.*;
import java.util.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idNo;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String phoneNo;
    private String address;
    private String nic;
    private Date dob;
    private int age;
    private String type; // "customer" or "seller"

    // Relationships
    @OneToOne(mappedBy = "seller")
    private Shop shop; // For seller

    @OneToOne(mappedBy = "customer")
    private Cart cart; // For customer

    @OneToMany(mappedBy = "customer")
    private List<Order> orders; // For customer

    @OneToMany(mappedBy = "customer")
    private List<Review> reviews; // For customer

    @OneToMany(mappedBy = "seller")
    private List<Product> products; // For seller
}*/

package com.web.vintageonlinemarket.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idNo")
    private Long idNo;

    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String type; // customer, seller, admin
    private Long aId; // Admin ID
    private String nic;
    private String address;
    private Date dob;
    private Integer age;
    private String phoneNo;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Order> orders;

    @OneToMany(mappedBy = "seller", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Product> products;

    // Getters and Setters
    public Long getIdNo() { return idNo; }
    public void setIdNo(Long idNo) { this.idNo = idNo; }
    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    public String getType() { return type; }
    public void setType(String type) { this.type = type; }
    public Long getaId() { return aId; }
    public void setaId(Long aId) { this.aId = aId; }
    public String getNic() { return nic; }
    public void setNic(String nic) { this.nic = nic; }
    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }
    public Date getDob() { return dob; }
    public void setDob(Date dob) { this.dob = dob; }
    public Integer getAge() { return age; }
    public void setAge(Integer age) { this.age = age; }
    public String getPhoneNo() { return phoneNo; }
    public void setPhoneNo(String phoneNo) { this.phoneNo = phoneNo; }
    public List<Order> getOrders() { return orders; }
    public void setOrders(List<Order> orders) { this.orders = orders; }
    public List<Product> getProducts() { return products; }
    public void setProducts(List<Product> products) { this.products = products; }
}
