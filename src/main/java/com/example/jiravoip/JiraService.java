package com.example.jiravoip;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import java.util.Base64;

@Service  // Marks this class as a Spring service
public class JiraService {

    @Value("${jira.url}")  // Load JIRA URL from application.properties
    private String jiraUrl;

    @Value("${jira.username}")  // Load JIRA username from application.properties
    private String username;

    @Value("${jira.apiToken}")  // Load JIRA API token from application.properties
    private String apiToken;

    private final RestTemplate restTemplate;

    // Constructor-based dependency injection
    public JiraService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public void createIssue(JiraIssue issue) {
        String apiUrl = jiraUrl + "/rest/api/3/issue";

        try {
            // Create headers with Basic Authentication
            HttpHeaders headers = new HttpHeaders();
            String auth = username + ":" + apiToken;
            String encodedAuth = Base64.getEncoder().encodeToString(auth.getBytes());
            headers.set("Authorization", "Basic " + encodedAuth);
            headers.set("Content-Type", "application/json");

            // Create the JSON payload
            JsonObject payload = new JsonObject();
            JsonObject fields = new JsonObject();

            JsonObject project = new JsonObject();
            project.addProperty("key", "VOIP");
            fields.add("project", project);

            JsonObject issuetype = new JsonObject();
            issuetype.addProperty("id", "10014");
            fields.add("issuetype", issuetype);

            JsonObject reporter = new JsonObject();
            reporter.addProperty("accountId", "712020:549f3108-0805-410c-ab11-9161331a3938");
            fields.add("reporter", reporter);

            String summary = "Unanswered Call from " + issue.getCallerPhoneNumber() + " to " + issue.getRecipientPhoneNumber();
            fields.addProperty("summary", summary);

            JsonObject description = new JsonObject();
            description.addProperty("type", "doc");
            description.addProperty("version", 1);

            JsonArray contentArray = new JsonArray();
            JsonObject paragraph = new JsonObject();
            paragraph.addProperty("type", "paragraph");

            JsonArray textArray = new JsonArray();
            JsonObject textNode = new JsonObject();
            textNode.addProperty("type", "text");
            textNode.addProperty("text", "Caller's Phone: " + issue.getCallerPhoneNumber() + "\n"
                    + "Recipient's Phone: " + issue.getRecipientPhoneNumber() + "\n"
                    + "Duration: " + issue.getCallDuration() + " seconds\n"
                    + "Timestamp: " + issue.getCallTimestamp());

            textArray.add(textNode);
            paragraph.add("content", textArray);
            contentArray.add(paragraph);
            description.add("content", contentArray);

            fields.add("description", description);
            payload.add("fields", fields);

            // Prepare the HTTP request entity with headers and body
            HttpEntity<String> entity = new HttpEntity<>(payload.toString(), headers);

            // Make the HTTP POST request to Jira API
            ResponseEntity<String> response = restTemplate.exchange(apiUrl, HttpMethod.POST, entity, String.class);

            // Print the response from Jira API
            System.out.println("JIRA API Response: " + response.getBody());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
