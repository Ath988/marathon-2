package com.atahan;

import com.atahan.controller.CategoryController;
import com.atahan.controller.MainController;
import com.atahan.controller.ProductController;
import com.atahan.entity.Product;
import com.atahan.service.ProductService;

public class Runner {
    public static void main(String[] args) {
//        ProductController productController = new ProductController();
//        productController.add();

        MainController mainController = new MainController();
        mainController.secim();


    }
}
