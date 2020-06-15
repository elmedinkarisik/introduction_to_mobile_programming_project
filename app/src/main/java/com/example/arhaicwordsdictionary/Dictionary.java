package com.example.arhaicwordsdictionary;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class Dictionary extends AppCompatActivity {
    public static FloatingActionButton addWord;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dictionary);

        addWord = findViewById(R.id.add_word_button);
        listView = findViewById(R.id.list_view_container);
        getWords();
        /*  First Version

        WordsListViewAdapter wordsListViewAdapter = new WordsListViewAdapter(getWords(),this);
        listView.setAdapter(wordsListViewAdapter);*/
    }

    public void onActionClick(View view) {
        Intent intent = new Intent(Dictionary.this,WordAddActivity.class);
        startActivity(intent);
    }

    private void getWords(){
        Call<List<Words>> listCall = RetrofitProvider.getInstance().getAllWords();
        listCall.enqueue(new Callback<List<Words>>() {
            @Override
            public void onResponse(Call<List<Words>> call, Response<List<Words>> response) {
                if(response.isSuccessful()) {
                    List<Words> words = response.body();
                    WordsListViewAdapter adapter = new WordsListViewAdapter(words, Dictionary.this);
                    listView.setAdapter(adapter);
                    Collections.sort(words,new WordsComparator());
                }else{

                }
            }

            @Override
            public void onFailure(Call<List<Words>> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }

    /*  First version

        private List<Words> getWords(){
        List<Words> wordsList = new ArrayList<>();
        wordsList.add(new Words("Pendžer","Prozor"));
        wordsList.add(new Words("Basamaci","Stepenice"));
        wordsList.add(new Words("Hećim","Doktor"));
        wordsList.add(new Words("Ćeif","Uživanje"));
        wordsList.add(new Words("","Uživanje"));
        wordsList.add(new Words("Aeif",""));

        Collections.sort(wordsList,new WordsComparator());

        return wordsList;
    }*/
}
