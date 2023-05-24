package com.groupe4.frontoffice.mapper;

import com.groupe4.frontoffice.dto.ProductDto;
import com.groupe4.frontoffice.model.product.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    ProductDto productToProductDto(Product product);

    Product productDtoToProduct(ProductDto productDto);
}

