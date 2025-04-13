package com.example.jiravoip;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;
import javax.annotation.PostConstruct;
import java.util.List;

@SpringBootApplication
@RestController
public class Main {
    @Autowired
    private VoipService voipService;

    @Autowired
    private JiraService jiraService;

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @GetMapping("/")
    public String home() {
        return "Jira-VoIP Integration Service";
    }

    @GetMapping("/status")
    public String status() {
        return "Service is running";
    }

    @GetMapping("/calls")
    public List<Call> getCalls() {
        return voipService.fetchCalls();
    }

    @PostConstruct
    public void processCalls() {
        voipService.fetchCalls().stream()
                .filter(call -> !call.isAnswered())
                .forEach(call -> {
                    JiraIssue issue = new JiraIssue(
                            call.getFrom(),
                            call.getTo(),
                            30, // Default duration
                            java.time.Instant.now().toString()
                    );
                    jiraService.createIssue(issue);
                });
    }
}