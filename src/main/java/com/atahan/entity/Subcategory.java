package com.atahan.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data  //get,set,toString
@AllArgsConstructor // parametreli constructor
@NoArgsConstructor // default constructor
@Builder
@Entity
@Table(name = "tbl")
public class Subcategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // is için otomatik artan bir GB sequence oluşturur.
    @Column(name = "alt_kategori_id")
    private int altkategoriid;
    @Column(name = "alt_kategori_adi")
    private String altkategoriAdi;

}
