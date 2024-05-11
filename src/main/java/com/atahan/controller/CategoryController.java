package com.atahan.controller;

import com.atahan.entity.Category;
import com.atahan.entity.Product;
import com.atahan.service.CategoryService;
import com.atahan.service.ProductService;

import java.util.List;
import java.util.Scanner;

public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController() {
        this.categoryService = new CategoryService();
    }


    public void add() {
        int secim;
        do {
            System.out.println("""
                    **********
                    *** MENU *****
                    **********
                                
                    1- LISTELE
                    2- KATEGORİ EKLEME
                    3- CIKIS YAPILDI
                  """);

            System.out.print("Yapmak istediğiniz işlemi seçiniz...: ");

            secim = new Scanner(System.in).nextInt();
            switch (secim) {
                case 1:
                    System.out.println(" --- LISTELEME ---");
                    list(new Category());
                    break;

                case 2:
                    System.out.println(" --- KATEGORİ EKLEME ---");
                    register();
                    break;

                case 3:
                    System.out.println("CIKIS YAPILDI");
                    break;

                default:
                    System.out.println("HATALI BIR GIRIS YAPILDI LUTFEN TEKRAR SECIM YAPINIZ");
                    break;


            }
        } while (secim != 4);
    }

    public void register() {
        System.out.println("""
                ************
                ***** EKLE *****
                ************
                """);

        System.out.print("KATEGORİ ADİ..............: ");
        String kategoriAdi = new Scanner(System.in).nextLine();
        categoryService.addCategory(Category.builder()
                .ad(kategoriAdi)
                .build());
    }
    public void list(Category category) {
        List<Category> categoryList = categoryService.categoryList();
        System.out.println(categoryList);

    }


}


