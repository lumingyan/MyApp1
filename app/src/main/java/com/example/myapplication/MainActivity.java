package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {

    private EditText editText2;
    private EditText editText3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText2 = findViewById(R.id.editText2);
        editText3 = findViewById(R.id.editText3);
    }

    /*public void testgetRequest(View view) throws ExecutionException, InterruptedException {
        System.out.println(OkHttpUtil.getRequest("https://www.baidu.com"));
    }*/

    public void testpostRequest(View view) throws ExecutionException, InterruptedException {
        Map<String, String> map = new HashMap<>();
        map.put("username",editText2.getText().toString());
        map.put("userpass",editText3.getText().toString());
        String result = OkHttpUtil.postRequest(
                "http://172.18.85.254:8080/auction/api/users/login",map);
        if (result!=null&&result.equals("1")){
            Intent intent = new Intent(
                    this, IndexActivity.class);
            startActivity(intent);
        }else {
            Toast.makeText(this,"登录失败！",Toast.LENGTH_LONG).show();
        }
    }
}
