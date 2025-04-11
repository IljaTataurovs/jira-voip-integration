package com.example.jiravoip;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class VoipServiceTest {
    private VoipService voipService;

    @BeforeEach
    void setUp() {
        voipService = new VoipService();
    }

    @Test
    void testFetchCalls() {
        List<Call> calls = voipService.fetchCalls();
        assertFalse(calls.isEmpty(), "Call list should not be empty");
    }
}