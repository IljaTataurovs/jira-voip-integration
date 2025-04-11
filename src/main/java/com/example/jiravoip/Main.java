package com.example.jiravoip;

<<<<<<< HEAD
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
=======
import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

public class Main {
    public static void main(String[] args) throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(80), 0);

        // Root endpoint
        server.createContext("/", exchange -> {
            String response = "Welcome to Jira VoIP Integration App!";
            exchange.sendResponseHeaders(200, response.length());
            try (OutputStream os = exchange.getResponseBody()) {
                os.write(response.getBytes());
            }
        });

        // /status endpoint
        server.createContext("/status", exchange -> {
            String response = "Service is running";
            exchange.sendResponseHeaders(200, response.length());
            try (OutputStream os = exchange.getResponseBody()) {
                os.write(response.getBytes());
            }
        });

        server.setExecutor(null); // default
        server.start();
        System.out.println("Server started on port 80");
>>>>>>> 59381ae0d25802559ba1f80d1d09294f419a5d3b
    }
}
