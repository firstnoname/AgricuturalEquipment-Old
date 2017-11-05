package se.is.agriculturalequipment;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import se.is.agriculturalequipment.addPart.AddPartGX35;
import se.is.agriculturalequipment.DAO.PartDAO;
import se.is.agriculturalequipment.model.PartList;

public class SettingPartsGX35 extends AppCompatActivity {

    private ListView listViewGX35;
    private TableGX35 objTableGX35;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting_parts_gx35);

        bindWidget();

//        createAndConnectDB();

//        addDefaultPart();

//        createListView();
    }

    @Override
    protected void onResume() {
        super.onResume();
        PartDAO partDAO = new PartDAO(getApplicationContext());
        partDAO.open();
        //ArrayList<String> myList = partDAO.getAllPart("G200TABLE");
        /*ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, myList);*/
        ArrayList<PartList> myList = partDAO.getAllPart("GX35TABLE");
        final ListviewAdapterSettingList adapter = new ListviewAdapterSettingList(myList,this);

        listViewGX35.setAdapter(adapter);
        partDAO.close();

        //Set when click on item list.
        listViewGX35.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Toast.makeText(SettingPartsG200.this, String.valueOf(adapter.getItemId(position)), Toast.LENGTH_SHORT).show();
                Intent intentEdit = new Intent(getApplicationContext(), EditPart.class);
                intentEdit.putExtra("editPartList", adapter.getItem(position));
                intentEdit.putExtra("tblName", "GX35");
                startActivity(intentEdit);
            }
        });
    }

    private void addDefaultPart() {
        objTableGX35.addNewPart("จานกระตุกชุด","350");
        objTableGX35.addNewPart("เขี้ยวสตาร์ท","100");
        objTableGX35.addNewPart("เชือกดึง","30");
        objTableGX35.addNewPart("ถังน้ำมัน","350");
        objTableGX35.addNewPart("หม้อกรองอากาศ", "250");
        objTableGX35.addNewPart("ลูกสูบ","250");
        objTableGX35.addNewPart("คาร์บูเรเตอร์","550");
        objTableGX35.addNewPart("เสื้อสูบ","850");
        objTableGX35.addNewPart("ก๊อกน้ำมัน","120");
        objTableGX35.addNewPart("ท่อไอเสีย", "210");
        objTableGX35.addNewPart("สวิตช์ปิดเปิด", "80");
        objTableGX35.addNewPart("คอยล์ + CDI","550");
        objTableGX35.addNewPart("ฝาถังน้ำมัน","50");
        objTableGX35.addNewPart("ทำสี","120");
        objTableGX35.addNewPart("มือเร่ง", "180");
        objTableGX35.addNewPart("ใบมีด", "150");
        objTableGX35.addNewPart("คอตัดหญ้า","800");
        objTableGX35.addNewPart("กระบอกหาง","580");
        objTableGX35.addNewPart("แกนเพลา","280");

    }

    private void createAndConnectDB() {
        objTableGX35 = new TableGX35(this);
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
