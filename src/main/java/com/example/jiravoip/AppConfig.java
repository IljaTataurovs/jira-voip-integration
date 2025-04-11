package com.example.jiravoip;

<<<<<<< HEAD
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
=======
import org.apache.commons.configuration2.PropertiesConfiguration;
import org.apache.commons.configuration2.builder.fluent.Configurations;
import org.apache.commons.configuration2.ex.ConfigurationException;

public class AppConfig {
    private static PropertiesConfiguration config;

    static {
        try {
            config = new Configurations().properties(AppConfig.class.getClassLoader().getResource("application.properties"));
        } catch (ConfigurationException e) {
            System.err.println("Failed to load application.properties. Please ensure the file exists in src/main/resources.");
            e.printStackTrace();
            System.exit(1);
        }
    }

    public static String getProperty(String key) {
        return config.getString(key);
    }
}
>>>>>>> 59381ae0d25802559ba1f80d1d09294f419a5d3b
