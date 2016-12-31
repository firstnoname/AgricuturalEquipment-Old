package se.is.agriculturalequipment;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddPartG200 extends AppCompatActivity {


    private TableG200 objTableG200;
    private Button btnSavePartG200;
    private EditText edtName, edtPrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_part_g200);

        //create & connect database.
        createAndConnectDB();

        //insert data.
        //testInsert();

        //Bind widget.
        bindWidget();

        btnSavePartG200.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                savePartG200();
                intentSettingG200(view);
            }
        });
    }

    private void bindWidget() {
        edtName = (EditText) findViewById(R.id.edtG200Name);
        edtPrice = (EditText) findViewById(R.id.edtG200Price);
        btnSavePartG200 = (Button) findViewById(R.id.btnSaveG200);
    }

    private void createAndConnectDB() {
        objTableG200 = new TableG200(this);
    }

    public void savePartG200(){
        String part_g200_name = edtName.getText().toString();
        String part_g200_price = edtPrice.getText().toString();

        objTableG200.addNewPart(part_g200_name, part_g200_price);
    }

    public void intentSettingG200(View view){
        Intent intentSettingG200 = new Intent(this, SettingPartsG200.class);
        startActivity(intentSettingG200);
    }

    private void testInsert() {
        objTableG200.addNewPart("อะไหล่","200");
    }

}
