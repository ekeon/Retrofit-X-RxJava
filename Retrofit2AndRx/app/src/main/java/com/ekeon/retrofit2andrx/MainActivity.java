package com.ekeon.retrofit2andrx;

import android.app.Service;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.ekeon.retrofit2andrx.model.GitHubUserModel;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;

public class MainActivity extends AppCompatActivity {

  private TextView tvInfo;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    tvInfo = (TextView)findViewById(R.id.tv_info);

      GitHubService gitHubService = ServiceFactory.createRetrofitService(GitHubService.class);
      gitHubService.getInfo("ekeon")
              .observeOn(AndroidSchedulers.mainThread())
              .subscribe(new Subscriber<GitHubUserModel>() {
                @Override
                public void onCompleted() {

                }

                @Override
                public void onError(Throwable e) {

                }

                @Override
                public void onNext(GitHubUserModel gitHubUserModel) {
                  tvInfo.setText("" + gitHubUserModel.toString());
                  Log.d("TAG","" + gitHubUserModel.toString());
                }
              });


  }
}
