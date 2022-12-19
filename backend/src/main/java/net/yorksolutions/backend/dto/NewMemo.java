package net.yorksolutions.backend.dto;

public class NewMemo {

    private String text;

    public NewMemo(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
