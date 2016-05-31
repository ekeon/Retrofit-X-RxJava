package com.ekeon.retrofit2andrx;

import com.ekeon.retrofit2andrx.model.GitHubUserModel;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by Ekeon on 2016. 5. 30..
 */
public interface GitHubService {

  @GET("/users/{id}")
  Observable<GitHubUserModel> getInfo(@Path("id") String login);
}
