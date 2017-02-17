package se.is.agriculturalequipment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import org.w3c.dom.Text;

import static android.R.attr.value;

public class SubmitEstimateG200 extends AppCompatActivity {

    private Integer getEngine, getBodyColor, getFuelTankCap, getOilFilter, getStarter, getMuffler,
        getSparkPlug, getCarburetor, getCoilCDI, getBallValueSwitchOil, getAirFilter, getSwitchOnOff;

    private String strEngine, strBodyColor, strFuelTankCap, strOilFilter, strStarter, strMuffler,
            strSparkPlug,strCarburetor, strCoilCDI, strBallValueSwitchOil, strAirFilter,
            strSwitchOnOff;

    private String[] textNameArray, strRepairPriceArray;
    //private Double[] repairPriceArray;

    private ListView listViewEstimatedG200;

    private Double repairEngine = 0.0,
            repairBodyColor = 0.0,
            repairFuelTankCap = 0.0,
            repairOilFilter = 0.0,
            repairStarter = 0.0,
            repairMuffler = 0.0,
            repairSparkPlug = 0.0,
            repairCarburetor = 0.0,
            repairCoilCDI = 0.0,
            repairBallValueSwitchOil = 0.0,
            repairAirFilter = 0.0,
            repairSwitchOnOff = 0.0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submit_estimate_g200);

        //
        Bundle bundle = getIntent().getExtras();
        getEngine = bundle.getInt("Engine");
        getBodyColor = bundle.getInt("BodyColor");
        getFuelTankCap = bundle.getInt("FuelTankCap");
        getOilFilter = bundle.getInt("OilFilter");
        getStarter = bundle.getInt("Starter");
        getMuffler = bundle.getInt("Muffler");
        getSparkPlug = bundle.getInt("SparkPlug");
        getCarburetor = bundle.getInt("Carburetor");
        getCoilCDI = bundle.getInt("CoilCDI");
        getBallValueSwitchOil = bundle.getInt("BallValueSwitchOil");
        getAirFilter = bundle.getInt("AirFilter");
        getSwitchOnOff = bundle.getInt("SwitchOnOff");

        setRepair();

        String[] value = {
                String.valueOf(getEngine),
                String.valueOf(getBodyColor),
                String.valueOf(getFuelTankCap),
                String.valueOf(getOilFilter),
                String.valueOf(getStarter),
                String.valueOf(getMuffler),
                String.valueOf(getSparkPlug),
                String.valueOf(getCarburetor),
                String.valueOf(getCoilCDI),
                String.valueOf(getBallValueSwitchOil),
                String.valueOf(getAirFilter),
                String.valueOf(getSwitchOnOff)};

        textNameArray = new String[] {
                strEngine,
                strBodyColor,
                strFuelTankCap,
                strOilFilter,
                strStarter,
                strMuffler,
                strSparkPlug,
                strCarburetor,
                strCoilCDI,
                strBallValueSwitchOil,
                strAirFilter,
                strSwitchOnOff
        };

//        repairPriceArray = new Double[]{
//                repairBodyColor,
//                repairFuelTankCap,
//                repairOilFilter,
//                repairStarter,
//                repairMuffler,
//                repairSparkPlug,
//                repairCarburetor,
//                repairCoilCDI,
//                repairBallValueSwitchOil,
//                repairAirFilter,
//                repairSwitchOnOff
//        };

        bindWidget();
        createListView();

//        Toast.makeText(SubmitEstimateG200.this, "0 " + value[0] + " : " + strEngine, Toast.LENGTH_SHORT).show();
//        Toast.makeText(SubmitEstimateG200.this, "1 " + value[1] + " : " + strBodyColor, Toast.LENGTH_SHORT).show();
//        Toast.makeText(SubmitEstimateG200.this, "2 " + value[2] + " : " + strFuelTankCap, Toast.LENGTH_SHORT).show();
//        Toast.makeText(SubmitEstimateG200.this, "3 " + value[3] + " : " + strOilFilter, Toast.LENGTH_SHORT).show();
//        Toast.makeText(SubmitEstimateG200.this, "4 " + value[4] + " : " + strStarter, Toast.LENGTH_SHORT).show();
//        Toast.makeText(SubmitEstimateG200.this, "5 " + value[5] + " : " + strMuffler, Toast.LENGTH_SHORT).show();
//        Toast.makeText(SubmitEstimateG200.this, "6 " + value[6] + " : " + strSparkPlug, Toast.LENGTH_SHORT).show();
//        Toast.makeText(SubmitEstimateG200.this, "7 " + value[7] + " : " + strCarburetor, Toast.LENGTH_SHORT).show();
//        Toast.makeText(SubmitEstimateG200.this, "8 " + value[8] + " : " + strCoilCDI, Toast.LENGTH_SHORT).show();
//        Toast.makeText(SubmitEstimateG200.this, "9 " + value[9] + " : " + strBallValueSwitchOil, Toast.LENGTH_SHORT).show();
//        Toast.makeText(SubmitEstimateG200.this, "10 " + value[10] + " : " + strAirFilter, Toast.LENGTH_SHORT).show();
//        Toast.makeText(SubmitEstimateG200.this, "11 " + value[11] + " : " + strSwithchOnOff, Toast.LENGTH_SHORT).show();

    }//End of constructor.

    private void bindWidget() {
        listViewEstimatedG200 = (ListView) findViewById(R.id.listViewEstimatedG200);
    }

    private void createListView() {
        strRepairPriceArray = new String[]{
                repairEngine.toString(),
                repairBodyColor.toString(),
                repairFuelTankCap.toString(),
                repairOilFilter.toString(),
                repairStarter.toString(),
                repairMuffler.toString(),
                repairSparkPlug.toString(),
                repairCarburetor.toString(),
                repairCoilCDI.toString(),
                repairBallValueSwitchOil.toString(),
                repairAirFilter.toString(),
                repairSwitchOnOff.toString()
        };

        AdapterEstimated objAdapterEstimated = new AdapterEstimated(SubmitEstimateG200.this, textNameArray, strRepairPriceArray);
        listViewEstimatedG200.setAdapter(objAdapterEstimated);
    }

    private void setRepair() {
        //Compare int to text.
        if(getEngine==0){
            strEngine = "สตาร์ทติด";
        }else{
            strEngine = "สตาร์ทไม่ติด";
        }

        if (getBodyColor != 1) {
            strBodyColor = "ไม่ทำสีใหม่";
        } else {
            strBodyColor = "ทำสีใหม่";
            repairBodyColor = 120.0;
        }

        if (getFuelTankCap != 1) {
            strFuelTankCap = "ไม่เปลี่ยนฝาถังน้ำมันเบนซิล";
        }else{
            strFuelTankCap = "เปลี่ยนฝาถังน้ำมันเบนซิล";
            repairFuelTankCap = 50.0;
        }

        if (getOilFilter != 1) {
            strOilFilter = "ไม่เปลี่ยนฝาถังน้ำมันเครื่อง";
        }else{
            strOilFilter = "เปลี่ยนฝาถังน้ำมันเครื่อง";
            repairOilFilter = 50.0;
        }

        if (getStarter != 1) {
            if(getStarter != 2){
                if(getStarter != 3){
                    strStarter = "ไม่เปลี่ยนชุดจานกระตุก";
                }else{
                    strStarter = "เปลี่ยนเฉพาะเขี้ยวสตาร์ท";
                    repairStarter = 80.0;
                }
            }else{
                strStarter = "เปลี่ยนเฉพาะเชือกกระตุก";
                repairStarter = 30.0;
            }
        }else {
            strStarter = "เปลี่ยนจานกระตุกทั้งชุด";
            repairStarter = 450.0;
        }

        if (getMuffler != 1) {
            strMuffler = "ไม่เปลี่ยนท่อไอเสีย";
        } else {
            strMuffler = "เปลี่ยนท่อไอเสีย";
            repairMuffler = 160.0;
        }

        if (getSparkPlug != 1) {
            strSparkPlug = "ไม่เปลี่ยนปลั๊กหัวเทียน";
        } else {
            strSparkPlug = "เปลี่ยนปลั๊กหัวเทียน";
            repairSparkPlug = 50.0;
        }

        if (getCarburetor != 1) {
            strCarburetor = "ไม่เปลี่ยนคาร์บูเรเตอร์";
        } else {
            strCarburetor = "เปลี่ยนคาร์บูเรเตอร์";
            repairCarburetor = 450.0;
        }

        if (getCoilCDI != 1) {
            strCoilCDI = "ไม่เปลี่ยนคอยล์";
        } else {
            strCoilCDI = "เปลี่ยนคอยล์";
            repairCoilCDI = 580.0;
        }

        if (getBallValueSwitchOil != 1) {
            strBallValueSwitchOil = "ไม่เปลี่ยนก๊อกน้ำมัน";
        } else {
            strBallValueSwitchOil = "เปลี่ยนก๊อกน้ำมัน";
            repairBallValueSwitchOil = 150.0;
        }

        if (getAirFilter != 1) {
            if (getAirFilter != 2) {
                strAirFilter = "ไม่ต้องเปลี่ยนหม้อกรองอากาศ";
            } else {
                strAirFilter = "เปลี่ยนหม้อกรองอากาศทั้งลูก";
                repairAirFilter = 250.0;
            }
        } else {
            strAirFilter = "เปลี่ยนเฉพาะไส้กรองอากาศ";
            repairAirFilter = 100.0;
        }

        if (getSwitchOnOff != 1) {
            strSwitchOnOff = "ไม่เปลี่ยนสวิตท์เปิด-ปิด";
        } else {
            strSwitchOnOff = "เปลี่ยนสวิตท์เปิด-ปิด";
            repairSwitchOnOff = 120.0;
        }
    }//End of setRepair.
}
