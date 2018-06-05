package se.is.agriculturalequipment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import se.is.agriculturalequipment.model.G200;

public class SingleItemG200 extends AppCompatActivity {

    Button btnChangeStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_item_g200);

        //Get object from HistoryG200List.
        final G200 edtG200 = (G200) getIntent().getSerializableExtra("editG200");

        TextView txtID = (TextView) findViewById(R.id.txtIdCustomer);
        TextView txtName = (TextView) findViewById(R.id.txtName);
        TextView txtEngine = (TextView) findViewById(R.id.txtEngine);
        TextView txtStarter = (TextView) findViewById(R.id.txtStarter);
        TextView txtFuelTank = (TextView) findViewById(R.id.txtFuelTank);
        TextView txtAirFilter = (TextView) findViewById(R.id.txtAirFilter);
        TextView txtCarburetor = (TextView) findViewById(R.id.txtCarburetor);
        TextView txtCylinderSet = (TextView) findViewById(R.id.txtCylinderSet);
        TextView txtBallValveSwitchOil = (TextView) findViewById(R.id.txtBallValveSwitchOil);
        TextView txtMuffler = (TextView) findViewById(R.id.txtMuffler);
        TextView txtSwitchOnOff = (TextView) findViewById(R.id.txtSwitchOnOff);
        TextView txtCoil = (TextView) findViewById(R.id.txtCoil);
        TextView txtFuelTankCap = (TextView) findViewById(R.id.txtFuelTankCap);
        TextView txtNewPaint = (TextView) findViewById(R.id.txtNewPaint);
        TextView txtOilTankCap = (TextView) findViewById(R.id.txtOilTankCap);
        TextView txtSparkPlug = (TextView) findViewById(R.id.txtSparkPlug);
        TextView txtDealStatus = (TextView) findViewById(R.id.txtDealStatus);
        TextView txtBuyDate = (TextView) findViewById(R.id.txtBuyDate);
        TextView txtAmount = (TextView) findViewById(R.id.txtAmount);

        btnChangeStatus = (Button) findViewById(R.id.btnChangeStatus);


        txtID.setText(edtG200.getIdentification_no());
        txtName.setText(edtG200.getName());
        txtEngine.setText(edtG200.getEngineStatus());
        txtStarter.setText(edtG200.getStarter());
        txtFuelTank.setText(edtG200.getFuelTank());
        txtAirFilter.setText(edtG200.getAirFilter());
        txtCarburetor.setText(edtG200.getCarburetor());
        txtCylinderSet.setText(edtG200.getCylinderSet());
        txtBallValveSwitchOil.setText(edtG200.getBallValveSwitchOil());
        txtMuffler.setText(edtG200.getMuffler());
        txtSwitchOnOff.setText(edtG200.getSwitchOnOff());
        txtCoil.setText(edtG200.getCoil());
        txtFuelTankCap.setText(edtG200.getFuelTankCap());
        txtNewPaint.setText(edtG200.getNewPaint());
        txtOilTankCap.setText(edtG200.getOilTankCap());
        txtSparkPlug.setText(edtG200.getSparkPlug());
        txtDealStatus.setText(edtG200.getDealStatus());
        txtBuyDate.setText(edtG200.getBuyDate());
        txtAmount.setText(edtG200.getAmount());

        //Change status from Save to Buy.
        btnChangeStatus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}
