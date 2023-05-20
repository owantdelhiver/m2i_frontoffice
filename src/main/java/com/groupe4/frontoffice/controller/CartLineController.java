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
    @PostMapping("/add-to-cart")
    public String addItemToCartLine(@RequestParam("id") int id,
                                    @RequestParam(value = "quantity", defaultValue = "1") int quantity, Model model, HttpSession httpsession) {

        Product product = productService.getById(id);
        User user = super.getUserSession(httpsession);

        if (httpsession != null) {
            CartLine cartLine = cartLineService.addItemToCart(product, quantity, user.getCart());
            httpsession.setAttribute("totalItems", cartLineService.fetchAll());
            model.addAttribute("cartLine", cartLine);
        }
        return "redirect:/cart" ;
    }

}
