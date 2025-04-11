package com.example.jiravoip;

import java.util.ArrayList;
import java.util.List;

public class VoipService {
    public List<Call> fetchCalls() {
        List<Call> calls = new ArrayList<>();
        calls.add(new Call("+1234567890", "+0987654321", false));
        calls.add(new Call("+1234567890", "+0987654321", true));
        return calls;
    }
}
