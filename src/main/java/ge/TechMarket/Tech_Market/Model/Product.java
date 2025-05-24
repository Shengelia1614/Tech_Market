package ge.TechMarket.Tech_Market.Model;


import lombok.Data;

@Data
public class Product {
    private Long Id;
    private String name;
    private float price;
    private String description;
    private String image;
    private String category;

    public Product(String name, float price, String description, String image, String category, Long Id) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.image = image;
        this.category = category;
        this.Id = Id;
    }
}
