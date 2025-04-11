package com.example.jiravoip;

public class JiraIssue {

    private String callerPhoneNumber;
    private String recipientPhoneNumber;
    private int callDuration;
    private String callTimestamp;

    // Constructor
    public JiraIssue(String callerPhoneNumber, String recipientPhoneNumber, int callDuration, String callTimestamp) {
        this.callerPhoneNumber = callerPhoneNumber;
        this.recipientPhoneNumber = recipientPhoneNumber;
        this.callDuration = callDuration;
        this.callTimestamp = callTimestamp;
    }

    // Getters for all fields
    public String getCallerPhoneNumber() {
        return callerPhoneNumber;
    }

    public String getRecipientPhoneNumber() {
        return recipientPhoneNumber;
    }

    public int getCallDuration() {
        return callDuration;
    }

    public String getCallTimestamp() {
        return callTimestamp;
    }

    // Optional Setters if you want to modify them later
    public void setCallerPhoneNumber(String callerPhoneNumber) {
        this.callerPhoneNumber = callerPhoneNumber;
    }

    public void setRecipientPhoneNumber(String recipientPhoneNumber) {
        this.recipientPhoneNumber = recipientPhoneNumber;
    }

    public void setCallDuration(int callDuration) {
        this.callDuration = callDuration;
    }

    public void setCallTimestamp(String callTimestamp) {
        this.callTimestamp = callTimestamp;
    }
}
