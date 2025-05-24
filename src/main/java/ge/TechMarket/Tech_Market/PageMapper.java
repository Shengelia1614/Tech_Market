package ge.TechMarket.Tech_Market;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class PageMapper implements WebMvcConfigurer {
    @Override
    public void addViewControllers(org.springframework.web.servlet.config.annotation.ViewControllerRegistry registry) {
        registry.addViewController("index").setViewName("index");
        //registry.addViewController("profile").setViewName("profile");
        registry.addViewController("store").setViewName("store");
        registry.addViewController("shop").setViewName("shop");
        registry.addViewController("second_hand").setViewName("second_hand");
        registry.addViewController("login").setViewName("login");
        //registry.addViewController("register").setViewName("register");
        //registry.addViewController("submit").setViewName("profile");
        registry.addRedirectViewController("profile", "login");
        registry.addRedirectViewController("Main", "store");
        registry.addRedirectViewController("/", "store");
    }
}