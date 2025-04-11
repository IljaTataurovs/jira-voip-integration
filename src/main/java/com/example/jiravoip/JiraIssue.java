package com.example.jiravoip;

public class JiraIssue {

    private String callerPhoneNumber;
    private String recipientPhoneNumber;
    private int callDuration;
    private String callTimestamp;

    // Getters and setters
    public String getCallerPhoneNumber() {
        return callerPhoneNumber;
    }

    public void setCallerPhoneNumber(String callerPhoneNumber) {
        this.callerPhoneNumber = callerPhoneNumber;
    }

    public String getRecipientPhoneNumber() {
        return recipientPhoneNumber;
    }

    public void setRecipientPhoneNumber(String recipientPhoneNumber) {
        this.recipientPhoneNumber = recipientPhoneNumber;
    }

    public int getCallDuration() {
        return callDuration;
    }

    public void setCallDuration(int callDuration) {
        this.callDuration = callDuration;
    }

    public String getCallTimestamp() {
        return callTimestamp;
    }

    public void setCallTimestamp(String callTimestamp) {
        this.callTimestamp = callTimestamp;
    }

    // Constructor for JiraIssue
    public JiraIssue(String callerPhoneNumber, String recipientPhoneNumber, int callDuration, String callTimestamp) {
        this.callerPhoneNumber = callerPhoneNumber;
        this.recipientPhoneNumber = recipientPhoneNumber;
        this.callDuration = callDuration;
        this.callTimestamp = callTimestamp;
    }

    // Default constructor
    public JiraIssue() {}
}
