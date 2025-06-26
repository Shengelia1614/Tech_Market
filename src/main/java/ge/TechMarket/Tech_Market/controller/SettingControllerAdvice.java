package ge.TechMarket.Tech_Market.controller;

import ge.TechMarket.Tech_Market.confiuration.MyProperties;
import ge.TechMarket.Tech_Market.confiuration.Page;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;


@Slf4j
@Profile("prod")
@ControllerAdvice
public class SettingControllerAdvice {

    @Autowired
    private MyProperties myProperties;


    @ModelAttribute("appName")
    public String AppName() {
        return myProperties.getName();
    }

    @ModelAttribute("appPages")
    public List<Page> AppPages() {
        return myProperties.getPages();
    }



//    @Value("${spring.profiles.active:prod}")
//    private String activeProfile;
//
//    @ModelAttribute("isDev")
//    public boolean isDev() {
//        return "dev".equalsIgnoreCase(activeProfile);
//    }

}
