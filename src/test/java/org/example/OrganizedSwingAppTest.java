package org.example;

import org.junit.jupiter.api.Test;
import java.util.HashMap;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.*;

public class OrganizedSwingAppTest {

    @Test
    void testUserStorage() {
        // Test that users can be stored in a map (simulating the app's user storage)
        Map<String, OrganizedSwingApp.User> users = new HashMap<>();
        assertNotNull(users);
        assertEquals(0, users.size());
    }

    @Test
    void testUserMapOperations() {
        // Test basic map operations for user storage
        Map<String, OrganizedSwingApp.User> users = new HashMap<>();
        
        OrganizedSwingApp.User user1 = new OrganizedSwingApp.User(
            "Alice", "Smith", "28", "alice@test.com", "555-0001", "alice", "pass1"
        );
        OrganizedSwingApp.User user2 = new OrganizedSwingApp.User(
            "Bob", "Jones", "32", "bob@test.com", "555-0002", "bob", "pass2"
        );

        users.put("alice", user1);
        users.put("bob", user2);

        assertEquals(2, users.size());
        assertTrue(users.containsKey("alice"));
        assertTrue(users.containsKey("bob"));
        assertEquals("Alice", users.get("alice").firstName);
        assertEquals("Bob", users.get("bob").firstName);
    }

    @Test
    void testUserMapDuplicateKey() {
        Map<String, OrganizedSwingApp.User> users = new HashMap<>();
        
        OrganizedSwingApp.User user1 = new OrganizedSwingApp.User(
            "Alice", "Smith", "28", "alice@test.com", "555-0001", "alice", "pass1"
        );
        OrganizedSwingApp.User user2 = new OrganizedSwingApp.User(
            "Alice2", "Smith2", "29", "alice2@test.com", "555-0002", "alice", "pass2"
        );

        users.put("alice", user1);
        users.put("alice", user2); // Overwrites previous user

        assertEquals(1, users.size());
        assertEquals("Alice2", users.get("alice").firstName);
    }
}

