package com.example.arhaicwordsdictionary;

import java.util.Comparator;

public class WordsComparator implements Comparator<Words> {

    @Override
    public int compare(Words first, Words second) {
        return first.getWord().compareTo(second.getWord());
    }
}
