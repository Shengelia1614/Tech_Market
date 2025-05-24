package ge.TechMarket.Tech_Market;

//import ge.TechMarket.Tech_Market.Model.Product;
import ge.TechMarket.Tech_Market.entity.product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


public interface ProductRepository extends JpaRepository<product, Long> {



//    public static final List<Product> FAKE_PRODUCTS = new ArrayList<>();
//    static {
//        FAKE_PRODUCTS.add(new Product("Wireless Mouse", 25.99f, "Ergonomic wireless mouse with 1600 DPI", "mouse.jpg", "Electronics", 1L));
//        FAKE_PRODUCTS.add(new Product("Bluetooth Speaker", 45.50f, "Portable speaker with high-quality sound", "speaker.jpg", "Electronics", 2L));
//        FAKE_PRODUCTS.add(new Product("Yoga Mat", 19.99f, "Non-slip mat for yoga and workouts", "yogamat.jpg", "Fitness", 3L));
//        FAKE_PRODUCTS.add(new Product("Water Bottle", 12.00f, "Insulated stainless steel water bottle", "bottle.jpg", "Fitness", 4L));
//        FAKE_PRODUCTS.add(new Product("LED Desk Lamp", 34.75f, "Adjustable LED desk lamp with touch control", "lamp.jpg", "Home", 5L));
//        FAKE_PRODUCTS.add(new Product("Notebook", 4.99f, "200-page college-ruled notebook", "notebook.jpg", "Stationery", 6L));
//        FAKE_PRODUCTS.add(new Product("Gaming Keyboard", 59.95f, "Mechanical keyboard with RGB lighting", "keyboard.jpg", "Electronics", 7L));
//        FAKE_PRODUCTS.add(new Product("Cookware Set", 89.99f, "Non-stick cookware set with 10 pieces", "cookware.jpg", "Kitchen", 8L));
//        FAKE_PRODUCTS.add(new Product("Running Shoes", 69.99f, "Lightweight running shoes for men", "shoes.jpg", "Apparel", 9L));
//        FAKE_PRODUCTS.add(new Product("Smartwatch", 129.99f, "Water-resistant smartwatch with heart rate monitor", "smartwatch.jpg", "Electronics", 10L));
//
//    }
//
//    public List<Product> getAll() {
//        return FAKE_PRODUCTS;
//    }
//
//    public Product getById(Long id) {
//        return FAKE_PRODUCTS.parallelStream().filter(p -> p.getId().equals(id)).findFirst().orElse(null);
//
//    }

}
