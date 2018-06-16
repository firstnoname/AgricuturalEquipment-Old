package se.is.agriculturalequipment;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class SubmitEstimateG200 extends AppCompatActivity {

    private int idxEngine;
    private String idxEnginePass;
    private String priceStarter, priceFuelTank, priceAirFilter, priceCarburetor, priceCylinderSet,
            priceBallValveSwitchOil, priceMuffler, priceSwitchOnOff, priceCoil, priceFuelTankCap,
            priceNewPaint, priceOilTankCap, priceSparkPlug;
    private Double dStarter, dFuelTank, dAirFilter, dCarburetor, dCylinderSet,
            dBallValveSwitchOil, dMuffler, dSwitchOnOff, dCoil, dFuelTankCap,
            dNewPaint, dOilTankCap, dSparkPlug;
    private Double dAmount = 0.0;
    private TextView txtAmount;
    private ListView listViewEstimatedG200;
    private String[] strName, strPrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submit_estimate_g200);

        idxEngine = getIntent().getIntExtra("idxEngine", 0);

        //Get data from SQLite.
        getDataFromSQLite();

        //Calculate price.
        calculatePrice();

        //Bind widget.
        bindWidget();

        //Create listview.
        createListView();


    }//End of constructor.

    private void bindWidget() {
        txtAmount = (TextView) findViewById(R.id.txtAmountGX160);
        listViewEstimatedG200 = (ListView) findViewById(R.id.listViewEstimatedG200);
    }

    private void calculatePrice() {
        //Convert String to Double.
        if (idxEngine == 0) {
            dStarter = Double.parseDouble(priceStarter);
            dFuelTank = Double.parseDouble(priceFuelTank);
            dAirFilter = Double.parseDouble(priceAirFilter);
            dCarburetor = Double.parseDouble(priceCarburetor);
            //dCylinderSet = Double.parseDouble(priceCylinderSet);
            dBallValveSwitchOil = Double.parseDouble(priceBallValveSwitchOil);
            dMuffler = Double.parseDouble(priceMuffler);
            dSwitchOnOff = Double.parseDouble(priceSwitchOnOff);
            dCoil = Double.parseDouble(priceCoil);
            dFuelTankCap = Double.parseDouble(priceFuelTankCap);
            dNewPaint = Double.parseDouble(priceNewPaint);
            dOilTankCap = Double.parseDouble(priceOilTankCap);
            dSparkPlug = Double.parseDouble(priceSparkPlug);

            //Estimate price.
            dAmount = 4400 - (dStarter + dFuelTank + dAirFilter + dCarburetor +
                    dBallValveSwitchOil + dMuffler + dSwitchOnOff + dCoil + dFuelTankCap +
                    dNewPaint + dOilTankCap + dSparkPlug);

        } else {
            dStarter = Double.parseDouble(priceStarter);
            dFuelTank = Double.parseDouble(priceFuelTank);
            dAirFilter = Double.parseDouble(priceAirFilter);
            //dCylinderSet = Double.parseDouble(priceCylinderSet);
            dMuffler = Double.parseDouble(priceMuffler);
            dSwitchOnOff = Double.parseDouble(priceSwitchOnOff);
            dFuelTankCap = Double.parseDouble(priceFuelTankCap);

            dNewPaint = Double.parseDouble(priceNewPaint);
            dOilTankCap = Double.parseDouble(priceOilTankCap);
            dSparkPlug = Double.parseDouble(priceSparkPlug);

            //Estimate price.
            dAmount = 2640 - (dStarter + dFuelTank + dAirFilter +
                    dMuffler + dSwitchOnOff + dFuelTankCap +
                    dNewPaint + dOilTankCap + dSparkPlug);
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
                    dStarter.toString(),
                    dFuelTank.toString(),
                    dAirFilter.toString(),
                    dCarburetor.toString(),
                    //dCylinderSet.toString(),
                    dBallValveSwitchOil.toString(),
                    dMuffler.toString(),
                    dSwitchOnOff.toString(),
                    dCoil.toString(),
                    dFuelTankCap.toString(),
                    dNewPaint.toString(),
                    dOilTankCap.toString(),
                    dSparkPlug.toString()
            };

        } else {
            strPrice = new String[]{
                    "30%",
                    dStarter.toString(),
                    dFuelTank.toString(),
                    dAirFilter.toString(),
                    //dCylinderSet.toString(),
                    dMuffler.toString(),
                    dSwitchOnOff.toString(),
                    dFuelTankCap.toString(),
                    dNewPaint.toString(),
                    dOilTankCap.toString(),
                    dSparkPlug.toString()
            };

        }

        strName = new String[strListName.size()];
        strName = strListName.toArray(strName);

        MyAdapter objMyAdapter = new MyAdapter(SubmitEstimateG200.this, strName, strPrice);
        listViewEstimatedG200.setAdapter(objMyAdapter);

        if (dAmount <= 500.00) {
            dAmount = 500.00;
        }
        txtAmount.setText(dAmount.toString());
    }

    private void getDataFromSQLite() {
        //Get data from EstimateG200.
//        idxEngine = getIntent().getIntExtra("idxEngine",0);
        ArrayList<Integer> idSelectedList = (ArrayList<Integer>) getIntent().getIntegerArrayListExtra("arrSelectedID");

        TableG200 objTableG200 = new TableG200(this);
        String[] strPartPrice = objTableG200.readPartPrice();
        for (int i = 0; i < strPartPrice.length; i++) {
            Log.d("strPartPrice " + i + " : ", strPartPrice[i]);
        }
        //Compare data from sqlite.
        if (idxEngine == 0) {
            if (idSelectedList.get(1) == 1) {
                priceStarter = strPartPrice[0];
            } else if (idSelectedList.get(1) == 2) {
                priceStarter = "0.0";
            } else {
                priceStarter = "0.0";
            }

            if (idSelectedList.get(2) == 1) {
                priceFuelTank = strPartPrice[1];
            } else {
                priceFuelTank = "0.0";
            }

            if (idSelectedList.get(3) == 1) {
                priceAirFilter = strPartPrice[2];
            } else if (idSelectedList.get(3) == 2) {
                priceAirFilter = "0.0";
            } else {
                priceAirFilter = "0.0";
            }

            if (idSelectedList.get(4) == 1) {
                priceCarburetor = strPartPrice[3];
            } else {
                priceCarburetor = strPartPrice[3];
            }

            if (idSelectedList.get(5) == 1) {
                priceCylinderSet = strPartPrice[4];
            } else {
                priceCylinderSet = "0.0";
            }

            if (idSelectedList.get(6) == 1) {
                priceBallValveSwitchOil = strPartPrice[5];
            } else {
                priceBallValveSwitchOil = "0.0";
            }

            if (idSelectedList.get(7) == 1) {
                priceMuffler = strPartPrice[6];
            } else {
                priceMuffler = "0.0";
            }

            if (idSelectedList.get(8) == 1) {
                priceSwitchOnOff = strPartPrice[7];
            } else {
                priceSwitchOnOff = "0.0";
            }

            if (idSelectedList.get(9) == 1) {
                priceCoil = strPartPrice[8];
            } else {
                priceCoil = "0.0";
            }

            if (idSelectedList.get(10) == 1) {
                priceFuelTankCap = strPartPrice[9];
            } else {
                priceFuelTankCap = "0.0";
            }

            if (idSelectedList.get(11) == 1) {
                priceNewPaint = strPartPrice[10];
            } else {
                priceNewPaint = "0.0";
            }

            if (idSelectedList.get(12) == 1) {
                priceOilTankCap = strPartPrice[11];
            } else {
                priceOilTankCap = "0.0";
            }

            if (idSelectedList.get(13) == 1) {
                priceSparkPlug = strPartPrice[12];
            } else {
                priceSparkPlug = "0.0";
            }

        } else {

            if (idSelectedList.get(1) == 1) {
                priceStarter = strPartPrice[0];
            } else if (idSelectedList.get(1) == 2) {
                priceStarter = "0.0";
            } else {
                priceStarter = "0.0";
            }

            if (idSelectedList.get(2) == 1) {
                priceFuelTank = strPartPrice[1];
            } else {
                priceFuelTank = "0.0";
            }

            if (idSelectedList.get(3) == 1) {
                priceAirFilter = strPartPrice[2];
            } else if (idSelectedList.get(3) == 2) {
                priceAirFilter = "0.0";
            } else {
                priceAirFilter = "0.0";
            }

            if (idSelectedList.get(4) == 1) {
                priceCylinderSet = strPartPrice[4];
            } else {
                priceCylinderSet = "0.0";
            }

            if (idSelectedList.get(5) == 1) {
                priceMuffler = strPartPrice[6];
            } else {
                priceMuffler = "0.0";
            }

            if (idSelectedList.get(6) == 1) {
                priceSwitchOnOff = strPartPrice[7];
            } else {
                priceSwitchOnOff = "0.0";
            }

            if (idSelectedList.get(7) == 1) {
                priceFuelTankCap = strPartPrice[9];
            } else {
                priceFuelTankCap = "0.0";
            }

            if (idSelectedList.get(8) == 1) {
                priceNewPaint = strPartPrice[10];
            } else {
                priceNewPaint = "0.0";
            }

            if (idSelectedList.get(9) == 1) {
                priceOilTankCap = strPartPrice[11];
            } else {
                priceOilTankCap = "0.0";
            }

            if (idSelectedList.get(10) == 1) {
                priceSparkPlug = strPartPrice[12];
            } else {
                priceSparkPlug = "0.0";
            }

        }//End else.


    }

    public void intentSaveG200(View view) {
        if (idxEngine == 0) {
            idxEnginePass = "0";
        } else {
            idxEnginePass = "1";
        }

        Intent intentSaveG200 = new Intent(this, BuyEstimated.class);
        intentSaveG200.putExtra("amount", dAmount.toString());
        intentSaveG200.putExtra("partName", strName);
        intentSaveG200.putExtra("partPrice", strPrice);
        intentSaveG200.putExtra("idxEngine", idxEnginePass);
        intentSaveG200.putExtra("dealStatus", "Save");

        startActivity(intentSaveG200);
    }

    public void intentBuyG200(View view) {
        if (idxEngine == 0) {
            idxEnginePass = "0";
        } else {
            idxEnginePass = "1";
        }

        Intent intentBuyG200 = new Intent(this, BuyEstimated.class);
        intentBuyG200.putExtra("amount", dAmount.toString());
        intentBuyG200.putExtra("partName", strName);
        intentBuyG200.putExtra("partPrice", strPrice);
        intentBuyG200.putExtra("idxEngine", idxEnginePass);
        intentBuyG200.putExtra("dealStatus", "Buy");

        startActivity(intentBuyG200);
    }

}
