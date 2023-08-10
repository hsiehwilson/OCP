package com.example.consumer.utils;
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
    //下⾯這個是想⽤在email列點，後⾯會⽤hashmap⽅式put
    public ArrayList<String> technologies;
}