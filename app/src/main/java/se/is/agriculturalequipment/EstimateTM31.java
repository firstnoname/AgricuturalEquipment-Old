package se.is.agriculturalequipment;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.ArrayList;

public class EstimateTM31 extends AppCompatActivity {

    private RadioGroup rdgCheckEngine, rdg1, rdg2, rdg3, rdg4, rdg5, rdg6, rdg7, rdg8, rdg9, rdg10, rdg11, rdg12;

    private RadioButton rdbEngineTrue, rdbEngineFalse, rdb1_1, rdb1_2,
            rdb2_1, rdb2_2,
            rdb3_1, rdb3_2, rdb3_3,
            rdb4_1, rdb4_2,
            rdb5_1, rdb5_2,
            rdb6_1, rdb6_2,
            rdb7_1, rdb7_2,
            rdb8_1, rdb8_2,
            rdb9_1, rdb9_2,
            rdb10_1, rdb10_2,
            rdb11_1, rdb11_2,
            rdb12_1, rdb12_2;

    private RadioButton rdbSelectedEngine, rdbSelectedAirChamber, rdbSelectedSealSet, rdbSelectedAdjustSet,
            rdbSelectedDischargeMetal, rdbSelectedSuctionMetal, rdbSelectedPistonSet, rdbSelectedStarterRopeReel, rdbSelectedPressureGauge,
            rdbSelectedBallValveSwitch, rdbSelectedOilFilter, rdbSelectedNewPaint, rdbSelectedOilTankCap;

    private Integer idSelectedEngine, idSelectedAirChamber, idSelectedSealSet, idSelectedAdjustSet,
            idSelectedDischargeMetal, idSelectedSuctionMetal, idSelectedPistonSet, idSelectedStarterRopeReel, idSelectedPressureGauge,
            idSelectedBallValveSwitch, idSelectedOilFilter, idSelectedNewPaint, idSelectedOilTankCap;

    private Integer idxSelectedEngine, idxSelectedAirChamber, idxSelectedSealSet, idxSelectedAdjustSet,
            idxSelectedDischargeMetal, idxSelectedSuctionMetal, idxSelectedPistonSet, idxSelectedStarterRopeReel, idxSelectedPressureGauge,
            idxSelectedBallValveSwitch, idxSelectedOilFilter, idxSelectedNewPaint, idxSelectedOilTankCap;

    private LinearLayout layoutButtonGroup;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estimate_tm31);

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
                idxSelectedEngine = 0;
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
                rdg10.setVisibility(View.VISIBLE);
                rdg11.setVisibility(View.VISIBLE);
                rdg12.setVisibility(View.VISIBLE);


                layoutButtonGroup.setVisibility(View.VISIBLE);
                idxSelectedEngine = 1;
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
        rdg12 = (RadioGroup) findViewById(R.id.no12);


        rdbEngineFalse = (RadioButton) findViewById(R.id.radioBtnEngineFalse);
        rdbEngineTrue = (RadioButton) findViewById(R.id.radioBtnEngineTrue);
        rdb1_1 = (RadioButton) findViewById(R.id.radioBtn1_1);
        rdb1_2 = (RadioButton) findViewById(R.id.radioBtn1_2);
        rdb2_1 = (RadioButton) findViewById(R.id.radioBtn2_1);
        rdb2_2 = (RadioButton) findViewById(R.id.radioBtn2_2);
        rdb3_1 = (RadioButton) findViewById(R.id.radioBtn3_1);
        rdb3_2 = (RadioButton) findViewById(R.id.radioBtn3_2);
        rdb3_3 = (RadioButton) findViewById(R.id.radioBtn3_3);
        rdb4_1 = (RadioButton) findViewById(R.id.radioBtn4_1);
        rdb4_2 = (RadioButton) findViewById(R.id.radioBtn4_2);
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
        rdb12_1 = (RadioButton) findViewById(R.id.radioBtn12_1);
        rdb12_2 = (RadioButton) findViewById(R.id.radioBtn12_2);


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
        rdg12.setVisibility(View.GONE);


        layoutButtonGroup.setVisibility(View.GONE);
    }

    public void intentSubmitEstimateTM31(View view) {

        ArrayList<String> arrNameList = new ArrayList<String>();
        ArrayList<Integer> arrSelectedID = new ArrayList<Integer>();

        //Get id and text from RadioButton.
        idSelectedEngine = rdgCheckEngine.getCheckedRadioButtonId();
        rdbSelectedEngine = (RadioButton) findViewById(idSelectedEngine);
        arrSelectedID.add(idxSelectedEngine = rdgCheckEngine.indexOfChild(rdbSelectedEngine));
        arrNameList.add(rdbSelectedEngine.getText().toString());
//        Check can start or not. 0 = The engine can starts, 1 = The engine can't starts.
        if (idxSelectedEngine == 0) {

            /*No1 = หม้อลม*/
            idSelectedAirChamber = rdg1.getCheckedRadioButtonId();
            rdbSelectedAirChamber = (RadioButton) findViewById(idSelectedAirChamber);
            arrSelectedID.add(idxSelectedAirChamber = rdg1.indexOfChild(rdbSelectedAirChamber));
            arrNameList.add(rdbSelectedAirChamber.getText().toString());

            /*No2 = ลูกยางชุด*/
            idSelectedSealSet = rdg2.getCheckedRadioButtonId();
            rdbSelectedSealSet = (RadioButton) findViewById(idSelectedSealSet);
            arrSelectedID.add(idxSelectedSealSet = rdg2.indexOfChild(rdbSelectedSealSet));
            arrNameList.add(rdbSelectedSealSet.getText().toString());

            /*No3 = ตัวตั้งโปโล*/
            idSelectedAdjustSet = rdg3.getCheckedRadioButtonId();
            rdbSelectedAdjustSet = (RadioButton) findViewById(idSelectedAdjustSet);
            arrSelectedID.add(idxSelectedAdjustSet = rdg3.indexOfChild(rdbSelectedAdjustSet));
            arrNameList.add(rdbSelectedAdjustSet.getText().toString());

            /*No4 = ท่อนดูด*/
            idSelectedDischargeMetal = rdg4.getCheckedRadioButtonId();
            rdbSelectedDischargeMetal = (RadioButton) findViewById(idSelectedDischargeMetal);
            arrSelectedID.add(idxSelectedDischargeMetal = rdg4.indexOfChild(rdbSelectedDischargeMetal));
            arrNameList.add(rdbSelectedDischargeMetal.getText().toString());

            /*No5 = ท่อนส่ง */
            idSelectedSuctionMetal = rdg5.getCheckedRadioButtonId();
            rdbSelectedSuctionMetal = (RadioButton) findViewById(idSelectedSuctionMetal);
            arrSelectedID.add(idxSelectedSuctionMetal = rdg5.indexOfChild(rdbSelectedSuctionMetal));
            arrNameList.add(rdbSelectedSuctionMetal.getText().toString());

            /*No6 = ลูกสูบ */
            idSelectedPistonSet = rdg6.getCheckedRadioButtonId();
            rdbSelectedPistonSet = (RadioButton) findViewById(idSelectedPistonSet);
            arrSelectedID.add(idxSelectedPistonSet = rdg6.indexOfChild(rdbSelectedPistonSet));
            arrNameList.add(rdbSelectedPistonSet.getText().toString());

            /*No7 = มู่เล่ย์*/
            idSelectedStarterRopeReel = rdg7.getCheckedRadioButtonId();
            rdbSelectedStarterRopeReel = (RadioButton) findViewById(idSelectedStarterRopeReel);
            arrSelectedID.add(idxSelectedStarterRopeReel = rdg7.indexOfChild(rdbSelectedStarterRopeReel));
            arrNameList.add(rdbSelectedStarterRopeReel.getText().toString());

            /*No8 = เกย์วัดความดัน*/
            idSelectedPressureGauge = rdg8.getCheckedRadioButtonId();
            rdbSelectedPressureGauge = (RadioButton) findViewById(idSelectedPressureGauge);
            arrSelectedID.add(idxSelectedPressureGauge = rdg8.indexOfChild(rdbSelectedPressureGauge));
            arrNameList.add(rdbSelectedPressureGauge.getText().toString());

            /*No9 = ก๊อกน้ำ*/
            idSelectedBallValveSwitch = rdg9.getCheckedRadioButtonId();
            rdbSelectedBallValveSwitch = (RadioButton) findViewById(idSelectedBallValveSwitch);
            arrSelectedID.add(idxSelectedBallValveSwitch = rdg9.indexOfChild(rdbSelectedBallValveSwitch));
            arrNameList.add(rdbSelectedBallValveSwitch.getText().toString());

             /*No10 = ฝาถังน้ำมันเครื่อง */
            idSelectedOilTankCap = rdg12.getCheckedRadioButtonId();
            rdbSelectedOilTankCap = (RadioButton) findViewById(idSelectedOilTankCap);
            arrSelectedID.add(idxSelectedOilTankCap = rdg12.indexOfChild(rdbSelectedOilTankCap));
            arrNameList.add(rdbSelectedOilTankCap.getText().toString());


            /*No11 = ทำสี */
            idSelectedNewPaint = rdg11.getCheckedRadioButtonId();
            rdbSelectedNewPaint = (RadioButton) findViewById(idSelectedNewPaint);
            arrSelectedID.add(idxSelectedNewPaint = rdg11.indexOfChild(rdbSelectedNewPaint));
            arrNameList.add(rdbSelectedNewPaint.getText().toString());

            /*No12 = ฝาถังน้ำมันเครื่อง */
            idSelectedOilTankCap = rdg12.getCheckedRadioButtonId();
            rdbSelectedOilTankCap = (RadioButton) findViewById(idSelectedOilTankCap);
            arrSelectedID.add(idxSelectedOilTankCap = rdg12.indexOfChild(rdbSelectedOilTankCap));
            arrNameList.add(rdbSelectedOilTankCap.getText().toString());


        } else {
            /*No1 = หม้อลม*/
            idSelectedAirChamber = rdg1.getCheckedRadioButtonId();
            rdbSelectedAirChamber = (RadioButton) findViewById(idSelectedAirChamber);
            arrSelectedID.add(idxSelectedAirChamber = rdg1.indexOfChild(rdbSelectedAirChamber));
            arrNameList.add(rdbSelectedAirChamber.getText().toString());

            /*No2 = ลูกยางชุด*/
            idSelectedSealSet = rdg2.getCheckedRadioButtonId();
            rdbSelectedSealSet = (RadioButton) findViewById(idSelectedSealSet);
            arrSelectedID.add(idxSelectedSealSet = rdg2.indexOfChild(rdbSelectedSealSet));
            arrNameList.add(rdbSelectedSealSet.getText().toString());

            /*No3 = ตัวตั้งโปโล*/
            idSelectedAdjustSet = rdg3.getCheckedRadioButtonId();
            rdbSelectedAdjustSet = (RadioButton) findViewById(idSelectedAdjustSet);
            arrSelectedID.add(idxSelectedAdjustSet = rdg3.indexOfChild(rdbSelectedAdjustSet));
            arrNameList.add(rdbSelectedAdjustSet.getText().toString());

            /*No4 = ท่อนดูด*/
            idSelectedDischargeMetal = rdg4.getCheckedRadioButtonId();
            rdbSelectedDischargeMetal = (RadioButton) findViewById(idSelectedDischargeMetal);
            arrSelectedID.add(idxSelectedDischargeMetal = rdg4.indexOfChild(rdbSelectedDischargeMetal));
            arrNameList.add(rdbSelectedDischargeMetal.getText().toString());

            /*No5 = ท่อนส่ง */
            idSelectedSuctionMetal = rdg5.getCheckedRadioButtonId();
            rdbSelectedSuctionMetal = (RadioButton) findViewById(idSelectedSuctionMetal);
            arrSelectedID.add(idxSelectedSuctionMetal = rdg5.indexOfChild(rdbSelectedSuctionMetal));
            arrNameList.add(rdbSelectedSuctionMetal.getText().toString());

            /*No6 = ลูกสูบ */
            idSelectedPistonSet = rdg6.getCheckedRadioButtonId();
            rdbSelectedPistonSet = (RadioButton) findViewById(idSelectedPistonSet);
            arrSelectedID.add(idxSelectedPistonSet = rdg6.indexOfChild(rdbSelectedPistonSet));
            arrNameList.add(rdbSelectedPistonSet.getText().toString());

            /*No7 = มู่เล่ย์*/
            idSelectedStarterRopeReel = rdg7.getCheckedRadioButtonId();
            rdbSelectedStarterRopeReel = (RadioButton) findViewById(idSelectedStarterRopeReel);
            arrSelectedID.add(idxSelectedStarterRopeReel = rdg7.indexOfChild(rdbSelectedStarterRopeReel));
            arrNameList.add(rdbSelectedStarterRopeReel.getText().toString());

            /*No8 = เกย์วัดความดัน*/
            idSelectedPressureGauge = rdg8.getCheckedRadioButtonId();
            rdbSelectedPressureGauge = (RadioButton) findViewById(idSelectedPressureGauge);
            arrSelectedID.add(idxSelectedPressureGauge = rdg8.indexOfChild(rdbSelectedPressureGauge));
            arrNameList.add(rdbSelectedPressureGauge.getText().toString());

            /*No9 = ก๊อกน้ำ*/
            idSelectedBallValveSwitch = rdg9.getCheckedRadioButtonId();
            rdbSelectedBallValveSwitch = (RadioButton) findViewById(idSelectedBallValveSwitch);
            arrSelectedID.add(idxSelectedBallValveSwitch = rdg9.indexOfChild(rdbSelectedBallValveSwitch));
            arrNameList.add(rdbSelectedBallValveSwitch.getText().toString());

             /*No10 = ฝาถังน้ำมันเครื่อง */
            idSelectedOilTankCap = rdg10.getCheckedRadioButtonId();
            rdbSelectedOilTankCap = (RadioButton) findViewById(idSelectedOilTankCap);
            arrSelectedID.add(idxSelectedOilTankCap = rdg10.indexOfChild(rdbSelectedOilTankCap));
            arrNameList.add(rdbSelectedOilTankCap.getText().toString());


            /*No11 = ทำสี */
            idSelectedNewPaint = rdg11.getCheckedRadioButtonId();
            rdbSelectedNewPaint = (RadioButton) findViewById(idSelectedNewPaint);
            arrSelectedID.add(idxSelectedNewPaint = rdg11.indexOfChild(rdbSelectedNewPaint));
            arrNameList.add(rdbSelectedNewPaint.getText().toString());

            /*No12 = ฝาถังน้ำมันเครื่อง */
            idSelectedOilTankCap = rdg12.getCheckedRadioButtonId();
            rdbSelectedOilTankCap = (RadioButton) findViewById(idSelectedOilTankCap);
            arrSelectedID.add(idxSelectedOilTankCap = rdg12.indexOfChild(rdbSelectedOilTankCap));
            arrNameList.add(rdbSelectedOilTankCap.getText().toString());
        }


        Intent intentSubmitEstimateTM31 = new Intent(this, SubmitEstimateTM31.class);
        intentSubmitEstimateTM31.putExtra("idxEngine", idxSelectedEngine);
        intentSubmitEstimateTM31.putStringArrayListExtra("arrListName", arrNameList);
        intentSubmitEstimateTM31.putIntegerArrayListExtra("arrSelectedID", arrSelectedID);
        Log.d("arrListName : ", arrNameList.toString());
        Log.d("arrSelectID : ", arrSelectedID.toString());
        startActivity(intentSubmitEstimateTM31);

    }

    private void setDefaultSelect(Integer check) {
        if (check == 0) {
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

        } else {
            //Can't start.
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


        }

    }
}
