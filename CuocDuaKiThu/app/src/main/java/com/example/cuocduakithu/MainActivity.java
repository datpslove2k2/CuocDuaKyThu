package com.example.cuocduakithu;

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

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    TextView txtPoint;
    ImageButton btnPlayG;
    CheckBox cbOne, cbTwo, cbThree;
    SeekBar skOne, skTwo, skThree;
    int pontG = 199;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        anhXa();
        skOne.setEnabled(false);
        skTwo.setEnabled(false);
        skThree.setEnabled(false);
        txtPoint.setText(pontG + "");
        CountDownTimer countDownTimer = new CountDownTimer(60000, 300) {
            @Override
            public void onTick(long l) {
                int number = 4;
                Random rand = new Random();
                int one = rand.nextInt(number);
                int two = rand.nextInt(number);
                int three = rand.nextInt(number);

                // check win
                if (skOne.getProgress() >= skOne.getMax()) {
                    this.cancel();
                    btnPlayG.setVisibility(View.VISIBLE);
                    Toast.makeText(MainActivity.this, "Dragon One Win", Toast.LENGTH_SHORT).show();
                    // check đặt cược
                    if (cbOne.isChecked()){
                        pontG += 10;
                        Toast.makeText(MainActivity.this, "WIN + 10 Point", Toast.LENGTH_SHORT).show();
                    } else {
                        pontG -= 5;
                        Toast.makeText(MainActivity.this, "LOSS - 5 Point", Toast.LENGTH_SHORT).show();
                    }
                    txtPoint.setText(pontG + "");
                    EnableCheckBox();
                }
                if (skTwo.getProgress() >= skTwo.getMax()) {
                    this.cancel();
                    btnPlayG.setVisibility(View.VISIBLE);
                    Toast.makeText(MainActivity.this, "Dragon Two Win", Toast.LENGTH_SHORT).show();
                    // check đặt cược
                    if (cbTwo.isChecked()){
                        pontG += 10;
                        Toast.makeText(MainActivity.this, "WIN + 10 Point", Toast.LENGTH_SHORT).show();
                    } else {
                        pontG -= 5;
                        Toast.makeText(MainActivity.this, "LOSS - 5 Point", Toast.LENGTH_SHORT).show();
                    }
                    txtPoint.setText(pontG + "");
                    EnableCheckBox();
                }
                if (skThree.getProgress() >= skThree.getMax()) {
                    this.cancel();
                    btnPlayG.setVisibility(View.VISIBLE);
                    Toast.makeText(MainActivity.this, "Dragon Three Win", Toast.LENGTH_SHORT).show();
                    // check đặt cược
                    if (cbThree.isChecked()){
                        pontG += 10;
                        Toast.makeText(MainActivity.this, "WIN + 10 Point", Toast.LENGTH_SHORT).show();
                    } else {
                        pontG -= 5;
                        Toast.makeText(MainActivity.this, "LOSS - 5 Point", Toast.LENGTH_SHORT).show();
                    }
                    txtPoint.setText(pontG + "");
                    EnableCheckBox();
                }

                skOne.setProgress(skOne.getProgress() + one);
                skTwo.setProgress(skTwo.getProgress() + two);
                skThree.setProgress(skThree.getProgress() + three);

            }

            @Override
            public void onFinish() {

            }
        };
        // Button

        btnPlayG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (cbOne.isChecked() || cbTwo.isChecked() || cbThree.isChecked()) {
                    skOne.setProgress(0);
                    skTwo.setProgress(0);
                    skThree.setProgress(0);
                    btnPlayG.setVisibility(View.INVISIBLE); // ẩn button
                    countDownTimer.start();
                    DisEnableCheckBox();
                } else {
                    Toast.makeText(MainActivity.this, "Vui lòng đặt cược trước khi đua!!", Toast.LENGTH_SHORT).show();
                }

            }
        });
        cbOne.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    // bỎ check 2,3
                    cbTwo.setChecked(false);
                    cbThree.setChecked(false);
                }
            }
        });
        cbTwo.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    // bỎ check 2,3
                    cbOne.setChecked(false);
                    cbThree.setChecked(false);
                }
            }
        });
        cbThree.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    // bỎ check 2,3
                    cbOne.setChecked(false);
                    cbTwo.setChecked(false);
                }
            }
        });
    }
    private void EnableCheckBox () {
        cbOne.setEnabled(true);
        cbTwo.setEnabled(true);
        cbThree.setEnabled(true);
    }

    private void DisEnableCheckBox () {
        cbOne.setEnabled(false);
        cbTwo.setEnabled(false);
        cbThree.setEnabled(false);
    }
    private void anhXa() {
        txtPoint = (TextView) findViewById(R.id.point);
        btnPlayG = (ImageButton) findViewById(R.id.btnPlay);
        cbOne = (CheckBox) findViewById(R.id.checkboxOne);
        cbTwo = (CheckBox) findViewById(R.id.checkboxTwo);
        cbThree = (CheckBox) findViewById(R.id.checkboxThree);
        skOne = (SeekBar) findViewById(R.id.seekbarOne);
        skTwo = (SeekBar) findViewById(R.id.seekbarTwo);
        skThree = (SeekBar) findViewById(R.id.seekbarThree);
    }

}