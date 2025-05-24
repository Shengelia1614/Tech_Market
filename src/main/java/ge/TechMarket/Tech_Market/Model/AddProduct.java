package ge.TechMarket.Tech_Market.Model;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddProduct {
    @NotNull
    private Long Id;
    @NotNull
    private String name;
    @NotNull
    private float price;
    @NotNull
    private String description;
    private String image;
    @NotNull
    private String category;
}
