package com.example.jiravoip;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
<<<<<<< HEAD
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
=======
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import java.util.Base64;

public class JiraService {
    private static final String JIRA_URL = AppConfig.getProperty("jira.url");
    private static final String USERNAME = AppConfig.getProperty("jira.username");
    private static final String API_TOKEN = AppConfig.getProperty("jira.apiToken");

    public void createIssue(JiraIssue issue) {
        String apiUrl = JIRA_URL + "/rest/api/3/issue";

        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            HttpPost request = new HttpPost(apiUrl);
            String auth = USERNAME + ":" + API_TOKEN;
            String encodedAuth = Base64.getEncoder().encodeToString(auth.getBytes());
            request.setHeader("Authorization", "Basic " + encodedAuth);
            request.setHeader("Content-Type", "application/json");

>>>>>>> 59381ae0d25802559ba1f80d1d09294f419a5d3b
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
<<<<<<< HEAD
            textNode.addProperty("text", "Caller's Phone: " + issue.getCallerPhoneNumber() + "\n"
                    + "Recipient's Phone: " + issue.getRecipientPhoneNumber() + "\n"
                    + "Duration: " + issue.getCallDuration() + " seconds\n"
                    + "Timestamp: " + issue.getCallTimestamp());
=======
            textNode.addProperty("text", "Caller's Phone: " + issue.getCallerPhoneNumber() + "\n" +
                    "Recipient's Phone: " + issue.getRecipientPhoneNumber() + "\n" +
                    "Duration: " + issue.getCallDuration() + " seconds\n" +
                    "Timestamp: " + issue.getCallTimestamp());
>>>>>>> 59381ae0d25802559ba1f80d1d09294f419a5d3b

            textArray.add(textNode);
            paragraph.add("content", textArray);
            contentArray.add(paragraph);
            description.add("content", contentArray);

            fields.add("description", description);
            payload.add("fields", fields);
<<<<<<< HEAD

            // Prepare the HTTP request entity with headers and body
            HttpEntity<String> entity = new HttpEntity<>(payload.toString(), headers);

            // Make the HTTP POST request to Jira API
            ResponseEntity<String> response = restTemplate.exchange(apiUrl, HttpMethod.POST, entity, String.class);

            // Print the response from Jira API
            System.out.println("JIRA API Response: " + response.getBody());

=======
            request.setEntity(new StringEntity(payload.toString()));

            HttpResponse response = httpClient.execute(request);
            int statusCode = response.getStatusLine().getStatusCode();
            String responseBody = EntityUtils.toString(response.getEntity());

            if (statusCode >= 200 && statusCode < 300) {
                System.out.println("JIRA issue created successfully: " + responseBody);
            } else {
                System.err.println("Failed to create JIRA issue. Status: " + statusCode);
                System.err.println("Response: " + responseBody);
            }
>>>>>>> 59381ae0d25802559ba1f80d1d09294f419a5d3b
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
<<<<<<< HEAD
=======

>>>>>>> 59381ae0d25802559ba1f80d1d09294f419a5d3b
