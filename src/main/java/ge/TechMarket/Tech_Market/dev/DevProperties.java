package ge.TechMarket.Tech_Market.dev;

import ge.TechMarket.Tech_Market.confiuration.Page;
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

import java.util.List;

@Profile("dev")
@Getter
@Setter
@Component
@PropertySource("classpath:application-dev.properties")
@ConfigurationProperties(prefix = "devapp")
@Validated
public class DevProperties {
    @NotBlank
    private String name;
    @Valid
    @NotNull
    private List<Page> pages;

}
