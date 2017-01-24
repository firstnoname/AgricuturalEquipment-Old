package se.is.agriculturalequipment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioGroup;

public class EstimateTM31 extends AppCompatActivity {

    private RadioGroup radioGroup1, radioGroup2,radioGroup3,radioGroup4,radioGroup5,radioGroup6,radioGroup7,radioGroup8,radioGroup9,radioGroup10, radioGroup11;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estimate_tm31);

        bindWidget();
    }

    private void bindWidget() {
        radioGroup1 = (RadioGroup) findViewById(R.id.no1);
        radioGroup2 = (RadioGroup) findViewById(R.id.no2);
        radioGroup3 = (RadioGroup) findViewById(R.id.no3);
        radioGroup4 = (RadioGroup) findViewById(R.id.no4);
        radioGroup5 = (RadioGroup) findViewById(R.id.no5);
        radioGroup6 = (RadioGroup) findViewById(R.id.no6);
        radioGroup7 = (RadioGroup) findViewById(R.id.no7);
        radioGroup8 = (RadioGroup) findViewById(R.id.no8);
        radioGroup9 = (RadioGroup) findViewById(R.id.no9);
        radioGroup10 = (RadioGroup) findViewById(R.id.no10);
        radioGroup11 = (RadioGroup) findViewById(R.id.no11);
    }
}
