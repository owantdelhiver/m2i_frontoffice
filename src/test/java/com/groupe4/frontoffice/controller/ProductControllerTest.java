package com.groupe4.frontoffice.controller;

import com.groupe4.frontoffice.dto.ProductDto;
import com.groupe4.frontoffice.service.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class ProductControllerTest {

    @InjectMocks
    private ProductController productController;

    @Mock
    private ProductService productService;

    @Mock
    private Model model;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetProductById() {

        int productId = 1;
        ProductDto productDto = new ProductDto();

        when(productService.getById(productId)).thenReturn(productDto);

        String viewName = productController.getProductbyId(productId, model);

        assertEquals("product", viewName);

        verify(model).addAttribute("product", productDto);
    }
}
