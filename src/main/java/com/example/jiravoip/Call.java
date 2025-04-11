package com.example.jiravoip;

public class Call {
    private String from;
    private String to;
    private boolean answered;

    public Call(String from, String to, boolean answered) {
        this.from = from;
        this.to = to;
        this.answered = answered;
    }

    public String getFrom() { return from; }
    public String getTo() { return to; }
    public boolean isAnswered() { return answered; }
}
