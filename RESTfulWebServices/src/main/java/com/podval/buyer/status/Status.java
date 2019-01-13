package com.podval.buyer.status;

public class Status {

    private String name;

    private String description;

    private String additionalMessage;

    public Status() {
    }

    private Status(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public static final Status NO_CONTENT = new Status("NO_CONTENT", "There are no content with such parameters");
    public static final Status NOT_FOUND = new Status("NOT_FOUND", "Cant fount this object");
    //public static final Status OK = new Status("OK", "All is good");
    public static final Status NOT_MODIFIED = new Status("NOT_MODIFIED", "Data wasn't modified");
    public static final Status CREATED = new Status("CREATED", "DataObject has been created");

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getAdditionalMessage() {
        return additionalMessage;
    }

    public void setAdditionalMessage(String additionalMessage) {
        this.additionalMessage = additionalMessage;
    }
}
