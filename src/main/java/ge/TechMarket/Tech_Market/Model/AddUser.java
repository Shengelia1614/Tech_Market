package ge.TechMarket.Tech_Market.Model;


import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddUser {

    @NotNull
    private Long Id;
    @NotNull(message = "name is required")
    private String name;

    @NotNull(message = "email is required")
    private String email;
    @NotNull(message = "password is required")
    private String password;
    private String imageUrl;
}
