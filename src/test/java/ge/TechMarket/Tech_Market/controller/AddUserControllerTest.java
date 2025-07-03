package ge.TechMarket.Tech_Market.controller;

import ge.TechMarket.Tech_Market.Model.AddUser;
import ge.TechMarket.Tech_Market.Repository.UserRepository;
import ge.TechMarket.Tech_Market.entity.user;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class AddUserControllerTest {

    @InjectMocks
    private AddUserController addUserController;

    @Mock
    private UserRepository userRepository;

    @Mock
    private BindingResult bindingResult;

    @Mock
    private RedirectAttributes redirectAttributes;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testProductAdd_successfulRegistration() {
        // Arrange
        AddUser addUser = new AddUser();
        addUser.setName("John Doe");
        addUser.setEmail("john@example.com");
        addUser.setPassword("password123");
        addUser.setImageUrl("");

        when(bindingResult.hasErrors()).thenReturn(false);

        // We want to capture the saved user:
        ArgumentCaptor<user> userCaptor = ArgumentCaptor.forClass(user.class);

        // Act
        String view = addUserController.productAdd(addUser, bindingResult, redirectAttributes);

        // Assert
        assertTrue(view.startsWith("redirect:/profile?id="));

        // Verify that save was called and capture the user
        verify(userRepository, times(1)).save(userCaptor.capture());
        user savedUser = userCaptor.getValue();

        // The password should be encoded and different from the raw password
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        assertNotEquals(addUser.getPassword(), savedUser.getPassword());
        assertTrue(encoder.matches(addUser.getPassword(), savedUser.getPassword()));

        assertEquals(addUser.getName(), savedUser.getName());
        assertEquals(addUser.getEmail(), savedUser.getEmail());
        assertEquals(addUser.getImageUrl(), savedUser.getImageUrl());
    }

    @Test
    void testProductAdd_bindingErrors() {
        // Arrange
        AddUser addUser = new AddUser();
        when(bindingResult.hasErrors()).thenReturn(true);

        // Act
        String view = addUserController.productAdd(addUser, bindingResult, redirectAttributes);

        // Assert
        assertEquals("add", view);

        verify(userRepository, never()).save(any());
    }
}
