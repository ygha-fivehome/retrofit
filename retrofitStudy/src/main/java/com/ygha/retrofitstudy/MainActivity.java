package com.ygha.retrofitstudy;


import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.JsonObject;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by NewLand on 2017. 11. 7..
 */

public class MainActivity extends AppCompatActivity {
    EditText editText;
    android.widget.TextView textView;
    Button confirmBtn;

    @Override
    protected void onCreate(android.os.Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText) findViewById(R.id.editText);
        textView = (android.widget.TextView) findViewById(R.id.textView);
        confirmBtn = (Button) findViewById(R.id.button);
        confirmBtn.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(android.view.View v) {
                onSearch(v);
            }
        });
    }

    public void onSearch(android.view.View view) {
        String id = editText.getText().toString();

        if (!id.isEmpty()) {
            Call<ArrayList<JsonObject>> res = NetRetrofit.getInstance().getService().getListRepos(id);
            res.enqueue(new Callback<ArrayList<JsonObject>>() {
                @Override
                public void onResponse(Call<ArrayList<JsonObject>> call, Response<ArrayList<JsonObject>> response) {
                    android.util.Log.d("Retrofit", response.toString());
                    if (response.body() != null)
                        textView.setText(response.body().toString());

                    if(response.errorBody()!=null)
                        textView.setText(response.errorBody().toString());
                }

                @Override
                public void onFailure(Call<ArrayList<JsonObject>> call, Throwable t) {
                    android.util.Log.e("Err", t.getMessage());
                }
            });
        } else
            Toast.makeText(this, "아이디를 입력하세요.", Toast.LENGTH_SHORT).show();
    }
}
