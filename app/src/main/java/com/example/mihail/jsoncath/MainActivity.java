package com.example.mihail.jsoncath;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.mihail.jsoncath.api.ChatApi;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    public static String LOG_TAG = "my_log";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView textView = findViewById(R.id.text);

        Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("http://sayes.mcdir.ru/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

        ChatApi api = retrofit.create(ChatApi.class);
//Фрагмент который выводит информацию из апи в интерфейс
        api.getChats()
                .enqueue(new Callback<List<Chat>>() {
                    @Override
                    public void onResponse(Call<List<Chat>> call, Response<List<Chat>> response) {
                        if (response.code() == 200) {
                            textView.setText(String.valueOf(response.body().get(2).getMsgText()));
                        }
                    }

                    @Override
                    public void onFailure(Call<List<Chat>> call, Throwable t) {

                    }
                });
    }

//    private class ParseTask extends AsyncTask<Void, Void, String> {
//
//        HttpURLConnection urlConnection = null;
//        BufferedReader reader = null;
//        String resultJson = "";
//
//        @Override
//        public String doInBackground(Void... params) {
//            // получаем данные с внешнего ресурса
//           Retrofit retrofit = new Retrofit.Builder()
//                    .baseUrl("http://sayes.mcdir.ru/")
//                    .build();
//
//            ChatApi api = retrofit.create(ChatApi.class);
//
//
//
//            api.getChats()
//                    .enqueue(new Callback<List<Chat>>() {
//                        @Override
//                        public void onResponse(Call<List<Chat>> call, Response<List<Chat>> response) {
//                            if (response.code() == 200) {
//                                result = response.body();
//                            }
//                        }
//
//                        @Override
//                        public void onFailure(Call<List<Chat>> call, Throwable t) {
//
//                        }
//                    });
//            /*try {
//                URL url = new URL("http://sayes.mcdir.ru/api/getmessage/21/10/20");
//
//                urlConnection = (HttpURLConnection) url.openConnection();
//                urlConnection.setRequestMethod("GET");
//                urlConnection.connect();
//
//                InputStream inputStream = urlConnection.getInputStream();
//                StringBuffer buffer = new StringBuffer();
//
//                reader = new BufferedReader(new InputStreamReader(inputStream));
//
//                String line;
//                while ((line = reader.readLine()) != null) {
//                    buffer.append(line);
//                }
//
//                resultJson = buffer.toString();
//
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//            return resultJson;*/
//        }
//
//
//
//
//
//
//        @Override
//        protected void onPostExecute(List<Chat> data) {
//            super.onPostExecute(strJson);
//            // выводим целиком полученную json-строку
//            Log.d(LOG_TAG, strJson);
//
//            JSONObject dataJsonObj = null;
//            String secondName = "";
//
//            try {
//
//                dataJsonObj = new JSONObject(strJson);
//                JSONArray friends = dataJsonObj.getJSONArray("friends");
//
//                // 1. достаем инфо о втором друге - индекс 1
//                JSONObject secondFriend = friends.getJSONObject(1);
//
//                String mes = dataJsonObj.getString("msg_text");
//                secondName = secondFriend.getString("name");
//                Log.d(LOG_TAG, "Второе имя: " + secondName);
//
//                // 2. перебираем и выводим контакты каждого друга
//                for (int i = 0; i < friends.length(); i++) {
//                    JSONObject friend = friends.getJSONObject(i);
//
//                    JSONObject contacts = friend.getJSONObject("contacts");
//
//                    String phone = contacts.getString("mobile");
//                    String email = contacts.getString("email");
//                    String skype = contacts.getString("skype");
//
//                    Log.d(LOG_TAG, "phone: " + phone);
//                    Log.d(LOG_TAG, "email: " + email);
//                    Log.d(LOG_TAG, "skype: " + skype);
//                    Log.d(LOG_TAG, "Сообщение: " + mes);
//                }
//
//            } catch (JSONException e) {
//                e.printStackTrace();
//            }
//            Log.d(LOG_TAG, strJson);
//
//
//            //GsonBuilder builder = new GsonBuilder();
//            //Gson gson = builder.create();
//            //String murzik;
//            //murzik = gson.fromJson(strJson);
//            //Log.i("GSON", "Имя: " + murzik);
//        }
//    }
}
