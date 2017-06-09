package se.is.agriculturalequipment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class EstimateGX35 extends AppCompatActivity {

    private RadioGroup rdgCheckEngine, rdg1, rdg2, rdg3, rdg4, rdg5, rdg6, rdg7, rdg8, rdg9, rdg10,
            rdg11, rdg12;
    private RadioButton rdbEngineTrue, rdbEngineFalse, rdb1_1,rdb1_2, rdb2_1,rdb2_2,rdb3_1,rdb3_2,
            rdb3_3,rdb3_4,rdb4_1,rdb4_2,rdb5_1,rdb5_2,rdb6_1,rdb6_2,rdb6_3,rdb7_1,rdb7_2,rdb8_1,
            rdb8_2,rdb8_3,rdb9_1,rdb9_2,rdb10_1,rdb10_2,rdb11_1,rdb11_2,rdb12_1,rdb12_2,rdb12_3;
    private LinearLayout layoutButtonGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estimate_gx35);

        bindWidget();

        hideRadioGroup();

        onClickListener();

    }

    private void onClickListener() {
        rdbEngineTrue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rdbEngineFalse.setChecked(false);
                rdg1.setVisibility(View.VISIBLE);
                rdg2.setVisibility(View.VISIBLE);
                rdg3.setVisibility(View.VISIBLE);
                rdg4.setVisibility(View.VISIBLE);
                rdg5.setVisibility(View.VISIBLE);
                rdg6.setVisibility(View.VISIBLE);
                rdg7.setVisibility(View.VISIBLE);
                rdg8.setVisibility(View.VISIBLE);
                rdg9.setVisibility(View.VISIBLE);
                rdg10.setVisibility(View.VISIBLE);
                rdg11.setVisibility(View.VISIBLE);
                rdg12.setVisibility(View.VISIBLE);

                layoutButtonGroup.setVisibility(View.VISIBLE);

                setDefaultSelect(0);

            }
        });

        rdbEngineFalse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rdbEngineTrue.setChecked(false);
                rdg1.setVisibility(View.VISIBLE);
                rdg2.setVisibility(View.VISIBLE);
                rdg3.setVisibility(View.VISIBLE);
                rdg4.setVisibility(View.VISIBLE);
                rdg5.setVisibility(View.VISIBLE);
                rdg6.setVisibility(View.VISIBLE);
                rdg7.setVisibility(View.VISIBLE);
                rdg8.setVisibility(View.VISIBLE);
                rdg9.setVisibility(View.VISIBLE);
                rdg10.setVisibility(View.GONE);
                rdg11.setVisibility(View.VISIBLE);
                rdg12.setVisibility(View.GONE);

                layoutButtonGroup.setVisibility(View.VISIBLE);

                setDefaultSelect(1);

            }
        });
    }

    private void setDefaultSelect(int i) {
        if (i == 0) {
            //Can start.
            rdb1_1.setChecked(true);
            rdb2_1.setChecked(true);
            rdb3_1.setChecked(true);
            rdb4_1.setChecked(true);
            rdb5_1.setChecked(true);
            rdb6_1.setChecked(true);
            rdb7_1.setChecked(true);
            rdb8_1.setChecked(true);
            rdb9_1.setChecked(true);
            rdb10_1.setChecked(true);
            rdb11_1.setChecked(true);
            rdb12_1.setChecked(true);
        }else {

        }
    }

    private void hideRadioGroup() {
        rdg1.setVisibility(View.GONE);
        rdg2.setVisibility(View.GONE);
        rdg3.setVisibility(View.GONE);
        rdg4.setVisibility(View.GONE);
        rdg5.setVisibility(View.GONE);
        rdg6.setVisibility(View.GONE);
        rdg7.setVisibility(View.GONE);
        rdg8.setVisibility(View.GONE);
        rdg9.setVisibility(View.GONE);
        rdg10.setVisibility(View.GONE);
        rdg11.setVisibility(View.GONE);
        rdg12.setVisibility(View.GONE);

        layoutButtonGroup.setVisibility(View.GONE);
    }

    private void bindWidget() {
        rdbEngineFalse = (RadioButton) findViewById(R.id.radioBtnEngineFalse);
        rdbEngineTrue = (RadioButton) findViewById(R.id.radioBtnEngineTrue);

        rdgCheckEngine = (RadioGroup) findViewById(R.id.checkEngine);
        rdg1 = (RadioGroup) findViewById(R.id.no1);
        rdg2 = (RadioGroup) findViewById(R.id.no2);
        rdg3 = (RadioGroup) findViewById(R.id.no3);
        rdg4 = (RadioGroup) findViewById(R.id.no4);
        rdg5 = (RadioGroup) findViewById(R.id.no5);
        rdg6 = (RadioGroup) findViewById(R.id.no6);
        rdg7 = (RadioGroup) findViewById(R.id.no7);
        rdg8 = (RadioGroup) findViewById(R.id.no8);
        rdg9 = (RadioGroup) findViewById(R.id.no9);
        rdg10 = (RadioGroup) findViewById(R.id.no10);
        rdg11 = (RadioGroup) findViewById(R.id.no11);
        rdg12 = (RadioGroup)findViewById(R.id.no12);

        rdb1_1 = (RadioButton) findViewById(R.id.radioBtn1_1);
        rdb1_2 = (RadioButton)findViewById(R.id.radioBtn1_2);
        rdb2_1 = (RadioButton)findViewById(R.id.radioBtn2_1);
        rdb2_2 = (RadioButton) findViewById(R.id.radioBtn2_2);
        rdb3_1 = (RadioButton)findViewById(R.id.radioBtn3_1);
        rdb3_2 = (RadioButton)findViewById(R.id.radioBtn3_2);
        rdb3_3 = (RadioButton)findViewById(R.id.radioBtn3_3);
        rdb3_4 = (RadioButton)findViewById(R.id.radioBtn3_4);
        rdb4_1 = (RadioButton)findViewById(R.id.radioBtn4_1);
        rdb4_2 = (RadioButton)findViewById(R.id.radioBtn4_2);
        rdb5_1 = (RadioButton)findViewById(R.id.radioBtn5_1);
        rdb5_2 = (RadioButton)findViewById(R.id.radioBtn5_2);
        rdb6_1 = (RadioButton)findViewById(R.id.radioBtn6_1);
        rdb6_2 = (RadioButton)findViewById(R.id.radioBtn6_2);
        rdb6_3 = (RadioButton)findViewById(R.id.radioBtn6_3);
        rdb7_1 = (RadioButton)findViewById(R.id.radioBtn7_1);
        rdb7_2 = (RadioButton)findViewById(R.id.radioBtn7_2);
        rdb8_1 = (RadioButton)findViewById(R.id.radioBtn8_1);
        rdb8_2 = (RadioButton)findViewById(R.id.radioBtn8_2);
        rdb8_3 = (RadioButton)findViewById(R.id.radioBtn8_3);
        rdb9_1 = (RadioButton)findViewById(R.id.radioBtn9_1);
        rdb9_2 = (RadioButton)findViewById(R.id.radioBtn9_2);
        rdb10_1 = (RadioButton)findViewById(R.id.radioBtn10_1);
        rdb10_2 = (RadioButton)findViewById(R.id.radioBtn10_2);
        rdb11_1 = (RadioButton)findViewById(R.id.radioBtn11_1);
        rdb11_2 = (RadioButton)findViewById(R.id.radioBtn11_2);
        rdb12_1 = (RadioButton)findViewById(R.id.radioBtn12_1);
        rdb12_2 = (RadioButton)findViewById(R.id.radioBtn12_2);
        rdb12_3 = (RadioButton) findViewById(R.id.radioBtn12_3);


        layoutButtonGroup = (LinearLayout) findViewById(R.id.layoutNavigation);
    }
}
