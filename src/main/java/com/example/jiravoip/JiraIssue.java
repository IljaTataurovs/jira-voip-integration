package com.example.jiravoip;

public class JiraIssue {
<<<<<<< HEAD

=======
>>>>>>> 59381ae0d25802559ba1f80d1d09294f419a5d3b
    private String callerPhoneNumber;
    private String recipientPhoneNumber;
    private int callDuration;
    private String callTimestamp;

<<<<<<< HEAD
    // Constructor
=======
>>>>>>> 59381ae0d25802559ba1f80d1d09294f419a5d3b
    public JiraIssue(String callerPhoneNumber, String recipientPhoneNumber, int callDuration, String callTimestamp) {
        this.callerPhoneNumber = callerPhoneNumber;
        this.recipientPhoneNumber = recipientPhoneNumber;
        this.callDuration = callDuration;
        this.callTimestamp = callTimestamp;
    }

<<<<<<< HEAD
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
=======
    public String getCallerPhoneNumber() { return callerPhoneNumber; }
    public String getRecipientPhoneNumber() { return recipientPhoneNumber; }
    public int getCallDuration() { return callDuration; }
    public String getCallTimestamp() { return callTimestamp; }
}
>>>>>>> 59381ae0d25802559ba1f80d1d09294f419a5d3b
