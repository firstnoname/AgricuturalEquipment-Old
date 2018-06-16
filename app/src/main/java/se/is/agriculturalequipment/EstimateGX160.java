package se.is.agriculturalequipment;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.menu.MenuView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class EstimateGX160 extends AppCompatActivity {

    //Test new logic.
    private RadioGroup rdgCheckEngine, rdg1, rdg2, rdg3, rdg4, rdg5, rdg6, rdg7, rdg8, rdg9, rdg10, rdg11,rdg12,rdg13;

    private RadioButton rdbEngineTrue, rdbEngineFalse, rdb1_1, rdb1_2,rdb1_3,
            rdb2_1, rdb2_2,
            rdb3_1, rdb3_2,rdb3_3,
            rdb4_1, rdb4_2,
            rdb5_1, rdb5_2,
            rdb6_1, rdb6_2,
            rdb7_1, rdb7_2,
            rdb8_1, rdb8_2,
            rdb9_1, rdb9_2,
            rdb10_1, rdb10_2,
            rdb11_1, rdb11_2,
            rdb12_1,rdb12_2,
            rdb13_1,rdb13_2;

    private RadioButton rdbSelectedEngine, rdbSelectedStarter, rdbSelectedFuelTank, rdbSelectedAirFilter,
            rdbSelectedCarburetor, rdbSelectedCylinderSet, rdbSelectedBallValveSwitchOil, rdbSelectedMuffler, rdbSelectedSwitchOnOff,
            rdbSelectedCoil, rdbSelectedFuelTankCap, rdbSelectedNewPaint,rdbSelectedOilTankCap,rdbSelectedSparkPlug;

    private Integer idSelectedEngine, idSelectedStarter, idSelectedFuelTank, idSelectedAirFilter,
            idSelectedCarburetor, idSelectedCylinderSet, idSelectedBallValveSwitchOil, idSelectedMuffler, idSelectedSwitchOnOff,
            idSelectedCoil, idSelectedFuelTankCap, idSelectedNewPaint,idSelectedOilTankCap,idSelectedSparkPlug;

    private Integer idxSelectedEngine, idxSelectedStarter, idxSelectedFuelTank, idxSelectedAirFilter,
            idxSelectedCarburetor, idxSelectedCylinderSet, idxSelectedBallValveSwitchOil, idxSelectedMuffler, idxSelectedSwitchOnOff,
            idxSelectedCoil, idxSelectedFuelTankCap, idxSelectedNewPaint,idxSelectedOilTankCap,idxSelectedSparkPlug;

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
                rdg5.setVisibility(View.GONE);
                rdg6.setVisibility(View.VISIBLE);
                rdg7.setVisibility(View.VISIBLE);
                rdg8.setVisibility(View.VISIBLE);
                rdg9.setVisibility(View.VISIBLE);
                rdg10.setVisibility(View.VISIBLE);
                rdg11.setVisibility(View.VISIBLE);
                rdg12.setVisibility(View.VISIBLE);
                rdg13.setVisibility(View.VISIBLE);

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
                rdg4.setVisibility(View.GONE);
                rdg5.setVisibility(View.GONE);
                rdg6.setVisibility(View.VISIBLE);
                rdg7.setVisibility(View.VISIBLE);
                rdg8.setVisibility(View.VISIBLE);
                rdg9.setVisibility(View.GONE);
                rdg10.setVisibility(View.VISIBLE);
                rdg11.setVisibility(View.VISIBLE);
                rdg12.setVisibility(View.VISIBLE);
                rdg13.setVisibility(View.VISIBLE);

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

    public void intentSubmitEstimateGX160(View view){

        ArrayList<String> arrNameList = new ArrayList<String>();
        ArrayList<Integer> arrSelectedID = new ArrayList<Integer>();

        //Get id and text from RadioButton.
        idSelectedEngine = rdgCheckEngine.getCheckedRadioButtonId();
        rdbSelectedEngine = (RadioButton) findViewById(idSelectedEngine);
        arrSelectedID.add(idxSelectedEngine = rdgCheckEngine.indexOfChild(rdbSelectedEngine));
        arrNameList.add(rdbSelectedEngine.getText().toString());

//        Check can start or not. 0 = The engine can starts, 1 = The engine can't starts.
        if(idxSelectedEngine == 0){

            /*No1 = จานกระตุกชุด*/
            idSelectedStarter = rdg1.getCheckedRadioButtonId();
            rdbSelectedStarter = (RadioButton) findViewById(idSelectedStarter);
            arrSelectedID.add(idxSelectedStarter = rdg1.indexOfChild(rdbSelectedStarter));
            arrNameList.add(rdbSelectedStarter.getText().toString());

            /*No2 = ถังน้ำมัน*/
            idSelectedFuelTank = rdg2.getCheckedRadioButtonId();
            rdbSelectedFuelTank= (RadioButton) findViewById(idSelectedFuelTank);
            arrSelectedID.add(idxSelectedFuelTank= rdg2.indexOfChild(rdbSelectedFuelTank));
            arrNameList.add(rdbSelectedFuelTank.getText().toString());

            /*No3 = หม้อกรองอากาศ*/
            idSelectedAirFilter= rdg3.getCheckedRadioButtonId();
            rdbSelectedAirFilter= (RadioButton) findViewById(idSelectedAirFilter);
            arrSelectedID.add(idxSelectedAirFilter= rdg3.indexOfChild(rdbSelectedAirFilter));
            arrNameList.add(rdbSelectedAirFilter.getText().toString());

            /*No4 = คาร์บูเรเตอร์*/
            idSelectedCarburetor= rdg4.getCheckedRadioButtonId();
            rdbSelectedCarburetor= (RadioButton) findViewById(idSelectedCarburetor);
            arrSelectedID.add(idxSelectedCarburetor= rdg4.indexOfChild(rdbSelectedCarburetor));
            arrNameList.add(rdbSelectedCarburetor.getText().toString());

            /*No5 = เสื้อสูบ */
            /*idSelectedCylinderSet= rdg5.getCheckedRadioButtonId();
            rdbSelectedCylinderSet= (RadioButton) findViewById(idSelectedCylinderSet);
            arrSelectedID.add(idxSelectedCylinderSet= rdg5.indexOfChild(rdbSelectedCylinderSet));
            arrNameList.add(rdbSelectedCylinderSet.getText().toString());*/

            /*No6 = ก๊อกน้ำมัน*/
            idSelectedBallValveSwitchOil= rdg6.getCheckedRadioButtonId();
            rdbSelectedBallValveSwitchOil= (RadioButton) findViewById(idSelectedBallValveSwitchOil);
            arrSelectedID.add(idxSelectedBallValveSwitchOil= rdg6.indexOfChild(rdbSelectedBallValveSwitchOil));
            arrNameList.add(rdbSelectedBallValveSwitchOil.getText().toString());

            /*No7 = ท่อไอเสีย*/
            idSelectedMuffler= rdg7.getCheckedRadioButtonId();
            rdbSelectedMuffler= (RadioButton) findViewById(idSelectedMuffler);
            arrSelectedID.add(idxSelectedMuffler= rdg7.indexOfChild(rdbSelectedMuffler));
            arrNameList.add(rdbSelectedMuffler.getText().toString());

            /*No8 = สวิตช์ปิดเปิด*/
            idSelectedSwitchOnOff= rdg8.getCheckedRadioButtonId();
            rdbSelectedSwitchOnOff= (RadioButton) findViewById(idSelectedSwitchOnOff);
            arrSelectedID.add(idxSelectedSwitchOnOff= rdg8.indexOfChild(rdbSelectedSwitchOnOff));
            arrNameList.add(rdbSelectedSwitchOnOff.getText().toString());

            /*No9 = คอยล์*/
            idSelectedCoil= rdg9.getCheckedRadioButtonId();
            rdbSelectedCoil= (RadioButton) findViewById(idSelectedCoil);
            arrSelectedID.add(idxSelectedCoil= rdg9.indexOfChild(rdbSelectedCoil));
            arrNameList.add(rdbSelectedCoil.getText().toString());

            /*No10 = ฝาถังน้ำมัน */
            idSelectedFuelTankCap= rdg10.getCheckedRadioButtonId();
            rdbSelectedFuelTankCap= (RadioButton) findViewById(idSelectedFuelTankCap);
            arrSelectedID.add(idxSelectedFuelTankCap= rdg10.indexOfChild(rdbSelectedFuelTankCap));
            arrNameList.add(rdbSelectedFuelTankCap.getText().toString());

            /*No11 = ทำสี */
            idSelectedNewPaint= rdg11.getCheckedRadioButtonId();
            rdbSelectedNewPaint= (RadioButton) findViewById(idSelectedNewPaint);
            arrSelectedID.add(idxSelectedNewPaint= rdg11.indexOfChild(rdbSelectedNewPaint));
            arrNameList.add(rdbSelectedNewPaint.getText().toString());

            /*No12 = ฝาถังน้ำมันเครื่อง */
            idSelectedOilTankCap = rdg12.getCheckedRadioButtonId();
            rdbSelectedOilTankCap = (RadioButton) findViewById(idSelectedOilTankCap);
            arrSelectedID.add(idxSelectedOilTankCap = rdg12.indexOfChild(rdbSelectedOilTankCap));
            arrNameList.add(rdbSelectedOilTankCap.getText().toString());


            /*No13 = ปลั๊กหัวเทียน  */
            idSelectedSparkPlug= rdg13.getCheckedRadioButtonId();
            rdbSelectedSparkPlug= (RadioButton) findViewById(idSelectedSparkPlug);
            arrSelectedID.add(idxSelectedSparkPlug= rdg13.indexOfChild(rdbSelectedSparkPlug));
            arrNameList.add(rdbSelectedSparkPlug.getText().toString());



        }else{
            idSelectedStarter = rdg1.getCheckedRadioButtonId();
            rdbSelectedStarter = (RadioButton) findViewById(idSelectedStarter);
            arrSelectedID.add(idxSelectedStarter = rdg1.indexOfChild(rdbSelectedStarter));
            arrNameList.add(rdbSelectedStarter.getText().toString());

            /*No2 = สังน้ำมัน*/
            idSelectedFuelTank= rdg2.getCheckedRadioButtonId();
            rdbSelectedFuelTank= (RadioButton) findViewById(idSelectedFuelTank);
            arrSelectedID.add(idxSelectedFuelTank= rdg2.indexOfChild(rdbSelectedFuelTank));
            arrNameList.add(rdbSelectedFuelTank.getText().toString());

            /*No3 = หม้อกรองอากาศ */
            idSelectedAirFilter= rdg3.getCheckedRadioButtonId();
            rdbSelectedAirFilter= (RadioButton) findViewById(idSelectedAirFilter);
            arrSelectedID.add(idxSelectedAirFilter= rdg3.indexOfChild(rdbSelectedAirFilter));
            arrNameList.add(rdbSelectedAirFilter.getText().toString());

            /*No5 = เสื้อสูบ*/
            /*idSelectedCylinderSet= rdg5.getCheckedRadioButtonId();
            rdbSelectedCylinderSet= (RadioButton) findViewById(idSelectedCylinderSet);
            arrSelectedID.add(idxSelectedCylinderSet= rdg5.indexOfChild(rdbSelectedCylinderSet));
            arrNameList.add(rdbSelectedCylinderSet.getText().toString());*/

            /*No6 = ทก๊อกน้ำมัน*/
            idSelectedBallValveSwitchOil= rdg6.getCheckedRadioButtonId();
            rdbSelectedBallValveSwitchOil= (RadioButton) findViewById(idSelectedBallValveSwitchOil);
            arrSelectedID.add(idxSelectedBallValveSwitchOil= rdg6.indexOfChild(rdbSelectedBallValveSwitchOil));
            arrNameList.add(rdbSelectedBallValveSwitchOil.getText().toString());

            /*No7 = ท่อไอเสีย*/
            idSelectedMuffler= rdg7.getCheckedRadioButtonId();
            rdbSelectedMuffler= (RadioButton) findViewById(idSelectedMuffler);
            arrSelectedID.add(idxSelectedMuffler= rdg7.indexOfChild(rdbSelectedMuffler));
            arrNameList.add(rdbSelectedMuffler.getText().toString());

            /*No8 = สวิตช์ปิดเปิด */
            idSelectedSwitchOnOff= rdg8.getCheckedRadioButtonId();
            rdbSelectedSwitchOnOff= (RadioButton) findViewById(idSelectedSwitchOnOff);
            arrSelectedID.add(idxSelectedSwitchOnOff= rdg8.indexOfChild(rdbSelectedSwitchOnOff));
            arrNameList.add(rdbSelectedSwitchOnOff.getText().toString());

            /*No10 = ฝาถังน้ำมัน*/
            idSelectedFuelTankCap= rdg10.getCheckedRadioButtonId();
            rdbSelectedFuelTankCap= (RadioButton) findViewById(idSelectedFuelTankCap);
            arrSelectedID.add(idxSelectedFuelTankCap= rdg10.indexOfChild(rdbSelectedFuelTankCap));
            arrNameList.add(rdbSelectedFuelTankCap.getText().toString());


            /*No11 = ทำสี*/
            idSelectedNewPaint= rdg11.getCheckedRadioButtonId();
            rdbSelectedNewPaint= (RadioButton) findViewById(idSelectedNewPaint);
            arrSelectedID.add(idxSelectedNewPaint= rdg11.indexOfChild(rdbSelectedNewPaint));
            arrNameList.add(rdbSelectedNewPaint.getText().toString());

            /*No12 = ฝาถังน้ำมันเครื่อง */
            idSelectedOilTankCap= rdg12.getCheckedRadioButtonId();
            rdbSelectedOilTankCap= (RadioButton) findViewById(idSelectedOilTankCap);
            arrSelectedID.add(idxSelectedOilTankCap= rdg12.indexOfChild(rdbSelectedOilTankCap));
            arrNameList.add(rdbSelectedOilTankCap.getText().toString());


            /*No13 = ปลั๊กหัวเทียน*/
            idSelectedSparkPlug= rdg13.getCheckedRadioButtonId();
            rdbSelectedSparkPlug= (RadioButton) findViewById(idSelectedSparkPlug);
            arrSelectedID.add(idxSelectedSparkPlug= rdg13.indexOfChild(rdbSelectedSparkPlug));
            arrNameList.add(rdbSelectedSparkPlug.getText().toString());
        }


        Intent intentSubmitEstimateGX160 = new Intent(this, SubmitEstimateGX160.class);
        intentSubmitEstimateGX160.putExtra("idxEngine", idxSelectedEngine);
        intentSubmitEstimateGX160.putStringArrayListExtra("arrListName",arrNameList);
        intentSubmitEstimateGX160.putIntegerArrayListExtra("arrSelectedID", arrSelectedID);
        Log.d("arrListName : ", arrNameList.toString());
        Log.d("arrSelectID : ", arrSelectedID.toString());
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
            rdb12_1.setChecked(true);
            rdb13_1.setChecked(true);
        }else {
            //Can't start.
            rdb1_1.setChecked(true);
            rdb2_1.setChecked(true);
            rdb3_1.setChecked(true);
            rdb5_1.setChecked(true);
            rdb6_1.setChecked(true);
            rdb7_1.setChecked(true);
            rdb8_1.setChecked(true);
            rdb10_1.setChecked(true);
            rdb11_1.setChecked(true);
            rdb12_1.setChecked(true);
            rdb13_1.setChecked(true);
        }

    }

    public void txtViewClickedGX160(View view) {
        AlertDialog.Builder mBuilder = new AlertDialog.Builder(EstimateGX160.this);
        View mView = getLayoutInflater().inflate(R.layout.custom_dialog, null);
        ImageView mImage = (ImageView) mView.findViewById(R.id.imageGuide);
        ImageView mImageL = (ImageView) mView.findViewById(R.id.imageGuideLeft);
        TextView mText = (TextView) mView.findViewById(R.id.txtGuideDialog);

        switch (view.getId()) {
            case R.id.txtViewEngine:
                //Do something.
                mText.setText("ตรวจสอบว่าสตาร์ทติดหรือไม่");
//                Toast.makeText(this, "Engine has clicked", Toast.LENGTH_SHORT).show();
                break;
            case R.id.txtViewStarter:
                //Do something.
                mImage.setImageResource(R.drawable.gx160_starter_change);
                mImageL.setImageResource(R.drawable.gx160_starter_not);
                mText.setText("จานกระตุกเครื่อง พิจารณา 3 แบบ คือ\n" +
                        "1.\tเปลี่ยนทั่งชุดของจานกระตุก คือ จานกระตุกไม่สามารถใช้ได้เลยกระชากแล้วไม่เกาะเครื่อง ไม่สามารถทำการ สตาทเครื่องได้\n" +
                        "2.\tเปลี่ยนเฉพาะเชือกกระตุก คือ จานกระตุกสามารถหมุนเกาะเครื่องได้พียงแต่เชือกที่ใช้ในการกระชากชำรุดเสียหาย\n" +
                        "3.\tไม่ต้องเปลี่ยนจานกระตุก คือ การทำงานสมบูรณ์ดี\n");
//                Toast.makeText(this, "Starter has clicked", Toast.LENGTH_SHORT).show();
                break;
            case R.id.txtViewFuelTank:
                //Do something.
                mImage.setImageResource(R.drawable.gx160_fueltank_change);
                mImageL.setImageResource(R.drawable.gx160_fueltank_not);
                mText.setText("ถังน้ำมันเครื่อง พิจารณา 2 แบบ\n" +
                        "1.\tเปลี่ยนถังน้ำมัน ในกรณีที่ถังมีรอยแตกร้าวหรือตัวรูที่ใส่ตัวกรองน้ำมันชำรุดไม่สามารถใช้งานได้\n" +
                        "2.\tไม่เปลี่ยน ในกรณีที่ สภาพสมบูรณ์ไม่มีรอยแตกร้าวให้เห็นใส่น้ำมันแล้วไม่มีรอยรั่ว\n");
//                Toast.makeText(this, "Fuel tank has clicked", Toast.LENGTH_SHORT).show();
                break;
            case R.id.txtViewAirFilter:
                //Do something.
                mImage.setImageResource(R.drawable.gx160_airfilter_change);
                mImageL.setImageResource(R.drawable.gx160_airfilter_not);
                mText.setText("หม้อกรองอากาศ พิจารณา 3 แบบ คือ\n" +
                        "1.\tเปลี่ยนเฉพาะไส้กรองอากาศ คือ ตัวหม้อกรองอากาศไม่มีรอยแตกหรือชำรุดในส่วนของการยึดติดกับตัวเครื่อง แต่ตัวไส้กรองมีการชำรุดหรือสกปรก\n" +
                        "2.\tเปลี่ยนทั้งลูก คือ ตัวหม้อกรองชำรุดเสียหายทั้งหมด หรือ ชำรุดในส่วนของการยึดติดกับตัวเครื่อง\n" +
                        "3.\tไม่ต้องเปลี่ยน คือ สามารถใช้งานได้ปกติ\n");
//                Toast.makeText(this, "Air Filter has clicked", Toast.LENGTH_SHORT).show();
                break;
            case R.id.txtViewCarburetor:
                mImage.setImageResource(R.drawable.gx160_carburetor_change);
                mImageL.setImageResource(R.drawable.gx160_carburetor_not);
                mText.setText("คาร์บูเรเตอร์ เป็นตัวที่ใช้ในการเร่งเครื่องยนต์ว่าจะให้เบาหรือจะให้เร่งเครื่อง พิจารณา 2 แบบ คือ\n" +
                        "1.\tเปลี่ยนใหม่ คือ น้ำมันเครื่องเบนซินไม่สามารถไหลผ่านคาร์บูเรเตอร์ , เครื่องยนต์ไม่สามารถเร่งหรือเบาได้ ,เข็มเร่งที่เป็นตัวเปิดปิดอากาศไม่สามารถทำงานได้\n" +
                        "2.\tไม่เปลี่ยน คือ สามารถทำงานได้ปกติ\n");
//                Toast.makeText(this, "Carburetor has clicked", Toast.LENGTH_SHORT).show();
                break;
            case R.id.txtViewCylinderSet:
                mText.setText("เสื้อสูบ เป็นส่วนที่สำคัญของตัวเครื่อง พิจารณา 2 แบบ\n" +
                        "1.\tเปลี่ยนเสื้อสูบ ในกรณีที่จานกระตุกไม่สามารถหมุนได้ หรือ หมุนแล้วมีเสียงดังที่ผิดปกติ\n" +
                        "2.\tไม่เปลี่ยน ในกรณี ที่สามารถหมุนจานกระตุก และไม่มีเสียงดังที่ผิดปกติ\n");
//                Toast.makeText(this, "CylinderSet has clicked", Toast.LENGTH_SHORT).show();
                break;
            case R.id.txtViewBallValveSwitchOil:
                mImage.setImageResource(R.drawable.gx160_ballvalveswitchoil_change);
                mImageL.setImageResource(R.drawable.gx160_ballvalveswitchoil_not);
                mText.setText("ก๊อกน้ำมันเครื่องเบนซิน พิจารณา 2 แบบ คือ\n" +
                        "1.\tเปลี่ยนใหม่ คือ น้ำมันไม่สามารถไหลผ่านได้ , ตัวกรองที่อยู่ในก๊อกชำรุดเสียหาย , ตัวก๊อกไม่อยู่ในสภาพที่ทำงานได้,ปิดก๊อกแล้วแต่น้ำมันเบนซินยังไหลอยู่\n" +
                        "2.\tไม่เปลี่ยน คือ สามารถทำงานได้ปกติ\n");
//                Toast.makeText(this, "Ball switch oil has clicked", Toast.LENGTH_SHORT).show();
                break;
            case R.id.txtViewMuffler:
                mImage.setImageResource(R.drawable.gx160_muffler_change);
                mImageL.setImageResource(R.drawable.gx160_muffler_not);
                mText.setText("ท่อไอเสีย พิจารณา 2 แบบ คือ\n" +
                        "1.\tเปลี่ยนใหม่ คือ ท่อไอเสียแตกหรือสภาพไม่พร้อมในการใช้งาน\n" +
                        "2.\tไม่เปลี่ยน  คือ พร้อมในการใช้งานไม่เป็นสนิทหรือแตก\n");
//                Toast.makeText(this, "Muffler has clicked", Toast.LENGTH_SHORT).show();
                break;
            case R.id.txtViewSwitchOnOff:
                mImage.setImageResource(R.drawable.gx160_switch_on_off_change);
                mImageL.setImageResource(R.drawable.gx160_switch_on_off_not);
                mText.setText("วิตช์ปิดเปิดเครื่อง พิจารณา 2 แบบ คือ\n" +
                        "1.\tเปลี่ยนใหม่ คือ ไม่อยู่ในสภาพที่ใช้งานได้ ตัวสวิตช์มีสายขาดหรือปรับปิดเปิดเครื่องไม่ได้\n" +
                        "2.\tไม่เปลี่ยน คือ สามารถใช้งานได้ปกติ\n");
//                Toast.makeText(this, "Switch on-off has clicked", Toast.LENGTH_SHORT).show();
                break;
            case R.id.txtViewCoil:
                mText.setText("คอยล์ เป็นตัวจุดระเบิดเครื่องว่าเครื่องจะสามารถใช้งานได้หรือไม่  พิจารณา 2 แบบ คือ\n" +
                        "12.1.\tเปลี่ยนใหม่ คือ ตัวคอยล์ไม่มีไฟ พิจารณาจากการหมุนจานกระตุกแล้วนำสายไฟไปใกล้กับตัวเครื่องจะไม่มีไฟออกมา\n" +
                        "12.2.\tไม่เปลี่ยน คือ คอยล์มีไฟออกเมื่อหมุนจานกระตุกแล้วนำสายไฟไปใกล้กับตัวเครื่อง\n");
//                Toast.makeText(this, "Coil has clicked", Toast.LENGTH_SHORT).show();
                break;
            case R.id.txtViewFuelTankCap:
                mImage.setImageResource(R.drawable.gx160_fueltankcap_change);
                mImageL.setImageResource(R.drawable.gx160_fueltankcap_not);
                mText.setText("ฝาถังน้ำมันเบนซิน พิจารณาว่า ปิดแล้วน้ำมันรั่วออกจากตัวถังหรือไม่ รั่วจะต้องเปลี่ยน ปิดแล้วไม่มีการรั่วไม่ต้องทำการเปลี่ยน");
//                Toast.makeText(this, "Fuel Tank Cap has clicked", Toast.LENGTH_SHORT).show();
                break;
            case R.id.txtViewNewPaint:
                mImage.setImageResource(R.drawable.gx160_new_paint_change);
                mImageL.setImageResource(R.drawable.gx160_new_paint_not);
                mText.setText("สีตัวเครื่องจะดูแยกเป็น 2 ส่วน คือ ส่วนของถังน้ำมัน และ ส่วนของตัวเครื่องหรือฝากระโปรง โดยจะพิจารณาว่า ต้องทำสีใหม่ในกรณีที่มีสนิมหรือสีมีการหลุดลอกให้เห็น และไม่ต้องทำสี");
//                Toast.makeText(this, "Muffler has clicked", Toast.LENGTH_SHORT).show();
                break;
            case R.id.txtViewOilTankCap:
                mImage.setImageResource(R.drawable.gx160_oil_filter_change);
                mImageL.setImageResource(R.drawable.gx160_oil_filter_not);
                mText.setText("ฝาถังน้ำมันเครื่อง พิจารณา 2 แบบ คือพิจารณาว่า ปิดแล้วน้ำมันรั่วออกจากตัวถังหรือไม่ รั่วจะต้องเปลี่ยน ปิดแล้วไม่มีการรั่วไม่ต้องทำการเปลี่ยน");
//                Toast.makeText(this, "Oil Tank Cap clicked", Toast.LENGTH_SHORT).show();
                break;
            case R.id.txtViewSparkPlug:
                mImage.setImageResource(R.drawable.gx160_spark_plug_change);
                mImageL.setImageResource(R.drawable.gx160_spark_plug_not);
                mText.setText("ปลั๊กหัวเทียนจะเป็นส่วนของคอยล์ที่จะเป็นตัวจุดระเบิดเครื่องทำให้เครื่องทำงานได้ พิจารณา 2 แบบ คือ\n" +
                        "1.\tเปลี่ยนใหม่ คือ สายขาดหรือไม่อยู่ในสภาพที่ใช้งานได้\n" +
                        "2.\tไม่เปลี่ยน คือ สามารถทำงานได้ปกติ\n");
//                Toast.makeText(this, "Spark plug has clicked", Toast.LENGTH_SHORT).show();
                break;
        }

        mBuilder.setView(mView);
        AlertDialog dialog = mBuilder.create();
        dialog.show();
    }

}
