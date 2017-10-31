package se.is.agriculturalequipment;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class SubmitEstimateGX160 extends AppCompatActivity {

    private int idxEngine;
    private String idxEnginePass;
    private String priceStarter,  priceFuelTank, priceAirFilter, priceCarburetor,
            priceCylinderSet, priceBallValveSwitchOil, priceMuffler, priceSwitchOnOff, priceCoil,
            priceFuelTankCap,priceNewPaint,priceOilTankCap,priceSparkPlug;
    private Double dStarter,  dFuelTank, dAirFilter, dCarburetor,
            dCylinderSet, dBallValveSwitchOil, dMuffler, dSwitchOnOff, dCoil, dFuelTankCap,dNewPaint,dOilTankCap,dSparkPlug;
    private Double dAmount = 0.0;
    private TextView txtAmount;
    private ListView listViewEstimatedGX160;
    private String[] strName, strPrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submit_estimate_gx160);

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
                    dAirFilter.toString(),
                    dCarburetor.toString(),
                    dCylinderSet.toString(),
                    dBallValveSwitchOil.toString(),
                    dMuffler.toString(),
                    dSwitchOnOff.toString(),
                    dCoil.toString(),
                    dFuelTankCap.toString(),
                    dNewPaint.toString(),
                    dOilTankCap.toString(),
                    dSparkPlug.toString()
            };

        }else {
            strPrice = new String[]{
                    "30%",
                    dFuelTank.toString(),
                    dAirFilter.toString(),
                    dCylinderSet.toString(),
                    dBallValveSwitchOil.toString(),
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

        MyAdapter objMyAdapter = new MyAdapter(SubmitEstimateGX160.this, strName, strPrice);
        listViewEstimatedGX160.setAdapter(objMyAdapter);

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
            dAirFilter = Double.parseDouble(priceAirFilter);
            dCarburetor = Double.parseDouble(priceCarburetor);
            dCylinderSet = Double.parseDouble(priceCylinderSet);
            dBallValveSwitchOil = Double.parseDouble(priceBallValveSwitchOil);
            dMuffler = Double.parseDouble(priceMuffler);
            dSwitchOnOff = Double.parseDouble(priceSwitchOnOff);
            dCoil = Double.parseDouble(priceCoil);
            dFuelTankCap = Double.parseDouble(priceFuelTankCap);
            dNewPaint = Double.parseDouble(priceNewPaint);
            dOilTankCap = Double.parseDouble(priceOilTankCap);
            dSparkPlug = Double.parseDouble(priceSparkPlug);

            //Estimate price.
            dAmount = 4400 - (dStarter + dFuelTank + dAirFilter + dCarburetor + dCylinderSet + dBallValveSwitchOil + dMuffler + dSwitchOnOff + dCoil + dFuelTankCap + dNewPaint + dOilTankCap + dSparkPlug);

        }else {
            dFuelTank = Double.parseDouble(priceFuelTank);
            dAirFilter = Double.parseDouble(priceAirFilter);
            dCylinderSet = Double.parseDouble(priceCylinderSet);
            dBallValveSwitchOil = Double.parseDouble(priceBallValveSwitchOil);
            dMuffler = Double.parseDouble(priceMuffler);
            dSwitchOnOff = Double.parseDouble(priceSwitchOnOff);
            dFuelTankCap = Double.parseDouble(priceFuelTankCap);
            dNewPaint = Double.parseDouble(priceNewPaint);
            dOilTankCap = Double.parseDouble(priceOilTankCap);
            dSparkPlug = Double.parseDouble(priceSparkPlug);

            //Estimate price.
            dAmount = 2640-(dFuelTank + dAirFilter + dCylinderSet + dMuffler + dSwitchOnOff + dFuelTankCap + dNewPaint + dOilTankCap + dSparkPlug );
        }

    }

    private void getDataFromSQLite() {
        //Get data from EstimateGX160.
        idxEngine = getIntent().getIntExtra("idxEngine",0);
        /*if (idxEngine == -1) {
            idxEngine = 0;
        } else {
            idxEngine = 1;
        }*/

       /* ArrayList<String> testArrName = (ArrayList<String>) getIntent().getExtras().getSerializable("arrListName");
        Log.d("testArrName : ", testArrName.toString());*/

        ArrayList<Integer> idSelectedList = (ArrayList<Integer>) getIntent().getIntegerArrayListExtra("arrSelectedID");
        TableGX160 objTableGX160 = new TableGX160(this);
        String[] strPartPrice = objTableGX160.readPartPrice();

        //Compare data from SQLite.
        if (idxEngine == 0) {
            if (idSelectedList.get(1) == 1) {
                priceStarter = strPartPrice[0];
            }else if (idSelectedList.get(1) == 2) {
                priceStarter = "100";
            }else {
                priceStarter = "0.0";
            }
            // 3 choices.
            if (idSelectedList.get(2) == 1) {
                priceFuelTank = strPartPrice[1];
            }else {
                priceFuelTank = "0.0";
            }

            if (idSelectedList.get(3) == 1) {
                priceAirFilter = strPartPrice[2];
            }else if (idSelectedList.get(3) == 2){
                priceAirFilter = "150";
            }else {
                priceAirFilter = "0.0";
            }
            // 3 choices.
            if (idSelectedList.get(4) == 1) {
                priceCarburetor = strPartPrice[3];
            }else {
                priceCarburetor = "0.0";
            }

            if (idSelectedList.get(5) == 1 ) {
                priceCylinderSet = strPartPrice [4];
            }else {
                priceCylinderSet = "0.0";
            }

            if (idSelectedList.get(6) == 1) {
                priceBallValveSwitchOil = strPartPrice [5];
            }else {
                priceBallValveSwitchOil = "0.0";
            }

            if (idSelectedList.get(7) == 1) {
                priceMuffler = strPartPrice [6];
            }else {
                priceMuffler = "0.0";
            }

            if (idSelectedList.get(8) == 1) {
                priceSwitchOnOff = strPartPrice [7];
            }else {
                priceSwitchOnOff = "0.0";
            }

            if (idSelectedList.get(9) == 1) {
                priceCoil = strPartPrice [8];
            }else {
                priceCoil = "0.0";
            }

            if (idSelectedList.get(10) == 1) {
                priceFuelTankCap = strPartPrice[9];
            }else {
                priceFuelTankCap = "0.0";
            }

            if (idSelectedList.get(11) == 1) {
                priceNewPaint = strPartPrice[10];
            }else {
                priceNewPaint = "0.0";
            }

            if (idSelectedList.get(12) == 1) {
                priceOilTankCap = strPartPrice[11];
            }else {
                priceOilTankCap = "0.0";
            }

            if (idSelectedList.get(13) == 1) {
                priceSparkPlug = strPartPrice[12];
            }else {
                priceSparkPlug = "0.0";
            }

        }else{

            if (idSelectedList.get(1) == 1) {
                priceFuelTank = strPartPrice[1];
            }else {
                priceFuelTank = "0.0";
            }

            if (idSelectedList.get(2) == 1) {
                priceAirFilter = strPartPrice[2];
            }else if (idSelectedList.get(3) == 2){
                priceAirFilter = "150";
            }else {
                priceAirFilter = "0.0";
            }

            if (idSelectedList.get(3) == 1 ) {
                priceCylinderSet = strPartPrice [4];
            }else {
                priceCylinderSet = "0.0";
            }

            if (idSelectedList.get(4) == 1) {
                priceBallValveSwitchOil = strPartPrice [5];
            }else {
                priceBallValveSwitchOil = "0.0";
            }

            if (idSelectedList.get(5) == 1) {
                priceMuffler = strPartPrice [6];
            }else {
                priceMuffler = "0.0";
            }

            if (idSelectedList.get(6) == 1) {
                priceSwitchOnOff = strPartPrice [7];
            }else {
                priceSwitchOnOff = "0.0";
            }

            if (idSelectedList.get(7) == 1) {
                priceFuelTankCap = strPartPrice[9];
            }else {
                priceFuelTankCap = "0.0";
            }

            if (idSelectedList.get(8) == 1) {
                priceNewPaint = strPartPrice[10];
            }else {
                priceNewPaint = "0.0";
            }

            if (idSelectedList.get(9) == 1) {
                priceOilTankCap = strPartPrice[11];
            }else {
                priceOilTankCap = "0.0";
            }

            if (idSelectedList.get(10) == 1) {
                priceSparkPlug = strPartPrice[12];
            }else {
                priceSparkPlug = "0.0";
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
        Toast.makeText(this, strPartPrice[12], Toast.LENGTH_SHORT).show();
        Toast.makeText(this, strPartPrice[13], Toast.LENGTH_SHORT).show();*/

    }

    private void bindWidget() {
        txtAmount = (TextView) findViewById(R.id.txtAmountGX160);
        listViewEstimatedGX160 = (ListView) findViewById(R.id.listViewEstimatedGX160);
    }

    public void intentBuyGX160(View view){
        if (idxEngine == 0) {
            idxEnginePass = "0";
        }else{
            idxEnginePass = "1";
        }

        Intent intentBuyGX160 = new Intent(this, BuyEstimatedGX160.class);
        intentBuyGX160.putExtra("amount", dAmount.toString());
        intentBuyGX160.putExtra("partName", strName);
        intentBuyGX160.putExtra("partPrice", strPrice);
        intentBuyGX160.putExtra("idxEngine", idxEnginePass);

        startActivity(intentBuyGX160);
    }

}
