package com.atahan.entity;

import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.*;

@Getter
@Data  //get,set,toString
@AllArgsConstructor // parametreli constructor
@NoArgsConstructor // default constructor
@Builder
@Entity
@Table(name = "tbl_product")
@NamedQuery(
        name = "Product.urunAra",
        query = "SELECT u FROM Product u WHERE u.urunAdi LIKE CONCAT('%', :arananKelime, '%') " +
                "ORDER BY CASE WHEN u.urunAdi = :arananKelime THEN 1 ELSE 2 END, u.urunAdi")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @Column(name = "product_name",unique = true,nullable = false)
    String urunAdi;
    @Column(name = "product_description",nullable = false)
    String aciklama;
    @Column(name = "product_price",nullable = false)
    Double fiyat;
    int stokMiktari;
}
