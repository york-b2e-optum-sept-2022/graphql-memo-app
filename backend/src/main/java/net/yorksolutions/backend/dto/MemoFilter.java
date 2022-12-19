package net.yorksolutions.backend.dto;

public class MemoFilter {
    private String text;

    public MemoFilter(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
