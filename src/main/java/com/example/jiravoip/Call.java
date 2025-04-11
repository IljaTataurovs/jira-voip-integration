package com.example.jiravoip;

public class Call {
<<<<<<< HEAD

=======
>>>>>>> 59381ae0d25802559ba1f80d1d09294f419a5d3b
    private String from;
    private String to;
    private boolean answered;

<<<<<<< HEAD
    // Constructor for creating call objects with parameters
=======
>>>>>>> 59381ae0d25802559ba1f80d1d09294f419a5d3b
    public Call(String from, String to, boolean answered) {
        this.from = from;
        this.to = to;
        this.answered = answered;
    }

<<<<<<< HEAD
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
=======
    public String getFrom() { return from; }
    public String getTo() { return to; }
    public boolean isAnswered() { return answered; }
>>>>>>> 59381ae0d25802559ba1f80d1d09294f419a5d3b
}
