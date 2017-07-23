package com.erensto.hello;

/**
 * Created by Ernesto on 2016-07-05.
 */
public class Greeting {
    private final long id;
    private final String subject;
    private static final String template = "Hello, %s!";

    public Greeting(long id, String subject) {
        this.id = id;
        this.subject = subject;
    }

    public long getId() {
        return id;
    }

    public String getGreeting() {
        return String.format(template,subject);
    }
}
