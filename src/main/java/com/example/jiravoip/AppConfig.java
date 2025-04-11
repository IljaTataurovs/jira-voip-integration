package com.example.jiravoip;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestTemplate;

@Configuration // Marks this as a Spring configuration class
public class AppConfig {

    // Properties injected from the application.properties file
    @Value("${jira.url}")
    private String jiraUrl;

    @Value("${jira.username}")
    private String jiraUsername;

    @Value("${jira.apiToken}")
    private String jiraApiToken;

    @Value("${jira.issue.callerPhoneNumber}")  // New properties for JiraIssue
    private String callerPhoneNumber;

    @Value("${jira.issue.recipientPhoneNumber}")
    private String recipientPhoneNumber;

    @Value("${jira.issue.callDuration}")
    private int callDuration;

    @Value("${jira.issue.callTimestamp}")
    private String callTimestamp;

    // Define the RestTemplate bean for HTTP requests
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    // Define the JiraIssue bean for creating Jira issues
    @Bean
    public JiraIssue jiraIssue() {
        return new JiraIssue(callerPhoneNumber, recipientPhoneNumber, callDuration, callTimestamp);
    }

    // Getters for the properties injected from the application.properties
    public String getJiraUrl() {
        return jiraUrl;
    }

    public String getJiraUsername() {
        return jiraUsername;
    }

    public String getJiraApiToken() {
        return jiraApiToken;
    }
}
