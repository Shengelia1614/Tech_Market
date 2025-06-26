package ge.TechMarket.Tech_Market;


import ge.TechMarket.Tech_Market.Model.Product;
import ge.TechMarket.Tech_Market.entity.product;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
public class ProductController {

    @Autowired
    private ProductRepository Repository;

    @GetMapping("/store")
    public String listProducts(Model model) {
        log.info("listProducts");
        //List<Product> products = new ArrayList<Product>();
        model.addAttribute("products", Repository.findAll());
        log.debug("all products loaded, item count : {}", Repository.count());
        return "store";
    }

    @GetMapping("/product")
    public String product(@RequestParam("id") Long id, Model model) {
        log.info("loading product page");
        product product = Repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid product ID: " + id));
        model.addAttribute("product", product);

        log.debug("{} product page loaded", product.getName());
        return "product";
    }

    @PostMapping("/product/delete")
    public String deleteProduct(@RequestParam Long id) {
        Repository.deleteById(id);
        log.debug("product with {} id has been removed", id);
        return "redirect:/store";
    }


}
