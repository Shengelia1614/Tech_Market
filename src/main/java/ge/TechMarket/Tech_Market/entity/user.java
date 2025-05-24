package ge.TechMarket.Tech_Market.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data
@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "USERS")
public class user {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    private Long Id;


    @Column(name="NAME")
    private String name;

    @Column(name="EMAIL",unique = true)
    private String email;

    @Column(name="PASSWORD")
    private String password;

    @Column(name="IMAGE")
    private String imageUrl;



}
