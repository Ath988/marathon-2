package com.atahan.service;

import com.atahan.entity.Product;
import com.atahan.repository.ProductRepo;

import java.util.List;

public class ProductService {
    private final ProductRepo productRepo;

    public ProductService() {
        this.productRepo = new ProductRepo();

    }
    public  void addProduct(Product product) {
        productRepo.save(product);
    }
    public List<Product> urunSorgula(String urunAdi){
        if (urunAdi.isEmpty()){
            throw new RuntimeException("Urun bulunamadi!");
        }
        return productRepo.listUrunFirtsTenByAd(urunAdi);
    }
    public List<Product> productList() {

        return productRepo.findAll();
    }


}
