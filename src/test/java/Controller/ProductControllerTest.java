package Controller;

import org.example.novproductservice.Controller.ProductController;
import org.example.novproductservice.Exceptions.ProductNotFoundException;
import org.example.novproductservice.Models.Product;
import org.example.novproductservice.Service.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class ProductControllerTest {
    @Autowired
    private ProductController productController;

    @MockitoBean(name = "dbProductService")
    private ProductService productService;

    @Test
    void getProductById() throws ProductNotFoundException {
        // Arrange
        Long productId = 2L;
        Product expectedProduct = new Product();
        expectedProduct.setId(productId);
        expectedProduct.setTitle("Iphone Pro Max Ultra");
        expectedProduct.setPrice(10000.0);

        when(productService.getSingleProduct(productId))
                .thenReturn(expectedProduct);

        // Act
        Product actualProduct = productController.getProductById(productId).getBody();

        // Assert
        assertNotNull(actualProduct);
        assertEquals(expectedProduct, actualProduct);
    }

    @Test
    void testGetSingleProductNegative() throws ProductNotFoundException {
        long productId = -1L;
        when(productService.getSingleProduct(productId))
                .thenThrow(ProductNotFoundException.class);

        assertThrows(
                ProductNotFoundException.class,
                () -> productController.getProductById(productId)
        );
    }

    @Test
    void getAllProducts() {
    }

    @Test
    void addNewProduct() {
    }

    @Test
    void deleteProduct() {
    }

    @Test
    void getLimitedProducts() {
    }

    @Test
    void replaceProduct() {
    }

    @Test
    void updateProduct() {
    }
}