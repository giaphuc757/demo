package com.hothithuhop.demo;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {
    String[] language ={"C", "C++", "Java",".NET","iPhone",
            "Android", "ASP.NET", "PHP"};
    private Button btn_tuychon, btn_goiy, lview;
    private RadioButton rb_2,rb_3;
    private RadioGroup rb_g;
    private TextView result2, color;
    private SwitchCompat Scompat;
    private ToggleButton toggleButton;
    private AutoCompleteTextView autoCompleteTextView1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>
                (this,android.R.layout.select_dialog_item,language);
        AutoCompleteTextView actv=

                (AutoCompleteTextView)findViewById(R.id.autoCompleteTextView1);

        actv.setThreshold(1); // hỗ trợ khi gõ 1 ký tự
        actv.setAdapter(adapter); //Phương thức này trả về một Listadapter có thể lọc được được sử dụng cho Autocomplete
        actv.setTextColor(Color.RED);



        anhxa();

        ControlButton();

        Scompat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    if (Scompat.isChecked())
                    {
                        color.setBackgroundColor(Color.GREEN);
                    }
                    else {
                        color.setBackgroundColor(Color.RED);
                    }
            }
        });

        toggleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (toggleButton.isChecked())
                {

                    color.setBackgroundColor(Color.YELLOW);
                }
                else {
                    color.setBackgroundColor(Color.BLUE);
                }
            }
        });

        btn_goiy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (rb_2.isChecked())
                {
                    btn_goiy.setText("đúng rồi");
                    result2.setTextColor(Color.RED);
                }
                else
                {
                    btn_goiy.setText("1 + 1 = 2 nha :V");
                    result2.setTextColor(Color.RED);
                }
            }
        });

        //Chuyen Activity List view
        lview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, ListviewActivity.class));
            }
        });

    }
    private void ControlButton() {
        btn_tuychon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this, android.R.style.Theme_DeviceDefault_Dialog_Alert);
                builder.setTitle("Tùy chọn!!!");
                builder.setMessage("hãy lựa chọn để xác nhận");
                builder.setIcon(android.R.drawable.ic_dialog_alert);
                builder.setPositiveButton("thoát", new DialogInterface.OnClickListener() //Đồng ý thoát app
                {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        onBackPressed();
                    }
                });
                builder.setNegativeButton(" Reset", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        btn_goiy.setText("");
                        rb_g.clearCheck();
                        autoCompleteTextView1.setText("");
                        color.setBackgroundColor(Color.GRAY);
                        btn_goiy.setText("summit");
                        result2.setTextColor(Color.BLACK);
                        Toast.makeText(MainActivity.this, "Đã reset", Toast.LENGTH_SHORT).show();

                    }//không xét gì thì nghĩa là nó ở lại trang và xét thì sẽ thực hiện bt
                });
                builder.show();
            }
        });
    }
    private void anhxa()
    {
        btn_tuychon=(Button )findViewById(R.id.btn_tuychon);
        btn_goiy=(Button)findViewById(R.id. btn_goiy);
        rb_2=(RadioButton) findViewById(R.id.rb_2);
        rb_3=(RadioButton) findViewById(R.id.rb_3);
        lview = (Button) findViewById(R.id.lview);
        autoCompleteTextView1 =findViewById(R.id.autoCompleteTextView1);
        result2 =findViewById(R.id.result2);
        color =findViewById(R.id.color);
        toggleButton =findViewById(R.id.toggleButton);
        Scompat =findViewById(R.id.Scompat);
        rb_g =findViewById(R.id.rb_g);
    }
}
