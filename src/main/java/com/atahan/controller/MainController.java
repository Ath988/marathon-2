package com.atahan.controller;

import com.atahan.entity.Category;
import com.atahan.entity.Product;
import com.atahan.service.CategoryService;
import com.atahan.service.ProductService;

import java.util.Scanner;



public class MainController  {
    private final CategoryService categoryService;
    private final ProductService productService;
    private final ProductController productController;

    public MainController() {
        this.categoryService = new CategoryService();
        this.productService = new ProductService();
        this.productController = new ProductController();
    }
    public void secim() {
        int secim;
        do {
            System.out.println("""
                    **********
                    *** REHBER *****
                    **********
                                
                    1-KATEGORI EKLE
                    2-KATEGORI LISTELE 
                    3-URUN EKLE
                    4-URUN ARA
                    5-CIKIS
                    """);

            System.out.print("Yapmak istediğiniz işlemi seçiniz...: ");

            secim = new Scanner(System.in).nextInt();
            switch (secim) {
                case 1:
                    System.out.println(" ---KATEGORI EKLEME ---");
                    kategoriRegister();
                    break;
                case 2:
                    System.out.println(" ---KATEGORI LISTELE ---");
                    kategoriList(new Category());
                    break;
                case 3:
                    System.out.println(" ---URUN EKLEME ---");
                    productController.register();
                    break;
                case 4:
                    System.out.println(" --- URUN ARAMA  ---");
                    urunAra();
                    break;
                case 5:
                    System.out.println(" ---CIKIS YAPILDI  ---");
                    break;
                default:
                    System.out.println("HATALI BIR GIRIS YAPILDI LUTFEN TEKRAR SECIM YAPINIZ");
                    break;
            }
        } while (secim != 5);
    }
    public void urunRegister() {
        System.out.println("""
                ************
                ***** EKLE *****
                ************
                """);
        System.out.println("KATEGORİ ID......;");
        int categoryId = new Scanner(System.in).nextInt();
        System.out.print("URUN ADİ..............: ");
        String urunAdi = new Scanner(System.in).nextLine();
        System.out.println("ACIKLAMA...............: ");
        String aciklama = new Scanner(System.in).nextLine();
        System.out.println("URUN FIYATI............: ");
        double fiyat = new Scanner(System.in).nextDouble();
        System.out.println("STOK MIKTARI...........: ");
        int stokMiktari = new Scanner(System.in).nextInt();


        productService.addProduct(Product.builder()
                .id(categoryId)
                .urunAdi(urunAdi)
                .aciklama(aciklama)
                .fiyat(fiyat)
                .stokMiktari(stokMiktari)
                .build());
    }
    public void urunAra() {
        System.out.println("""
                *****************
                    Aramak istediginiz urunun adini yaziniz
                *****************
                """);
        String ad = new Scanner(System.in).nextLine();
        System.out.print("Urun adi ........: ");
        if (ad.length() > 24) {
            System.out.println("Urun adi uzunlugu 24 karakter ile sınırlıdır!");
        } else {
            productService.urunSorgula(ad);
        }
    }

    public void kategoriList(Category category)
    {

        categoryService.categoryList();
    }
    public void kategoriRegister() {
        System.out.println("""
                ************
                ***** EKLE *****
                ************
                """);
        System.out.print("KATEGORI AD...........: ");
        String kategoriAd = new Scanner(System.in).nextLine();
        categoryService.addCategory(Category.builder()
                .ad(kategoriAd)
                .build());
    }





}
