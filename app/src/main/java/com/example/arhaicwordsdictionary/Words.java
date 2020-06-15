package com.example.arhaicwordsdictionary;

public class Words {
    private int id;
    private String word;
    private String description;

    public Words(int id, String word, String description) {
        this.id = id;
        this.word = word;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
