package com.example.baitap_tuan3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    TextView tvDiem;
    int sodiem = 100;
    CheckBox checkBox1,checkBox2,checkBox3;
    SeekBar seekBar1,seekBar2,seekBar3;
    ImageButton button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Anhxa();
        seekBar1.setEnabled(false);
        seekBar2.setEnabled(false);
        seekBar3.setEnabled(false);
        tvDiem.setText(sodiem + "");
        CountDownTimer countDownTimer=new CountDownTimer(60000,300) {
            @Override
            public void onTick(long l) {
                int number = 7;
                Random random=new Random();
                int a = random.nextInt(number);
                int b = random.nextInt(number);
                int c = random.nextInt(number);
                if (seekBar1.getProgress() >= seekBar1.getMax()){
                    this.cancel();
                    button.setVisibility(View.VISIBLE);
                    Toast.makeText(MainActivity.this, "One Win", Toast.LENGTH_SHORT).show();
                    if (checkBox1.isChecked()){
                        sodiem += 10;
                        Toast.makeText(MainActivity.this, "Bại Đoán Chính Xác", Toast.LENGTH_SHORT).show();
                    }else {
                        sodiem -= 5;
                        Toast.makeText(MainActivity.this, "Bạn Đoán Sai Rồi", Toast.LENGTH_SHORT).show();
                    }
                    tvDiem.setText(sodiem+"");
                    EnableCheckBox();
                }
                if (seekBar2.getProgress() >= seekBar2.getMax()){
                    this.cancel();
                    button.setVisibility(View.VISIBLE);
                    Toast.makeText(MainActivity.this, "Two Win", Toast.LENGTH_SHORT).show();
                    if (checkBox2.isChecked()){
                        sodiem += 10;
                        Toast.makeText(MainActivity.this, "Bại Đoán Chính Xác", Toast.LENGTH_SHORT).show();
                    }else {
                        sodiem -= 5;
                        Toast.makeText(MainActivity.this, "Bạn Đoán Sai Rồi", Toast.LENGTH_SHORT).show();
                    }
                    tvDiem.setText(sodiem+"");
                    EnableCheckBox();
                }
                if (seekBar3.getProgress() >= seekBar3.getMax()){
                    this.cancel();
                    button.setVisibility(View.VISIBLE);
                    Toast.makeText(MainActivity.this, "Three Win", Toast.LENGTH_SHORT).show();
                    if (checkBox3.isChecked()){
                        sodiem+=10;
                        Toast.makeText(MainActivity.this, "Bại Đoán Chính Xác", Toast.LENGTH_SHORT).show();
                    }else {
                        sodiem-=5;

                        Toast.makeText(MainActivity.this, "Bạn Đoán Sai Rồi", Toast.LENGTH_SHORT).show();
                    }
                    tvDiem.setText(sodiem+"");
                    EnableCheckBox();
                }
                seekBar1.setProgress(seekBar1.getProgress()+a);
                seekBar2.setProgress(seekBar2.getProgress()+b);
                seekBar3.setProgress(seekBar3.getProgress()+c);
            }

            @Override
            public void onFinish() {

            }
        };
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (checkBox1.isChecked()||checkBox2.isChecked()||checkBox3.isChecked()){
                seekBar1.setProgress(0);
                seekBar2.setProgress(0);
                seekBar3.setProgress(0);
                button.setVisibility(View.INVISIBLE);
                countDownTimer .start();
                DisableCheckBoc();
            }else {
                    Toast.makeText(MainActivity.this, "VUI LONG DAT CUOC", Toast.LENGTH_SHORT).show();
                }
            }

        });
        checkBox1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b){
                    checkBox2.setChecked(false);
                    checkBox3.setChecked(false);
                }
            }
        });
        checkBox2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b){
                    checkBox1.setChecked(false);
                    checkBox3.setChecked(false);
                }
            }
        });
        checkBox3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b){
                    checkBox2.setChecked(false);
                    checkBox1.setChecked(false);
                }
            }
        });
    }
    private void EnableCheckBox(){
        checkBox1.setEnabled(true);
        checkBox2.setEnabled(true);
        checkBox3.setEnabled(true);

    }
    private void DisableCheckBoc(){
        checkBox1.setEnabled(false);
        checkBox2.setEnabled(false);
        checkBox3.setEnabled(false);
    }
    private void Anhxa(){
        tvDiem=(TextView) findViewById(R.id.textviewDiem);
        button=(ImageButton) findViewById(R.id.buttonplay);
        checkBox1=(CheckBox) findViewById(R.id.checkbox1);
        checkBox2=(CheckBox) findViewById(R.id.checkbox2);
        checkBox3=(CheckBox) findViewById(R.id.checkbox3);
        seekBar1=(SeekBar) findViewById(R.id.search_badge1);
        seekBar2=(SeekBar) findViewById(R.id.search_badge2);
        seekBar3=(SeekBar) findViewById(R.id.search_badge3);
    }
}