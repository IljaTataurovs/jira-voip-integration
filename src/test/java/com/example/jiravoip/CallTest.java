
package com.example.jiravoip;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.*;

public class CallTest {
    @ParameterizedTest
    @CsvSource({
            "+1234567890, +0987654321, false",
            "+1112223333, +4445556666, true"
    })
    void testCallProperties(String from, String to, boolean answered) {
        Call call = new Call(from, to, answered);
        assertEquals(from, call.getFrom());
        assertEquals(to, call.getTo());
        assertEquals(answered, call.isAnswered());
    }
}