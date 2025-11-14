package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

public class UserTest {

    private OrganizedSwingApp.User user;

    @BeforeEach
    void setUp() {
        user = new OrganizedSwingApp.User(
            "John",
            "Doe",
            "25",
            "john.doe@example.com",
            "123-456-7890",
            "johndoe",
            "password123"
        );
    }

    @Test
    void testUserCreation() {
        assertNotNull(user);
        assertEquals("John", user.firstName);
        assertEquals("Doe", user.lastName);
        assertEquals("25", user.age);
        assertEquals("john.doe@example.com", user.email);
        assertEquals("123-456-7890", user.phone);
        assertEquals("johndoe", user.username);
        assertEquals("password123", user.password);
    }

    @Test
    void testUserWithEmptyFields() {
        OrganizedSwingApp.User emptyUser = new OrganizedSwingApp.User(
            "",
            "",
            "",
            "",
            "",
            "",
            ""
        );
        assertNotNull(emptyUser);
        assertEquals("", emptyUser.firstName);
        assertEquals("", emptyUser.username);
    }

    @Test
    void testUserWithSpecialCharacters() {
        OrganizedSwingApp.User specialUser = new OrganizedSwingApp.User(
            "José",
            "O'Brien",
            "30",
            "jose@test.com",
            "+1-555-1234",
            "jose_obrien",
            "p@ssw0rd!"
        );
        assertNotNull(specialUser);
        assertEquals("José", specialUser.firstName);
        assertEquals("O'Brien", specialUser.lastName);
        assertEquals("p@ssw0rd!", specialUser.password);
    }
}

