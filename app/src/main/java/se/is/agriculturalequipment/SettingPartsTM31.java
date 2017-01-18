package se.is.agriculturalequipment;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

public class SettingPartsTM31 extends AppCompatActivity {

    private ListView listViewTM31;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting_parts_tm31);

        bindWidget();

        createListView();
    }

    private void createListView() {
        TableTM31 objTableTM31 = new TableTM31(this);
        String[] strPartName = objTableTM31.readPartName();
        String[] strPartPrice = objTableTM31.readPartPrice();

        MyAdapter objMyAdapter = new MyAdapter(SettingPartsTM31.this, strPartName, strPartPrice);
        listViewTM31.setAdapter(objMyAdapter);
    }

    private void bindWidget() {
        listViewTM31 = (ListView) findViewById(R.id.listViewTM31);
    }

    public void intentAddPartTM31(View view) {
        Intent intentAddPartTM31 = new Intent(this, AddPartTM31.class);
        startActivity(intentAddPartTM31);
        finish();
    }
}
