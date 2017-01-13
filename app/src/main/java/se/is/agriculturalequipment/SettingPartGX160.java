package se.is.agriculturalequipment;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

public class SettingPartGX160 extends AppCompatActivity {

    private FloatingActionButton Fab;
    private ListView listViewGX160;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_setting_part_gx160);

        bindWidget();

        createListView();
    }

    private void createListView() {
        TableGX160 objTableGX160 = new TableGX160(this);
        String[] strPartName = objTableGX160.readPartName();
        String[] strPartPrice = objTableGX160.readPartPrice();

        MyAdapter objMyAdapter = new MyAdapter(SettingPartGX160.this, strPartName, strPartPrice);
        listViewGX160.setAdapter(objMyAdapter);
    }

    public void intentAddPartGX160(View view){
        Intent intentGX160 = new Intent(this, AddPartGX160.class);
        startActivity(intentGX160);
        finish();
    }

    private void bindWidget() {
        Fab = (FloatingActionButton) findViewById(R.id.floatingActionButton);
        listViewGX160 = (ListView) findViewById(R.id.listViewGX160);
    }
}
