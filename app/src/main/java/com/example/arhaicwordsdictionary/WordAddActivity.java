package com.example.arhaicwordsdictionary;

import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class WordAddActivity extends AppCompatActivity {
    private EditText word,wordDescription;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_word_add);

        word = findViewById(R.id.word);
        wordDescription = findViewById(R.id.word_description);

    }

    public void onSaveClick(View view){
        // "Back" Action ---> Intent bintent = new Intent(WordAddActivity.this, Dictionary.class);
        Words words = new Words(7,word.getText().toString(),wordDescription.getText().toString());
        Call<Words> wordsCall = RetrofitProvider.getInstance().addNewWord(words);
        wordsCall.enqueue(new Callback<Words>() {
            @Override
            public void onResponse(Call<Words> call, Response<Words> response) {
                if(response.isSuccessful()){

                }
            }

            @Override
            public void onFailure(Call<Words> call, Throwable t) {
                t.printStackTrace();
            }
        });
        // "Back" Action ---> startActivity(bintent);
    }
}
