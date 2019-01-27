package com.weatherforecastapp.network;

import com.weatherforecastapp.network.interceptor.ApiKeyInterceptor;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.weatherforecastapp.ui.util.Constants.BASE_URL;

public class RetrofitInstance {

    private static Retrofit retrofit;

    public static Retrofit getInstance(){
        if(retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(createClient())
                    .build();
        }
        return retrofit;
    }

    private static OkHttpClient createClient(){
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.addInterceptor(createHttpLoggingInterceptor());
        builder.addInterceptor(new ApiKeyInterceptor());
        return builder.build();
    }

    private static Interceptor createHttpLoggingInterceptor(){
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return loggingInterceptor;
    }
}
