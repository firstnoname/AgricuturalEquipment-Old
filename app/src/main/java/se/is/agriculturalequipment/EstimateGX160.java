package se.is.agriculturalequipment;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;

public class EstimateGX160 extends AppCompatActivity {

    //Test new logic.
    private RadioGroup rdgCheckEngine, rdg1, rdg2, rdg3, rdg4, rdg5, rdg6, rdg7, rdg8, rdg9, rdg10, rdg11;

    private RadioButton rdbEngineTrue, rdbEngineFalse, rdb1_1, rdb1_2, rdb2_1,
            rdb2_2, rdb3_1, rdb3_2, rdb4_1, rdb4_2, rdb4_3,
            rdb4_4, rdb5_1, rdb5_2, rdb6_1, rdb6_2, rdb7_1,
            rdb7_2, rdb8_1, rdb8_2, rdb9_1, rdb9_2, rdb10_1,
            rdb10_2, rdb11_1, rdb11_2;

    private RadioButton rdbSelectedEngine, rdbSelectedBodyColor, rdbSelectedFuelTankCap, rdbSelectedOilFilter,
            rdbSelectedStarter, rdbSelectedMuffler, rdbSelectedSparkPlug, rdbSelectedCarburetor, rdbSelectedCoilCDI,
            rdbSelectedBallValueSwitchOil, rdbSelectedAirFilter, rdbSelectedSwitchOnOff;

    private Integer idSelectedEngine, idSelectedBodyColor, idSelectedFuelTankCap, idSelectedOilFilter, idSelectedStarter,
            idSelectedMuffler, idSelectedSparkPlug, idSelectedCarburetor, idSelectedCoilCDI,
            idSelectedBallValueSwitchOil, idSelectedAirFilter, idSelectedSwitchOnOff;

    private Integer idxSelectedEngine, idxSelectedBodyColor, idxSelectedFuelTankCap, idxSelectedOilFilter,
            idxSelectedStarter, idxSelectedMuffler, idxSelectedSparkPlug, idxSelectedCarburetor, idxSelectedCoilCDI,
            idxSelectedBallValueSwitchOil, idxSelectedAirFilter, idxSelectedSwitchOnOff;

    private LinearLayout layoutButtonGroup;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estimate_gx160);

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
                rdg4.setVisibility(View.GONE);
                rdg5.setVisibility(View.VISIBLE);
                rdg6.setVisibility(View.VISIBLE);
                rdg7.setVisibility(View.GONE);
                rdg8.setVisibility(View.GONE);
                rdg9.setVisibility(View.GONE);
                rdg10.setVisibility(View.VISIBLE);
                rdg11.setVisibility(View.VISIBLE);

                layoutButtonGroup.setVisibility(View.VISIBLE);

                setDefaultSelect(1);

            }
        });

    }

    private void bindWidget() {
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

        rdbEngineFalse = (RadioButton) findViewById(R.id.radioBtnEngineFalse);
        rdbEngineTrue = (RadioButton) findViewById(R.id.radioBtnEngineTrue);
        rdbSelectedEngine = (RadioButton) findViewById(idSelectedEngine);
        rdb1_1 = (RadioButton) findViewById(R.id.radioBtn1_1);
        rdb1_2 = (RadioButton) findViewById(R.id.radioBtn1_2);
        rdb2_1 = (RadioButton) findViewById(R.id.radioBtn2_1);
        rdb2_2 = (RadioButton) findViewById(R.id.radioBtn2_2);
        rdb3_1 = (RadioButton) findViewById(R.id.radioBtn3_1);
        rdb3_2 = (RadioButton) findViewById(R.id.radioBtn3_2);
        rdb4_1 = (RadioButton) findViewById(R.id.radioBtn4_1);
        rdb4_2 = (RadioButton) findViewById(R.id.radioBtn4_2);
        rdb4_3 = (RadioButton) findViewById(R.id.radioBtn4_3);
        rdb4_4 = (RadioButton) findViewById(R.id.radioBtn4_4);
        rdb5_1 = (RadioButton) findViewById(R.id.radioBtn5_1);
        rdb5_2 = (RadioButton) findViewById(R.id.radioBtn5_2);
        rdb6_1 = (RadioButton) findViewById(R.id.radioBtn6_1);
        rdb6_2 = (RadioButton) findViewById(R.id.radioBtn6_2);
        rdb7_1 = (RadioButton) findViewById(R.id.radioBtn7_1);
        rdb7_2 = (RadioButton) findViewById(R.id.radioBtn7_2);
        rdb8_1 = (RadioButton) findViewById(R.id.radioBtn8_1);
        rdb8_2 = (RadioButton) findViewById(R.id.radioBtn8_2);
        rdb9_1 = (RadioButton) findViewById(R.id.radioBtn9_1);
        rdb9_2 = (RadioButton) findViewById(R.id.radioBtn9_2);
        rdb10_1 = (RadioButton) findViewById(R.id.radioBtn10_1);
        rdb10_2 = (RadioButton) findViewById(R.id.radioBtn10_2);
        rdb11_1 = (RadioButton) findViewById(R.id.radioBtn11_1);
        rdb11_2 = (RadioButton) findViewById(R.id.radioBtn11_2);

        layoutButtonGroup = (LinearLayout) findViewById(R.id.layoutNavigation);
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

        layoutButtonGroup.setVisibility(View.GONE);
    }

    public void intentSubmitEstimateGX160(View view){

        ArrayList<String> arrNameList = new ArrayList<String>();
        ArrayList<Integer> arrSelectedID = new ArrayList<Integer>();

        //Get id and text from RadioButton.
        idSelectedEngine = rdgCheckEngine.getCheckedRadioButtonId();
        arrSelectedID.add(idxSelectedEngine = rdgCheckEngine.indexOfChild(rdbSelectedEngine));
        arrNameList.add(rdbSelectedEngine.getText().toString());
//        Check can start or not. 0 = The engine can starts, 1 = The engine can't starts.
        if(idxSelectedEngine==0){

            /*No1 = สีตัวเครื่องโดยรวม*/
            idSelectedBodyColor = rdg1.getCheckedRadioButtonId();
            rdbSelectedBodyColor = (RadioButton) findViewById(idSelectedBodyColor);
            arrSelectedID.add(idxSelectedBodyColor = rdg1.indexOfChild(rdbSelectedBodyColor));
            arrNameList.add(rdbSelectedBodyColor.getText().toString());

            /*No2 = ฝาถังน้ำมันเบนซิน*/
            idSelectedFuelTankCap = rdg2.getCheckedRadioButtonId();
            rdbSelectedFuelTankCap = (RadioButton) findViewById(idSelectedFuelTankCap);
            arrSelectedID.add(idxSelectedFuelTankCap = rdg2.indexOfChild(rdbSelectedFuelTankCap));
            arrNameList.add(rdbSelectedFuelTankCap.getText().toString());

            /*No3 = ฝาถังน้ำมันเครื่อง*/
            idSelectedOilFilter = rdg3.getCheckedRadioButtonId();
            rdbSelectedOilFilter = (RadioButton) findViewById(idSelectedOilFilter);
            arrSelectedID.add(idxSelectedOilFilter = rdg3.indexOfChild(rdbSelectedOilFilter));
            arrNameList.add(rdbSelectedOilFilter.getText().toString());

            /*No4 = จานกระตุก*/
            idSelectedStarter = rdg4.getCheckedRadioButtonId();
            rdbSelectedStarter = (RadioButton) findViewById(idSelectedStarter);
            arrSelectedID.add(idxSelectedStarter = rdg4.indexOfChild(rdbSelectedStarter));
            arrNameList.add(rdbSelectedStarter.getText().toString());

            /*No5 = ท่อไอเสีย*/
            idSelectedMuffler = rdg5.getCheckedRadioButtonId();
            rdbSelectedMuffler = (RadioButton) findViewById(idSelectedMuffler);
            arrSelectedID.add(idxSelectedMuffler = rdg5.indexOfChild(rdbSelectedMuffler));
            arrNameList.add(rdbSelectedMuffler.getText().toString());

            /*No6 = ปลั๊กหัวเทียน*/
            idSelectedSparkPlug = rdg6.getCheckedRadioButtonId();
            rdbSelectedSparkPlug = (RadioButton) findViewById(idSelectedSparkPlug);
            arrSelectedID.add(idxSelectedSparkPlug = rdg6.indexOfChild(rdbSelectedSparkPlug));
            arrNameList.add(rdbSelectedSparkPlug.getText().toString());

            /*No7 = คาร์บูเรเตอร์*/
            idSelectedCarburetor = rdg7.getCheckedRadioButtonId();
            rdbSelectedCarburetor = (RadioButton) findViewById(idSelectedCarburetor);
            arrSelectedID.add(idxSelectedCarburetor = rdg7.indexOfChild(rdbSelectedCarburetor));
            arrNameList.add(rdbSelectedCarburetor.getText().toString());

            /*No8 = CDI*/
            idSelectedCoilCDI = rdg8.getCheckedRadioButtonId();
            rdbSelectedCoilCDI = (RadioButton) findViewById(idSelectedCoilCDI);
            arrSelectedID.add(idxSelectedCoilCDI = rdg8.indexOfChild(rdbSelectedCoilCDI));
            arrNameList.add(rdbSelectedCoilCDI.getText().toString());

            /*No9 = ก๊อกน้ำมัน*/
            idSelectedBallValueSwitchOil = rdg9.getCheckedRadioButtonId();
            rdbSelectedBallValueSwitchOil = (RadioButton) findViewById(idSelectedBallValueSwitchOil);
            arrSelectedID.add(idxSelectedBallValueSwitchOil = rdg9.indexOfChild(rdbSelectedBallValueSwitchOil));
            arrNameList.add(rdbSelectedBallValueSwitchOil.getText().toString());

            /*No10 = หม้อกรองอากาศ*/
            idSelectedAirFilter = rdg10.getCheckedRadioButtonId();
            rdbSelectedAirFilter = (RadioButton) findViewById(idSelectedAirFilter);
            arrSelectedID.add(idxSelectedAirFilter = rdg10.indexOfChild(rdbSelectedAirFilter));
            arrNameList.add(rdbSelectedAirFilter.getText().toString());

            /*No11 = สวิตท์เปิด ปิด*/
            idSelectedSwitchOnOff = rdg11.getCheckedRadioButtonId();
            rdbSelectedSwitchOnOff = (RadioButton) findViewById(idSelectedSwitchOnOff);
            arrSelectedID.add(idxSelectedSwitchOnOff = rdg11.indexOfChild(rdbSelectedSwitchOnOff));
            arrNameList.add(rdbSelectedSwitchOnOff.getText().toString());

        }else{
            /*No1 = สีตัวเครื่องโดยรวม*/
            idSelectedBodyColor = rdg1.getCheckedRadioButtonId();
            rdbSelectedBodyColor = (RadioButton) findViewById(idSelectedBodyColor);
            arrSelectedID.add(idxSelectedBodyColor = rdg1.indexOfChild(rdbSelectedBodyColor));
            arrNameList.add(rdbSelectedBodyColor.getText().toString());

            /*No2 = ฝาถังน้ำมันเบนซิน*/
            idSelectedFuelTankCap = rdg2.getCheckedRadioButtonId();
            rdbSelectedFuelTankCap = (RadioButton) findViewById(idSelectedFuelTankCap);
            arrSelectedID.add(idxSelectedFuelTankCap = rdg2.indexOfChild(rdbSelectedFuelTankCap));
            arrNameList.add(rdbSelectedFuelTankCap.getText().toString());

            /*No3 = ฝาถังน้ำมันเครื่อง*/
            idSelectedOilFilter = rdg3.getCheckedRadioButtonId();
            rdbSelectedOilFilter = (RadioButton) findViewById(idSelectedOilFilter);
            arrSelectedID.add(idxSelectedOilFilter = rdg3.indexOfChild(rdbSelectedOilFilter));
            arrNameList.add(rdbSelectedOilFilter.getText().toString());

            /*No5 = ท่อไอเสีย*/
            idSelectedMuffler = rdg5.getCheckedRadioButtonId();
            rdbSelectedMuffler = (RadioButton) findViewById(idSelectedMuffler);
            arrSelectedID.add(idxSelectedMuffler = rdg5.indexOfChild(rdbSelectedMuffler));
            arrNameList.add(rdbSelectedMuffler.getText().toString());

            /*No6 = ปลั๊กหัวเทียน*/
            idSelectedSparkPlug = rdg6.getCheckedRadioButtonId();
            rdbSelectedSparkPlug = (RadioButton) findViewById(idSelectedSparkPlug);
            arrSelectedID.add(idxSelectedSparkPlug = rdg6.indexOfChild(rdbSelectedSparkPlug));
            arrNameList.add(rdbSelectedSparkPlug.getText().toString());

            /*No10 = หม้อกรองอากาศ*/
            idSelectedAirFilter = rdg10.getCheckedRadioButtonId();
            rdbSelectedAirFilter = (RadioButton) findViewById(idSelectedAirFilter);
            arrSelectedID.add(idxSelectedAirFilter = rdg10.indexOfChild(rdbSelectedAirFilter));
            arrNameList.add(rdbSelectedAirFilter.getText().toString());

            /*No11 = สวิตท์เปิด ปิด*/
            idSelectedSwitchOnOff = rdg11.getCheckedRadioButtonId();
            rdbSelectedSwitchOnOff = (RadioButton) findViewById(idSelectedSwitchOnOff);
            arrSelectedID.add(idxSelectedSwitchOnOff = rdg11.indexOfChild(rdbSelectedSwitchOnOff));
            arrNameList.add(rdbSelectedSwitchOnOff.getText().toString());
        }


        Intent intentSubmitEstimateGX160 = new Intent(this, SubmitEstimateGX160.class);
        intentSubmitEstimateGX160.putExtra("idxEngine", idxSelectedEngine);
        intentSubmitEstimateGX160.putStringArrayListExtra("arrListName",arrNameList);
        intentSubmitEstimateGX160.putIntegerArrayListExtra("arrSelectedID", arrSelectedID);
        startActivity(intentSubmitEstimateGX160);

    }

    private void setDefaultSelect(Integer check) {
        if(check == 0){
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
        }else {
            //Can't start.
            rdb1_1.setChecked(true);
            rdb2_1.setChecked(true);
            rdb3_1.setChecked(true);
            rdb5_1.setChecked(true);
            rdb6_1.setChecked(true);
            rdb10_1.setChecked(true);
            rdb11_1.setChecked(true);
        }

    }

}
