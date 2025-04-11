package com.example.jiravoip;

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