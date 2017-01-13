package se.is.agriculturalequipment;

import android.content.Intent;
import android.database.Cursor;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

public class SettingPartsG200 extends AppCompatActivity {

    private FloatingActionButton fab;
    private ListView listViewG200;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting_parts_g200);

        bindWidget();

        //Crete listview.
        createListView();
    }

    private void createListView() {
        TableG200 objTableG200 = new TableG200(this);
        String[] strPartName = objTableG200.readPartName();
        String[] strPartPrice = objTableG200.readPartPrice();

        MyAdapter objMyAdapter = new MyAdapter(SettingPartsG200.this, strPartName, strPartPrice);
        listViewG200.setAdapter(objMyAdapter);

    }//Create ListView.

    public void intentAddPartG200(View view){
        Intent intentAddPart = new Intent(this, AddPartG200.class);
        startActivity(intentAddPart);
        finish();
    }

    private void bindWidget() {
        fab = (FloatingActionButton) findViewById(R.id.floatingActionButton);
        listViewG200 = (ListView) findViewById(R.id.listViewG200);

    }
}
