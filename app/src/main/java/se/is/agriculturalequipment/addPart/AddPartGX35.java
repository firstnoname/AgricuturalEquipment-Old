package se.is.agriculturalequipment.addPart;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import se.is.agriculturalequipment.R;
import se.is.agriculturalequipment.SettingPartsGX35;
import se.is.agriculturalequipment.TableGX35;

public class AddPartGX35 extends AppCompatActivity {

    private TableGX35 objTableGX35;
    private EditText edtName, edtPrice;
    private Button btnSavePartGX35;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_part_gx35);

        bindWidget();

        createAndConnectDB();

        btnSavePartGX35.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                savePartGX35();
                intentSettingGX35(v);
                finish();
            }
        });
    }

    private void intentSettingGX35(View v) {
        Intent intentSettingGX35 = new Intent(this, SettingPartsGX35.class);
        startActivity(intentSettingGX35);
    }

    private void savePartGX35() {
        String part_gx35_name = edtName.getText().toString();
        String part_gx35_price = edtPrice.getText().toString();

        objTableGX35.addNewPart(part_gx35_name, part_gx35_price);
    }

    private void createAndConnectDB() {
        objTableGX35 = new TableGX35(this);
    }

    private void bindWidget() {
        edtName = (EditText) findViewById(R.id.edtGX35Name);
        edtPrice = (EditText) findViewById(R.id.edtGX35Price);
        btnSavePartGX35 = (Button) findViewById(R.id.btnSaveGX35);
    }
}
