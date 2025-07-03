package ge.TechMarket.Tech_Market.entity;


import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "PRODUCTS")
public class product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    private Long Id;

    @Column(name="NAME")
    private String name;

    @Column(name="PRICE")
    private float price;
    @Column(name="DESCRIPTION")
    private String description;
    @Column(name="IMAGE")
    private String image;
    @Column(name="CATEGORY")
    private String category;

    public product(product other) {
        this.Id = other.Id;
        this.name = other.name;
        this.price = other.price;
        this.description = other.description;
        this.image = other.image;
        this.category = other.category;
    }

}
