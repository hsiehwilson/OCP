package com.example.consumer.model;

import lombok.Data;

import java.util.Map;

@Data
public class Email {
    public String to;
    public String From;
    public String Subject;
    public String Template;

    private Map<String, Object> properties;
}
