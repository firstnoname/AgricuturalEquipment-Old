package se.is.agriculturalequipment;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

public class SettingPartGX160 extends AppCompatActivity {

    private TableGX160 objTableGX160;
    private ListView listViewGX160;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_setting_part_gx160);

        bindWidget();

        createAndConnectDB();

        addDefaultPart();

        createListView();
    }

    private void addDefaultPart() {
            objTableGX160.addNewPart("ทำสี", "120");
            objTableGX160.addNewPart("ฝาถังน้ำมัน", "50");
            objTableGX160.addNewPart("ฝาถังน้ำมันเครื่อง", "50");
            objTableGX160.addNewPart("จานกระตุกชุด", "420");
            objTableGX160.addNewPart("เชือกดึง", "30");
            objTableGX160.addNewPart("เขี้ยวสตาร์ท", "70");
            objTableGX160.addNewPart("ท่อไอเสีย", "160");
            objTableGX160.addNewPart("ปลั๊กหัวเทีียน", "30");
            objTableGX160.addNewPart("คาร์บูเรเตอร์", "420");
            objTableGX160.addNewPart("คอยล์", "550");
            objTableGX160.addNewPart("ก๊อกน้ำมัน", "150");
            objTableGX160.addNewPart("หม้อกรองอากาศ", "300");
            objTableGX160.addNewPart("สวิตช์ปิดเปิด", "120");
            objTableGX160.addNewPart("เสื้อสูบ", "180");
            objTableGX160.addNewPart("ลูกสูบ", "380");
            objTableGX160.addNewPart("ถังน้ำมัน", "650");

    }

    private void createAndConnectDB() {
        objTableGX160 = new TableGX160(this);
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
        listViewGX160 = (ListView) findViewById(R.id.listViewGX160);
    }
}
