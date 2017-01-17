package se.is.agriculturalequipment;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddPartT200 extends AppCompatActivity {

    private TableT200 objTableT200;
    private Button btnSavePartT200;
    private EditText edtName, edtPrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_part_t200);

        bindWidget();

        createAndConnectDB();

        btnSavePartT200.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                savePartT200();
                intentSettingT200();
                finish();
            }
        });
    }

    private void intentSettingT200() {
        Intent intentSettingT200 = new Intent(this, SettingPartsT200.class);
        startActivity(intentSettingT200);
    }

    public void savePartT200() {
        String part_t200_name = edtName.getText().toString();
        String part_t200_price = edtPrice.getText().toString();

        objTableT200.addNewPart(part_t200_name, part_t200_price);
    }

    private void createAndConnectDB() {
        objTableT200 = new TableT200(this);
    }

    private void bindWidget() {
        btnSavePartT200 = (Button) findViewById(R.id.btnSaveT200);
        edtName = (EditText) findViewById(R.id.edtT200Name);
        edtPrice = (EditText) findViewById(R.id.edtT200Price);
    }

}
