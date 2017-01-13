package se.is.agriculturalequipment;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddPartGX160 extends AppCompatActivity {

    private TableGX160 objTableGX160;
    private Button btnSavePartGX160;
    private EditText edtName, edtPrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_part_gx160);

        bindWidget();

        createAndConnectDB();

        btnSavePartGX160.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                savePartGX160();
                intentSettingGX160(v);
                finish();
            }
        });
    }

    private void intentSettingGX160(View view) {
        Intent intentSettingGX160 = new Intent(this, SettingPartGX160.class);
        startActivity(intentSettingGX160);
    }

    private void savePartGX160() {
        String part_gx160_name = edtName.getText().toString();
        String part_gx160_price = edtPrice.getText().toString();

        objTableGX160.addNewPart(part_gx160_name, part_gx160_price);
    }

    private void createAndConnectDB() {
        objTableGX160 = new TableGX160(this);
    }

    private void bindWidget() {
        btnSavePartGX160 = (Button) findViewById(R.id.btnSaveGX160);
        edtName = (EditText) findViewById(R.id.edtGX160Name);
        edtPrice = (EditText) findViewById(R.id.edtGX160Price);
    }
}
