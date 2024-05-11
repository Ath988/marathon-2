package com.atahan.repository;

import com.atahan.entity.Product;
import com.atahan.utility.Repository;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class ProductRepo extends Repository<Product,Long> {
    public ProductRepo() {

        super(new Product());
    }
    public ProductRepo(Product entity) {
        super(entity);
    }

    public List<Product> listUrunFirtsTenByAd(String value) {
        openEntityManager();
        TypedQuery<Product> typedQuery = getEm().createNamedQuery("Product.urunAra", Product.class);
        typedQuery.setParameter("arananKelime", value);
        return typedQuery.getResultList();
    }

}
