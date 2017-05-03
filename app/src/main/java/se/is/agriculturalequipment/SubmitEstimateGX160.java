package se.is.agriculturalequipment;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class SubmitEstimateGX160 extends AppCompatActivity {

    private int idxEngine;
    private String priceBodyColor, priceFuelTankCap, priceOilFilter, priceStarter, priceMuffler,
            priceSparkPlug, priceCarburetor, priceCoilCDI, priceBallValueSwitchOil, priceAirFilter, priceSwitchOnOff;
    private Double dBodyColor, dFuelTankCap, dOilFilter, dStarter, dMuffler,
            dSparkPlug, dCarburetor, dCoilCDI, dBallValueSwitchOil, dAirFilter, dSwitchOnOff;
    private Double dAmount = 0.0;
    private TextView txtAmount;
    private ListView listViewEstimatedGX160;
    private String[] strName, strPrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Get data from SQLite.
        getDataFromSQLite();

        //Calculate price.
        calculatePrice();

        bindWidget();

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

        MyAdapter objMyAdapter = new MyAdapter(SubmitEstimateGX160.this, strName, strPrice);
        listViewEstimatedGX160.setAdapter(objMyAdapter);

        txtAmount.setText(dAmount.toString());
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

    private void getDataFromSQLite() {
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

    private void bindWidget() {
        txtAmount = (TextView) findViewById(R.id.txtAmount);
        listViewEstimatedGX160 = (ListView) findViewById(R.id.listViewEstimatedG200);
    }


}
