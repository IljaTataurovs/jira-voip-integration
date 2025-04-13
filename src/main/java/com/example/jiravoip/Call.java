package com.example.jiravoip;

public class Call {
    private String from;
    private String to;
    private boolean answered;

    public Call() {}

    public Call(String from, String to, boolean answered) {
        this.from = from;
        this.to = to;
        this.answered = answered;
    }

    // Getters and Setters
    public String getFrom() { return from; }
    public void setFrom(String from) { this.from = from; }
    public String getTo() { return to; }
    public void setTo(String to) { this.to = to; }
    public boolean isAnswered() { return answered; }
    public void setAnswered(boolean answered) { this.answered = answered; }
}