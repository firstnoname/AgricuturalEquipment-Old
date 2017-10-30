package se.is.agriculturalequipment;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class SubmitEstimateTM31 extends AppCompatActivity {

    private int idxEngine;
    private String priceAirChamber, priceSealSet, priceAdjustSet, priceDischargeMetal, priceSuctionMetal,
            pricePistonSet, priceStarterRopeReel, pricePressureGauge, priceBallValveSwitch, priceOilFilter,
            priceNewPaint,priceOilTankCap;
    private Double dAirChamber,  dSealSet, dAdjustSet, dDischargeMetal, dSuctionMetal, dPistonSet,
            dStarterRopeReel, dPressureGauge, dBallValveSwitch, dOilFilter, dNewPaint, dOilTankCap;
    private Double dAmount = 0.0;
    private TextView txtAmount;
    private ListView listViewEstimatedTM31;
    private String[] strName, strPrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submit_estimate_tm31);

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
                    dAirChamber.toString(),
                    dSealSet.toString(),
                    dAdjustSet.toString(),
                    dDischargeMetal.toString(),
                    dSuctionMetal.toString(),
                    dPistonSet.toString(),
                    dStarterRopeReel.toString(),
                    dPressureGauge.toString(),
                    dBallValveSwitch.toString(),
                    dOilFilter.toString(),
                    dNewPaint.toString(),
                    dOilTankCap.toString(),

            };

        }else {
            strPrice = new String[]{
                    "30%",
                    dAirChamber.toString(),
                    dSealSet.toString(),
                    dAdjustSet.toString(),
                    dDischargeMetal.toString(),
                    dSuctionMetal.toString(),
                    dPistonSet.toString(),
                    dStarterRopeReel.toString(),
                    dPressureGauge.toString(),
                    dBallValveSwitch.toString(),
                    dOilFilter.toString(),
                    dNewPaint.toString(),
                    dOilTankCap.toString(),

            };

        }

        strName = new String[strListName.size()];
        strName = strListName.toArray(strName);

        MyAdapter objMyAdapter = new MyAdapter(SubmitEstimateTM31.this, strName, strPrice);
        listViewEstimatedTM31.setAdapter(objMyAdapter);

        txtAmount.setText(dAmount.toString());
    }

    private void calculatePrice() {
        //Convert String to Double.
        if (idxEngine == 0) {
            dAirChamber = Double.parseDouble(priceAirChamber);
            dSealSet = Double.parseDouble(priceSealSet);
            dAdjustSet = Double.parseDouble(priceAdjustSet);
            dDischargeMetal = Double.parseDouble(priceDischargeMetal);
            dSuctionMetal = Double.parseDouble(priceSuctionMetal);
            dPistonSet = Double.parseDouble(pricePistonSet);
            dStarterRopeReel = Double.parseDouble(priceStarterRopeReel);
            dPressureGauge = Double.parseDouble(pricePressureGauge);
            dBallValveSwitch = Double.parseDouble(priceBallValveSwitch);
            dOilFilter = Double.parseDouble(priceOilFilter);
            dNewPaint = Double.parseDouble(priceNewPaint);
            dOilTankCap = Double.parseDouble(priceOilTankCap);

            //Estimate price.
            dAmount = 4400 - (dAirChamber + dSealSet + dAdjustSet + dDischargeMetal + dSuctionMetal +
                    dPistonSet + dStarterRopeReel + dPressureGauge + dBallValveSwitch + dOilFilter +  dNewPaint + dOilTankCap );

        }else {
            dAirChamber = Double.parseDouble(priceAirChamber);
            dSealSet = Double.parseDouble(priceSealSet);
            dAdjustSet = Double.parseDouble(priceAdjustSet);
            dDischargeMetal = Double.parseDouble(priceDischargeMetal);
            dSuctionMetal = Double.parseDouble(priceSuctionMetal);
            dPistonSet = Double.parseDouble(pricePistonSet);
            dStarterRopeReel = Double.parseDouble(priceStarterRopeReel);
            dPressureGauge = Double.parseDouble(pricePressureGauge);
            dBallValveSwitch = Double.parseDouble(priceBallValveSwitch);
            dOilFilter = Double.parseDouble(priceOilFilter);
            dNewPaint = Double.parseDouble(priceNewPaint);
            dOilTankCap = Double.parseDouble(priceOilTankCap);


            //Estimate price.
            dAmount = 4400-(dAirChamber + dSealSet + dAdjustSet + dDischargeMetal + dSuctionMetal +
                    dPistonSet + dStarterRopeReel + dPressureGauge + dBallValveSwitch + dOilFilter +  dNewPaint + dOilTankCap );
        }

    }

    private void getDataFromSQLite() {
        //Get data from EstimateTM31.
        idxEngine = getIntent().getIntExtra("idxEngine",0);
        /*if (idxEngine == -1) {
            idxEngine = 0;
        } else {
            idxEngine = 1;
        }*/

       /* ArrayList<String> testArrName = (ArrayList<String>) getIntent().getExtras().getSerializable("arrListName");
        Log.d("testArrName : ", testArrName.toString());*/

        ArrayList<Integer> idSelectedList = (ArrayList<Integer>) getIntent().getIntegerArrayListExtra("arrSelectedID");
        TableTM31 objTableTM31 = new TableTM31(this);
        String[] strPartPrice = objTableTM31.readPartPrice();

        //Compare data from SQLite.
        if (idxEngine == 0) {
            if (idSelectedList.get(1) == 1) {
                priceAirChamber = strPartPrice[0];
            }else {
                priceAirChamber = "0.0";
            }

            if (idSelectedList.get(2) == 1) {
                priceSealSet = strPartPrice[1];
            }else {
                priceSealSet = "0.0";
            }

            if (idSelectedList.get(3) == 1 ) {
                priceAdjustSet = strPartPrice [2];
            }else if (idSelectedList.get(3) == 2) {
                priceAdjustSet = "125";
            }else {
                priceAdjustSet = "0.0";
            }

            // 3 choices
            if (idSelectedList.get(4) == 1) {
                priceDischargeMetal = strPartPrice [3];
            }else {
                priceDischargeMetal = "0.0";
            }

            if (idSelectedList.get(5) == 1) {
                priceSuctionMetal = strPartPrice [4];
            }else {
                priceSuctionMetal = "0.0";
            }

            if (idSelectedList.get(6) == 1) {
                pricePistonSet = strPartPrice [5];
            }else {
                pricePistonSet = "0.0";
            }

            if (idSelectedList.get(7) == 1) {
                priceStarterRopeReel = strPartPrice [6];
            }else {
                priceStarterRopeReel = "0.0";
            }

            if (idSelectedList.get(8) == 1) {
                pricePressureGauge = strPartPrice[7];
            }else {
                pricePressureGauge = "0.0";
            }

            if (idSelectedList.get(9) == 1) {
                priceBallValveSwitch = strPartPrice[8];
            }else {
                priceBallValveSwitch = "0.0";
            }

            if (idSelectedList.get(10) == 1) {
                priceOilFilter = strPartPrice[9];
            }else {
                priceOilFilter = "0.0";
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



        }else{

            if (idSelectedList.get(1) == 1) {
                priceAirChamber = strPartPrice[0];
            }else {
                priceAirChamber = "0.0";
            }

            if (idSelectedList.get(2) == 1) {
                priceSealSet = strPartPrice[1];
            }else {
                priceSealSet = "0.0";
            }

            if (idSelectedList.get(3) == 1 ) {
                priceAdjustSet = strPartPrice [2];
            }else if (idSelectedList.get(3) == 2) {
                priceAdjustSet = "125";
            }else {
                priceAdjustSet = "0.0";
            }
            // 3 choices
            if (idSelectedList.get(4) == 1) {
                priceDischargeMetal = strPartPrice [3];
            }else {
                priceDischargeMetal = "0.0";
            }

            if (idSelectedList.get(5) == 1) {
                priceSuctionMetal = strPartPrice [4];
            }else {
                priceSuctionMetal = "0.0";
            }

            if (idSelectedList.get(6) == 1) {
                pricePistonSet = strPartPrice [5];
            }else {
                pricePistonSet = "0.0";
            }

            if (idSelectedList.get(7) == 1) {
                priceStarterRopeReel = strPartPrice [6];
            }else {
                priceStarterRopeReel = "0.0";
            }

            if (idSelectedList.get(8) == 1) {
                pricePressureGauge = strPartPrice[7];
            }else {
                pricePressureGauge = "0.0";
            }

            if (idSelectedList.get(9) == 1) {
                priceBallValveSwitch = strPartPrice[8];
            }else {
                priceBallValveSwitch = "0.0";
            }

            if (idSelectedList.get(10) == 1) {
                priceOilFilter = strPartPrice[9];
            }else {
                priceOilFilter = "0.0";
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
        txtAmount = (TextView) findViewById(R.id.txtAmountTM31);
        listViewEstimatedTM31 = (ListView) findViewById(R.id.listViewEstimatedTM31);
    }

    public void intentBuyTM31(View view) {
        Intent intentBuyTM31 = new Intent(this, BuyEstimated.class);
        intentBuyTM31.putExtra("amount", dAmount.toString());
        intentBuyTM31.putExtra("partName", strName);
        intentBuyTM31.putExtra("partPrice", strPrice);

        startActivity(intentBuyTM31);
    }

}
