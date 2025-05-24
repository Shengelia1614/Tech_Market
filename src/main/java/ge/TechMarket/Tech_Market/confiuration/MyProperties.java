package ge.TechMarket.Tech_Market.confiuration;


import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

@Profile("prod")
@Getter
@Setter
@Component
@PropertySource("classpath:app-config.properties")
@ConfigurationProperties(prefix = "app")
@Validated
public class MyProperties {
    @NotBlank
    private String name;
    @Valid
    @NotNull
    private List<Page> pages;

}
