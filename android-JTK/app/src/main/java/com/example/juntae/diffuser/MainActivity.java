package com.example.juntae.diffuser;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.lang.annotation.Retention;
import java.lang.reflect.Type;
import java.util.List;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Converter;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.L;
import static com.example.juntae.diffuser.ApiService.API_URL;
import static com.example.juntae.diffuser.R.id.button6;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import static java.security.AccessController.getContext;

public class MainActivity extends AppCompatActivity {


    Button button1;
    Button button2;
    Button button3;
    Button button4;
    Button button5;
    Button button6;
    //ApiService apiService;
    Retrofit retrofit;
    Context context;
    int i=0;
    int x = 0, y = 0, z = 0, l = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = this;
        button1 = (Button) findViewById(R.id.button);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);
        button5 = (Button) findViewById(R.id.button5);
        button6 = (Button) findViewById(R.id.button6);


        Intent intent = new Intent(this, splash.class);
        startActivity(intent);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button1.setText(String.valueOf(++x));
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                button2.setText(String.valueOf(++y));
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                button3.setText(String.valueOf(++z));
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                button4.setText(String.valueOf(++l));
            }
        });
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (x == 0 && y == 0 && z == 0 && l == 0) {
                    Toast.makeText(getApplicationContext(), "향이 선택되어야 합니다.", Toast.LENGTH_SHORT).show();
                } else {

                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                    builder.setTitle("배합하시겠습니까?");
                    AlertDialog.Builder 예 = builder.setPositiveButton("예", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            CLoading.showLoading(context);    //show
                            retrofit = new Retrofit.Builder()
                                    .baseUrl(ApiService.API_URL)
                                    .addConverterFactory(GsonConverterFactory.create()).build();
                            ApiService apiService = retrofit.create(ApiService.class);
                          //  Call<ResponseJson> comment = apiService.getComment(x);
                            final DataModel datamodel = new DataModel(x,y,z,l);

                            Call<ResponseJson> call = apiService.getComment(datamodel);

                            call.enqueue(new Callback<ResponseJson>() {
                                @Override
                                public void onResponse(Call<ResponseJson> call, Response<ResponseJson> response) {

                                    Log.d("Response", response.body().toString());
                                    ResponseJson responseJson= response.body();

                                    Log.v("ResponseJson",""+responseJson.getResponse_x()+responseJson
                                            .getResponse_y()+responseJson.getResponse_z()+responseJson.getResponse_l());

                                    Log.i("Response", response.toString());
                                    Toast.makeText(getApplicationContext(), "통신 성공", Toast.LENGTH_SHORT).show();

                                    button1.setText(String.valueOf(x = 0));
                                    button2.setText(String.valueOf(y = 0));
                                    button3.setText(String.valueOf(z = 0));
                                    button4.setText(String.valueOf(l = 0));
                                }

                                @Override
                                public void onFailure(Call<ResponseJson> call, Throwable t) {
                                    Log.v("Response","Fail");
                                    Toast.makeText(getApplicationContext(), "통신 실패", Toast.LENGTH_SHORT).show();
                                }
                            });

                            final Handler handler = new Handler();
                            handler.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    // 5초 뒤에 작동!! -> 5s = 5000ms
                                    CLoading.hideLoading();
                                }
                            }, 5000);



                        }
                    });

                        builder.setNegativeButton("아니오", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
                    AlertDialog dialog = builder.create();
                    dialog.show();
                }
            }
        });

        /*
        while(i<100000){
            Log.v("hi","0"+i);
            i++;
        }
        if ( i >= 90000) {
                    //hide
        }*/         //Loading bar



        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                button1.setText(String.valueOf(x = 0));
                button2.setText(String.valueOf(y = 0));
                button3.setText(String.valueOf(z = 0));
                button4.setText(String.valueOf(l = 0));

            }
        });
    }
}
