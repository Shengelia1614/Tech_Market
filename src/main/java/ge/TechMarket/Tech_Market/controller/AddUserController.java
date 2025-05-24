package ge.TechMarket.Tech_Market.controller;


import ge.TechMarket.Tech_Market.Model.AddUser;
import ge.TechMarket.Tech_Market.Repository.UserRepository;
import ge.TechMarket.Tech_Market.entity.user;
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


@Profile("prod")
@Configuration
@Controller
public class AddUserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/register")
    public String productAdd(Model model) {
        model.addAttribute("user", new user());

        return "register";

    }



    @PostMapping("/register")
    public String productAdd(@ModelAttribute("product") AddUser addUser, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "add";
        }
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        user usr = new user();
        usr.setName(addUser.getName());
        usr.setEmail(addUser.getEmail());
        usr.setPassword(passwordEncoder.encode(addUser.getPassword()));
        usr.setImageUrl(addUser.getImageUrl());
        userRepository.save(usr);
        //return "redirect:/login";
        return "redirect:/profile?id=" + usr.getId();

    }
}
