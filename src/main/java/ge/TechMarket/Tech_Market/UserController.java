package ge.TechMarket.Tech_Market;


import ge.TechMarket.Tech_Market.Repository.UserRepository;
import ge.TechMarket.Tech_Market.entity.user;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Slf4j
@Controller
public class UserController {

    @Autowired
    UserRepository userRepository;




    @GetMapping("/profile")
    public String profile(Model model) {
        log.info("user profile loaded");
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String email = auth.getName();

        user usr = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        model.addAttribute("profile", usr);
        log.debug("authentificaterd");
        return "profile";
    }




}
