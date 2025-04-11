package com.example.jiravoip;

public class Call {

    private String from;
    private String to;
    private boolean answered;

    // Constructor for creating call objects with parameters
    public Call(String from, String to, boolean answered) {
        this.from = from;
        this.to = to;
        this.answered = answered;
    }

    // Getters for all fields
    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public boolean isAnswered() {
        return answered;
    }

    // Optional: Setters if you want to modify them later
    public void setFrom(String from) {
        this.from = from;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public void setAnswered(boolean answered) {
        this.answered = answered;
    }
}
