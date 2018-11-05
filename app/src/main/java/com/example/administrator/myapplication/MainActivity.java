package com.example.administrator.myapplication;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewDebug;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Chronometer;

import org.litepal.LitePal;
import org.litepal.LitePalApplication;
import org.litepal.LitePalBase;
import org.litepal.LitePalDB;
import org.litepal.crud.LitePalSupport;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    private TextView textView;
    private Timer mTimer;
    private CharSequence yellowTime;
    private CharSequence brownTime;
    private CharSequence bowbTime;
    private CharSequence downTime;
    private String mRemarks;
    private int tmpTime;
    //private  Handler mHandler;
    private Chronometer mChronometer;


    //final TextView text1=(TextView) findViewById(R.id.text1) ;
    //定义一个textview实例，为textview1赋值
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button startButton=(Button)findViewById(R.id.startButton);//开始计时
        Button stopButton=(Button)findViewById(R.id.stopButton);//保存
        Button yellowButton=(Button)findViewById(R.id.yellowButt) ;//黄点
        Button brownButton=(Button)findViewById(R.id.brownButt);//褐点
        Button bowbButton=(Button)findViewById(R.id.bombButt);//入爆点
        Button downButton=(Button)findViewById(R.id.downbButt);//下豆
        mChronometer=(Chronometer)findViewById(R.id.chronometer1);//时钟
        startButton.setOnClickListener(new View.OnClickListener(){
            @Deprecated
            public void onClick(View v){
                LitePal.getDatabase();
                textView=(TextView) findViewById(R.id.text1);
                mChronometer.setBase(SystemClock.elapsedRealtime());
                mChronometer.start();
            }
        });
        stopButton.setOnClickListener(new  View.OnClickListener(){
            @Override
            public void onClick(View v){
                CCRA_Tools_Timer mDatabase=new CCRA_Tools_Timer();
                //tmpTime=Integer.decode(""+yellowTime);

                final EditText edittext1=(EditText)findViewById(R.id.editText);
                mRemarks=edittext1.getText().toString();
                mDatabase.setTime1(""+yellowTime);
                mDatabase.setTime2(""+brownTime);
                mDatabase.setTime3(""+bowbTime);
                mDatabase.setTime4(""+downTime);
                mDatabase.setRemarks(""+mRemarks);;
                mDatabase.save();
                //finish();
            }
        });
        yellowButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                final TextView text1=(TextView) findViewById(R.id.text1) ;
                yellowTime =mChronometer.getText();
                text1.setText(yellowTime);
            }
        });
        brownButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                final TextView text3=(TextView) findViewById(R.id.text3) ;
                brownTime=mChronometer.getText();
                text3.setText(brownTime);
            }
        });
        bowbButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                final TextView text4=(TextView) findViewById(R.id.text4) ;
                //textView.setText(mChronometer.getText());
                bowbTime=mChronometer.getText();
                text4.setText(bowbTime);
            }
        });
        downButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                final TextView text5=(TextView) findViewById(R.id.text5) ;
                //textView.setText(mChronometer.getText());
                downTime=mChronometer.getText();
                text5.setText(downTime);
                mChronometer.stop();
            }
        });
    }
}
