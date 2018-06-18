package se.is.agriculturalequipment;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class EstimateT200 extends AppCompatActivity {
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
            rdbSelectedMuffler, rdbSelectedGearDiver, rdbSelectedMainPipe, rdbSelectedSwitchOnOff, rdbSelectedCoil,
            rdbSelectedFuelTankCap, rdbSelectedNewPaint, rdbSelectedShaft, rdbSelectedOilTankCap, rdbSelectedSparkPlug;

    private Integer idSelectedEngine, idSelectedStarter, idSelectedFuelTank, idSelectedControlSwitch,
            idSelectedBrushCutterBlade, idSelectedAirFilter, idSelectedCarburetor, idSelectedCylinderSet, idSelectedBallValveSwitchOil,
            idSelectedMuffler, idSelectedGearDiver, idSelectedMainPipe, idSelectedSwitchOnOff, idSelectedCoil,
            idSelectedFuelTankCap, idSelectedNewPaint, idSelectedShaft, idSelectedOilTankCap, idSelectedSparkPlug;

    private Integer idxSelectedEngine, idxSelectedStarter, idxSelectedFuelTank, idxSelectedControlSwitch,
            idxSelectedBrushCutterBlade, idxSelectedAirFilter, idxSelectedCarburetor, idxSelectedCylinderSet, idxSelectedBallValveSwitchOil,
            idxSelectedMuffler, idxSelectedGearDiver, idxSelectedMainPipe, idxSelectedSwitchOnOff, idxSelectedCoil,
            idxSelectedFuelTankCap, idxSelectedNewPaint, idxSelectedShaft, idxSelectedOilTankCap, idxSelectedSparkPlug;

    private LinearLayout layoutButtonGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estimate_t200);

        bindWidget();

        hideRadioGroup();

        rdbEngineTrue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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
                rdg12.setVisibility(View.GONE);
                rdg13.setVisibility(View.VISIBLE);
                rdg14.setVisibility(View.GONE);
                rdg15.setVisibility(View.GONE);
                rdg16.setVisibility(View.VISIBLE);
                rdg17.setVisibility(View.VISIBLE);
                rdg18.setVisibility(View.VISIBLE);


                layoutButtonGroup.setVisibility(View.VISIBLE);

                setDefaultSelect(0);
            }
        });

        rdbEngineFalse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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
                rdg12.setVisibility(View.GONE);
                rdg13.setVisibility(View.GONE);
                rdg14.setVisibility(View.GONE);
                rdg15.setVisibility(View.GONE);
                rdg16.setVisibility(View.GONE);
                rdg17.setVisibility(View.GONE);
                rdg18.setVisibility(View.VISIBLE);

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

    public void intentSubmitEstimateT200(View view) {

        ArrayList<String> arrNameList = new ArrayList<String>();
        ArrayList<Integer> arrSelectedID = new ArrayList<Integer>();

        //Get id and text from RadioButton.
        idSelectedEngine = rdgCheckEngine.getCheckedRadioButtonId();
        rdbSelectedEngine = (RadioButton) findViewById(idSelectedEngine);
        arrSelectedID.add(idxSelectedEngine = rdgCheckEngine.indexOfChild(rdbSelectedEngine));
        arrNameList.add(rdbSelectedEngine.getText().toString());
//        Check can start or not. 0 = The engine can starts, 1 = The engine can't starts.
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

             /*No3 = มือเร่ง */
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

            /*No10 = คอตัดหญ้า */
            idSelectedGearDiver = rdg10.getCheckedRadioButtonId();
            rdbSelectedGearDiver = (RadioButton) findViewById(idSelectedGearDiver);
            arrSelectedID.add(idxSelectedGearDiver = rdg10.indexOfChild(rdbSelectedGearDiver));
            arrNameList.add(rdbSelectedGearDiver.getText().toString());

            /*No11 = กระบอกหาง */
            idSelectedMainPipe = rdg11.getCheckedRadioButtonId();
            rdbSelectedMainPipe = (RadioButton) findViewById(idSelectedMainPipe);
            arrSelectedID.add(idxSelectedMainPipe = rdg11.indexOfChild(rdbSelectedMainPipe));
            arrNameList.add(rdbSelectedMainPipe.getText().toString());

            /*No12 = สวิตช์ปิดเปิด*/
            /*idSelectedSwitchOnOff = rdg12.getCheckedRadioButtonId();
            rdbSelectedSwitchOnOff = (RadioButton) findViewById(idSelectedSwitchOnOff);
            arrSelectedID.add(idxSelectedSwitchOnOff = rdg12.indexOfChild(rdbSelectedSwitchOnOff));
            arrNameList.add(rdbSelectedSwitchOnOff.getText().toString());*/

            /*No13 = คอยล์*/
            idSelectedCoil = rdg13.getCheckedRadioButtonId();
            rdbSelectedCoil = (RadioButton) findViewById(idSelectedCoil);
            arrSelectedID.add(idxSelectedCoil = rdg13.indexOfChild(rdbSelectedCoil));
            arrNameList.add(rdbSelectedCoil.getText().toString());

            /*No14 = ฝาถังน้ำมัน */
            /*idSelectedFuelTankCap = rdg14.getCheckedRadioButtonId();
            rdbSelectedFuelTankCap = (RadioButton) findViewById(idSelectedFuelTankCap);
            arrSelectedID.add(idxSelectedFuelTankCap = rdg14.indexOfChild(rdbSelectedFuelTankCap));
            arrNameList.add(rdbSelectedFuelTankCap.getText().toString());*/

            /*No15 = ทำสี */
            /*idSelectedNewPaint = rdg15.getCheckedRadioButtonId();
            rdbSelectedNewPaint = (RadioButton) findViewById(idSelectedNewPaint);
            arrSelectedID.add(idxSelectedNewPaint = rdg15.indexOfChild(rdbSelectedNewPaint));
            arrNameList.add(rdbSelectedNewPaint.getText().toString());*/

             /*No16 = แกนเพลา */
            idSelectedShaft = rdg16.getCheckedRadioButtonId();
            rdbSelectedShaft = (RadioButton) findViewById(idSelectedShaft);
            arrSelectedID.add(idxSelectedShaft = rdg16.indexOfChild(rdbSelectedShaft));
            arrNameList.add(rdbSelectedShaft.getText().toString());

            /*No17 = ฝาถังน้ำมันเครื่อง */
            idSelectedOilTankCap = rdg17.getCheckedRadioButtonId();
            rdbSelectedOilTankCap = (RadioButton) findViewById(idSelectedOilTankCap);
            arrSelectedID.add(idxSelectedOilTankCap = rdg17.indexOfChild(rdbSelectedOilTankCap));
            arrNameList.add(rdbSelectedOilTankCap.getText().toString());

            /*No18 = ปลั้คหัวเทียน*/
            idSelectedSparkPlug = rdg18.getCheckedRadioButtonId();
            rdbSelectedSparkPlug = (RadioButton) findViewById(idSelectedSparkPlug);
            arrSelectedID.add(idxSelectedSparkPlug = rdg18.indexOfChild(rdbSelectedSparkPlug));
            arrNameList.add(rdbSelectedSparkPlug.getText().toString());


        } else {
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

             /*No3 = มือเร่ง */
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

            /*No9 = ท่อไอเสีย*/
            idSelectedMuffler = rdg9.getCheckedRadioButtonId();
            rdbSelectedMuffler = (RadioButton) findViewById(idSelectedMuffler);
            arrSelectedID.add(idxSelectedMuffler = rdg9.indexOfChild(rdbSelectedMuffler));
            arrNameList.add(rdbSelectedMuffler.getText().toString());

            /*No10 = คอตัดหญ้า */
            idSelectedGearDiver = rdg10.getCheckedRadioButtonId();
            rdbSelectedGearDiver = (RadioButton) findViewById(idSelectedGearDiver);
            arrSelectedID.add(idxSelectedGearDiver = rdg10.indexOfChild(rdbSelectedGearDiver));
            arrNameList.add(rdbSelectedGearDiver.getText().toString());

            /*No11 = กระบอกหาง */
            idSelectedMainPipe = rdg11.getCheckedRadioButtonId();
            rdbSelectedMainPipe = (RadioButton) findViewById(idSelectedMainPipe);
            arrSelectedID.add(idxSelectedMainPipe = rdg11.indexOfChild(rdbSelectedMainPipe));
            arrNameList.add(rdbSelectedMainPipe.getText().toString());

            /*No12 = สวิตช์ปิดเปิด*/
            /*idSelectedSwitchOnOff = rdg12.getCheckedRadioButtonId();
            rdbSelectedSwitchOnOff = (RadioButton) findViewById(idSelectedSwitchOnOff);
            arrSelectedID.add(idxSelectedSwitchOnOff = rdg12.indexOfChild(rdbSelectedSwitchOnOff));
            arrNameList.add(rdbSelectedSwitchOnOff.getText().toString());*/

            /*No14 = ฝาถังน้ำมัน */
            /*idSelectedFuelTankCap = rdg14.getCheckedRadioButtonId();
            rdbSelectedFuelTankCap = (RadioButton) findViewById(idSelectedFuelTankCap);
            arrSelectedID.add(idxSelectedFuelTankCap = rdg14.indexOfChild(rdbSelectedFuelTankCap));
            arrNameList.add(rdbSelectedFuelTankCap.getText().toString());*/

            /*No15 = ทำสี */
            /*idSelectedNewPaint = rdg15.getCheckedRadioButtonId();
            rdbSelectedNewPaint = (RadioButton) findViewById(idSelectedNewPaint);
            arrSelectedID.add(idxSelectedNewPaint = rdg15.indexOfChild(rdbSelectedNewPaint));
            arrNameList.add(rdbSelectedNewPaint.getText().toString());*/

             /*No16 = แกนเพลา */
            idSelectedShaft = rdg16.getCheckedRadioButtonId();
            rdbSelectedShaft = (RadioButton) findViewById(idSelectedShaft);
            arrSelectedID.add(idxSelectedShaft = rdg16.indexOfChild(rdbSelectedShaft));
            arrNameList.add(rdbSelectedShaft.getText().toString());

            /*No17 = ฝาถังน้ำมันเครื่อง */
            /*idSelectedOilTankCap = rdg17.getCheckedRadioButtonId();
            rdbSelectedOilTankCap = (RadioButton) findViewById(idSelectedOilTankCap);
            arrSelectedID.add(idxSelectedOilTankCap = rdg17.indexOfChild(rdbSelectedOilTankCap));
            arrNameList.add(rdbSelectedOilTankCap.getText().toString());*/

            /*No18 = ปลั้คหัวเทียน*/
            idSelectedSparkPlug = rdg18.getCheckedRadioButtonId();
            rdbSelectedSparkPlug = (RadioButton) findViewById(idSelectedSparkPlug);
            arrSelectedID.add(idxSelectedSparkPlug = rdg18.indexOfChild(rdbSelectedSparkPlug));
            arrNameList.add(rdbSelectedSparkPlug.getText().toString());
        }


        Intent intentSubmitEstimateT200 = new Intent(this, SubmitEstimateT200.class);
        intentSubmitEstimateT200.putExtra("idxEngine", idxSelectedEngine);
        intentSubmitEstimateT200.putStringArrayListExtra("arrListName", arrNameList);
        intentSubmitEstimateT200.putIntegerArrayListExtra("arrSelectedID", arrSelectedID);
        Log.d("arrListName : ", arrNameList.toString());
        Log.d("arrSelectID : ", arrSelectedID.toString());
        startActivity(intentSubmitEstimateT200);

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
            rdb13_1.setChecked(true);
            rdb14_1.setChecked(true);
            rdb15_1.setChecked(true);
            rdb16_1.setChecked(true);
            rdb17_1.setChecked(true);
            rdb18_1.setChecked(true);
        } else {
            //Can't start.
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
            //rdb15_1.setChecked(true);
            rdb16_1.setChecked(true);
            //rdb17_1.setChecked(true);
            rdb18_1.setChecked(true);
        }

    }

    public void txtViewClickedT200(View view) {
        AlertDialog.Builder mBuilder = new AlertDialog.Builder(EstimateT200.this);
        View mView = getLayoutInflater().inflate(R.layout.custom_dialog, null);
        ImageView mImage = (ImageView)mView.findViewById(R.id.imageGuide);
        ImageView mImageL = (ImageView)mView.findViewById(R.id.imageGuideLeft);
        TextView mText = (TextView)mView.findViewById(R.id.txtGuideDialog);

        switch (view.getId()) {
            case R.id.txtViewEngine:
                mText.setText("");
                break;
            case R.id.txtViewStarter:
                mImage.setImageResource(R.drawable.t200_starter_change);
                mImageL.setImageResource(R.drawable.t200_starter_not);
                mText.setVisibility(view.INVISIBLE);
                mText.setText("จานกระตุกจานกระตุกเครื่อง พิจารณา 3 แบบ คือ\n" +
                        "1.\tเปลี่ยนทั่งชุดของจานกระตุก คือ จานกระตุกไม่สามารถใช้ได้เลยกระชากแล้วไม่เกาะเครื่อง ไม่สามารถทำการ สตาทเครื่องได้\n" +
                        "2.\tเปลี่ยนเฉพาะเชือกกระตุก คือ สามารถที่จะทำการสตาทเครื่องได้ เพียงแต่เชือกที่ใช้ในการกระชากชำรุดเสียหาย\n" +
                        "3.\tไม่ต้องเปลี่ยนจานกระตุก คือ การทำงานสมบูรณ์ดี\n");
                break;
            case R.id.txtFuelTank:
                mImage.setImageResource(R.drawable.t200_fueltank_change);
                mImageL.setImageResource(R.drawable.t200_fueltank_not);
                mText.setVisibility(view.INVISIBLE);
                mText.setText("");
                break;
            case R.id.txtViewControlSwitch:
                mImage.setImageResource(R.drawable.t200_controlswitch_change);
                mImageL.setImageResource(R.drawable.t200_controlswitch_not);
                mText.setText("มือเร่ง เป็นคันเร่งเครื่องว่าจะหนักหรือเบา พิจารณา 2 แบบ คือ\n" +
                        "1.\tเปลี่ยน คือ คันเร่งหักใช้งานไม่ได้ , สายคันเร่งขาด\n" +
                        "2.\tไม่เปลี่ยน คือ สามารถใช้งานได้ปกติ ไม่มีอากาศติดขัดระหว่างใช้งาน และสายคันเร่งไม่ฝืด\n");
                break;
            case R.id.txtViewBrushCutterBlade:
                mImage.setImageResource(R.drawable.t200_brushcutterblade_change);
                mImageL.setImageResource(R.drawable.t200_brushcutterblade_not);
                mText.setVisibility(view.INVISIBLE);
                mText.setText("ใบมีดตัดหญ้า พิจารณา 2 แบบคือ\n" +
                        "1.\tเปลี่ยน คือ ใบมีดบิ่นหรือหัก\n" +
                        "2.\tไม่เปลี่ยน คือ ใบมีดเต็มใบ ไม่บิ่นหรือหัก\n");
                break;
            case R.id.txtViewAirFilter:
                mImage.setImageResource(R.drawable.t200_airfilter_change);
                mImageL.setImageResource(R.drawable.t200_airfilter_not);
                mText.setVisibility(view.INVISIBLE);
                mText.setText("หม้อกรองอากาศ พิจารณา 3 แบบ คือ\n" +
                        "1.\tเปลี่ยนเฉพาะไส้กรองอากาศ คือ ตัวหม้อกรองไม่ชำรุดเสียหายแต่ไส้กรองสกปรกหรือเสียหาย\n" +
                        "2.\tเปลี่ยนทั้งลูก คือ ตัวหม้อกรองชำรุดเสียหายทั้งหมด หรือ ชำรุดในส่วนของการยึดติดกับตัวเครื่อง\n" +
                        "3.\tไม่ต้องเปลี่ยน คือ สามารถใช้งานได้ปกติ\n");
                break;
            case R.id.txtViewCarburetor:
                mImage.setImageResource(R.drawable.t200_carnurater_change);
                mImageL.setImageResource(R.drawable.t200_carnurater_not);
                mText.setVisibility(view.INVISIBLE);
                mText.setText("คาร์บูเรเตอร์ เป็นตัวที่ใช้ในการเร่งเครื่องยนต์ว่าจะให้เบาหรือจะให้เร่งเครื่อง พิจารณา 2 แบบ คือ\n" +
                        "1  เปลี่ยนใหม่ คือ น้ำมันเครื่องเบนซินไม่สามารถไหลผ่านคาร์บูเรเตอร์ , เครื่องยนต์ไม่สามารถเร่งหรือเบาได้ ,เข็มเร่งที่เป็นตัวเปิดปิดอากาศไม่สามารถทำงานได้\n" +
                        "2\tไม่เปลี่ยน คือ สามารถทำงานได้ปกติ \n");
                break;
            case R.id.txtViewCylinderSet:
                mText.setVisibility(view.INVISIBLE);
                mText.setText("เสื้อสูบ พิจารณา 2 แบบ คือ\n" +
                        "1เปลี่ยนทั้งเสื้อสูบ คือ หมุนมูเลย์หรือจานกระตุกที่ติดมากับเครื่องแล้วไม่สามารถ หมุนได้แสดงว่าลูกสูบที่อยู่ข้างในมีอาการติดขัดหรือเสื้อสูบอาจเป็นรอยได้ , เสื้อสูบมีรอยแต่หรือชำรุด\n" +
                        "2ไม่เปลี่ยน คือ มีแรงอัด เสื้อสูบไม่ชำรุดเสียหาย สามารถใช้งานได้ปก\n");
                break;
            case R.id.txtViewBallValveSwitchOil:
                mImage.setImageResource(R.drawable.t200_ballvalveswitch_change);
                mImageL.setImageResource(R.drawable.t200_ballvalveswitch_not);
                mText.setVisibility(view.INVISIBLE);
                mText.setText("ก๊อกน้ำมันเครื่องเบนซิน พิจารณา 2 แบบ คือ\n" +
                        "1เปลี่ยนใหม่ คือ น้ำมันไม่สามารถไหลผ่านได้ , ตัวกรองที่อยู่ในก๊อกชำรุดเสียหาย , ตัวก๊อกไม่อยู่ในสภาพที่ทำงานได้,ปิดก๊อกแล้วแต่น้ำมันเบนซินยังไหลอยู่\n" +
                        "2ไม่เปลี่ยน คือ สามารถทำงานได้ปกติ\n");
                break;
            case R.id.txtViewMuffler:
                mImage.setImageResource(R.drawable.t200_muffler_change);
                mImageL.setImageResource(R.drawable.t200_muffler_not);
                mText.setVisibility(view.INVISIBLE);
                mText.setText("ท่อไอเสีย พิจารณา 2 แบบ คือ\n" +
                        "1.\tเปลี่ยนใหม่ คือ ท่อไอเสียแตกหรือสภาพไม่พร้อมในการใช้งาน\n" +
                        "2.\tไม่เปลี่ยน  คือ พร้อมในการใช้งาน\n");
                break;
            case R.id.txtViewGearDiver:
                mImage.setImageResource(R.drawable.t200_geardiver_change);
                mImageL.setImageResource(R.drawable.t200_geardiver_not);
                mText.setVisibility(view.INVISIBLE);
                mText.setText("คอตัดหญ้า พิจารณา 3 แบบ คือ\n" +
                        "1.\tเปลี่ยนทั้งชุด คือ คอตัดหญ้ามีรอยแตก\n" +
                        "2.\tเปลี่ยนเฉพาะเฟื่องที่อยู่ในคอตัดหญ้า  คือ คอตัดหญ้าไม่มีรอยแตกหักแต่ตรงใบมีดหมุนฟรี หรือไม่สามารถหมุนได้\n" +
                        "3.\tไม่เปลี่ยน คือ สามารถใช้งานได้ปกติ ไม่มีอาการติดขัด\n");
                break;
            case R.id.txtViewMainPipe:
                mImage.setImageResource(R.drawable.t200_mainpipe_change);
                mImageL.setImageResource(R.drawable.t200_mainpipe_not);
                mText.setVisibility(view.INVISIBLE);
                mText.setText("กระบอกหางเครื่องตัดหญ้า พิจารณา 2 แบบ คือ\n" +
                        "5.1.\tเปลี่ยน คือ กระบอกหางขาด , ไม่อยู่ในสภาพที่ใช้งานได้\n" +
                        "5.2.\tไม่เปลี่ยน คือ กระบอกหางอยู่ในสภาพที่ใช้งานได้\n");
                break;
            case R.id.txtViewSwitchOnOff:
                mText.setText("");
                break;
            case R.id.txtViewCoil:
                mText.setText("");
                break;
            case R.id.txtViewFuelTankCap:
                mImage.setImageResource(R.drawable.t200_fueltankcap_change);
                mImageL.setImageResource(R.drawable.t200_fueltankcap_not);
                mText.setVisibility(view.INVISIBLE);
                mText.setText("ถังน้ำมัน พิจารณา 2 แบบ คือ\n" +
                        "1.\tเปลี่ยนใหม่ คือ ถังน้ำมันชำรุดไม่สามารถเก็บน้ำมันเบนซินไว้ได้ , ไม่สามารถยึดติดกับตัวเครื่องได้\n" +
                        "2.\tไม่เปลี่ยน คือ ถังน้ำมันไม่ชำรุด สามารถยึดติดกับตัวเครื่องได้\n");
                break;
            case R.id.txtViewNewPaint:
                mText.setVisibility(view.INVISIBLE);
                mText.setText("");
                break;
            case R.id.txtViewShaft:
                mText.setVisibility(view.INVISIBLE);
                mText.setText("แกนเพลา พิจารณา 2 แบบ\n" +
                        "1.\tเปลี่ยนแกนเพลา ในกรณี เครื่องสตาร์ติด บีบคันเร่งแล้วใบมีดไม่หมุน\n" +
                        "2.\tไม่เปลี่ยนแกนเพลา ในกรณี เครื่องสตาร์ทติด เร่งเครื่องแล้วใบมีดหมุน\n");
                break;
            case R.id.txtViewOilTankCap:
                mText.setVisibility(view.INVISIBLE);
                mText.setText("ฝาถังน้ำมันเครื่อง พิจารณา 2 แบบ คือพิจารณาว่า ปิดแล้วน้ำมันรั่วออกจากตัวถังหรือไม่ รั่วจะต้องเปลี่ยน ปิดแล้วไม่มีการรั่วไม่ต้องทำการเปลี่ยน");
                break;
            case  R.id.txtViewSparkPlug:

        }

        mBuilder.setView(mView);
        AlertDialog dialog = mBuilder.create();
        dialog.show();

    }

}
