package com.example.jiravoip;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.PostConstruct;

import java.util.List;

@SpringBootApplication
public class Main {

    @Autowired
    private VoipService voipService;

    @Autowired
    private JiraService jiraService;

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args); // This will start the Spring Boot application
    }

    // Use this method to call the logic for processing calls at the start
    @PostConstruct
    public void processCalls() {
        // Fetch calls from VoIP service
        List<Call> calls = voipService.fetchCalls();

        // Process unanswered calls and create Jira issues
        for (Call call : calls) {
            if (!call.isAnswered()) {
                JiraIssue issue = new JiraIssue(
                        call.getFrom(),
                        call.getTo(),
                        30,
                        "2023-10-15T14:30:00"
                );
                jiraService.createIssue(issue);
            }
        }
    }

    // Spring Boot Controller for exposing endpoints
    @RestController
    public class ApiController {

        @GetMapping("/status")
        public String getStatus() {
            return "Service is running";
        }

        @GetMapping("/calls")
        public List<Call> getCalls() {
            // Fetch calls from the VoIP service
            return voipService.fetchCalls();
        }
    }
}
