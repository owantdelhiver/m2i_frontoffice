package com.groupe4.frontoffice.service;

import com.groupe4.frontoffice.dto.CartLineDto;
import com.groupe4.frontoffice.mapper.CartLineMapper;
import com.groupe4.frontoffice.model.cart.CartLine;
import com.groupe4.frontoffice.repository.cart.CartLineRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

@ExtendWith(MockitoExtension.class)
class CartLineServiceTest {
    @Mock
    private CartLineRepository cartLineRepository;

    @Mock
    private CartLineMapper cartLineMapper;

    @InjectMocks
    private CartLineService cartLineService;

    @Test
    void shouldFetchAllByIdCart() {
        int cartId = 1;
        CartLine cartLine1 = new CartLine();
        CartLine cartLine2 = new CartLine();
        List<CartLine> expectedCartLines = List.of(cartLine1, cartLine2);

        when(cartLineRepository.findAllByCartId(cartId)).thenReturn(expectedCartLines);

        List<CartLine> result = cartLineService.fetchAllByIdCart(cartId);
        assertEquals(expectedCartLines, result);
    }

    @Test
    void shouldDeleteById() {
        int id = 1;

        cartLineService.deleteById(id);

        verify(cartLineRepository).deleteById(id);
    }

    @Test
    void shouldFetchAllByIdCartDto() {
        int cartId = 1;
        CartLine cartLine1 = new CartLine();
        CartLine cartLine2 = new CartLine();
        List<CartLine> cartLines = List.of(cartLine1, cartLine2);
        when(cartLineRepository.findAllByCartId(cartId)).thenReturn(cartLines);

        CartLineDto cartLineDto1 = new CartLineDto();
        CartLineDto cartLineDto2 = new CartLineDto();
        List<CartLineDto> expectedCartLineDtos = List.of(cartLineDto1, cartLineDto2);
        when(cartLineMapper.cartLineToCartLineDto(cartLine1)).thenReturn(cartLineDto1);
        when(cartLineMapper.cartLineToCartLineDto(cartLine2)).thenReturn(cartLineDto2);

        List<CartLineDto> result = cartLineService.fetchAllByIdCartDto(cartId);
        assertEquals(expectedCartLineDtos, result);
    }

    @Test
    void shouldDeleteAllByCartId() {
        int cartId = 1;

        cartLineService.deleteAllByCartId(cartId);
        verify(cartLineRepository).deleteAllByCartId(cartId);
    }
}
