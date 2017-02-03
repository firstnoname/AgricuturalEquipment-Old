package se.is.agriculturalequipment;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class EstimateG200 extends AppCompatActivity {

    private RadioGroup radioGroup1, radioGroup2,radioGroup3,radioGroup4,radioGroup5,radioGroup6,
            radioGroup7,radioGroup8,radioGroup9,radioGroup10, radioGroup11;
    private RadioButton rdgEngineTrue, rdgEngineFalse, radioBtn1_1, radioBtn1_2, radioBtn2_1,
            radioBtn2_2, radioBtn3_1, radioBtn3_2, radioBtn4_1, radioBtn4_2, radioBtn4_3,
            radioBtn4_4, radioBtn5_1, radioBtn5_2, radioBtn6_1, radioBtn6_2, radioBtn7_1,
            radioBtn7_2, radioBtn8_1, radioBtn8_2, radioBtn9_1, radioBtn9_2, radioBtn10_1,
            radioBtn10_2,radioBtn10_3, radioBtn11_1, radioBtn11_2;
    private LinearLayout linearNavi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estimate_g200);

        bindWidget();

        hideRadioGroup();

        rdgEngineTrue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
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
                linearNavi.setVisibility(View.VISIBLE);

                setDefaultSelect();
            }
        });

        rdgEngineFalse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
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
                linearNavi.setVisibility(View.VISIBLE);

                setDefaultSelect();
            }
        });
    }

    public void intentSubmitEstimateG200(View view){
        //Get value from radio button.
        

        Intent intentSubmitEstimateG200 = new Intent(this, SubmitEstimateG200.class);
        startActivity(intentSubmitEstimateG200);
    }

    private void setDefaultSelect() {
        radioBtn1_1.setChecked(true);
        radioBtn2_1.setChecked(true);
        radioBtn3_1.setChecked(true);
        radioBtn4_1.setChecked(true);
        radioBtn5_1.setChecked(true);
        radioBtn6_1.setChecked(true);
        radioBtn7_1.setChecked(true);
        radioBtn8_1.setChecked(true);
        radioBtn9_1.setChecked(true);
        radioBtn10_1.setChecked(true);
        radioBtn11_1.setChecked(true);
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
        linearNavi.setVisibility(View.GONE);
    }

    private void bindWidget() {
        rdgEngineFalse = (RadioButton) findViewById(R.id.radioBtnEngineFalse);
        rdgEngineTrue = (RadioButton) findViewById(R.id.radioBtnEngineTrue);
        radioBtn1_1 = (RadioButton) findViewById(R.id.radioBtn1_1);
        radioBtn1_2 = (RadioButton) findViewById(R.id.radioBtn1_2);
        radioBtn2_1 = (RadioButton) findViewById(R.id.radioBtn2_1);
        radioBtn2_2 = (RadioButton) findViewById(R.id.radioBtn2_2);
        radioBtn3_1 = (RadioButton) findViewById(R.id.radioBtn3_1);
        radioBtn3_2 = (RadioButton) findViewById(R.id.radioBtn3_2);
        radioBtn4_1 = (RadioButton) findViewById(R.id.radioBtn4_1);
        radioBtn4_2 = (RadioButton) findViewById(R.id.radioBtn4_2);
        radioBtn4_3 = (RadioButton) findViewById(R.id.radioBtn4_3);
        radioBtn4_4 = (RadioButton) findViewById(R.id.radioBtn4_4);
        radioBtn5_1 = (RadioButton) findViewById(R.id.radioBtn5_1);
        radioBtn5_2 = (RadioButton) findViewById(R.id.radioBtn5_2);
        radioBtn6_1 = (RadioButton) findViewById(R.id.radioBtn6_1);
        radioBtn6_2 = (RadioButton) findViewById(R.id.radioBtn6_2);
        radioBtn7_1 = (RadioButton) findViewById(R.id.radioBtn7_1);
        radioBtn7_2 = (RadioButton) findViewById(R.id.radioBtn7_2);
        radioBtn8_1 = (RadioButton) findViewById(R.id.radioBtn8_1);
        radioBtn8_2 = (RadioButton) findViewById(R.id.radioBtn8_2);
        radioBtn9_1 = (RadioButton) findViewById(R.id.radioBtn9_1);
        radioBtn9_2 = (RadioButton) findViewById(R.id.radioBtn9_2);
        radioBtn10_1 = (RadioButton) findViewById(R.id.radioBtn10_1);
        radioBtn10_2 = (RadioButton) findViewById(R.id.radioBtn10_2);
        radioBtn10_3 = (RadioButton) findViewById(R.id.radioBtn10_3);
        radioBtn11_1 = (RadioButton) findViewById(R.id.radioBtn11_1);
        radioBtn11_2 = (RadioButton) findViewById(R.id.radioBtn11_2);

        linearNavi = (LinearLayout) findViewById(R.id.layoutNavigation);

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
