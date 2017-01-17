package se.is.agriculturalequipment;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

public class SettingPartsGX35 extends AppCompatActivity {

    private ListView listViewGX35;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting_parts_gx35);

        bindWidget();

        createListView();
    }

    private void createListView() {
        TableGX35 objTableGX35 = new TableGX35(this);
        String[] strPartName = objTableGX35.readPartName();
        String[] strPartPrice = objTableGX35.readPartPrice();

        MyAdapter objMyAdapter = new MyAdapter(SettingPartsGX35.this, strPartName, strPartPrice);
        listViewGX35.setAdapter(objMyAdapter);
    }

    private void bindWidget() {
        listViewGX35 = (ListView) findViewById(R.id.listViewGX35);
    }

    public void intentAddPartGX35(View view){
        Intent intentGX35 = new Intent(this, AddPartGX35.class);
        startActivity(intentGX35);
        finish();
    }


}
