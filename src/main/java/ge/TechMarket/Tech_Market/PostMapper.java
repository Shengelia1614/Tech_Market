package ge.TechMarket.Tech_Market;

import ge.TechMarket.Tech_Market.entity.user;
import jakarta.validation.Valid;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Configuration
@Controller
public class PostMapper {

    private final ProductRepository productRepository;

    public PostMapper(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

//    @GetMapping("/register")
//    public String register(Model model) {
//        model.addAttribute("newUser", new user());
//        return "register";
//    }

    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("usr", new user());
        return "login";
    }

    @GetMapping("/second_hand")
    public String secondHandPage() {
        return "second_hand";
    }

    @GetMapping("/shop")
    public String MyShop() {
        return "shop";
    }
//    @GetMapping("/add")
//    public String add(Model model) {
//        model.addAttribute("prod", new product());
//        return "add";
//    }
//
//    @GetMapping("/prod")
//    public String getProductDetails(@RequestParam("id") Long id, Model model) {
//        product product = productRepository.findById(id)
//                .orElseThrow(() -> new IllegalArgumentException("Invalid product ID: " + id));
//        model.addAttribute("product", product);
//        return "productDetails";
//    }


//    @PostMapping("/register")
//    public String reg(@Valid @ModelAttribute("user") user usr, BindingResult bindingResult) {
//
//        if(bindingResult.hasErrors()) {return "register";}
//        return "redirect:/profile";
//    }

//    @PostMapping("/add")
//    public String reg(@Valid @ModelAttribute("prod") product prod, BindingResult bindingResult) {
//
//        if(bindingResult.hasErrors()) {return "add";}
//        productRepository.save(prod);
//
//        return "redirect:/store";
//    }


}
