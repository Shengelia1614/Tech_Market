package ge.TechMarket.Tech_Market;


import ge.TechMarket.Tech_Market.Model.Product;
import ge.TechMarket.Tech_Market.entity.product;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
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


    public List<product> sorter(List<product> products) {
        List<product> sortedList = new ArrayList<>();
        List<product> tempList = new ArrayList<>();

        // Deep copy to avoid modifying original list
        for (product p : products) {
            tempList.add(new product(p));
        }

        while (!tempList.isEmpty()) {
            product min = tempList.get(0);
            int minIndex = 0;

            for (int i = 1; i < tempList.size(); i++) {
                if (tempList.get(i).getPrice() < min.getPrice()) {
                    min = tempList.get(i);
                    minIndex = i;
                }
            }

            sortedList.add(min);
            tempList.remove(minIndex); // safe: remove by index
        }

        return sortedList;
    }


    @GetMapping("/store")
    public String listProducts(@RequestParam(required = false) String sort, Model model) {
//        log.info("listProducts");
//        //List<Product> products = new ArrayList<Product>();
//        model.addAttribute("products", Repository.findAll());
//        log.debug("all products loaded, item count : {}", Repository.count());
//        return "store";
        log.info("listProducts");

        List<product> products;

        if ("price".equalsIgnoreCase(sort)) {
            products = Repository.findAll();
            products = sorter(products);
            log.debug("Products sorted by price ascending. Count: {}", products.size());
        } else {
            products = Repository.findAll();
            log.debug("All products loaded. Count: {}", products.size());
        }

        model.addAttribute("products", products);
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
