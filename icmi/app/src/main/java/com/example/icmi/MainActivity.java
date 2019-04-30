package com.example.icmi;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{


    /**
     *  解析JSON格式文件的步骤：
     *  1.发送解析请求
     *  2.解析
     *
     *  工具包：GSON，依赖库为：OkHttp
     *
     */




    //接口方法
    public void onClick(View v){
        switch (v.getId()){
            case R.id.getJsonData:
                //点击以后执行解析操作
                sendRequestWithOkHttp();
                break;
                default:
                    break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.index);
        Button b = (Button)findViewById(R.id.getJsonData);
        b.setOnClickListener(this);

    }

    //发送请求到服务器获取到json数据
    private void sendRequestWithOkHttp(){
        //线程编程
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    //发送请求--替换成本地解析
                    String js = "[{\n" +
                            "\t'id': 1,\n" +
                            "\t'name': '北京'\n" +
                            "}, {\n" +
                            "\t'id': 2,\n" +
                            "\t'name': '上海'\n" +
                            "}, {\n" +
                            "\t'id': 3,\n" +
                            "\t'name': '天津'\n" +
                            "}, {\n" +
                            "\t'id': 4,\n" +
                            "\t'name': '重庆'\n" +
                            "}, {\n" +
                            "\t'id': 5,\n" +
                            "\t'name': '香港'\n" +
                            "}, {\n" +
                            "\t'id': 6,\n" +
                            "\t'name': '澳门'\n" +
                            "}, {\n" +
                            "\t'id': 7,\n" +
                            "\t'name': '台湾'\n" +
                            "}, {\n" +
                            "\t'id': 8,\n" +
                            "\t'name': '黑龙江'\n" +
                            "}, {\n" +
                            "\t'id': 9,\n" +
                            "\t'name': '吉林'\n" +
                            "}, {\n" +
                            "\t'id': 10,\n" +
                            "\t'name': '辽宁'\n" +
                            "}, {\n" +
                            "\t'id': 11,\n" +
                            "\t'name': '内蒙古'\n" +
                            "}, {\n" +
                            "\t'id': 12,\n" +
                            "\t'name': '河北'\n" +
                            "}, {\n" +
                            "\t'id': 13,\n" +
                            "\t'name': '河南'\n" +
                            "}, {\n" +
                            "\t'id': 14,\n" +
                            "\t'name': '山西'\n" +
                            "}, {\n" +
                            "\t'id': 15,\n" +
                            "\t'name': '山东'\n" +
                            "}, {\n" +
                            "\t'id': 16,\n" +
                            "\t'name': '江苏'\n" +
                            "}, {\n" +
                            "\t'id': 17,\n" +
                            "\t'name': '浙江'\n" +
                            "}, {\n" +
                            "\t'id': 18,\n" +
                            "\t'name': '福建'\n" +
                            "}, {\n" +
                            "\t'id': 19,\n" +
                            "\t'name': '江西'\n" +
                            "}, {\n" +
                            "\t'id': 20,\n" +
                            "\t'name': '安徽'\n" +
                            "}, {\n" +
                            "\t'id': 21,\n" +
                            "\t'name': '湖北'\n" +
                            "}, {\n" +
                            "\t'id': 22,\n" +
                            "\t'name': '湖南'\n" +
                            "}, {\n" +
                            "\t'id': 23,\n" +
                            "\t'name': '广东'\n" +
                            "}, {\n" +
                            "\t'id': 24,\n" +
                            "\t'name': '广西'\n" +
                            "}, {\n" +
                            "\t'id': 25,\n" +
                            "\t'name': '海南'\n" +
                            "}, {\n" +
                            "\t'id': 26,\n" +
                            "\t'name': '贵州'\n" +
                            "}, {\n" +
                            "\t'id': 27,\n" +
                            "\t'name': '云南'\n" +
                            "}, {\n" +
                            "\t'id': 28,\n" +
                            "\t'name': '四川'\n" +
                            "}, {\n" +
                            "\t'id': 29,\n" +
                            "\t'name': '西藏'\n" +
                            "}, {\n" +
                            "\t'id': 30,\n" +
                            "\t'name': '陕西'\n" +
                            "}, {\n" +
                            "\t'id': 31,\n" +
                            "\t'name': '宁夏'\n" +
                            "}, {\n" +
                            "\t'id': 32,\n" +
                            "\t'name': '甘肃'\n" +
                            "}, {\n" +
                            "\t'id': 33,\n" +
                            "\t'name': '青海'\n" +
                            "}, {\n" +
                            "\t'id': 34,\n" +
                            "\t'name': '新疆'\n" +
                            "}]";
                    parseJsonWhitGSON(js);

                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });

        //启动线程
        t.start();
    }
    //解析
    private void parseJsonWhitGSON(String jsonData){
        Gson gson = new Gson();
        List<JsonDataEnity> appList = (List<JsonDataEnity>) gson.fromJson(jsonData,new TypeToken<List<JsonDataEnity>>(){}.getType());
        for (JsonDataEnity a : appList){
            //Toast.makeText(MainActivity.this,"id:" + a.getId() + ",name:" + a.getName() + "\n",Toast.LENGTH_LONG).show();
            Log.d("*","id = " + a.getId() + ",name = " + a.getName());
        }
    }



}
