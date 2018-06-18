package se.is.agriculturalequipment;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class SubmitEstimateT200 extends AppCompatActivity {

    private int idxEngine;
    private String priceStarter, priceFuelTank, priceControlSwitch, priceBrushCutterBlade, priceAirFilter,
            priceCarburetor, priceCylinderSet, priceBallValveSwitchOil, priceMuffler, priceGearDiver,
            priceMainPipe, priceSwitchOnOff, priceCoil, priceFuelTankCap, priceNewPaint, priceShaft,
            priceOilTankCap, priceSparkPlug;
    private Double dStarter, dFuelTank, dControlSwitch, dBrushCutterBlade, dAirFilter, dCarburetor,
            dCylinderSet, dBallValveSwitchOil, dMuffler, dGearDiver, dMainPipe, dSwitchOnOff, dCoil,
            dFuelTankCap, dNewPaint, dShaft, dOilTankCap, dSparkPlug;
    private Double dAmount = 0.0;
    private TextView txtAmount;
    private ListView listViewEstimatedT200;
    private String[] strName, strPrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submit_estimate_t200);

        bindWidget();

        //Get data from SQLite.
        getDataFromSQLite();

        //Calculate price.
        calculatePrice();

        createListView();


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
                    dStarter.toString(),
                    dFuelTank.toString(),
                    dControlSwitch.toString(),
                    dBrushCutterBlade.toString(),
                    dAirFilter.toString(),
                    dCarburetor.toString(),
                    dCylinderSet.toString(),
                    dBallValveSwitchOil.toString(),
                    dMuffler.toString(),
                    dGearDiver.toString(),
                    dMainPipe.toString(),
                    //dSwitchOnOff.toString(),
                    dCoil.toString(),
                    //dFuelTankCap.toString(),
                    //dNewPaint.toString(),
                    dShaft.toString(),
                    dOilTankCap.toString(),
                    dSparkPlug.toString()

            };

        } else {
            strPrice = new String[]{
                    "30%",
                    dStarter.toString(),
                    dFuelTank.toString(),
                    dControlSwitch.toString(),
                    dBrushCutterBlade.toString(),
                    dAirFilter.toString(),
                    dBallValveSwitchOil.toString(),
                    dMuffler.toString(),
                    dGearDiver.toString(),
                    dMainPipe.toString(),
//                    dSwitchOnOff.toString(),
                    //dFuelTankCap.toString(),
                    //dNewPaint.toString(),
                    dShaft.toString(),
                    dSparkPlug.toString()

            };

        }

        strName = new String[strListName.size()];
        strName = strListName.toArray(strName);

        MyAdapter objMyAdapter = new MyAdapter(SubmitEstimateT200.this, strName, strPrice);
        listViewEstimatedT200.setAdapter(objMyAdapter);

        if (dAmount <= 500.00) {
            dAmount = 500.00;
        }
        txtAmount.setText(dAmount.toString());
    }

    private void calculatePrice() {
        //Convert String to Double.
        if (idxEngine == 0) {
            dStarter = Double.parseDouble(priceStarter);
            dFuelTank = Double.parseDouble(priceFuelTank);
            dControlSwitch = Double.parseDouble(priceControlSwitch);
            dBrushCutterBlade = Double.parseDouble(priceBrushCutterBlade);
            dAirFilter = Double.parseDouble(priceAirFilter);
            dCarburetor = Double.parseDouble(priceCarburetor);
            dCylinderSet = Double.parseDouble(priceCylinderSet);
            dBallValveSwitchOil = Double.parseDouble(priceBallValveSwitchOil);
            dMuffler = Double.parseDouble(priceMuffler);
            dGearDiver = Double.parseDouble(priceGearDiver);
            dMainPipe = Double.parseDouble(priceMainPipe);
//            dSwitchOnOff = Double.parseDouble(priceSwitchOnOff);
            dCoil = Double.parseDouble(priceCoil);
//            dFuelTankCap = Double.parseDouble(priceFuelTankCap);
//            dNewPaint = Double.parseDouble(priceNewPaint);
            dShaft = Double.parseDouble(priceShaft);
            dOilTankCap = Double.parseDouble(priceOilTankCap);
            dSparkPlug = Double.parseDouble(priceSparkPlug);

            //Estimate price.
            dAmount = 4400 - (dStarter + dFuelTank + dControlSwitch + dBrushCutterBlade + dAirFilter +
                    dCarburetor + dCylinderSet + dBallValveSwitchOil + dMuffler + dGearDiver + dMainPipe +
                    dCoil + dShaft + dOilTankCap + dSparkPlug);

        } else {
            dStarter = Double.parseDouble(priceStarter);
            dFuelTank = Double.parseDouble(priceFuelTank);
            dControlSwitch = Double.parseDouble(priceControlSwitch);
            dBrushCutterBlade = Double.parseDouble(priceBrushCutterBlade);
            dAirFilter = Double.parseDouble(priceAirFilter);
            dBallValveSwitchOil = Double.parseDouble(priceBallValveSwitchOil);
            dMuffler = Double.parseDouble(priceMuffler);
            dGearDiver = Double.parseDouble(priceGearDiver);
            dMainPipe = Double.parseDouble(priceMainPipe);
//            dSwitchOnOff = Double.parseDouble(priceSwitchOnOff);
//            dFuelTankCap = Double.parseDouble(priceFuelTankCap);
//            dNewPaint = Double.parseDouble(priceNewPaint);
            dShaft = Double.parseDouble(priceStarter);
            dSparkPlug = Double.parseDouble(priceSparkPlug);


            //Estimate price.
            dAmount = 2640 - (dStarter + dFuelTank + dControlSwitch + dBrushCutterBlade + dAirFilter +
                    dBallValveSwitchOil + dMuffler + dGearDiver + dMainPipe + dShaft + dSparkPlug);
        }

    }

    private void getDataFromSQLite() {
        //Get data from EstimateT200.
        idxEngine = getIntent().getIntExtra("idxEngine", 0);
        /*if (idxEngine == -1) {
            idxEngine = 0;
        } else {
            idxEngine = 1;
        }*/

       /* ArrayList<String> testArrName = (ArrayList<String>) getIntent().getExtras().getSerializable("arrListName");
        Log.d("testArrName : ", testArrName.toString());*/

        ArrayList<Integer> idSelectedList = (ArrayList<Integer>) getIntent().getIntegerArrayListExtra("arrSelectedID");
        TableT200 objTableT200 = new TableT200(this);
        String[] strPartPrice = objTableT200.readPartPrice();

        for (int i = 0; i<strPartPrice.length; i++) {
            Log.d("Query string", i + " : " + strPartPrice[i]);
        }
        //Compare data from SQLite.
        if (idxEngine == 0) {
            if (idSelectedList.get(1) == 1) {
                priceStarter = strPartPrice[0];
            } else if (idSelectedList.get(1) == 2) {
                priceStarter = "100";
            } else {
                priceStarter = "0.0";
            }
            // 3 choices.
            if (idSelectedList.get(2) == 1) {
                priceFuelTank = strPartPrice[1];
            } else {
                priceFuelTank = "0.0";
            }

            if (idSelectedList.get(3) == 1) {
                priceControlSwitch = strPartPrice[2];
            } else {
                priceControlSwitch = "0.0";
            }

            if (idSelectedList.get(4) == 1) {
                priceBrushCutterBlade = strPartPrice[3];
            } else {
                priceBrushCutterBlade = "0.0";
            }

            if (idSelectedList.get(5) == 1) {
                priceAirFilter = strPartPrice[4];
            } else if (idSelectedList.get(5) == 2) {
                priceAirFilter = "125";
            } else {
                priceAirFilter = "0.0";
            }
            // 3 choices
            if (idSelectedList.get(6) == 1) {
                priceCarburetor = strPartPrice[5];
            } else {
                priceCarburetor = "0.0";
            }

            if (idSelectedList.get(7) == 1) {
                priceCylinderSet = strPartPrice[6];
            } else if (idSelectedList.get(7) == 2) {
                priceCylinderSet = "425";
            } else {
                priceCylinderSet = "0.0";
            }
            // 3 choices
            if (idSelectedList.get(8) == 1) {
                priceBallValveSwitchOil = strPartPrice[7];
            } else {
                priceBallValveSwitchOil = "0.0";
            }

            if (idSelectedList.get(9) == 1) {
                priceMuffler = strPartPrice[8];
            } else {
                priceMuffler = "0.0";
            }

            if (idSelectedList.get(10) == 1) {
                priceGearDiver = strPartPrice[9];
            } else if (idSelectedList.get(10) == 2) {
                priceGearDiver = "400";
            } else {
                priceGearDiver = "0.0";
            }
            // 3 choices
            if (idSelectedList.get(11) == 1) {
                priceMainPipe = strPartPrice[10];
            } else {
                priceMainPipe = "0.0";
            }

            /*if (idSelectedList.get(12) == 1) {
                priceSwitchOnOff = strPartPrice[11];
            } else {
                priceSwitchOnOff = "0.0";
            }*/

            if (idSelectedList.get(12) == 1) {
                priceCoil = strPartPrice[12];
            } else {
                priceCoil = "0.0";
            }

            /*if (idSelectedList.get(14) == 1) {
                priceFuelTankCap = strPartPrice[13];
            } else {
                priceFuelTankCap = "0.0";
            }*/

            /*if (idSelectedList.get(15) == 1) {
                priceNewPaint = strPartPrice[14];
            } else {
                priceNewPaint = "0.0";
            }*/

            if (idSelectedList.get(13) == 1) {
                priceShaft = strPartPrice[15];
            } else {
                priceShaft = "0.0";
            }

            if (idSelectedList.get(14) == 1) {
                priceOilTankCap = strPartPrice[16];
            } else {
                priceOilTankCap = "0.0";
            }

            if (idSelectedList.get(15) == 1) {
                priceSparkPlug = strPartPrice[17];
            } else {
                priceSparkPlug = "0.0";
            }

        } else {

            if (idSelectedList.get(1) == 1) {
                priceStarter = strPartPrice[0];
            } else if (idSelectedList.get(1) == 2) {
                priceStarter = "100";
            } else {
                priceStarter = "0.0";
            }
            // 3 choices.
            if (idSelectedList.get(2) == 1) {
                priceFuelTank = strPartPrice[1];
            } else {
                priceFuelTank = "0.0";
            }

            if (idSelectedList.get(3) == 1) {
                priceControlSwitch = strPartPrice[2];
            } else {
                priceControlSwitch = "0.0";
            }

            if (idSelectedList.get(4) == 1) {
                priceBrushCutterBlade = strPartPrice[3];
            } else {
                priceBrushCutterBlade = "0.0";
            }

            if (idSelectedList.get(5) == 1) {
                priceAirFilter = strPartPrice[4];
            } else if (idSelectedList.get(5) == 2) {
                priceAirFilter = "125";
            } else {
                priceAirFilter = "0.0";
            }

            if (idSelectedList.get(6) == 1) {
                priceBallValveSwitchOil = strPartPrice[7];
            } else {
                priceBallValveSwitchOil = "0.0";
            }

            if (idSelectedList.get(7) == 1) {
                priceMuffler = strPartPrice[8];
            } else {
                priceMuffler = "0.0";
            }

            if (idSelectedList.get(8) == 1) {
                priceGearDiver = strPartPrice[9];
            } else if (idSelectedList.get(10) == 2) {
                priceGearDiver = "400";
            } else {
                priceGearDiver = "0.0";
            }
            // 3 choices
            if (idSelectedList.get(9) == 1) {
                priceMainPipe = strPartPrice[10];
            } else {
                priceMainPipe = "0.0";
            }

            /*if (idSelectedList.get(10) == 1) {
                priceSwitchOnOff = strPartPrice[11];
            } else {
                priceSwitchOnOff = "0.0";
            }*/

           /* if (idSelectedList.get(11) == 1) {
                priceFuelTankCap = strPartPrice[13];
            } else {
                priceFuelTankCap = "0.0";
            }*/

            /*if (idSelectedList.get(12) == 1) {
                priceNewPaint = strPartPrice[14];
            } else {
                priceNewPaint = "0.0";
            }*/

            if (idSelectedList.get(10) == 1) {
                priceShaft = strPartPrice[15];
            } else {
                priceShaft = "0.0";
            }

            /*if (idSelectedList.get(11) == 1) {
                priceOilTankCap = strPartPrice[16];
            } else {
                priceOilTankCap = "0.0";
            }*/




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
        Toast.makeText(this, strPartPrice[12], Toast.LENGTH_SHORT).show();
        Toast.makeText(this, strPartPrice[13], Toast.LENGTH_SHORT).show();*/

    }

    private void bindWidget() {
        txtAmount = (TextView) findViewById(R.id.txtAmountT200);
        listViewEstimatedT200 = (ListView) findViewById(R.id.listViewEstimatedT200);
    }

    public void intentBuyT200(View view) {
        Intent intentBuyT200 = new Intent(this, BuyEstimatedT200.class);
        intentBuyT200.putExtra("amount", dAmount.toString());
        intentBuyT200.putExtra("partName", strName);
        intentBuyT200.putExtra("partPrice", strPrice);

        startActivity(intentBuyT200);
    }
}
