package com.googleauth;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private EditText editText;
    private TextView tvString;
    private static final String TAG = "MainActivity";
    private String s ="null";
    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.et_value);
        tvString = findViewById(R.id.tv_string);
        tvString.setText("hello"+s);
        editText.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                final int DRAWABLE_LEFT = 0;
                final int DRAWABLE_TOP = 1;
                final int DRAWABLE_RIGHT = 2;
                final int DRAWABLE_BOTTOM = 3;
                if (event.getAction() == MotionEvent.ACTION_UP) {



               int drawableLeft=editText.getRight()-editText.getPaddingRight()-editText.getCompoundDrawables()[DRAWABLE_RIGHT].getBounds().width()-20;
               int drawableRight=editText.getRight()-editText.getPaddingRight()+20;
                 //   if (event.getRawX() >= (editText.getRight() - (editText.getCompoundDrawables()[DRAWABLE_RIGHT].getBounds().width())-editText.getPaddingRight())) {
                    if((event.getX()>=drawableLeft) && (event.getX()<=drawableRight))
                    {
                        Log.i(TAG,"Padding  "+editText.getPaddingRight());
                        Log.i(TAG,"X "+event.getRawX()+"  "+event.getX());
                        Log.i(TAG, "onTouch:1 "+editText.getRight());
                        Log.i(TAG, "onTouch:3 "+editText.getBottom()+" "+event.getRawY());
                        Log.i(TAG, "onTouch:2 "+editText.getCompoundDrawables()[DRAWABLE_RIGHT].getBounds().width());
                        Toast.makeText(MainActivity.this, "Play some right button ", Toast.LENGTH_SHORT).show();

                    }
                    else {
                        Toast.makeText(MainActivity.this, "aaaa", Toast.LENGTH_SHORT).show();
                    }
                 /*   if(event.getRawX()>=(editText.getLeft()-editText.getCompoundDrawables()[DRAWABLE_LEFT].getBounds().width())){
                        Toast.makeText(MainActivity.this, "play with left button ", Toast.LENGTH_SHORT).show();
                    }*/



                }
                return false;
            }
        });
    }
}
