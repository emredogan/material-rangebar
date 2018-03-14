package com.emredogan.sliders;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatSeekBar;
import android.widget.SeekBar;
import android.widget.TextView;

import com.appyvet.materialrangebar.RangeBar;

public class MainActivity extends AppCompatActivity {

    AppCompatSeekBar appCompatSeekBar;
    TextView value;
    RangeBar rangeBar1;
    RangeBar rangebar2;
    TextView rangeBar1value;
    TextView rangeBar2leftvalue;
    TextView rangeBar2rightvalue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        appCompatSeekBar = (AppCompatSeekBar) findViewById(R.id.seekbar_id);
        value = (TextView) findViewById(R.id.value);
        rangeBar1 = (RangeBar) findViewById(R.id.rangeBar1_id);
        rangebar2 = (RangeBar) findViewById(R.id.rangebar2);
        rangeBar2leftvalue = (TextView) findViewById(R.id.rangebar2_leftvalue);
        rangeBar2rightvalue = (TextView) findViewById(R.id.rangebar2_rightvalue);

        rangeBar1value = (TextView) findViewById(R.id.rangebar1_value);

        appCompatSeekBar.setProgress(0);

        appCompatSeekBar.setKeyProgressIncrement(1);

        appCompatSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

                System.out.println(i);

                value.setText(Integer.toString(i));



            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

                System.out.println("OnStartTrackingTouch");

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

                System.out.println("OnStopTrackingTouch");

            }
        });



        rangeBar1.setSeekPinByIndex(0);
        rangeBar1.setPinTextColor(getResources().getColor(R.color.colorRangeBarText));
        rangeBar1.setSelectorColor(getResources().getColor(R.color.colorAccent));
        rangeBar1.setTickColor(getResources().getColor(R.color.colorAccent));
        rangeBar1.setBarColor(getResources().getColor(R.color.colorAccent));
        rangeBar1.setPinColor(getResources().getColor(R.color.colorAccent));

        rangeBar1.setOnRangeBarChangeListener(new RangeBar.OnRangeBarChangeListener() {
            @Override
            public void onRangeChangeListener(RangeBar rangeBar, int leftPinIndex, int rightPinIndex, String leftPinValue, String rightPinValue) {
                System.out.println(rightPinValue);

                rangeBar1value.setText(rightPinValue);


            }
        });

        rangebar2.setTickStart(10);
        rangebar2.setTickEnd(20);



        rangebar2.setOnRangeBarChangeListener(new RangeBar.OnRangeBarChangeListener() {
            @Override
            public void onRangeChangeListener(RangeBar rangeBar, int leftPinIndex, int rightPinIndex, String leftPinValue, String rightPinValue) {
                rangeBar2leftvalue.setText(leftPinValue);
                rangeBar2rightvalue.setText(rightPinValue);
            }
        });

    }
}
