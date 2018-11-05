package com.example.administrator.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toolbar;
//import android.widget.Toolbar;

public class TimerList extends AppCompatActivity {
    //创建菜单按钮

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }
    //添加菜单按钮功能

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.add_Itme:
                Intent intent1=new Intent(TimerList.this,MainActivity.class);
                startActivity(intent1);
                break;
            case R.id.remove_Item:
                Intent intent2=new Intent(TimerList.this,Color.class);
                startActivity(intent2);
                break;
            case R.id.exit_Item:
                finish();
                default:
        }
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer_list);
        android.support.v7.widget.Toolbar toolbar=(android.support.v7.widget.Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

    }
}
