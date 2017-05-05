package se.is.agriculturalequipment;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

public class SettingPartsTM31 extends AppCompatActivity {

    private ListView listViewTM31;
    private TableTM31 objTableTM31;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting_parts_tm31);

        bindWidget();

        addDefaultPart();

        createListView();
    }

    private void addDefaultPart() {
        objTableTM31.addNewPart("ฝาถังน้ำมันเครื่อง","50");
        objTableTM31.addNewPart("หม้อลม","350");
        objTableTM31.addNewPart("ลูกยางชุด","220");
        objTableTM31.addNewPart("ตัวตั้งโปโล","580");
        objTableTM31.addNewPart("ท่อนดูด","350");
        objTableTM31.addNewPart("ท่อนส่ง","550");
        objTableTM31.addNewPart("ลูกสูบ","220");
        objTableTM31.addNewPart("มู่เล่ย์","280");
        objTableTM31.addNewPart("เกย์วัดความดัน","180");
        objTableTM31.addNewPart("ก๊อกน้ำ","65");
        objTableTM31.addNewPart("ทำสี","80");
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
