package ge.TechMarket.Tech_Market.controller;


import ge.TechMarket.Tech_Market.Model.AddProduct;
import ge.TechMarket.Tech_Market.Model.Product;
import ge.TechMarket.Tech_Market.ProductRepository;
import ge.TechMarket.Tech_Market.entity.product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Configuration
@Controller
public class AddProductController {


    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/add")
    public String productAdd(Model model) {
        model.addAttribute("prod", new product());

        return "add";
    }



    @PostMapping("/add")
    public String productAdd(@ModelAttribute("product") AddProduct addProduct, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "add";
        }

        product nprod = new product();
        nprod.setName(addProduct.getName());
        nprod.setPrice(addProduct.getPrice());
        nprod.setCategory(addProduct.getCategory());
        nprod.setDescription(addProduct.getDescription());
        productRepository.save(nprod);
        return "redirect:/product?id=" + nprod.getId();

    }
}
