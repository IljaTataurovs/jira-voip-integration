// AppConfigTest.java
package com.example.jiravoip;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AppConfigTest {
    @BeforeEach
    void setUp() {
        // Ensure properties are loaded correctly
    }

    @Test
    void testGetProperty() {
        String jiraUrl = AppConfig.getProperty("jira.url");
        assertNotNull(jiraUrl, "JIRA URL should not be null");
    }
}