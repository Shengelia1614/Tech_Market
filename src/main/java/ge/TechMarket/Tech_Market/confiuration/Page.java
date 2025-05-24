package ge.TechMarket.Tech_Market.confiuration;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

import java.util.List;
@Validated
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Page {
    @NotBlank
    private String name;
    @Valid
    @NotNull
    private String path;
}
