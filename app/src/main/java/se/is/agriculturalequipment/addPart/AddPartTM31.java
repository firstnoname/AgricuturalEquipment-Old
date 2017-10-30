package se.is.agriculturalequipment.addPart;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import se.is.agriculturalequipment.R;
import se.is.agriculturalequipment.SettingPartsTM31;
import se.is.agriculturalequipment.TableTM31;

public class AddPartTM31 extends AppCompatActivity {

    private Button btnSavePartTM31;
    private EditText edtName, edtPrice;
    private TableTM31 objTableTM31;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_part_tm31);

        bindWidget();

        createAndConnectDB();

        btnSavePartTM31.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                savePartTM31();
                intentSettingTM31();
                finish();
            }
        });
    }

    private void savePartTM31() {
        String part_tm31_name = edtName.getText().toString();
        String part_tm31_price = edtPrice.getText().toString();

        objTableTM31.addNewPart(part_tm31_name, part_tm31_price);
    }

    private void intentSettingTM31(){
        Intent intentSettingTM31 = new Intent(this, SettingPartsTM31.class);
        startActivity(intentSettingTM31);
    }

    private void createAndConnectDB() {
        objTableTM31 = new TableTM31(this);
    }

    private void bindWidget() {
        edtName = (EditText) findViewById(R.id.edtTM31Name);
        edtPrice = (EditText) findViewById(R.id.edtTM31Price);
        btnSavePartTM31 = (Button) findViewById(R.id.btnSaveTM31);
    }


}
