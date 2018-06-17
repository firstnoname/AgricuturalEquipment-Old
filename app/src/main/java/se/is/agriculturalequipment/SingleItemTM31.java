package se.is.agriculturalequipment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import se.is.agriculturalequipment.DAO.ChangeStatusDAOServer;
import se.is.agriculturalequipment.model.TM31;

public class SingleItemTM31 extends AppCompatActivity {

    Button btnChangeStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_item_tm31);

        TM31 tm31 = (TM31) getIntent().getSerializableExtra("editTM31");
        final String table_name = getIntent().getStringExtra("table_name");
        final String id_who_buy;

        TextView txtID = (TextView) findViewById(R.id.txtIdCustomer);
        TextView txtName = (TextView) findViewById(R.id.txtName);
        TextView txtEngine = (TextView) findViewById(R.id.txtEngine);
        TextView txtAirChamber = (TextView) findViewById(R.id.txtAirChamber);
        TextView txtSealSet = (TextView) findViewById(R.id.txtSealSet);
        TextView txtAdjustSet = (TextView) findViewById(R.id.txtAdjustSet);
        TextView txtDischargeMetal = (TextView) findViewById(R.id.txtDischargeMetal);
        TextView txtSuctionMetal = (TextView) findViewById(R.id.txtSuctionMetal);
        TextView txtPistonSet = (TextView) findViewById(R.id.txtPistonSet);
        TextView txtStarterRopeReel = (TextView) findViewById(R.id.txtStarterRopeReel);
        TextView txtPressureGauge = (TextView) findViewById(R.id.txtPressureGauge);
        TextView txtBallValveSwitch = (TextView) findViewById(R.id.txtBallValveSwitch);
        TextView txtOilFilter = (TextView) findViewById(R.id.txtOilFilter);
        TextView txtOilTankCap = (TextView) findViewById(R.id.txtOilTankCap);
        TextView txtDealStatus = (TextView) findViewById(R.id.txtDealStatus);
        TextView txtBuyDate = (TextView) findViewById(R.id.txtBuyDate);
        TextView txtAmount = (TextView) findViewById(R.id.txtAmount);

        btnChangeStatus = (Button) findViewById(R.id.btnChangeStatus);

        txtID.setText(tm31.getIdentification_no());
        txtName.setText(tm31.getName());
        txtEngine.setText(tm31.getEngineStatus());
        txtAirChamber.setText(tm31.getAirChamber());
        txtSealSet.setText(tm31.getSealSet());
        txtAdjustSet.setText(tm31.getAdjustSet());
        txtDischargeMetal.setText(tm31.getDischargeMetal());
        txtSuctionMetal.setText(tm31.getSuctionMetal());
        txtPistonSet.setText(tm31.getPistonSet());
        txtStarterRopeReel.setText(tm31.getStarterRopeReel());
        txtPressureGauge.setText(tm31.getPressureGauge());
        txtBallValveSwitch.setText(tm31.getBallValveSwitch());
        txtOilFilter.setText(tm31.getOilFilter());
        txtOilTankCap.setText(tm31.getOilTankCap());
        txtDealStatus.setText(tm31.getDealStatus());
        txtBuyDate.setText(tm31.getBuyDate());
        txtAmount.setText(tm31.getAmount());
        id_who_buy = tm31.getId_buy_tm31();
        if(tm31.getDealStatus().contains("Buy")){
            btnChangeStatus.setVisibility(View.INVISIBLE);
        } else {
            btnChangeStatus.setText("ซื้อ");
        }


        btnChangeStatus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ChangeStatusDAOServer updateDealStatus = new ChangeStatusDAOServer(getApplicationContext());
                updateDealStatus.updateDealStatus(id_who_buy, table_name);

                Toast.makeText(SingleItemTM31.this, "เปลี่ยนสถานะการซื้อสำเร็จ.", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}
