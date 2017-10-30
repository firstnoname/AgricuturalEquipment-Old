package se.is.agriculturalequipment;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import se.is.agriculturalequipment.addPart.AddPartG200;

public class SettingPartsG200 extends AppCompatActivity {

    private ListView listViewG200;
    private TableG200 objTableG200;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting_parts_g200);

        bindWidget();

        createAndConnectDB();

        addDefaultPart();

        //Crete listview.
        createListView();
    }

    private void createAndConnectDB() {
        objTableG200 = new TableG200(this);
    }

    public void addDefaultPart() {
        /*objTableG200.addNewPart("ทำสี","120");
        objTableG200.addNewPart("ฝาถังน้ำมัน", "50");
        objTableG200.addNewPart("ฝาถังน้ำมันเครื่อง", "50");
        objTableG200.addNewPart("จานกระตุกชุด","450");
        objTableG200.addNewPart("เชือกดึง","30");
        objTableG200.addNewPart("เขี้ยวสตาร์ท","80 ");
        objTableG200.addNewPart("ท่อไอเสีย","160");
        objTableG200.addNewPart("ปลั๊กหัวเทีียน","30");
        objTableG200.addNewPart("คาร์บูเรเตอร์","450");
        objTableG200.addNewPart("คอยล์","580");
        objTableG200.addNewPart("ก๊อกน้ำมัน","150");
        objTableG200.addNewPart("หม้อกรองอากาศ","250");
        objTableG200.addNewPart("สวิตช์ปิดเปิด","120");
        objTableG200.addNewPart("ลูกสูบ","480");
        objTableG200.addNewPart("เสื้อสูบ","2200");
        objTableG200.addNewPart("ถังน้ำมัน","700");*/
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
        listViewG200 = (ListView) findViewById(R.id.listViewG200);

    }
}
