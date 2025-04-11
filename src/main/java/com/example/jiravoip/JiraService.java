package com.example.jiravoip;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
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
            textNode.addProperty("text", "Caller's Phone: " + issue.getCallerPhoneNumber() + "\n" +
                    "Recipient's Phone: " + issue.getRecipientPhoneNumber() + "\n" +
                    "Duration: " + issue.getCallDuration() + " seconds\n" +
                    "Timestamp: " + issue.getCallTimestamp());

            textArray.add(textNode);
            paragraph.add("content", textArray);
            contentArray.add(paragraph);
            description.add("content", contentArray);

            fields.add("description", description);
            payload.add("fields", fields);
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
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

