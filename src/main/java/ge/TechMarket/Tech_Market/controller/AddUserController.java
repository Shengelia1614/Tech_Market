package ge.TechMarket.Tech_Market.controller;


import ge.TechMarket.Tech_Market.Model.AddUser;
import ge.TechMarket.Tech_Market.Repository.UserRepository;
import ge.TechMarket.Tech_Market.entity.user;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Slf4j
@Profile("prod")
@Configuration
@Controller
public class AddUserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/register")
    public String productAdd(Model model) {

        log.info("ading new product");
        model.addAttribute("user", new user());
        log.debug("adding {}", model.toString());

        return "register";

    }



    @PostMapping("/register")
    public String productAdd(@ModelAttribute("product") AddUser addUser, BindingResult bindingResult, RedirectAttributes redirectAttributes) {

        log.info("ading new user to repostiroey");

        if (bindingResult.hasErrors()) {
            log.error("binding error");
            return "add";
        }





        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        user usr = new user();

        try{
            usr.setName(addUser.getName());
            if(usr.getName()==""){
                log.warn("empty name");
            }
        } catch (Exception e) {
            log.error("mame was incorrectly passed");
            return "register";
        }
        try{
            usr.setEmail(addUser.getEmail());
            if(usr.getEmail()==""){
                log.warn("email is empty");
            }

        } catch (Exception e) {
            log.error("email was incorrectly passed");
            return "register";
        }
        try{
            usr.setPassword(passwordEncoder.encode(addUser.getPassword()));
            if(usr.getPassword()==addUser.getPassword()){
                throw new RuntimeException();
            }
        } catch (Exception e) {
            log.error("encryption did not happen");
            return "register";
        }
        try{
            usr.setImageUrl(addUser.getImageUrl());
            if(usr.getImageUrl()==""){
                log.warn("was not given imageUrl, defaulting to default picture");//not defaulting to default picture imitom rom es ar damimatebia jer
            }
        } catch (Exception e) {
            log.error("adding image failed");

            return "register";
        }





        userRepository.save(usr);
        //return "redirect:/login";
        log.debug("added user: {} to repository", usr.getName() );
        return "redirect:/profile?id=" + usr.getId();

    }
}
