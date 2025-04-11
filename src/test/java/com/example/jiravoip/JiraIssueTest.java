// JiraIssueTest.java
package com.example.jiravoip;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class JiraIssueTest {
    @Test
    void testJiraIssueProperties() {
        JiraIssue issue = new JiraIssue("+1234567890", "+0987654321", 30, "2025-03-09T14:30:00");
        assertEquals("+1234567890", issue.getCallerPhoneNumber());
        assertEquals("+0987654321", issue.getRecipientPhoneNumber());
        assertEquals(30, issue.getCallDuration());
        assertEquals("2025-03-09T14:30:00", issue.getCallTimestamp());
    }
}