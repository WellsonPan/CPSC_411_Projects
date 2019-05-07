package com.example.wells.miniapp1retry;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView mbps;
    TextView mib;
    TextView time;
    Button convert;
    int mbpsPrompt;
    int mibPrompt;
    NumberFormat formatter = new DecimalFormat("#0.0");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mbps = findViewById(R.id.editText);
        mib = findViewById(R.id.editText2);
        time = findViewById(R.id.textView4);

        convert = findViewById(R.id.button);
        convert.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (mbps.getText().toString() != "" && mib.getText().toString() != "") {
            mbpsPrompt = Integer.parseInt(mbps.getText().toString());
            mibPrompt = Integer.parseInt(mib.getText().toString());
            double mibConverted = (double) mibPrompt * 1.048576;
            double convertedTime = mibConverted / (double) mbpsPrompt;
            time.setText(formatter.format(convertedTime));
        }
    }
}
