package com.groupe4.frontoffice.controller;
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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CartLineController extends SuperController {

    @Autowired
    CartLineService cartLineService;
    @Autowired
    ProductService productService;
    @Autowired
    UserService userService;

    @GetMapping("add-to-cart")
    public String addtemToCartLine(CartLine cartLine, Model model) {
        model.addAttribute("cartLine", cartLine);
        return "product";
    }


    @PostMapping("/add-to-cart")
    public String savetemToCartLine( @RequestParam(value = "id" , required = false, defaultValue = "1") int id,
                                    @RequestParam(value = "quantity", defaultValue = "1") int quantity, Model model, HttpSession httpsession) {
        Product product = productService.getById(id);
        String email = (String) httpsession.getAttribute("email");
        if (httpsession != null) {
            CartLine cartLine = cartLineService.addItemToCart(product, quantity, email);
            httpsession.setAttribute("totalItems", cartLineService.fetchAll());
        }
        return "redirect:/add-to-cart";
    }

}
