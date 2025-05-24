package ge.TechMarket.Tech_Market;


import ge.TechMarket.Tech_Market.Model.Product;
import ge.TechMarket.Tech_Market.entity.product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller

public class ProductController {

    @Autowired
    private ProductRepository Repository;

    @GetMapping("/store")
    public String listProducts(Model model) {

        //List<Product> products = new ArrayList<Product>();
        model.addAttribute("products", Repository.findAll());
        return "store";
    }

    @GetMapping("/product")
    public String product(@RequestParam("id") Long id, Model model) {
        product product = Repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid product ID: " + id));
        model.addAttribute("product", product);
        return "product";
    }

    @PostMapping("/product/delete")
    public String deleteProduct(@RequestParam Long id) {
        Repository.deleteById(id);
        return "redirect:/store";
    }


}
