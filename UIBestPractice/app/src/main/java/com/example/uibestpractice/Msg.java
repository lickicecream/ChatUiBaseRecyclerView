package com.example.uibestpractice;

public class Msg {
    public static final int TYPE_RECEIVED=0;
    public static final int TYPE_SEND=1;

    private String text;
    private int type;
    public Msg(String text,int type){
        this.text=text;
        this.type=type;

    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
