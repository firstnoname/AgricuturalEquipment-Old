package se.is.agriculturalequipment;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class EstimateG200 extends AppCompatActivity {

    //Test new logic.
    private RadioGroup rdgCheckEngine, rdg1, rdg2, rdg3, rdg4, rdg5, rdg6, rdg7, rdg8, rdg9, rdg10,
                rdg11, rdg12, rdg13;

    private RadioButton rdbEngineTrue, rdbEngineFalse,
            rdb1_1, rdb1_2, rdb1_3,
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
            rdb12_1, rdb12_2,
            rdb13_1, rdb13_2;

    private RadioButton rdbSelectedEngine, rdbSelectedStarter, rdbSelectedFuelTank, rdbSelectedAirFilter,
        rdbSelectedCarburetor, rdbSelectedCylinderSet, rdbSelectedBallValveSwitchOil, rdbSelectedMuffler,
        rdbSelectedSwitchOnOff, rdbSelectedCoil, rdbSelectedFuelTankCap, rdbSelectedNewPaint, rdbSelectedOilTankCap,
        rdbSelectedSparkPlug;

    private Integer idSelectedEngine, idSelectedStarter, idSelectedFuelTank, idSelectedAirFilter,
        idSelectedCarburetor, idSelectedCylinderSet, idSelectedBallValveSwitchOil, idSelectedMuffler,
        idSelectedSwitchOnOff, idSelectedCoil, idSelectedFuelTankCap, idSelectedNewPaint, idSelectedOilTankCap,
        idSelectedSparkPlug;

    private Integer idxSelectedEngine, idxSelectedStarter, idxSelectedFuelTank, idxSelectedAirFilter,
            idxSelectedCarburetor, idxSelectedCylinderSet, idxSelectedBallValveSwitchOil, idxSelectedMuffler,
            idxSelectedSwitchOnOff, idxSelectedCoil, idxSelectedFuelTankCap, idxSelectedNewPaint, idxSelectedOilTankCap,
            idxSelectedSparkPlug;

    private LinearLayout layoutButtonGroup;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estimate_g200);

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

                layoutButtonGroup.setVisibility(View.VISIBLE);

                setDefaultSelect(0);

            }
        });

        rdbEngineFalse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rdbEngineTrue.setChecked(false);
                rdg1.setVisibility(View.GONE);
                rdg2.setVisibility(View.VISIBLE);
                rdg3.setVisibility(View.VISIBLE);
                rdg4.setVisibility(View.GONE);
                rdg5.setVisibility(View.VISIBLE);
                rdg6.setVisibility(View.GONE);
                rdg7.setVisibility(View.VISIBLE);
                rdg8.setVisibility(View.VISIBLE);
                rdg9.setVisibility(View.GONE);
                rdg10.setVisibility(View.VISIBLE);
                rdg11.setVisibility(View.VISIBLE);
                rdg12.setVisibility(View.VISIBLE);
                rdg13.setVisibility(View.VISIBLE);
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

        rdbEngineFalse = (RadioButton) findViewById(R.id.radioBtnEngineFalse);
        rdbEngineTrue = (RadioButton) findViewById(R.id.radioBtnEngineTrue);
        rdb1_1 = (RadioButton) findViewById(R.id.radioBtn1_1);
        rdb1_2 = (RadioButton) findViewById(R.id.radioBtn1_2);
        rdb1_3 = (RadioButton) findViewById(R.id.radioBtn1_3);
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
        rdb13_1 = (RadioButton) findViewById(R.id.radioBtn13_1);
        rdb13_2 = (RadioButton) findViewById(R.id.radioBtn13_2);

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

        layoutButtonGroup.setVisibility(View.GONE);
    }

    public void intentSubmitEstimateG200(View view){

        ArrayList<String> arrNameList = new ArrayList<String>();
        ArrayList<Integer> arrSelectedID = new ArrayList<Integer>();


        //Get id and text from RadioButton.
        idSelectedEngine = rdgCheckEngine.getCheckedRadioButtonId();
        rdbSelectedEngine = (RadioButton) findViewById(idSelectedEngine);
        arrSelectedID.add(idxSelectedEngine = rdgCheckEngine.indexOfChild(rdbSelectedEngine));
        arrNameList.add(rdbSelectedEngine.getText().toString());
//        Check can start or not. 0 = The engine can starts, 1 = The engine can't starts.
        if(idxSelectedEngine==0){

            /*No1 = สีตัวเครื่องโดยรวม*/
            idSelectedStarter = rdg1.getCheckedRadioButtonId();
            rdbSelectedStarter = (RadioButton) findViewById(idSelectedStarter);
            arrSelectedID.add(idxSelectedStarter = rdg1.indexOfChild(rdbSelectedStarter));
            arrNameList.add(rdbSelectedStarter.getText().toString());

            /*No2 = ฝาถังน้ำมันเบนซิน*/
            idSelectedFuelTank = rdg2.getCheckedRadioButtonId();
            rdbSelectedFuelTank = (RadioButton) findViewById(idSelectedFuelTank);
            arrSelectedID.add(idxSelectedFuelTank = rdg2.indexOfChild(rdbSelectedFuelTank));
            arrNameList.add(rdbSelectedFuelTank.getText().toString());

            /*No3 = ฝาถังน้ำมันเครื่อง*/
            idSelectedAirFilter = rdg3.getCheckedRadioButtonId();
            rdbSelectedAirFilter = (RadioButton) findViewById(idSelectedAirFilter);
            arrSelectedID.add(idxSelectedAirFilter = rdg3.indexOfChild(rdbSelectedAirFilter));
            arrNameList.add(rdbSelectedAirFilter.getText().toString());

            /*No4 = จานกระตุก*/
            idSelectedCarburetor = rdg4.getCheckedRadioButtonId();
            rdbSelectedCarburetor = (RadioButton) findViewById(idSelectedCarburetor);
            arrSelectedID.add(idxSelectedCarburetor = rdg4.indexOfChild(rdbSelectedCarburetor));
            arrNameList.add(rdbSelectedCarburetor.getText().toString());

            /*No5 = ท่อไอเสีย*/
            idSelectedCylinderSet = rdg5.getCheckedRadioButtonId();
            rdbSelectedCylinderSet = (RadioButton) findViewById(idSelectedCylinderSet);
            arrSelectedID.add(idxSelectedCylinderSet = rdg5.indexOfChild(rdbSelectedCylinderSet));
            arrNameList.add(rdbSelectedCylinderSet.getText().toString());

            /*No6 = ปลั๊กหัวเทียน*/
            idSelectedBallValveSwitchOil = rdg6.getCheckedRadioButtonId();
            rdbSelectedBallValveSwitchOil = (RadioButton) findViewById(idSelectedBallValveSwitchOil);
            arrSelectedID.add(idxSelectedBallValveSwitchOil = rdg6.indexOfChild(rdbSelectedBallValveSwitchOil));
            arrNameList.add(rdbSelectedBallValveSwitchOil.getText().toString());

            /*No7 = คาร์บูเรเตอร์*/
            idSelectedMuffler = rdg7.getCheckedRadioButtonId();
            rdbSelectedMuffler = (RadioButton) findViewById(idSelectedMuffler);
            arrSelectedID.add(idxSelectedMuffler = rdg7.indexOfChild(rdbSelectedMuffler));
            arrNameList.add(rdbSelectedMuffler.getText().toString());

            /*No8 = CDI*/
            idSelectedSwitchOnOff = rdg8.getCheckedRadioButtonId();
            rdbSelectedSwitchOnOff = (RadioButton) findViewById(idSelectedSwitchOnOff);
            arrSelectedID.add(idxSelectedSwitchOnOff = rdg8.indexOfChild(rdbSelectedSwitchOnOff));
            arrNameList.add(rdbSelectedSwitchOnOff.getText().toString());

            /*No9 = ก๊อกน้ำมัน*/
            idSelectedCoil = rdg9.getCheckedRadioButtonId();
            rdbSelectedCoil = (RadioButton) findViewById(idSelectedCoil);
            arrSelectedID.add(idxSelectedCoil = rdg9.indexOfChild(rdbSelectedCoil));
            arrNameList.add(rdbSelectedCoil.getText().toString());

            /*No10 = หม้อกรองอากาศ*/
            idSelectedFuelTankCap = rdg10.getCheckedRadioButtonId();
            rdbSelectedFuelTankCap = (RadioButton) findViewById(idSelectedFuelTankCap);
            arrSelectedID.add(idxSelectedFuelTankCap = rdg10.indexOfChild(rdbSelectedFuelTankCap));
            arrNameList.add(rdbSelectedFuelTankCap.getText().toString());

            /*No11 = สวิตท์เปิด ปิด*/
            idSelectedNewPaint = rdg11.getCheckedRadioButtonId();
            rdbSelectedNewPaint = (RadioButton) findViewById(idSelectedNewPaint);
            arrSelectedID.add(idxSelectedNewPaint = rdg11.indexOfChild(rdbSelectedNewPaint));
            arrNameList.add(rdbSelectedNewPaint.getText().toString());

            /*No12 */
            idSelectedOilTankCap = rdg12.getCheckedRadioButtonId();
            rdbSelectedOilTankCap = (RadioButton) findViewById(idSelectedOilTankCap);
            arrSelectedID.add(idxSelectedOilTankCap = rdg12.indexOfChild(rdbSelectedOilTankCap));
            arrNameList.add(rdbSelectedOilTankCap.getText().toString());

            /*No13 */
            idSelectedSparkPlug = rdg13.getCheckedRadioButtonId();
            rdbSelectedSparkPlug = (RadioButton) findViewById(idSelectedSparkPlug);
            arrSelectedID.add(idxSelectedSparkPlug = rdg13.indexOfChild(rdbSelectedSparkPlug));
            arrNameList.add(rdbSelectedSparkPlug.getText().toString());
        }else{

            /*No2 = ฝาถังน้ำมันเบนซิน*/
            idSelectedFuelTank = rdg2.getCheckedRadioButtonId();
            rdbSelectedFuelTank = (RadioButton) findViewById(idSelectedFuelTank);
            arrSelectedID.add(idxSelectedFuelTank = rdg2.indexOfChild(rdbSelectedFuelTank));
            arrNameList.add(rdbSelectedFuelTank.getText().toString());

            /*No3 = ฝาถังน้ำมันเครื่อง*/
            idSelectedAirFilter = rdg3.getCheckedRadioButtonId();
            rdbSelectedAirFilter = (RadioButton) findViewById(idSelectedAirFilter);
            arrSelectedID.add(idxSelectedAirFilter = rdg3.indexOfChild(rdbSelectedAirFilter));
            arrNameList.add(rdbSelectedAirFilter.getText().toString());

            /*No5 = ท่อไอเสีย*/
            idSelectedCylinderSet = rdg5.getCheckedRadioButtonId();
            rdbSelectedCylinderSet = (RadioButton) findViewById(idSelectedCylinderSet);
            arrSelectedID.add(idxSelectedCylinderSet = rdg5.indexOfChild(rdbSelectedCylinderSet));
            arrNameList.add(rdbSelectedCylinderSet.getText().toString());

            /*No7 = คาร์บูเรเตอร์*/
            idSelectedMuffler = rdg7.getCheckedRadioButtonId();
            rdbSelectedMuffler = (RadioButton) findViewById(idSelectedMuffler);
            arrSelectedID.add(idxSelectedMuffler = rdg7.indexOfChild(rdbSelectedMuffler));
            arrNameList.add(rdbSelectedMuffler.getText().toString());

            /*No8 = CDI*/
            idSelectedSwitchOnOff = rdg8.getCheckedRadioButtonId();
            rdbSelectedSwitchOnOff = (RadioButton) findViewById(idSelectedSwitchOnOff);
            arrSelectedID.add(idxSelectedSwitchOnOff = rdg8.indexOfChild(rdbSelectedSwitchOnOff));
            arrNameList.add(rdbSelectedSwitchOnOff.getText().toString());

            /*No10 = หม้อกรองอากาศ*/
            idSelectedFuelTankCap = rdg10.getCheckedRadioButtonId();
            rdbSelectedFuelTankCap = (RadioButton) findViewById(idSelectedFuelTankCap);
            arrSelectedID.add(idxSelectedFuelTankCap = rdg10.indexOfChild(rdbSelectedFuelTankCap));
            arrNameList.add(rdbSelectedFuelTankCap.getText().toString());

            /*No11 = สวิตท์เปิด ปิด*/
            idSelectedNewPaint = rdg11.getCheckedRadioButtonId();
            rdbSelectedNewPaint = (RadioButton) findViewById(idSelectedNewPaint);
            arrSelectedID.add(idxSelectedNewPaint = rdg11.indexOfChild(rdbSelectedNewPaint));
            arrNameList.add(rdbSelectedNewPaint.getText().toString());

            /*No12 */
            idSelectedOilTankCap = rdg12.getCheckedRadioButtonId();
            rdbSelectedOilTankCap = (RadioButton) findViewById(idSelectedOilTankCap);
            arrSelectedID.add(idxSelectedOilTankCap = rdg12.indexOfChild(rdbSelectedOilTankCap));
            arrNameList.add(rdbSelectedOilTankCap.getText().toString());

            /*No13 */
            idSelectedSparkPlug = rdg13.getCheckedRadioButtonId();
            rdbSelectedSparkPlug = (RadioButton) findViewById(idSelectedSparkPlug);
            arrSelectedID.add(idxSelectedSparkPlug = rdg13.indexOfChild(rdbSelectedSparkPlug));
            arrNameList.add(rdbSelectedSparkPlug.getText().toString());
        }

        Intent intentSubmitEstimateG200 = new Intent(this, SubmitEstimateG200.class);
        intentSubmitEstimateG200.putExtra("idxEngine", idxSelectedEngine);
        intentSubmitEstimateG200.putStringArrayListExtra("arrListName",arrNameList);
        intentSubmitEstimateG200.putIntegerArrayListExtra("arrSelectedID", arrSelectedID);
        startActivity(intentSubmitEstimateG200);

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
            rdb12_1.setChecked(true);
            rdb13_1.setChecked(true);
        }else {
            //Can't start.
            rdb2_1.setChecked(true);
            rdb3_1.setChecked(true);
            rdb5_1.setChecked(true);
            rdb7_1.setChecked(true);
            rdb8_1.setChecked(true);
            rdb10_1.setChecked(true);
            rdb11_1.setChecked(true);
            rdb12_1.setChecked(true);
            rdb13_1.setChecked(true);
        }

    }

    public void guideEngine(View view){
        //Toast.makeText(this, "Engine guide", Toast.LENGTH_SHORT).show();
        AlertDialog.Builder mBuilder = new AlertDialog.Builder(EstimateG200.this);
        View mView = getLayoutInflater().inflate(R.layout.custom_dialog, null);

        mBuilder.setView(mView);
        AlertDialog dialog = mBuilder.create();
        dialog.show();
    }

    public void guideFuelTank(View view) {
        AlertDialog.Builder mBuilder = new AlertDialog.Builder(EstimateG200.this);
        View mView = getLayoutInflater().inflate(R.layout.custom_dialog, null);

        mBuilder.setView(mView);
        AlertDialog dialog = mBuilder.create();
        dialog.show();
    }

    public void guideAirFilter(View view) {
        AlertDialog.Builder mBuilder = new AlertDialog.Builder(EstimateG200.this);
        View mView = getLayoutInflater().inflate(R.layout.custom_dialog, null);

        mBuilder.setView(mView);
        AlertDialog dialog = mBuilder.create();
        dialog.show();
    }

    //Get id from textview and change image follow the textview name.
    public void txtViewClicked(View view) {
        AlertDialog.Builder mBuilder = new AlertDialog.Builder(EstimateG200.this);
        View mView = getLayoutInflater().inflate(R.layout.custom_dialog,null);
        ImageView mImage = (ImageView) mView.findViewById(R.id.imageGuide);
        TextView mText = (TextView) mView.findViewById(R.id.txtGuideDialog);

        switch (view.getId()) {
            case R.id.txtViewEngine:
                //Do something.
                mImage.setImageResource(R.drawable.g200_test);
                mText.setText("ตรวจสอบว่าสตาร์ทติดหรือไม่");
//                Toast.makeText(this, "Engine has clicked", Toast.LENGTH_SHORT).show();
                break;
            case R.id.txtViewStarter:
                //Do something.
                mImage.setImageResource(R.drawable.gx_35);
                mText.setText("ตรวจสอบชุดจานกระตุก");
//                Toast.makeText(this, "Starter has clicked", Toast.LENGTH_SHORT).show();
                break;
            case R.id.txtViewFuelTank:
                //Do something.
                mImage.setImageResource(R.drawable.g200_ima3097);
                mText.setText("ตรวจสอบถังน้ำมัน");
//                Toast.makeText(this, "Fuel tank has clicked", Toast.LENGTH_SHORT).show();
                break;
            case R.id.txtViewAirFilter:
                //Do something.
                mImage.setImageResource(R.drawable.g200_ima3076);
                mText.setText("ตรวจสอบหม้อกรองอากาศ");
//                Toast.makeText(this, "Air Filter has clicked", Toast.LENGTH_SHORT).show();
                break;
            case R.id.txtViewCarburetor:
                mImage.setImageResource(R.drawable.g200_ima3077);
                mText.setText("ตรวจสอบคร์บิวเรเตอร์");
//                Toast.makeText(this, "Carburetor has clicked", Toast.LENGTH_SHORT).show();
                break;
            case R.id.txtViewCylinderSet:
                mImage.setImageResource(R.drawable.g200_ima3078);
                mText.setText("ตรวจสอบเสื้อสูบ");
//                Toast.makeText(this, "CylinderSet has clicked", Toast.LENGTH_SHORT).show();
                break;
            case R.id.txtViewBallValveSwitchOil:
                mImage.setImageResource(R.drawable.g200_ima3079);
                mText.setText("ตรวจสอบก๊อกน้ำมัน");
//                Toast.makeText(this, "Ball switch oil has clicked", Toast.LENGTH_SHORT).show();
                break;
            case R.id.txtViewMuffler:
                mImage.setImageResource(R.drawable.g200_ima3098);
                mText.setText("ตรวจสอบท่อไอเสีย");
//                Toast.makeText(this, "Muffler has clicked", Toast.LENGTH_SHORT).show();
                break;
            case R.id.txtViewSwitchOnOff:
                mImage.setImageResource(R.drawable.g200_ima3082);
                mText.setText("ตรวจสอบสวิตช์เปิดปิด");
//                Toast.makeText(this, "Switch on-off has clicked", Toast.LENGTH_SHORT).show();
                break;
            case R.id.txtViewCoil:
                mImage.setImageResource(R.drawable.g200_ima3083);
                mText.setText("ตรวจสอบคอยล์");
//                Toast.makeText(this, "Coil has clicked", Toast.LENGTH_SHORT).show();
                break;
            case R.id.txtViewFuelTankCap:
                mImage.setImageResource(R.drawable.g200_ima3084);
                mText.setText("ตรวจสอฝาถังน้ำมัน");
//                Toast.makeText(this, "Fuel Tank Cap has clicked", Toast.LENGTH_SHORT).show();
                break;
            case R.id.txtViewNewPaint:
                mImage.setImageResource(R.drawable.g200_ima3085);
                mText.setText("ตรวจสอบทำสี");
//                Toast.makeText(this, "Muffler has clicked", Toast.LENGTH_SHORT).show();
                break;
            case R.id.txtViewOilTankCap:
                mImage.setImageResource(R.drawable.g200_ima3086);
                mText.setText("ตรวจสอบฝาถังน้ำมัน");
//                Toast.makeText(this, "Oil Tank Cap clicked", Toast.LENGTH_SHORT).show();
                break;
            case R.id.txtViewSparkPlug:
                mImage.setImageResource(R.drawable.g200_ima3087);
                mText.setText("ตรวจสอบปลั๊คหัวเทียน");
//                Toast.makeText(this, "Spark plug has clicked", Toast.LENGTH_SHORT).show();
                break;
        }

        mBuilder.setView(mView);
        AlertDialog dialog = mBuilder.create();
        dialog.show();

    }
}
