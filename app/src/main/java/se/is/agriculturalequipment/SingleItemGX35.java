package se.is.agriculturalequipment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import se.is.agriculturalequipment.DAO.ChangeStatusDAOServer;
import se.is.agriculturalequipment.model.GX35;

public class SingleItemGX35 extends AppCompatActivity {

    Button btnChangeStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_item_gx35);

        GX35 edtGx35 = (GX35) getIntent().getSerializableExtra("editGX35");
        final String table_name = getIntent().getStringExtra("table_name");
        final String id_who_buy;

        TextView txtID = (TextView) findViewById(R.id.txtIdCustomer);
        TextView txtName = (TextView) findViewById(R.id.txtName);
        TextView txtEngine = (TextView) findViewById(R.id.txtEngine);
        TextView txtStarter = (TextView) findViewById(R.id.txtStarter);
        TextView txtControlSwitch = (TextView) findViewById(R.id.txtControlSwitch);
        TextView txtBrushCutterBlade = (TextView) findViewById(R.id.txtBrushCutterBlade);
        TextView txtFuelTank = (TextView) findViewById(R.id.txtFuelTank);
        TextView txtAirFilter = (TextView) findViewById(R.id.txtAirFilter);
        TextView txtCarburetor = (TextView) findViewById(R.id.txtCarburetor);
        TextView txtCylinderSet = (TextView) findViewById(R.id.txtCylinderSet);
        TextView txtBallValveSwitchOil = (TextView) findViewById(R.id.txtBallValveSwitchOil);
        TextView txtMuffler = (TextView) findViewById(R.id.txtMuffler);
        TextView txtGearDiver = (TextView) findViewById(R.id.txtGearDiver);
        TextView txtMainPipe = (TextView) findViewById(R.id.txtMainPipe);
        TextView txtSwitchOnOff = (TextView) findViewById(R.id.txtSwitchOnOff);
        TextView txtCoil = (TextView) findViewById(R.id.txtCoil);
        TextView txtFuelTankCap = (TextView) findViewById(R.id.txtFuelTankCap);
        TextView txtNewPaint = (TextView) findViewById(R.id.txtNewPaint);
        TextView txtShaft = (TextView) findViewById(R.id.txtShaft);
        TextView txtOilTankCap = (TextView) findViewById(R.id.txtOilTankCap);
        TextView txtSparkPlug = (TextView) findViewById(R.id.txtSparkPlug);
        TextView txtDealStatus = (TextView) findViewById(R.id.txtDealStatus);
        TextView txtBuyDate = (TextView) findViewById(R.id.txtBuyDate);
        TextView txtAmount = (TextView) findViewById(R.id.txtAmount);

        btnChangeStatus = (Button) findViewById(R.id.btnChangeStatus);

        txtID.setText(edtGx35.getIdentification_no());
        txtName.setText(edtGx35.getName());
        txtEngine.setText(edtGx35.getEngineStatus());
        txtStarter.setText(edtGx35.getStarter());
        txtControlSwitch.setText(edtGx35.getControlSwitch());
        txtBrushCutterBlade.setText(edtGx35.getBrushCutterBlade());
        txtFuelTank.setText(edtGx35.getFuelTank());
        txtAirFilter.setText(edtGx35.getAirFilter());
        txtCarburetor.setText(edtGx35.getCarburetor());
        txtCylinderSet.setText(edtGx35.getCylinderSet());
        txtBallValveSwitchOil.setText(edtGx35.getBallValveSwitchOil());
        txtMuffler.setText(edtGx35.getMuffler());
        txtGearDiver.setText(edtGx35.getGearDiver());
        txtMainPipe.setText(edtGx35.getMainPipe());
        txtSwitchOnOff.setText(edtGx35.getSwitchOnOff());
        txtCoil.setText(edtGx35.getCoil());
        txtFuelTankCap.setText(edtGx35.getFuelTankCap());
        txtNewPaint.setText(edtGx35.getNewPaint());
        txtShaft.setText(edtGx35.getShaft());
        txtOilTankCap.setText(edtGx35.getOilTankCap());
        txtSparkPlug.setText(edtGx35.getSparkPlug());
        txtDealStatus.setText(edtGx35.getDealStatus());
        txtBuyDate.setText(edtGx35.getBuyDate());
        txtAmount.setText(edtGx35.getAmount());
        id_who_buy = edtGx35.getId_buy_gx35();


        //Check if deal status are Buy.

        /*if (edtGx35.getDealStatus() == "Buy") {
            Toast.makeText(this, "Equal Buy" + edtGx35.getDealStatus(), Toast.LENGTH_SHORT).show();
            //btnChangeStatus.setEnabled(false);
        } else {
            Toast.makeText(this, "Status is not Buy" + edtGx35.getDealStatus(), Toast.LENGTH_SHORT).show();
        }*/

        //Change status from Save to Buy.
        btnChangeStatus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ChangeStatusDAOServer updateDealStatus = new ChangeStatusDAOServer(getApplicationContext());
                updateDealStatus.updateDealStatus(id_who_buy, table_name);

                Toast.makeText(SingleItemGX35.this, "เปลี่ยนสถานะการซื้อสำเร็จ.", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}
