package com.example.listview;

import java.util.ArrayList;

public class SmsEmail {
    private String sender;
    private String content;
    private String description;
    private String time;
    private int state;
    private int color;

    public SmsEmail(String sender, String content, String description, String time, int state, int color) {
        this.sender = sender;
        this.content = content;
        this.description = description;
        this.time = time;
        this.state = state;
        this.color = color;
    }
    public void setSender(String sender){
        this.sender = sender;
    }
    public String getSender(){
        return sender;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTime() {
        return time;
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getState() {
        return state;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }
}
