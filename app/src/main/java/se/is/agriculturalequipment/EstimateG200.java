package se.is.agriculturalequipment;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class EstimateG200 extends AppCompatActivity {

    private RadioGroup radioCheckEngine, radioGroup1, radioGroup2,radioGroup3,radioGroup4,radioGroup5,
            radioGroup6, radioGroup7,radioGroup8,radioGroup9,radioGroup10, radioGroup11;

    private RadioButton rdgEngineTrue, rdgEngineFalse, radioBtn1_1, radioBtn1_2, radioBtn2_1,
            radioBtn2_2, radioBtn3_1, radioBtn3_2, radioBtn4_1, radioBtn4_2, radioBtn4_3,
            radioBtn4_4, radioBtn5_1, radioBtn5_2, radioBtn6_1, radioBtn6_2, radioBtn7_1,
            radioBtn7_2, radioBtn8_1, radioBtn8_2, radioBtn9_1, radioBtn9_2, radioBtn10_1,
            radioBtn10_2,radioBtn10_3, radioBtn11_1, radioBtn11_2;

    private RadioButton rdbChkEngine, rdbChkBodyColor, rdbChkFuelTankCap, rdbChkOilFilter,
            rdbChkStarter, rdbChkMuffler, rdbChkSparkPlug, rdbChkCarburetor, rdbChkCoilCDI,
            rdbChkBallValueSwitchOil, rdbChkAirFilter, rdbChkSwitchOnOff;

    //linearNavi for Show or Hide the button.
    private LinearLayout linearNavi;

    int selectedEngine, selectedBodyColor, selectedFuelTankCap, selectedOilFilter, selectedStarter,
            selectedMuffler, selectedSparkPlug, selectedCarburetor, selectedCoilCDI,
            selectedBallValueSwitchOil, selectedAirFilter, selectedSwitchOnOff;

    int idxCheckEngine, idxBodyColor, idxFuelTankCap, idxOilFilter, idxStarter, idxMuffler, idxSparkPlug,
            idxCarburetor, idxCoilCDI, idxBallValueSwitchOil, idxAirFilter, idxSwitchOnOff;

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
        /*Get value from radio button.*/
        selectedEngine = radioCheckEngine.getCheckedRadioButtonId();
        rdbChkEngine = (RadioButton) findViewById(selectedEngine);
        idxCheckEngine = radioCheckEngine.indexOfChild(rdbChkEngine);

        /*Check engine can start or not? if 0 = Started*/
        if (idxCheckEngine == 0) {
            /*No1 = สีตัวเครื่องโดยรวม*/
            selectedBodyColor = radioGroup1.getCheckedRadioButtonId();
            rdbChkBodyColor = (RadioButton) findViewById(selectedBodyColor);
            idxBodyColor = radioGroup1.indexOfChild(rdbChkBodyColor);

            /*No2 = ฝาถังน้ำมันเบยซิน*/
            selectedFuelTankCap = radioGroup2.getCheckedRadioButtonId();
            rdbChkFuelTankCap = (RadioButton) findViewById(selectedFuelTankCap);
            idxFuelTankCap = radioGroup2.indexOfChild(rdbChkFuelTankCap);

            /*No3 = ฝาถังน้ำมันเครื่อง*/
            selectedOilFilter = radioGroup3.getCheckedRadioButtonId();
            rdbChkOilFilter = (RadioButton) findViewById(selectedOilFilter);
            idxOilFilter = radioGroup3.indexOfChild(rdbChkOilFilter);

            /*No4 = จานกระตุก*/
            selectedStarter = radioGroup4.getCheckedRadioButtonId();
            rdbChkStarter = (RadioButton) findViewById(selectedStarter);
            idxStarter = radioGroup4.indexOfChild(rdbChkStarter);

            /*No5 = ท่อไอเสีย*/
            selectedMuffler = radioGroup5.getCheckedRadioButtonId();
            rdbChkMuffler = (RadioButton) findViewById(selectedMuffler);
            idxMuffler = radioGroup5.indexOfChild(rdbChkMuffler);

            /*No6 = ปลั๊กหัวเทียน*/
            selectedSparkPlug = radioGroup6.getCheckedRadioButtonId();
            rdbChkSparkPlug = (RadioButton) findViewById(selectedSparkPlug);
            idxSparkPlug = radioGroup6.indexOfChild(rdbChkSparkPlug);

            /*No7 = คาร์บูเรเตอร์*/
            selectedCarburetor = radioGroup7.getCheckedRadioButtonId();
            rdbChkCarburetor = (RadioButton) findViewById(selectedCarburetor);
            idxCarburetor = radioGroup7.indexOfChild(rdbChkCarburetor);

            /*No8 = CDI*/
            selectedCoilCDI = radioGroup8.getCheckedRadioButtonId();
            rdbChkCoilCDI = (RadioButton) findViewById(selectedCoilCDI);
            idxCoilCDI = radioGroup8.indexOfChild(rdbChkCoilCDI);

            /*No9 = ก๊อกน้ำมัน*/
            selectedBallValueSwitchOil = radioGroup9.getCheckedRadioButtonId();
            rdbChkBallValueSwitchOil = (RadioButton) findViewById(selectedBallValueSwitchOil);
            idxBallValueSwitchOil = radioGroup9.indexOfChild(rdbChkBallValueSwitchOil);

            /*No10 = หม้อกรองอากาศ*/
            selectedAirFilter = radioGroup10.getCheckedRadioButtonId();
            rdbChkAirFilter = (RadioButton) findViewById(selectedAirFilter);
            idxAirFilter = radioGroup10.indexOfChild(rdbChkAirFilter);

            /*No11 = สวิตท์เปิด ปิด*/
            selectedSwitchOnOff = radioGroup11.getCheckedRadioButtonId();
            rdbChkSwitchOnOff = (RadioButton) findViewById(selectedSwitchOnOff);
            idxSwitchOnOff = radioGroup11.indexOfChild(rdbChkSwitchOnOff);

        }else{
            /*No1 = สีตัวเครื่องโดยรวม*//*
            selectedBodyColor = radioGroup1.getCheckedRadioButtonId();
            rdbChkBodyColor = (RadioButton) findViewById(selectedBodyColor);
            idxBodyColor = radioGroup1.indexOfChild(rdbChkBodyColor);

            *//*No2 = ฝาถังน้ำมันเบยซิน*//*
            selectedFuelTankCap = radioGroup2.getCheckedRadioButtonId();
            rdbChkFuelTankCap = (RadioButton) findViewById(selectedFuelTankCap);
            idxFuelTankCap = radioGroup2.indexOfChild(rdbChkFuelTankCap);

            *//*No3 = ฝาถังน้ำมันเครื่อง*//*
            selectedOilFilter = radioGroup3.getCheckedRadioButtonId();
            rdbChkOilFilter = (RadioButton) findViewById(selectedOilFilter);
            idxOilFilter = radioGroup3.indexOfChild(rdbChkOilFilter);

            *//*No5 = ท่อไอเสีย*//*
            selectedMuffler = radioGroup5.getCheckedRadioButtonId();
            rdbChkMuffler = (RadioButton) findViewById(selectedMuffler);
            idxMuffler = radioGroup5.indexOfChild(rdbChkMuffler);

            *//*No6 = ปลั๊กหัวเทียน*//*
            selectedSparkPlug = radioGroup6.getCheckedRadioButtonId();
            rdbChkSparkPlug = (RadioButton) findViewById(selectedSparkPlug);
            idxSparkPlug = radioGroup6.indexOfChild(rdbChkSparkPlug);

            *//*No10 = หม้อกรองอากาศ*//*
            selectedAirFilter = radioGroup10.getCheckedRadioButtonId();
            rdbChkAirFilter = (RadioButton) findViewById(selectedAirFilter);
            idxAirFilter = radioGroup10.indexOfChild(rdbChkBallValueSwitchOil);

            *//*No11 = สวิตท์เปิด ปิด*//*
            selectedSwitchOnOff = radioGroup11.getCheckedRadioButtonId();
            rdbChkSwitchOnOff = (RadioButton) findViewById(selectedSwitchOnOff);
            idxSwitchOnOff = radioGroup11.indexOfChild(rdbChkSwitchOnOff);*/
        }

        /*Intent and send data to another activity.*/
        Intent intentSubmitEstimateG200 = new Intent(this, SubmitEstimateG200.class);

        intentSubmitEstimateG200.putExtra("Engine", idxCheckEngine);
        intentSubmitEstimateG200.putExtra("BodyColor", idxBodyColor);
        intentSubmitEstimateG200.putExtra("FuelTankCap", idxFuelTankCap);
        intentSubmitEstimateG200.putExtra("OilFilter", idxOilFilter);
        intentSubmitEstimateG200.putExtra("Starter", idxStarter);
        intentSubmitEstimateG200.putExtra("Muffler", idxMuffler);
        intentSubmitEstimateG200.putExtra("SparkPlug", idxSparkPlug);
        intentSubmitEstimateG200.putExtra("Carburetor", idxCarburetor);
        intentSubmitEstimateG200.putExtra("CoilCDI", idxCoilCDI);
        intentSubmitEstimateG200.putExtra("BallValueSwitchOil", idxBallValueSwitchOil);
        intentSubmitEstimateG200.putExtra("AirFilter", idxAirFilter);
        intentSubmitEstimateG200.putExtra("SwitchOnOff", idxSwitchOnOff);

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

        radioCheckEngine = (RadioGroup) findViewById(R.id.checkEngine);
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
