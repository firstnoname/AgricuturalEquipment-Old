package se.is.agriculturalequipment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
