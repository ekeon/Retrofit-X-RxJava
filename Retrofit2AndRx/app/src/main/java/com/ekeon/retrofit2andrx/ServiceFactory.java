package com.ekeon.retrofit2andrx;

import java.util.Observable;
import java.util.concurrent.Executors;

import javax.xml.transform.Templates;

import okhttp3.OkHttpClient;
import okhttp3.internal.http.HttpMethod;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Ekeon on 2016. 5. 30..
 */
public class ServiceFactory {

  private static final String GITHUB_URL = "https://api.github.com/";
  private Retrofit retrofit;

  static <T> T createRetrofitService(final Class<T> clazz) {
    final Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(GITHUB_URL)
            .client(new OkHttpClient())
            .callbackExecutor(Executors.newCachedThreadPool())
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
            .build();

    T service = retrofit.create(clazz);

    return service;
  }

}
