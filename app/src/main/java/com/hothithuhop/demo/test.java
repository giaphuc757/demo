package com.hothithuhop.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class test extends AppCompatActivity {
    private RadioButton check1,check2,check3;
    private RadioGroup gcheck;
    private TextView txtview;
    private Button setcolor, clear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        check1 =findViewById(R.id.check1);
        gcheck =findViewById(R.id.gcheck);
        check2 =findViewById(R.id.check2);
        check3 =findViewById(R.id.check3);
        txtview =findViewById(R.id.txtview);
        setcolor =findViewById(R.id.setcolor);
        clear =findViewById(R.id.clear);


        setcolor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (check1.isChecked())
                {
                    txtview.setBackgroundColor(Color.RED);
                }
                if (check2.isChecked())
                {
                    txtview.setBackgroundColor(Color.BLUE);
                }
                if (check3.isChecked())
                {
                    txtview.setBackgroundColor(Color.WHITE);
                }
            }
        });

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtview.setBackgroundColor(Color.BLACK);
            }
        });
    }

}