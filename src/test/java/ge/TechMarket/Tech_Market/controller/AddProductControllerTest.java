package ge.TechMarket.Tech_Market.controller;

import ge.TechMarket.Tech_Market.Model.AddProduct;
import ge.TechMarket.Tech_Market.ProductRepository;
import ge.TechMarket.Tech_Market.entity.product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class AddProductControllerTest {

    @InjectMocks
    private AddProductController addProductController;

    @Mock
    private ProductRepository productRepository;

    @Mock
    private BindingResult bindingResult;

    @Mock
    private RedirectAttributes redirectAttributes;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testProductAdd_successful() {
        // Arrange
        AddProduct addProduct = new AddProduct();
        addProduct.setName("Test Product");
        addProduct.setPrice(19.99f);
        addProduct.setCategory("Electronics");
        addProduct.setDescription("A test product");

        when(bindingResult.hasErrors()).thenReturn(false);

        // Mock saved product to have an ID assigned
        doAnswer(invocation -> {
            product savedProduct = invocation.getArgument(0);
            savedProduct.setId(123L); // simulate generated id
            return null;
        }).when(productRepository).save(any(product.class));

        // Act
        String view = addProductController.productAdd(addProduct, bindingResult, redirectAttributes);

        // Assert
        assertEquals("redirect:/product?id=123", view);

        ArgumentCaptor<product> captor = ArgumentCaptor.forClass(product.class);
        verify(productRepository, times(1)).save(captor.capture());

        product saved = captor.getValue();
        assertEquals("Test Product", saved.getName());
        assertEquals(19.99f, saved.getPrice());
        assertEquals("Electronics", saved.getCategory());
        assertEquals("A test product", saved.getDescription());
    }

    @Test
    void testProductAdd_bindingErrors() {
        AddProduct addProduct = new AddProduct();
        when(bindingResult.hasErrors()).thenReturn(true);

        String view = addProductController.productAdd(addProduct, bindingResult, redirectAttributes);

        assertEquals("add", view);
        verify(productRepository, never()).save(any());
    }

    // Additional tests for error handling (empty name, zero price, empty category) can be added similarly if needed.
}
