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

public class EstimateGX35 extends AppCompatActivity {

    private RadioGroup rdgCheckEngine, rdg1, rdg2, rdg3, rdg4, rdg5, rdg6, rdg7, rdg8, rdg9, rdg10,
            rdg11, rdg12, rdg13, rdg14, rdg15, rdg16, rdg17, rdg18;
    private RadioButton rdbEngineTrue, rdbEngineFalse, rdb1_1, rdb1_2, rdb1_3,
            rdb2_1, rdb2_2,
            rdb3_1, rdb3_2,
            rdb4_1, rdb4_2,
            rdb5_1, rdb5_2, rdb5_3,
            rdb6_1, rdb6_2,
            rdb7_1, rdb7_2, rdb7_3,
            rdb8_1, rdb8_2,
            rdb9_1, rdb9_2,
            rdb10_1, rdb10_2, rdb10_3,
            rdb11_1, rdb11_2,
            rdb12_1, rdb12_2,
            rdb13_1, rdb13_2,
            rdb14_1, rdb14_2,
            rdb15_1, rdb15_2,
            rdb16_1, rdb16_2,
            rdb17_1, rdb17_2,
            rdb18_1, rdb18_2;

    private RadioButton rdbSelectedEngine, rdbSelectedStarter, rdbSelectedFuelTank, rdbSelectedControlSwitch,
            rdbSelectedBrushCutterBlade, rdbSelectedAirFilter, rdbSelectedCarburetor, rdbSelectedCylinderSet, rdbSelectedBallValveSwitchOil,
            rdbSelectedMuffler, rdbSelectedGearDiver, rdbSelectedMainPipe, rdbSelectedSwitchOnOff, rdbSelectedCoil, rdbSelectedFuelTankCap,
            rdbSelectedNewPaint, rdbSelectedShaft, rdbSelectedOilTankCap, rdbSelectedSparkPlug;

    private LinearLayout layoutButtonGroup;

    private Integer idSelectedEngine, idSelectedStarter, idSelectedFuelTank, idSelectedControlSwitch,
            idSelectedBrushCutterBlade, idSelectedAirFilter, idSelectedCarburetor, idSelectedCylinderSet, idSelectedBallValveSwitchOil,
            idSelectedMuffler, idSelectedGearDiver, idSelectedMainPipe, idSelectedSwitchOnOff, idSelectedCoil,
            idSelectedFuelTankCap, idSelectedNewPaint, idSelectedShaft, idSelectedOilTankCap, idSelectedSparkPlug;

    private Integer idxSelectedEngine, idxSelectedStarter, idxSelectedFuelTank, idxSelectedControlSwitch,
            idxSelectedBrushCutterBlade, idxSelectedAirFilter, idxSelectedCarburetor, idxSelectedCylinderSet, idxSelectedBallValveSwitchOil,
            idxSelectedMuffler, idxSelectedGearDiver, idxSelectedMainPipe, idxSelectedSwitchOnOff, idxSelectedCoil,
            idxSelectedFuelTankCap, idxSelectedNewPaint, idxSelectedShaft, idxSelectedOilTankCap, idxSelectedSparkPlug;

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
                rdg13.setVisibility(View.VISIBLE);
                rdg14.setVisibility(View.VISIBLE);
                rdg15.setVisibility(View.VISIBLE);
                rdg16.setVisibility(View.VISIBLE);
                rdg17.setVisibility(View.VISIBLE);
                rdg18.setVisibility(View.VISIBLE);

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
                rdg6.setVisibility(View.GONE);
                rdg7.setVisibility(View.GONE);
                rdg8.setVisibility(View.VISIBLE);
                rdg9.setVisibility(View.VISIBLE);
                rdg10.setVisibility(View.VISIBLE);
                rdg11.setVisibility(View.VISIBLE);
                rdg12.setVisibility(View.VISIBLE);
                rdg13.setVisibility(View.GONE);
                rdg14.setVisibility(View.VISIBLE);
                rdg15.setVisibility(View.VISIBLE);
                rdg16.setVisibility(View.VISIBLE);
                rdg17.setVisibility(View.VISIBLE);
                rdg18.setVisibility(View.VISIBLE);

                layoutButtonGroup.setVisibility(View.VISIBLE);
                idxSelectedEngine = 1;
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
            rdb13_1.setChecked(true);
            rdb14_1.setChecked(true);
            rdb15_1.setChecked(true);
            rdb16_1.setChecked(true);
            rdb17_1.setChecked(true);
            rdb18_1.setChecked(true);
        } else {
            rdb1_1.setChecked(true);
            rdb2_1.setChecked(true);
            rdb3_1.setChecked(true);
            rdb4_1.setChecked(true);
            rdb5_1.setChecked(true);
            rdb8_1.setChecked(true);
            rdb9_1.setChecked(true);
            rdb10_1.setChecked(true);
            rdb11_1.setChecked(true);
            rdb12_1.setChecked(true);
            rdb14_1.setChecked(true);
            rdb15_1.setChecked(true);
            rdb16_1.setChecked(true);
            rdb17_1.setChecked(true);
            rdb18_1.setChecked(true);

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
        rdg13.setVisibility(View.GONE);
        rdg14.setVisibility(View.GONE);
        rdg15.setVisibility(View.GONE);
        rdg16.setVisibility(View.GONE);
        rdg17.setVisibility(View.GONE);
        rdg18.setVisibility(View.GONE);


        layoutButtonGroup.setVisibility(View.GONE);
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
        rdg13 = (RadioGroup) findViewById(R.id.no13);
        rdg14 = (RadioGroup) findViewById(R.id.no14);
        rdg15 = (RadioGroup) findViewById(R.id.no15);
        rdg16 = (RadioGroup) findViewById(R.id.no16);
        rdg17 = (RadioGroup) findViewById(R.id.no17);
        rdg18 = (RadioGroup) findViewById(R.id.no18);


        rdbEngineFalse = (RadioButton) findViewById(R.id.radioBtnEngineFalse);
        rdbEngineTrue = (RadioButton) findViewById(R.id.radioBtnEngineTrue);
        rdb1_1 = (RadioButton) findViewById(R.id.radioBtn1_1);
        rdb1_2 = (RadioButton) findViewById(R.id.radioBtn1_2);
        rdb1_3 = (RadioButton) findViewById(R.id.radioBtn1_3);
        rdb2_1 = (RadioButton) findViewById(R.id.radioBtn2_1);
        rdb2_2 = (RadioButton) findViewById(R.id.radioBtn2_2);
        rdb3_1 = (RadioButton) findViewById(R.id.radioBtn3_1);
        rdb3_2 = (RadioButton) findViewById(R.id.radioBtn3_2);
        rdb4_1 = (RadioButton) findViewById(R.id.radioBtn4_1);
        rdb4_2 = (RadioButton) findViewById(R.id.radioBtn4_2);
        rdb5_1 = (RadioButton) findViewById(R.id.radioBtn5_1);
        rdb5_2 = (RadioButton) findViewById(R.id.radioBtn5_2);
        rdb5_3 = (RadioButton) findViewById(R.id.radioBtn5_3);
        rdb6_1 = (RadioButton) findViewById(R.id.radioBtn6_1);
        rdb6_2 = (RadioButton) findViewById(R.id.radioBtn6_2);
        rdb7_1 = (RadioButton) findViewById(R.id.radioBtn7_1);
        rdb7_2 = (RadioButton) findViewById(R.id.radioBtn7_2);
        rdb7_3 = (RadioButton) findViewById(R.id.radioBtn7_3);
        rdb8_1 = (RadioButton) findViewById(R.id.radioBtn8_1);
        rdb8_2 = (RadioButton) findViewById(R.id.radioBtn8_2);
        rdb9_1 = (RadioButton) findViewById(R.id.radioBtn9_1);
        rdb9_2 = (RadioButton) findViewById(R.id.radioBtn9_2);
        rdb10_1 = (RadioButton) findViewById(R.id.radioBtn10_1);
        rdb10_2 = (RadioButton) findViewById(R.id.radioBtn10_2);
        rdb10_3 = (RadioButton) findViewById(R.id.radioBtn10_3);
        rdb11_1 = (RadioButton) findViewById(R.id.radioBtn11_1);
        rdb11_2 = (RadioButton) findViewById(R.id.radioBtn11_2);
        rdb12_1 = (RadioButton) findViewById(R.id.radioBtn12_1);
        rdb12_2 = (RadioButton) findViewById(R.id.radioBtn12_2);
        rdb13_1 = (RadioButton) findViewById(R.id.radioBtn13_1);
        rdb13_2 = (RadioButton) findViewById(R.id.radioBtn13_2);
        rdb14_1 = (RadioButton) findViewById(R.id.radioBtn14_1);
        rdb14_2 = (RadioButton) findViewById(R.id.radioBtn14_2);
        rdb15_1 = (RadioButton) findViewById(R.id.radioBtn15_1);
        rdb15_2 = (RadioButton) findViewById(R.id.radioBtn15_2);
        rdb16_1 = (RadioButton) findViewById(R.id.radioBtn16_1);
        rdb16_2 = (RadioButton) findViewById(R.id.radioBtn16_2);
        rdb17_1 = (RadioButton) findViewById(R.id.radioBtn17_1);
        rdb17_2 = (RadioButton) findViewById(R.id.radioBtn17_2);
        rdb18_1 = (RadioButton) findViewById(R.id.radioBtn18_1);
        rdb18_2 = (RadioButton) findViewById(R.id.radioBtn18_2);

        layoutButtonGroup = (LinearLayout) findViewById(R.id.layoutNavigation);
    }

    public void intentSubmitEstimateGX160(View view) {
        ArrayList<String> arrNameList = new ArrayList<String>();
        ArrayList<Integer> arrSelectedID = new ArrayList<Integer>();

        //Get id and text from RadioButton.
        idSelectedEngine = rdgCheckEngine.getCheckedRadioButtonId();
        rdbSelectedEngine = (RadioButton) findViewById(idSelectedEngine);
        arrSelectedID.add(idxSelectedEngine = rdgCheckEngine.indexOfChild(rdbSelectedEngine));
        arrNameList.add(rdbSelectedEngine.getText().toString());

        //Check can start or not. 0 = The engine can starts, 1 = The engine can't starts.
        if (idxSelectedEngine == 0) {
            /*No1 = จานกระตุกชุด*/
            idSelectedStarter = rdg1.getCheckedRadioButtonId();
            rdbSelectedStarter = (RadioButton) findViewById(idSelectedStarter);
            arrSelectedID.add(idxSelectedStarter = rdg1.indexOfChild(rdbSelectedStarter));
            arrNameList.add(rdbSelectedStarter.getText().toString());

            /*No2 = ถังน้ำมัน*/
            idSelectedFuelTank = rdg2.getCheckedRadioButtonId();
            rdbSelectedFuelTank = (RadioButton) findViewById(idSelectedFuelTank);
            arrSelectedID.add(idxSelectedFuelTank = rdg2.indexOfChild(rdbSelectedFuelTank));
            arrNameList.add(rdbSelectedFuelTank.getText().toString());

            /*No3 = มือเร่ง*/
            idSelectedControlSwitch = rdg3.getCheckedRadioButtonId();
            rdbSelectedControlSwitch = (RadioButton) findViewById(idSelectedControlSwitch);
            arrSelectedID.add(idxSelectedControlSwitch = rdg3.indexOfChild(rdbSelectedControlSwitch));
            arrNameList.add(rdbSelectedControlSwitch.getText().toString());

            /*No4 = ใบมีด*/
            idSelectedBrushCutterBlade = rdg4.getCheckedRadioButtonId();
            rdbSelectedBrushCutterBlade = (RadioButton) findViewById(idSelectedBrushCutterBlade);
            arrSelectedID.add(idxSelectedBrushCutterBlade = rdg4.indexOfChild(rdbSelectedBrushCutterBlade));
            arrNameList.add(rdbSelectedBrushCutterBlade.getText().toString());

            /*No5 = หม้อกรองอากาศ*/
            idSelectedAirFilter = rdg5.getCheckedRadioButtonId();
            rdbSelectedAirFilter = (RadioButton) findViewById(idSelectedAirFilter);
            arrSelectedID.add(idxSelectedAirFilter = rdg5.indexOfChild(rdbSelectedAirFilter));
            arrNameList.add(rdbSelectedAirFilter.getText().toString());

            /*No6 = คาร์บูเรเตอร์*/
            idSelectedCarburetor = rdg6.getCheckedRadioButtonId();
            rdbSelectedCarburetor = (RadioButton) findViewById(idSelectedCarburetor);
            arrSelectedID.add(idxSelectedCarburetor = rdg6.indexOfChild(rdbSelectedCarburetor));
            arrNameList.add(rdbSelectedCarburetor.getText().toString());

            /*No7 = เสื้อสูบ */
            idSelectedCylinderSet = rdg7.getCheckedRadioButtonId();
            rdbSelectedCylinderSet = (RadioButton) findViewById(idSelectedCylinderSet);
            arrSelectedID.add(idxSelectedCylinderSet = rdg7.indexOfChild(rdbSelectedCylinderSet));
            arrNameList.add(rdbSelectedCylinderSet.getText().toString());

            /*No8 = ก๊อกน้ำมัน*/
            idSelectedBallValveSwitchOil = rdg8.getCheckedRadioButtonId();
            rdbSelectedBallValveSwitchOil = (RadioButton) findViewById(idSelectedBallValveSwitchOil);
            arrSelectedID.add(idxSelectedBallValveSwitchOil = rdg8.indexOfChild(rdbSelectedBallValveSwitchOil));
            arrNameList.add(rdbSelectedBallValveSwitchOil.getText().toString());

            /*No9 = ท่อไอเสีย*/
            idSelectedMuffler = rdg9.getCheckedRadioButtonId();
            rdbSelectedMuffler = (RadioButton) findViewById(idSelectedMuffler);
            arrSelectedID.add(idxSelectedMuffler = rdg9.indexOfChild(rdbSelectedMuffler));
            arrNameList.add(rdbSelectedMuffler.getText().toString());

            /*No10 = คอตัดหญ้า*/
            idSelectedGearDiver = rdg10.getCheckedRadioButtonId();
            rdbSelectedGearDiver = (RadioButton) findViewById(idSelectedGearDiver);
            arrSelectedID.add(idxSelectedGearDiver = rdg10.indexOfChild(rdbSelectedGearDiver));
            arrNameList.add(rdbSelectedGearDiver.getText().toString());

            /*No11 = กระบอกหาง*/
            idSelectedMainPipe = rdg11.getCheckedRadioButtonId();
            rdbSelectedMainPipe = (RadioButton) findViewById(idSelectedMainPipe);
            arrSelectedID.add(idxSelectedMainPipe = rdg11.indexOfChild(rdbSelectedMainPipe));
            arrNameList.add(rdbSelectedMainPipe.getText().toString());

             /*No12 = สวิตช์ปิดเปิด*/
            idSelectedSwitchOnOff = rdg12.getCheckedRadioButtonId();
            rdbSelectedSwitchOnOff = (RadioButton) findViewById(idSelectedSwitchOnOff);
            arrSelectedID.add(idxSelectedSwitchOnOff = rdg12.indexOfChild(rdbSelectedSwitchOnOff));
            arrNameList.add(rdbSelectedSwitchOnOff.getText().toString());

             /*No13 = คอยล์ */
            idSelectedCoil = rdg13.getCheckedRadioButtonId();
            rdbSelectedCoil = (RadioButton) findViewById(idSelectedCoil);
            arrSelectedID.add(idxSelectedCoil = rdg13.indexOfChild(rdbSelectedCoil));
            arrNameList.add(rdbSelectedCoil.getText().toString());

             /*No14 = ฝาถังน้ำมัน*/
            idSelectedFuelTankCap = rdg14.getCheckedRadioButtonId();
            rdbSelectedFuelTankCap = (RadioButton) findViewById(idSelectedFuelTankCap);
            arrSelectedID.add(idxSelectedFuelTankCap = rdg14.indexOfChild(rdbSelectedFuelTankCap));
            arrNameList.add(rdbSelectedFuelTankCap.getText().toString());

             /*No15 = ทำสี */
            idSelectedNewPaint = rdg15.getCheckedRadioButtonId();
            rdbSelectedNewPaint = (RadioButton) findViewById(idSelectedNewPaint);
            arrSelectedID.add(idxSelectedNewPaint = rdg15.indexOfChild(rdbSelectedNewPaint));
            arrNameList.add(rdbSelectedNewPaint.getText().toString());

             /*No16 = แกนเพลา*/
            idSelectedShaft = rdg16.getCheckedRadioButtonId();
            rdbSelectedShaft = (RadioButton) findViewById(idSelectedShaft);
            arrSelectedID.add(idxSelectedShaft = rdg16.indexOfChild(rdbSelectedShaft));
            arrNameList.add(rdbSelectedShaft.getText().toString());

             /*No17 = ฝาถังน้ำมันเครื่อง */
            idSelectedOilTankCap = rdg17.getCheckedRadioButtonId();
            rdbSelectedOilTankCap = (RadioButton) findViewById(idSelectedOilTankCap);
            arrSelectedID.add(idxSelectedOilTankCap = rdg17.indexOfChild(rdbSelectedOilTankCap));
            arrNameList.add(rdbSelectedOilTankCap.getText().toString());

             /*No18 = ปลั๊กหัวเทียน*/
            idSelectedSparkPlug = rdg18.getCheckedRadioButtonId();
            rdbSelectedSparkPlug = (RadioButton) findViewById(idSelectedSparkPlug);
            arrSelectedID.add(idxSelectedSparkPlug = rdg18.indexOfChild(rdbSelectedSparkPlug));
            arrNameList.add(rdbSelectedSparkPlug.getText().toString());

        } else {
            /*No1 = จานกระตุกชุด */
            idSelectedStarter = rdg1.getCheckedRadioButtonId();
            rdbSelectedStarter = (RadioButton) findViewById(idSelectedStarter);
            arrSelectedID.add(idxSelectedStarter = rdg1.indexOfChild(rdbSelectedStarter));
            arrNameList.add(rdbSelectedStarter.getText().toString());

            /*No2 = ถังน้ำมัน*/
            idSelectedFuelTank = rdg2.getCheckedRadioButtonId();
            rdbSelectedFuelTank = (RadioButton) findViewById(idSelectedFuelTank);
            arrSelectedID.add(idxSelectedFuelTank = rdg2.indexOfChild(rdbSelectedFuelTank));
            arrNameList.add(rdbSelectedFuelTank.getText().toString());

            /*No3 = มือเร่ง*/
            idSelectedControlSwitch = rdg3.getCheckedRadioButtonId();
            rdbSelectedControlSwitch = (RadioButton) findViewById(idSelectedControlSwitch);
            arrSelectedID.add(idxSelectedControlSwitch = rdg3.indexOfChild(rdbSelectedControlSwitch));
            arrNameList.add(rdbSelectedControlSwitch.getText().toString());

            /*No4 = ใบมีด*/
            idSelectedBrushCutterBlade = rdg4.getCheckedRadioButtonId();
            rdbSelectedBrushCutterBlade = (RadioButton) findViewById(idSelectedBrushCutterBlade);
            arrSelectedID.add(idxSelectedBrushCutterBlade = rdg4.indexOfChild(rdbSelectedBrushCutterBlade));
            arrNameList.add(rdbSelectedBrushCutterBlade.getText().toString());

            /*No5 = หม้อกรองอากาศ*/
            idSelectedAirFilter = rdg5.getCheckedRadioButtonId();
            rdbSelectedAirFilter = (RadioButton) findViewById(idSelectedAirFilter);
            arrSelectedID.add(idxSelectedAirFilter = rdg5.indexOfChild(rdbSelectedAirFilter));
            arrNameList.add(rdbSelectedAirFilter.getText().toString());

            /*No8 = ก๊อกน้ำมัน*/
            idSelectedBallValveSwitchOil = rdg8.getCheckedRadioButtonId();
            rdbSelectedBallValveSwitchOil = (RadioButton) findViewById(idSelectedBallValveSwitchOil);
            arrSelectedID.add(idxSelectedBallValveSwitchOil = rdg8.indexOfChild(rdbSelectedBallValveSwitchOil));
            arrNameList.add(rdbSelectedBallValveSwitchOil.getText().toString());

            /*No9 = ท่อไอเสีย */
            idSelectedMuffler = rdg9.getCheckedRadioButtonId();
            rdbSelectedMuffler = (RadioButton) findViewById(idSelectedMuffler);
            arrSelectedID.add(idxSelectedMuffler = rdg9.indexOfChild(rdbSelectedMuffler));
            arrNameList.add(rdbSelectedMuffler.getText().toString());

            /*No10 = คอตัดหญ้า*/
            idSelectedGearDiver = rdg10.getCheckedRadioButtonId();
            rdbSelectedGearDiver = (RadioButton) findViewById(idSelectedGearDiver);
            arrSelectedID.add(idxSelectedGearDiver = rdg10.indexOfChild(rdbSelectedGearDiver));
            arrNameList.add(rdbSelectedGearDiver.getText().toString());

            /*No11 = กระบอกหาง*/
            idSelectedMainPipe = rdg11.getCheckedRadioButtonId();
            rdbSelectedMainPipe = (RadioButton) findViewById(idSelectedMainPipe);
            arrSelectedID.add(idxSelectedMainPipe = rdg11.indexOfChild(rdbSelectedMainPipe));
            arrNameList.add(rdbSelectedMainPipe.getText().toString());

             /*No12 = สวิตช์ปิดเปิด*/
            idSelectedSwitchOnOff = rdg12.getCheckedRadioButtonId();
            rdbSelectedSwitchOnOff = (RadioButton) findViewById(idSelectedSwitchOnOff);
            arrSelectedID.add(idxSelectedSwitchOnOff = rdg12.indexOfChild(rdbSelectedSwitchOnOff));
            arrNameList.add(rdbSelectedSwitchOnOff.getText().toString());

             /*No14 = ฝาถังน้ำมัน*/
            idSelectedFuelTankCap = rdg14.getCheckedRadioButtonId();
            rdbSelectedFuelTankCap = (RadioButton) findViewById(idSelectedFuelTankCap);
            arrSelectedID.add(idxSelectedFuelTankCap = rdg14.indexOfChild(rdbSelectedFuelTankCap));
            arrNameList.add(rdbSelectedFuelTankCap.getText().toString());

             /*No15 = ทำสี */
            idSelectedNewPaint = rdg15.getCheckedRadioButtonId();
            rdbSelectedNewPaint = (RadioButton) findViewById(idSelectedNewPaint);
            arrSelectedID.add(idxSelectedNewPaint = rdg15.indexOfChild(rdbSelectedNewPaint));
            arrNameList.add(rdbSelectedNewPaint.getText().toString());

             /*No16 = แกนเพลา*/
            idSelectedShaft = rdg16.getCheckedRadioButtonId();
            rdbSelectedShaft = (RadioButton) findViewById(idSelectedShaft);
            arrSelectedID.add(idxSelectedShaft = rdg16.indexOfChild(rdbSelectedShaft));
            arrNameList.add(rdbSelectedShaft.getText().toString());

             /*No17 = ฝาถังน้ำมันเครื่อง */
            idSelectedOilTankCap = rdg17.getCheckedRadioButtonId();
            rdbSelectedOilTankCap = (RadioButton) findViewById(idSelectedOilTankCap);
            arrSelectedID.add(idxSelectedOilTankCap = rdg17.indexOfChild(rdbSelectedOilTankCap));
            arrNameList.add(rdbSelectedOilTankCap.getText().toString());

             /*No18 = ปลั๊กหัวเทียน*/
            idSelectedSparkPlug = rdg18.getCheckedRadioButtonId();
            rdbSelectedSparkPlug = (RadioButton) findViewById(idSelectedSparkPlug);
            arrSelectedID.add(idxSelectedSparkPlug = rdg18.indexOfChild(rdbSelectedSparkPlug));
            arrNameList.add(rdbSelectedSparkPlug.getText().toString());

        }


        Intent intentSubmitEstimateGX160 = new Intent(this, SubmitEstimateGX35.class);
        intentSubmitEstimateGX160.putExtra("idxEngine", idxSelectedEngine);
        intentSubmitEstimateGX160.putStringArrayListExtra("arrListName", arrNameList);
        intentSubmitEstimateGX160.putIntegerArrayListExtra("arrSelectedID", arrSelectedID);
        Log.d("arrListName : ", arrNameList.toString());
        Log.d("arrSelectID : ", arrSelectedID.toString());
        startActivity(intentSubmitEstimateGX160);

    }

}
