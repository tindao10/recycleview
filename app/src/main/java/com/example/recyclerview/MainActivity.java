package com.example.recyclerview;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText edtName;
    private EditText edtPhone;
    private EditText edtAge;
    private Switch cbxSex;
    private CheckBox cbxSport;
    private RadioGroup radGr;
    private RadioButton rad_btn;
    private Button btnRgister ;
    String radioValue;
    String checkValue;
    SeekBar seekBar;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtName = findViewById(R.id.edt_name);
        edtPhone = findViewById(R.id.edt_phone);
        seekBar = findViewById(R.id.seekBarAge);
        cbxSex = (Switch) findViewById(R.id.cbx_sex);
        cbxSport =(CheckBox) findViewById(R.id.cbx_sport);
        radGr = (RadioGroup) findViewById(R.id.rad_gr);
        btnRgister = (Button) findViewById(R.id.btn_register);

        btnRgister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerText();
            }
        });

        seekBar = findViewById(R.id.seekBarAge);
        textView = findViewById(R.id.textViewSeekBar);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean formUser) {
                textView.setText(progress + "/100");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }

    private void registerText() {
        String strName = edtName.getText().toString().trim();
        User.name = strName;
        String strPhone = edtPhone.getText().toString().trim();
        User.phone = strPhone;
        int strAge = seekBar.getProgress();
        User.age = Integer.toString(strAge);

        int checkRadioId = radGr.getCheckedRadioButtonId();
        rad_btn = (RadioButton) findViewById(checkRadioId);
        Toast.makeText(getApplicationContext(), rad_btn.getText(), Toast.LENGTH_SHORT).show();
        radioValue = String.valueOf(rad_btn.getText());
        User.level = radioValue;


        if(cbxSex.isChecked() == true) {
            checkValue = "Nam";
            User.sex = checkValue;
        } else {
            checkValue = "Nữ";
            User.sex = checkValue;
        }

        if(cbxSport.isChecked() == true) {
            checkValue = "Có chơi thể thao";
            User.sport = checkValue;
        } else {
            checkValue = "Không chơi thể thao";
            User.sport = checkValue;
        }

        Intent intent = new Intent(this,MainActivity2.class);
        startActivity(intent);

    }
}