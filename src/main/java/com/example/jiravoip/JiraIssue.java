package com.example.jiravoip;

public class JiraIssue {
    private String callerPhoneNumber;
    private String recipientPhoneNumber;
    private int callDuration;
    private String callTimestamp;

    public JiraIssue(String callerPhoneNumber, String recipientPhoneNumber, int callDuration, String callTimestamp) {
        this.callerPhoneNumber = callerPhoneNumber;
        this.recipientPhoneNumber = recipientPhoneNumber;
        this.callDuration = callDuration;
        this.callTimestamp = callTimestamp;
    }

    public String getCallerPhoneNumber() { return callerPhoneNumber; }
    public String getRecipientPhoneNumber() { return recipientPhoneNumber; }
    public int getCallDuration() { return callDuration; }
    public String getCallTimestamp() { return callTimestamp; }
}