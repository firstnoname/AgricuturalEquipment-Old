package se.is.agriculturalequipment;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

public class SaveEstimated extends AppCompatActivity {

    private EditText edtName, edtIDNo, edtAmount;
    private String[] receiveName, receivePrice;
    private String receiveAmount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save_estimated);

        //Bind widget.
        bindWidget();

        //Get data from SubmitEstimateG200.java
        getData();

        edtAmount.setText(receiveAmount);

    }

    private void bindWidget() {
        edtName = (EditText) findViewById(R.id.edtName);
        edtIDNo = (EditText) findViewById(R.id.edtIdentificationNo);
        edtAmount = (EditText) findViewById(R.id.edtAmount);
    }

    private void getData() {
        Intent receiveIntent = this.getIntent();
        receiveName = receiveIntent.getStringArrayExtra("partName");
        receivePrice = receiveIntent.getStringArrayExtra("partPrice");
        receiveAmount = receiveIntent.getStringExtra("amount");
    }
}
