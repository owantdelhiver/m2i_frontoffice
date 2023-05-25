package com.groupe4.frontoffice.service;
import com.groupe4.frontoffice.dto.ProductDto;
import com.groupe4.frontoffice.mapper.ProductMapper;
import com.groupe4.frontoffice.model.product.Product;
import com.groupe4.frontoffice.repository.product.ProductRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.nio.file.OpenOption;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProductServiceTest {
    @Mock
    private ProductRepository productRepository;
    @Mock
    private ProductMapper productMapper;
    @InjectMocks
    private ProductService serviceToTest;

    @Test
    void shouldFetchAllProducts() {
        Product product1 = new Product();
        Product product2 = new Product();
        product1.setId(1);
        product2.setId(2);
        List<Product> expectedProducts = List.of(product1, product2);

        when(productRepository.findAll()).thenReturn(expectedProducts);

        List<ProductDto> expectedDtos = expectedProducts.stream()
                .map(productMapper::productToProductDto)
                .collect(Collectors.toList());

        List<ProductDto> result = serviceToTest.fetchAll();
        assertEquals(expectedDtos, result);
    }

    @Test
    void shouldGetProductById() {

        Product product = new Product();
        product.setId(1);
        ProductDto expectedDto = new ProductDto();
        expectedDto.setId(1);

        when(productRepository.findById(1)).thenReturn(Optional.of(product));
        when(productMapper.productToProductDto(product)).thenReturn(expectedDto);

        ProductDto result = serviceToTest.getById(1);

        assertNotNull(result);
        assertEquals(expectedDto, result);
        verify(productRepository, times(1)).findById(1);
        verify(productMapper, times(1)).productToProductDto(product);
    }
    @Test
    void shouldUpdateProductStockWhenProductExists() {
        int productId = 1;
        int newStock = 10;
        Product product = new Product();
        product.setId(productId);
        product.setStock(5);

        when(productRepository.findById(productId)).thenReturn(Optional.of(product));
        serviceToTest.updateProductStock(newStock, productId);
        assertEquals(newStock, product.getStock());
        verify(productRepository, times(1)).findById(productId);
        verify(productRepository, times(1)).save(product);
    }

    @Test
    void shouldNotUpdateProductStockWhenProductDoesNotExist() {
        int productId = 1;
        int newStock = 10;

        when(productRepository.findById(productId)).thenReturn(Optional.empty());

        serviceToTest.updateProductStock(newStock, productId);

        verify(productRepository, times(1)).findById(productId);
        verify(productRepository, never()).save(any());
    }
}
