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
@Table(name = "tbl_category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // is için otomatik artan bir GB sequence oluşturur.
    Long id;
    @Column(name = "category_name",unique = true,nullable = false)
    String ad;

}
