package org.example.novproductservice.Repositories;

import org.example.novproductservice.Models.Product;
import org.example.novproductservice.Projections.ProductWithIdAndTitle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    // Product Repo - should contain all the methods(CRUD) related to the Product model

    // select * from products where price >
    List<Product> findProductByPriceGreaterThan(Double price);

    // select * from products where title like '%iphone%'
    List<Product> findProductByTitleLike(String title);

    // select * from products where title like 'iphone' LIMIT 5
//    List<Product> findProductByTitleLike(int top, String title);

    List<Product> findByPriceBetween(Double p1, Double p2);

    // HQL
    // Using declared queries, we are getting a list of product
    // id and title of a product.
    // Fetch 1 million products id and title
    // select id, title from product where createdAt > timestamp;
    // Product model has 100 attributes

    // when we fetch a product, we store it in memory.
    // each product -> 100 bytes
    // 1M products = 100 * 10^6 = 100 MB

    // I only want to get id and title; id -> 8 bytes + 22 bytes = 30 bytes
    // 30 * 10^6 = 30 MB

    @Query("select p.id as id, p.title as title from Product p")
    List<ProductWithIdAndTitle> randomSearchMethodForProduct();

    @Query("select p.id as id, p.title as title from Product p where p.id = :id")
    ProductWithIdAndTitle randomSearchMethodForProduct(Long id);


    // Native Queries: SQL
    @Query(nativeQuery = true, value="select p.id as id, p.title as title from product p")
    List<ProductWithIdAndTitle> nativeSearchMethodForProduct();
}