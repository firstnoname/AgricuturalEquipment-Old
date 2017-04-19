package se.is.agriculturalequipment;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Objects;

import static android.R.attr.start;
import static android.R.attr.value;

public class SubmitEstimateG200 extends AppCompatActivity {

//    private Integer getEngine, getBodyColor, getFuelTankCap, getOilFilter, getStarter, getMuffler,
//        getSparkPlug, getCarburetor, getCoilCDI, getBallValueSwitchOil, getAirFilter, getSwitchOnOff;
//
//    private String strEngine, strBodyColor, strFuelTankCap, strOilFilter, strStarter, strMuffler,
//            strSparkPlug,strCarburetor, strCoilCDI, strBallValueSwitchOil, strAirFilter,
//            strSwitchOnOff;
//
//    private String[] textNameArray, strRepairPriceArray;
//    //private Double[] repairPriceArray;

//
//    private ListView listViewEstimatedG200;
//
//    private Double repairEngine = 0.0,
//            repairBodyColor = 0.0,
//            repairFuelTankCap = 0.0,
//            repairOilFilter = 0.0,
//            repairStarter = 0.0,
//            repairMuffler = 0.0,
//            repairSparkPlug = 0.0,
//            repairCarburetor = 0.0,
//            repairCoilCDI = 0.0,
//            repairBallValueSwitchOil = 0.0,
//            repairAirFilter = 0.0,
//            repairSwitchOnOff = 0.0;

    private int idxEngine;
    private String priceBodyColor, priceFuelTankCap, priceOilFilter, priceStarter, priceMuffler,
            priceSparkPlug, priceCarburetor, priceCoilCDI, priceBallValueSwitchOil, priceAirFilter, priceSwitchOnOff;
    private Double dBodyColor, dFuelTankCap, dOilFilter, dStarter, dMuffler,
            dSparkPlug, dCarburetor, dCoilCDI, dBallValueSwitchOil, dAirFilter, dSwitchOnOff;
    private Double dAmount = 0.0;
    private TextView txtAmount;
    private ListView listViewEstimatedG200;
    private String[] strName, strPrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submit_estimate_g200);

        //Get data from SQLite.
        getDatafromSQLite();

        //Calculate price.
        calculatePrice();

        //Bind widget.
        bindWidget();

        //Create listview.
        createListView();

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

        /*bindWidget();
        createListView();*/

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
        txtAmount = (TextView) findViewById(R.id.txtAmount);
        listViewEstimatedG200 = (ListView) findViewById(R.id.listViewEstimatedG200);
    }

    private void calculatePrice() {
        //Convert String to Double.
        if (idxEngine == 0) {
            dBodyColor = Double.parseDouble(priceBodyColor);
            dFuelTankCap = Double.parseDouble(priceFuelTankCap);
            dOilFilter = Double.parseDouble(priceOilFilter);
            dStarter = Double.parseDouble(priceStarter);
            dMuffler = Double.parseDouble(priceMuffler);
            dSparkPlug = Double.parseDouble(priceSparkPlug);
            dCarburetor = Double.parseDouble(priceCarburetor);
            dCoilCDI = Double.parseDouble(priceCoilCDI);
            dBallValueSwitchOil = Double.parseDouble(priceBallValueSwitchOil);
            dAirFilter = Double.parseDouble(priceAirFilter);
            dSwitchOnOff = Double.parseDouble(priceSwitchOnOff);

            //Estimate price.
            dAmount = 4400 - (dBodyColor + dFuelTankCap + dOilFilter + dStarter + dMuffler + dSparkPlug + dCarburetor + dCoilCDI + dBallValueSwitchOil + dAirFilter + dSwitchOnOff);

        }else {
            dBodyColor = Double.parseDouble(priceBodyColor);
            dFuelTankCap = Double.parseDouble(priceFuelTankCap);
            dOilFilter = Double.parseDouble(priceOilFilter);
            dMuffler = Double.parseDouble(priceMuffler);
            dSparkPlug = Double.parseDouble(priceSparkPlug);
            dAirFilter = Double.parseDouble(priceAirFilter);
            dSwitchOnOff = Double.parseDouble(priceSwitchOnOff);

            //Estimate price.
            dAmount = 2640-(dBodyColor + dFuelTankCap + dOilFilter + dMuffler + dSparkPlug + dAirFilter + dSwitchOnOff);
        }

    }

    private void createListView() {
        //Two element in listview.
        /*
            1.String part name.
            2.String part price.
        */

        ArrayList<String> strListName = (ArrayList<String>) getIntent().getExtras().getSerializable("arrListName");

        if (idxEngine == 0) {
            strPrice = new String[]{
                    "0.0",
                    dBodyColor.toString(),
                    dFuelTankCap.toString(),
                    dOilFilter.toString(),
                    dStarter.toString(),
                    dMuffler.toString(),
                    dSparkPlug.toString(),
                    dCarburetor.toString(),
                    dCoilCDI.toString(),
                    dBallValueSwitchOil.toString(),
                    dAirFilter.toString(),
                    dSwitchOnOff.toString()
            };

        }else {
            strPrice = new String[]{
                    "30%",
                    dBodyColor.toString(),
                    dFuelTankCap.toString(),
                    dOilFilter.toString(),
                    dMuffler.toString(),
                    dSparkPlug.toString(),
                    dAirFilter.toString(),
                    dSwitchOnOff.toString()
            };

        }

        strName = new String[strListName.size()];
        strName = strListName.toArray(strName);

        MyAdapter objMyAdapter = new MyAdapter(SubmitEstimateG200.this, strName, strPrice);
        listViewEstimatedG200.setAdapter(objMyAdapter);

        txtAmount.setText(dAmount.toString());
    }

    private void getDatafromSQLite() {
        //Get data from EstimateG200.
        idxEngine = getIntent().getIntExtra("idxEngine",0);
        ArrayList<Integer> idSelectedList = (ArrayList<Integer>) getIntent().getIntegerArrayListExtra("arrSelectedID");

        TableG200 objTableG200 = new TableG200(this);
        String[] strPartPrice = objTableG200.readPartPrice();

        //Compare data from sqlite.
        if (idxEngine == 0) {
            if (idSelectedList.get(1) == 1) {
                priceBodyColor = strPartPrice[0];
            }else {
                priceBodyColor = "0.0";
            }

            if (idSelectedList.get(2) == 1) {
                priceFuelTankCap = strPartPrice[1];
            }else {
                priceFuelTankCap = "0.0";
            }

            if (idSelectedList.get(3) == 1) {
                priceOilFilter = strPartPrice[2];
            }else {
                priceOilFilter = "0.0";
            }

            if (idSelectedList.get(4) != 1) {
                //4 choices.
                if (idSelectedList.get(4) != 2) {
                    if (idSelectedList.get(4) != 3) {
                        priceStarter = "0.0";
                    }else {
                        priceStarter = strPartPrice[5];
                    }
                }else {
                    priceStarter = strPartPrice[4];
                }
            }else {
                priceStarter = strPartPrice[3];
            }

            if (idSelectedList.get(5) == 1) {
                priceMuffler = strPartPrice[6];
            }else {
                priceMuffler = "0.0";
            }

            if (idSelectedList.get(6) == 1) {
                priceSparkPlug = strPartPrice[7];
            }else {
                priceSparkPlug = "0.0";
            }

            if (idSelectedList.get(7) == 1) {
                priceCarburetor = strPartPrice[8];
            }else {
                priceCarburetor = "0.0";
            }

            if (idSelectedList.get(8) == 1) {
                priceCoilCDI = strPartPrice[9];
            }else {
                priceCoilCDI = "0.0";
            }

            if (idSelectedList.get(9) == 1) {
                priceBallValueSwitchOil = strPartPrice[10];
            }else {
                priceBallValueSwitchOil = "0.0";
            }

            if (idSelectedList.get(10) == 1) {
                priceAirFilter = strPartPrice[11];
            }else {
                priceAirFilter = "0.0";
            }

            if (idSelectedList.get(11) == 1) {
                priceSwitchOnOff = strPartPrice[12];
            }else {
                priceSwitchOnOff = "0.0";
            }

        }else{
            if (idSelectedList.get(1) == 1) {
                priceBodyColor = strPartPrice[0];
            }else {
                priceBodyColor = "0.0";
            }

            if (idSelectedList.get(2) == 1) {
                priceFuelTankCap = strPartPrice[1];
            }else {
                priceFuelTankCap = "0.0";
            }

            if (idSelectedList.get(3) == 1) {
                priceOilFilter = strPartPrice[2];
            }else {
                priceOilFilter = "0.0";
            }

            if (idSelectedList.get(4) == 1) {
                priceMuffler = strPartPrice[6];
            }else {
                priceMuffler = "0.0";
            }

            if (idSelectedList.get(5) == 1) {
                priceSparkPlug = strPartPrice[7];
            }else {
                priceSparkPlug = "0.0";
            }

            if (idSelectedList.get(6) == 1) {
                priceAirFilter = strPartPrice[11];
            }else {
                priceAirFilter = "0.0";
            }

            if (idSelectedList.get(7) == 1) {
                priceSwitchOnOff = strPartPrice[12];
            }else {
                priceSwitchOnOff = "0.0";
            }
        }


        /*Toast.makeText(this, strPartPrice[0], Toast.LENGTH_SHORT).show();
        Toast.makeText(this, strPartPrice[1], Toast.LENGTH_SHORT).show();
        Toast.makeText(this, strPartPrice[2], Toast.LENGTH_SHORT).show();
        Toast.makeText(this, strPartPrice[3], Toast.LENGTH_SHORT).show();
        Toast.makeText(this, strPartPrice[4], Toast.LENGTH_SHORT).show();
        Toast.makeText(this, strPartPrice[5], Toast.LENGTH_SHORT).show();
        Toast.makeText(this, strPartPrice[6], Toast.LENGTH_SHORT).show();
        Toast.makeText(this, strPartPrice[7], Toast.LENGTH_SHORT).show();
        Toast.makeText(this, strPartPrice[8], Toast.LENGTH_SHORT).show();
        Toast.makeText(this, strPartPrice[9], Toast.LENGTH_SHORT).show();
        Toast.makeText(this, strPartPrice[10], Toast.LENGTH_SHORT).show();
        Toast.makeText(this, strPartPrice[11], Toast.LENGTH_SHORT).show();
        Toast.makeText(this, strPartPrice[12], Toast.LENGTH_SHORT).show();*/

    }

    public void intentSaveG200(View view){
        Intent intentSaveEstimated = new Intent(this, SaveEstimated.class);
        intentSaveEstimated.putExtra("amount", dAmount.toString());
        intentSaveEstimated.putExtra("partName", strName);
        intentSaveEstimated.putExtra("partPrice", strPrice);
        startActivity(intentSaveEstimated);
    }

    public void intentBuyG200(View view){
        Intent intentBuyG200 = new Intent(this, BuyEstimated.class);
        intentBuyG200.putExtra("amount", dAmount.toString());
        intentBuyG200.putExtra("partName", strName);
        intentBuyG200.putExtra("partPrice", strPrice);
        startActivity(intentBuyG200);
    }

    /*private void bindWidget() {
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

        AdapterEstimated objAdapterEstimated = new AdapterEstimated(SubmitEstimateG200.this, getTextArray, strRepairPriceArray);
        listViewEstimatedG200.setAdapter(objAdapterEstimated);
    }

    private void setRepair() {
        //Compare int to text.
//        if(getEngine==0){
//            strEngine = "สตาร์ทติด";
//        }else{
//            strEngine = "สตาร์ทไม่ติด";
//        }
//
//        if (getBodyColor != 1) {
//            strBodyColor = "ไม่ทำสีใหม่";
//        } else {
//            strBodyColor = "ทำสีใหม่";
//            repairBodyColor = 120.0;
//        }
//
//        if (getFuelTankCap != 1) {
//            strFuelTankCap = "ไม่เปลี่ยนฝาถังน้ำมันเบนซิล";
//        }else{
//            strFuelTankCap = "เปลี่ยนฝาถังน้ำมันเบนซิล";
//            repairFuelTankCap = 50.0;
//        }
//
//        if (getOilFilter != 1) {
//            strOilFilter = "ไม่เปลี่ยนฝาถังน้ำมันเครื่อง";
//        }else{
//            strOilFilter = "เปลี่ยนฝาถังน้ำมันเครื่อง";
//            repairOilFilter = 50.0;
//        }
//
//        if (getStarter != 1) {
//            if(getStarter != 2){
//                if(getStarter != 3){
//                    strStarter = "ไม่เปลี่ยนชุดจานกระตุก";
//                }else{
//                    strStarter = "เปลี่ยนเฉพาะเขี้ยวสตาร์ท";
//                    repairStarter = 80.0;
//                }
//            }else{
//                strStarter = "เปลี่ยนเฉพาะเชือกกระตุก";
//                repairStarter = 30.0;
//            }
//        }else {
//            strStarter = "เปลี่ยนจานกระตุกทั้งชุด";
//            repairStarter = 450.0;
//        }
//
//        if (getMuffler != 1) {
//            strMuffler = "ไม่เปลี่ยนท่อไอเสีย";
//        } else {
//            strMuffler = "เปลี่ยนท่อไอเสีย";
//            repairMuffler = 160.0;
//        }
//
//        if (getSparkPlug != 1) {
//            strSparkPlug = "ไม่เปลี่ยนปลั๊กหัวเทียน";
//        } else {
//            strSparkPlug = "เปลี่ยนปลั๊กหัวเทียน";
//            repairSparkPlug = 50.0;
//        }
//
//        if (getCarburetor != 1) {
//            strCarburetor = "ไม่เปลี่ยนคาร์บูเรเตอร์";
//        } else {
//            strCarburetor = "เปลี่ยนคาร์บูเรเตอร์";
//            repairCarburetor = 450.0;
//        }
//
//        if (getCoilCDI != 1) {
//            strCoilCDI = "ไม่เปลี่ยนคอยล์";
//        } else {
//            strCoilCDI = "เปลี่ยนคอยล์";
//            repairCoilCDI = 580.0;
//        }
//
//        if (getBallValueSwitchOil != 1) {
//            strBallValueSwitchOil = "ไม่เปลี่ยนก๊อกน้ำมัน";
//        } else {
//            strBallValueSwitchOil = "เปลี่ยนก๊อกน้ำมัน";
//            repairBallValueSwitchOil = 150.0;
//        }
//
//        if (getAirFilter != 1) {
//            if (getAirFilter != 2) {
//                strAirFilter = "ไม่ต้องเปลี่ยนหม้อกรองอากาศ";
//            } else {
//                strAirFilter = "เปลี่ยนหม้อกรองอากาศทั้งลูก";
//                repairAirFilter = 250.0;
//            }
//        } else {
//            strAirFilter = "เปลี่ยนเฉพาะไส้กรองอากาศ";
//            repairAirFilter = 100.0;
//        }
//
//        if (getSwitchOnOff != 1) {
//            strSwitchOnOff = "ไม่เปลี่ยนสวิตท์เปิด-ปิด";
//        } else {
//            strSwitchOnOff = "เปลี่ยนสวิตท์เปิด-ปิด";
//            repairSwitchOnOff = 120.0;
//        }
    }//End of setRepair.*/
}
