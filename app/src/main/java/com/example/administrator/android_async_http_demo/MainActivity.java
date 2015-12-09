package com.example.administrator.android_async_http_demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestHandle;
import com.loopj.android.http.RequestParams;

import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.client.utils.HttpClientUtils;

public class MainActivity extends AppCompatActivity {
    private final String TAG = "MainActivity";
    private final String URL = "http://apis.juhe.cn/goodbook/catalog?key=81400dd58b3af6da3729f9376a63fb69&dtype=json";
    private final String URL_POST = "http://apis.juhe.cn/cook/query?key=dd63cca81dbbc59deaf7b7f6be0383e2&menu=%E8%A5%BF%E7%BA%A2%E6%9F%BF&rn=10&pn=3";
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.text);
//        getHttp();
        postHttp();
    }

    private void postHttp() {
        RequestParams params = new RequestParams();
//        params.add("clientData", "您好服务器端的post方法！！！");
        new AsyncHttpClient().post(URL_POST, params, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                Log.i(TAG, statusCode + ":" + new String(responseBody));
                textView.setText(new String(responseBody));
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                Log.i(TAG, "请求失败！");
            }
        });
    }

    private void getHttp() {
        RequestParams params = new RequestParams();
//        params.add("clientData", "您好服务器端的get方法！！！");
        params.setContentEncoding("UTF-8");
        new AsyncHttpClient().get(URL, params, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                Log.i(TAG, statusCode + ":" + new String(responseBody));
                textView.setText(new String(responseBody));
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                Log.i(TAG, "请求失败！");
            }
        });
    }

}
