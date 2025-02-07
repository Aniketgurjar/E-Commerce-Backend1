package org.example.novproductservice.Controller;

import org.example.novproductservice.Exceptions.ProductNotFoundException;
import org.example.novproductservice.Models.Product;
import org.example.novproductservice.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    ProductService productService;

    //TODO See how you can provide variable name and use configuration file to add the Qualifier
    public ProductController(@Qualifier("fakeStoreProductService") ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") Long id) throws ProductNotFoundException {
        ResponseEntity<Product> responseEntity = new ResponseEntity<>(
                productService.getSingleProduct(id),
                HttpStatus.OK
        );

        return responseEntity;
    }

//    @GetMapping("/{id}")
//    public Product getProductById(@PathVariable("id") Long id) {
//
//        return new Product();
//    }

    @GetMapping()
    public ResponseEntity<Page<Product>> getAllProducts(@RequestParam("pagenumber") int pageNumber,
                                                        @RequestParam("pageSize") int pageSize){
        ResponseEntity<Page<Product>> responseEntity = new ResponseEntity<>(
                productService.getAllProducts(pageNumber, pageSize),
                HttpStatus.OK
        );

        return responseEntity;
    }

    @PostMapping
    public Product addNewProduct(@RequestBody Product product) {
        return productService.addNewProduct(product);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable("id") Long id) throws ProductNotFoundException {
        productService.deleteSingleProduct(id);
    }

    @GetMapping("/limit/{num}")
    public List<Product> getLimitedProducts(@PathVariable("num") Integer num){
        return  productService.getLimitedProducts(num);
    }

    @PutMapping("/{id}")
    public Product replaceProduct(@PathVariable("id") Long id, @RequestBody Product product) {
        return productService.replaceProduct(id, product);
    }



    @PatchMapping("/{id}")
    public Product updateProduct(@PathVariable("id") Long id, @RequestBody Product product) throws ProductNotFoundException {
        return productService.updateProduct(id, product);
    }

}


