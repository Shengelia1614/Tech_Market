package ge.TechMarket.Tech_Market.controller;

import ge.TechMarket.Tech_Market.ProductController;
import ge.TechMarket.Tech_Market.entity.product;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ProductControllerTest {

    @Test
    void testSorter_sortsProductsByPriceAscending() {
        // Arrange
        ProductController controller = new ProductController();

        List<product> input = new ArrayList<>();
        input.add(new product(1L, "B", 200.0f, "desc2", "img2", "gtx 1070"));
        input.add(new product(2L, "A", 1000.0f, "desc1", "img1", "rx 6800"));
        input.add(new product(3L, "C", 600.0f, "desc3", "img3", "Ryzen 5 7600"));

        // Act
        List<product> result = controller.sorter(input);

        // Assert
        assertEquals(3, result.size());
        assertEquals("B", result.get(0).getName());
        assertEquals("C", result.get(1).getName());
        assertEquals("A", result.get(2).getName());
    }

    @Test
    void testSorter_handlesEmptyList() {
        ProductController controller = new ProductController();
        List<product> input = new ArrayList<>();

        List<product> result = controller.sorter(input);

        assertTrue(result.isEmpty());
    }

    @Test
    void testSorter_doesNotAffectOriginalList() {
        ProductController controller = new ProductController();

        List<product> input = new ArrayList<>();
        input.add(new product(1L, "X", 100.0f, "desc", "img", "16gb ddr5 ram"));

        List<product> result = controller.sorter(input);

        assertEquals(1, result.size());
        assertEquals("X", input.get(0).getName()); // Original remains intact
    }
}
