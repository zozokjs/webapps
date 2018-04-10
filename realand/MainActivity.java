package com.example.it.database;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class MainActivity extends AppCompatActivity {

    Button btn_2;
    RecyclerView recyclerView;
    List items;

    List<ProductVO> data;

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {0
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        new Thread(new Runnable() {
            @Override
            public void run() {
                //HttpURLConnection con = ;
                // 연결
                //while문 in.readline();

            }
        }).start();


        btn_2 = findViewById(R.id.btn_2);

/*        MyThread t = new MyThread();
        t.execute(1);*/





                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        getData();

                        Log.i(TAG,"데이터를 가져와용");
                    }
                }).start();




        btn_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final Handler handler = new Handler()
                {
                    public void handleMessage(Message msg)
                    {   Log.i(TAG, "핸들러에용");
                        attachView();

                    }
                };


                new Thread(){
                    public void run() {
                        Message message = handler.obtainMessage();
                        handler.sendMessage(message);
                    }
                }.start();

            }
        });









    }//end of onCreate

    class MyThread extends AsyncTask<Integer, Integer, Integer>{

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(Integer integer) {
            super.onPostExecute(integer);
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            attachView();
        }

        @Override
        protected Integer doInBackground(Integer... integers) {

            getData();

            publishProgress();

            return null;
        }
    }



    public void attachView(){
        //(1) 리사이클뷰 객체 생성
        recyclerView = findViewById(R.id.recyclerView);

        items = new Vector();

        for(int i = 0; i < data.size(); i++) {
            ProductVO product = new ProductVO();
            product.setPname(data.get(i).getPname());
            product.setPjanre(data.get(i).getPjanre());
            items.add(product);
        }


        //(3) 어댑터 연결 (LayoutManager 설정)
        recyclerView.setAdapter(new MyAdapter(items, R.layout.view));
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setItemAnimator(new DefaultItemAnimator());

    }

    public void getData(){
        try {

            BufferedReader in;

            URL url = new URL("http://222.234.36.90:8007/controller/getData");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            int responseCode = con.getResponseCode();
            Log.i(TAG,responseCode+"");

            if(responseCode == 200){
                //바이트 단위 스트림이므로 인풋스트림리더-> 버퍼드리더
                //인풋스트림에 utf8 달려있음
                in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            }else{
                in = new BufferedReader(new InputStreamReader(con.getErrorStream()));
            }

            String inputData;
            StringBuffer res = new StringBuffer();
            int i = 0;
            while ((inputData = in.readLine()) != null){

                res.append(inputData);

                // AyncTask  호출!! inputData날려여!!

                i++;
                Log.i(TAG,"count :"+i);
            }
            in.close();;
            Log.i(TAG,res.toString());

            Gson gson = new Gson();

            data = gson.fromJson(res.toString(), new TypeToken<List<ProductVO>>(){}.getType());

           Log.i(TAG, "찍혔냐 : "+data.get(0).getMid().toString());

        }catch (Exception e){
            e.printStackTrace();
        }


    }

}