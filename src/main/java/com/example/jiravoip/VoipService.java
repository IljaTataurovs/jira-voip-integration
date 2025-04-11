package com.example.jiravoip;

<<<<<<< HEAD
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service  // Mark this class as a Spring service
public class VoipService {

    public List<Call> fetchCalls() {
        // In a real application, here you might fetch data from a database or external API
        List<Call> calls = new ArrayList<>();
        calls.add(new Call("+1234567890", "+0987654321", false)); // Example unanswered call
        calls.add(new Call("+1234567890", "+0987654321", true));  // Example answered call
=======
import java.util.ArrayList;
import java.util.List;

public class VoipService {
    public List<Call> fetchCalls() {
        List<Call> calls = new ArrayList<>();
        calls.add(new Call("+1234567890", "+0987654321", false));
        calls.add(new Call("+1234567890", "+0987654321", true));
>>>>>>> 59381ae0d25802559ba1f80d1d09294f419a5d3b
        return calls;
    }
}
