package se.is.agriculturalequipment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class EstimateGX160 extends AppCompatActivity {

    private RadioGroup radioGroup1, radioGroup2,radioGroup3,radioGroup4,radioGroup5,radioGroup6,radioGroup7,radioGroup8,radioGroup9,radioGroup10, radioGroup11;
    private RadioButton rdgEngineTrue, rdgEngineFalse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edtimate_gx160);

        bindWidget();

        hideRadioGroup();

        rdgEngineTrue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rdgEngineFalse.setChecked(false);
                radioGroup1.setVisibility(View.VISIBLE);
                radioGroup2.setVisibility(View.VISIBLE);
                radioGroup3.setVisibility(View.VISIBLE);
                radioGroup4.setVisibility(View.VISIBLE);
                radioGroup5.setVisibility(View.VISIBLE);
                radioGroup6.setVisibility(View.VISIBLE);
                radioGroup7.setVisibility(View.VISIBLE);
                radioGroup8.setVisibility(View.VISIBLE);
                radioGroup9.setVisibility(View.VISIBLE);
                radioGroup10.setVisibility(View.VISIBLE);
                radioGroup11.setVisibility(View.VISIBLE);
            }
        });

        rdgEngineFalse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rdgEngineTrue.setChecked(false);
                radioGroup1.setVisibility(View.VISIBLE);
                radioGroup2.setVisibility(View.VISIBLE);
                radioGroup3.setVisibility(View.VISIBLE);
                radioGroup4.setVisibility(View.GONE);
                radioGroup5.setVisibility(View.VISIBLE);
                radioGroup6.setVisibility(View.VISIBLE);
                radioGroup7.setVisibility(View.GONE);
                radioGroup8.setVisibility(View.GONE);
                radioGroup9.setVisibility(View.GONE);
                radioGroup10.setVisibility(View.VISIBLE);
                radioGroup11.setVisibility(View.VISIBLE);
            }
        });
    }

    private void hideRadioGroup() {
        radioGroup1.setVisibility(View.GONE);
        radioGroup2.setVisibility(View.GONE);
        radioGroup3.setVisibility(View.GONE);
        radioGroup4.setVisibility(View.GONE);
        radioGroup5.setVisibility(View.GONE);
        radioGroup6.setVisibility(View.GONE);
        radioGroup7.setVisibility(View.GONE);
        radioGroup8.setVisibility(View.GONE);
        radioGroup9.setVisibility(View.GONE);
        radioGroup10.setVisibility(View.GONE);
        radioGroup11.setVisibility(View.GONE);
    }

    private void bindWidget() {
        rdgEngineFalse = (RadioButton) findViewById(R.id.radioBtnEngineFalse);
        rdgEngineTrue = (RadioButton) findViewById(R.id.radioBtnEngineTrue);

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
