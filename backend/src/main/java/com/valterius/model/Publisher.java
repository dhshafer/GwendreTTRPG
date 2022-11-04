package com.valterius.model;

public class Publisher {
    //PK
    private int publisherId;
    private String publisher;

    // default constructor

    // getters and setters
    public int getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(int publisherId) {
        this.publisherId = publisherId;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
}
