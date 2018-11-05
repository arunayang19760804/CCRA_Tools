package com.example.administrator.myapplication;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.dingmouren.colorpicker.ColorPickerDialog;
import com.dingmouren.colorpicker.ColorPlateView;
import com.dingmouren.colorpicker.OnColorPickerListener;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Color extends AppCompatActivity {
    public static final int TAKE_PHOTO=1;
    protected ImageView picture;
    private Uri imageUri;
    private boolean supportAlpha;//是否支持透明度
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color);
        Button takePhoto =(Button)findViewById(R.id.colorButt);
        picture=(ImageView) findViewById(R.id.mPicture);
        //创建拍照按钮的监听事件 -------------------------------------------------------
        takePhoto.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                File outputImage=new File(getExternalCacheDir(),"output_image.jpg");
                try{
                    if(outputImage.exists()){
                        outputImage.delete();
                    }
                    outputImage.createNewFile();
                }catch (IOException e){
                    e.printStackTrace();
                }
                if(Build.VERSION.SDK_INT>=24){
                    imageUri=FileProvider.getUriForFile(Color.this,"com.example.cameraalbumtest.fileprovider",outputImage);
                }else {
                    imageUri= Uri.fromFile(outputImage);
                }
                Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
                intent.putExtra(MediaStore.EXTRA_OUTPUT,imageUri);
                startActivityForResult(intent,TAKE_PHOTO);
            }
        });
        //创建对比按钮的监听事件
        Button colorButt=(Button)findViewById(R.id.colorButt1);
        colorButt.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                //ColorPickerDialog mColorPickerDialog = new ColorPickerDialog(
                //	MainActivity.this,
                //	getResources().getColor(R.color.colorPrimary),
                //	supportAlpha,
                //	mOnColorPickerListener
                //	).show();
                //ColorPickerDialog mColorPicker=new ColorPickerDialog(Color.this,
                        //getResources().getColor(R.color.colorPrimary),
                        //supportAlpha,mOnColorPickerListener).show();
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        switch (requestCode){
            case TAKE_PHOTO:
                if(resultCode == RESULT_OK){
                    try{
                        Bitmap bitmap = BitmapFactory.decodeStream(getContentResolver().openInputStream(imageUri));
                        picture.setImageBitmap(bitmap);
                    }catch (FileNotFoundException e){
                        e.printStackTrace();
                    }
                }
                break;
            default:
                break;
        }
    }
    private OnColorPickerListener mOnColorPickerListener = new OnColorPickerListener() {
        @Override
        public void onColorCancel(ColorPickerDialog dialog) {//取消选择的颜色
        }
        @Override
        public void onColorChange(ColorPickerDialog dialog, int color) {//实时监听颜色变化
        }
        @Override
        public void onColorConfirm(ColorPickerDialog dialog, int color) {//确定的颜色
        }
    };

}
