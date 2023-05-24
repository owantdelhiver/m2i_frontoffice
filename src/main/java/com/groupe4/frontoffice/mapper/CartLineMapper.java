package com.groupe4.frontoffice.mapper;
import com.groupe4.frontoffice.dto.CartLineDto;
import com.groupe4.frontoffice.model.cart.CartLine;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring")
public interface CartLineMapper {
    @Mapping(target = "productDto", source = "cartLine.product")
    CartLineDto cartLineToCartLineDto(CartLine cartLine);

//    CartLine cartLineDtoToCartLine(CartLineDto cartLineDto);
}

