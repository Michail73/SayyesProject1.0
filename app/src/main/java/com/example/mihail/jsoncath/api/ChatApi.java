package com.example.mihail.jsoncath.api;

import com.example.mihail.jsoncath.Chat;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import  retrofit2.http.POST;
import retrofit2.Callback;


public interface ChatApi {

    @GET("api/getmessage/21/10/20")
    Call<List<Chat>> getChats();

    @POST("api/getmessage/21/10/20")
    Callback<Chat> setChats();
}
