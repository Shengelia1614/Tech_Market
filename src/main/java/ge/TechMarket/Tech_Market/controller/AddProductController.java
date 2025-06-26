package ge.TechMarket.Tech_Market.controller;


import ge.TechMarket.Tech_Market.Model.AddProduct;
import ge.TechMarket.Tech_Market.Model.Product;
import ge.TechMarket.Tech_Market.ProductRepository;
import ge.TechMarket.Tech_Market.entity.product;
import lombok.extern.slf4j.Slf4j;
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


@Slf4j
@Configuration
@Controller
public class AddProductController {


    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/add")
    public String productAdd(Model model) {
        log.info("ading new product");

        model.addAttribute("prod", new product());
        log.debug("adding {}", model.toString());

        return "add";
    }



    @PostMapping("/add")
    public String productAdd(@ModelAttribute("product") AddProduct addProduct, BindingResult bindingResult, RedirectAttributes redirectAttributes) {

        log.info("ading new product to repostiroey");
        if (bindingResult.hasErrors()) {
            log.error("binding error");
            return "add";
        }

        product nprod = new product();

        try{
            nprod.setName(addProduct.getName());
            if(nprod.getName()==""){
                log.warn("empty name");
            }
        } catch (Exception e) {
            log.error("mame was incorrectly passed");
            return "add";
        }
        try{
            nprod.setPrice(addProduct.getPrice());
            if(nprod.getPrice()==0){
                log.warn("price is 0");
            }

        } catch (Exception e) {
            log.error("price was incorrectly passed");
            return "add";
        }
        try{
            nprod.setCategory(addProduct.getCategory());
            if(nprod.getCategory()==""){
                throw new RuntimeException();
            }
        } catch (Exception e) {
            log.error("Category was incorrectly passed");
            return "add";
        }
        try{
            nprod.setDescription(addProduct.getDescription());
        } catch (Exception e) {
            log.error("description was incorrectly passed");
            return "add";
        }





        productRepository.save(nprod);
        log.debug("added {} to repository", nprod.getName() );

        return "redirect:/product?id=" + nprod.getId();

    }
}
