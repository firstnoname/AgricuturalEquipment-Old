package se.is.agriculturalequipment;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

public class SettingPartsT200 extends AppCompatActivity {

    private ListView listViewT200;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting_parts_t200);

        bindWidget();

        createListView();
    }

    private void createListView() {
        TableT200 objTableT200 = new TableT200(this);
        String[] strPartName = objTableT200.readPartName();
        String[] strPartPrice = objTableT200.readPartPrice();

        MyAdapter objMyAdapter = new MyAdapter(SettingPartsT200.this, strPartName, strPartPrice);
        listViewT200.setAdapter(objMyAdapter);
    }

    public void intentAddPartT200(View view) {
        Intent intentAddPartT200 = new Intent(this, AddPartT200.class);
        startActivity(intentAddPartT200);
        finish();
    }

    private void bindWidget() {
        listViewT200 = (ListView) findViewById(R.id.listViewT200);
    }
}
