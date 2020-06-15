package com.example.arhaicwordsdictionary;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class WordsListViewAdapter extends BaseAdapter {
    private List<Words> wordsList;
    private Context context;

    public WordsListViewAdapter(List<Words> wordsList, Context context) {
        this.wordsList = wordsList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return wordsList.size();
    }

    @Override
    public Object getItem(int position) {
        return wordsList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return wordsList.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        convertView = inflater.inflate(R.layout.custom_list_view_item,parent,false);

        Words words = wordsList.get(position);

        TextView wordTextView = convertView.findViewById(R.id.word_text_view);
        TextView wordDescriptionTextView = convertView.findViewById(R.id.word_description_text_view);

        wordTextView.setText(words.getWord());
        wordDescriptionTextView.setText(words.getDescription());

        return convertView;
    }
}
