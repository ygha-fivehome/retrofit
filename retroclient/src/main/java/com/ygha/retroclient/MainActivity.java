package com.ygha.retroclient;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.ygha.retroclient.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    TextView resultTxt;

    RetroClient retroClient;
    ActivityMainBinding binding;
    PostResult postResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setMyText("바인딩 테스트");
        retroClient = RetroClient.getInstance(this).createBaseApi();

        retroClient.getFirst("1", new RetroCallback() {
            @Override
            public void onError(Throwable t) {

            }

            @Override
            public void onSuccess(int code, Object receivedData) {
               PostResult data = (PostResult)receivedData;
               binding.setPost(data);

            }

            @Override
            public void onFailure(int code) {

            }
        });
    }
}