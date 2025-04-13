package com.example.jiravoip;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class VoipService {
    public List<Call> fetchCalls() {
        List<Call> calls = new ArrayList<>();
        calls.add(new Call("+1234567890", "+0987654321", false)); // Missed call
        calls.add(new Call("+1122334455", "+5566778899", true));  // Answered call
        return calls;
    }
}