package com.example.producer.service.routingmode.bean;

import lombok.Data;
import java.util.ArrayList;
@Data
public class mailTemplate {

    public String To;
    public String From;
    public String Subject;
    public String Template;
    public String name;
    public String subscriptionDate;
    // 用在email列點，後面用hashmap方式put
    public ArrayList<String> technologies;
}
