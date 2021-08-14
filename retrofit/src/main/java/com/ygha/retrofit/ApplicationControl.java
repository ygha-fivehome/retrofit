package com.ygha.retrofit;

import android.app.Application;

import com.ygha.retrofit.commonutils.AppPreferenceManager;
import com.ygha.retrofit.network.NetworkService;


/**
 * Created by vidyanandmishra on 13/12/16.
 */

public class ApplicationControl extends Application {

    private NetworkService networkService;

    @Override
    public void onCreate() {
        super.onCreate();
        AppPreferenceManager.setAppPreferenceManager(this);
        networkService = new NetworkService(getApplicationContext());
    }

    public NetworkService getNetworkService() {

        if(networkService == null) {
            networkService = new NetworkService(getApplicationContext());
        }

        return networkService;
    }
}
