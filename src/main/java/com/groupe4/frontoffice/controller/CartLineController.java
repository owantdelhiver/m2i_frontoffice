package com.groupe4.frontoffice.controller;
import com.groupe4.frontoffice.dto.ProductDto;
import com.groupe4.frontoffice.mapper.ProductMapper;
import com.groupe4.frontoffice.mapper.ProductMapper;
import com.groupe4.frontoffice.model.cart.CartLine;
import com.groupe4.frontoffice.model.product.Product;
import com.groupe4.frontoffice.model.user.User;
import com.groupe4.frontoffice.service.CartLineService;
import com.groupe4.frontoffice.service.ProductService;
import com.groupe4.frontoffice.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class CartLineController extends SuperController {

    @Autowired
    CartLineService cartLineService;
    @Autowired
    ProductService productService;
    @Autowired
    UserService userService;
    @Autowired
    ProductMapper productMapper;

    @PostMapping("/add-to-cart/{id}")
    public String saveItemToCartLine(@PathVariable int id, CartLine cartLine, HttpSession httpsession, Model model) {
//        if (getUserSession(httpsession).getEmail() != null) {
            User user = super.getUserSession(httpsession);
            Product product = productService.getFullProductById(id);
            int qty = cartLine.getQuantity();
            if (qty <= product.getStock()) {
                ProductDto productDto = productService.getById(id);
                cartLine.setProduct(productMapper.productDtoToProduct(productDto));
                userService.addCartLine(user, cartLine);
                return "redirect:/cart";
            } else {
                String error = "Sorry, this product has insufficient stock.";
                model.addAttribute("product", productService.getById(id));
                model.addAttribute("cartLine", new CartLine());
                model.addAttribute("error", error);
                return "product";
            }
//        } else {
//            return "redirect:/login";
//        }
    }

    @GetMapping("/cartline/delete/{id}")
    public String deleteById ( @PathVariable int id){
        cartLineService.deleteById(id);
        return "redirect:/cart";
    }
}

