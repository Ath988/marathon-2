package com.atahan.controller;

import com.atahan.entity.Product;
import com.atahan.service.ProductService;

import java.util.Scanner;

import static java.util.Collections.list;

public class ProductController  {
    private final ProductService productService;
    public ProductController() {
        this.productService = new ProductService();
    }
    public void add() {
        int secim;
        do {
            System.out.println("""
                    **********
                    *** REHBER *****
                    **********
                                
                    1- LISTELeME
                    2- ARAMA
                    3- URUN EKLEME
                    4- CIKIS YAPILDI
                    """);

            System.out.print("Yapmak istediğiniz işlemi seçiniz...: ");

            secim = new Scanner(System.in).nextInt();
            switch (secim) {
                case 1:
                    System.out.println(" --- LISTELEME ---");
                    list(new Product());
                    break;

                case 2:
                    System.out.println(" --- ARAMA YAPMA ---");
                    urunAra();
                    break;
                case 3:
                    System.out.println(" --- URUN EKLEME ---");
                    register();
                    break;

                case 4:
                    System.out.println("CIKIS YAPILDI");
                    break;
                default:
                    System.out.println("HATALI BIR GIRIS YAPILDI LUTFEN TEKRAR SECIM YAPINIZ");
                    break;

            }
        } while (secim != 4);
    }
    public void list(Product product) {

        productService.productList();

    }
    public void register() {
        System.out.println("""
                ************
                ***** EKLE *****
                ************
                """);
        System.out.println("KATEGORİ ID......;");
        long categoryId = new Scanner(System.in).nextInt();
        System.out.print("URUN ADİ..............: ");
        String urunAdi = new Scanner(System.in).nextLine();
        System.out.println("URUN FIYATI............: ");
        double fiyat = new Scanner(System.in).nextDouble();
        System.out.println("STOK MIKTARI...........: ");
        int stokMiktari = new Scanner(System.in).nextInt();
        System.out.println("ACIKLAMA...............: ");
        String aciklama = new Scanner(System.in).nextLine();

        productService.addProduct(Product.builder()
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


}