package com.example.jiravoip;

import com.google.gson.JsonObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.Base64;

@Service
public class JiraService {
    private static final Logger logger = LoggerFactory.getLogger(JiraService.class);

    @Value("${jira.url}")
    private String jiraUrl;

    @Value("${jira.username}")
    private String username;

    @Value("${jira.apiToken}")
    private String apiToken;

    private final RestTemplate restTemplate;

    public JiraService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public void createIssue(JiraIssue issue) {
        try {
            // Create headers
            HttpHeaders headers = new HttpHeaders();
            String auth = username + ":" + apiToken;
            headers.add("Authorization", "Basic " + Base64.getEncoder().encodeToString(auth.getBytes()));
            headers.add("Content-Type", "application/json");

            // Build payload
            JsonObject payload = new JsonObject();
            JsonObject fields = new JsonObject();

            // Create project object
            JsonObject project = new JsonObject();
            project.addProperty("key", "VOIP");
            fields.add("project", project);

            // Create issue type object
            JsonObject issueType = new JsonObject();
            issueType.addProperty("id", "10014");
            fields.add("issuetype", issueType);

            fields.addProperty("summary", "Missed call from " + issue.getCallerPhoneNumber());
            payload.add("fields", fields);

            // Make API call
            ResponseEntity<String> response = restTemplate.exchange(
                    jiraUrl + "/rest/api/3/issue",
                    HttpMethod.POST,
                    new HttpEntity<>(payload.toString(), headers),
                    String.class
            );

            logger.info("JIRA API Response: {}", response.getBody());
        } catch (Exception e) {
            logger.error("Failed to create JIRA issue", e);
        }
    }
}