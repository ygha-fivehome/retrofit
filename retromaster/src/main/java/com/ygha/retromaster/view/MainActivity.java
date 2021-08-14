package com.ygha.retromaster.view;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.ygha.retromaster.R;
import com.ygha.retromaster.model.Country;
import com.ygha.retromaster.presenter.CountryPresenter;

import java.util.List;

public class MainActivity extends AppCompatActivity implements CountryView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        CountryPresenter countryPresenter = new CountryPresenter(this);

        // Maybe it's best to call it on onResume()
        countryPresenter.getCountries();
    }

    @Override
    public void countriesReady(List<Country> countries) {

        // See your Logcat :)
        for (Country country : countries) {
            Log.i("RETROFIT", country.getName() + "\n"
                    + " - Alpha2:  " + country.getAlphaCode2() + " \n"
                    + " - Alpha3: " + country.getAlphaCode3());
        }
    }
}
