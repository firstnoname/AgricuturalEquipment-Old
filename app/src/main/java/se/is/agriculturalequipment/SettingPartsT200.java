package se.is.agriculturalequipment;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import se.is.agriculturalequipment.addPart.AddPartT200;
import se.is.agriculturalequipment.DAO.PartDAO;
import se.is.agriculturalequipment.model.PartList;

public class SettingPartsT200 extends AppCompatActivity {

    private ListView listViewT200;
    private TableT200 objTableT200;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting_parts_t200);

        bindWidget();



//        addDefaultPart();

//        createListView();
    }

    @Override
    protected void onResume() {
        super.onResume();

        PartDAO partDAO = new PartDAO(getApplicationContext());
        partDAO.open();
        ArrayList<PartList> myList = partDAO.getAllPart("T200TABLE");
        final ListviewAdapterSettingList adapter = new ListviewAdapterSettingList(myList,this);

        listViewT200.setAdapter(adapter);
        partDAO.close();

        //Set when click on item list.
        listViewT200.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Toast.makeText(SettingPartsG200.this, String.valueOf(adapter.getItemId(position)), Toast.LENGTH_SHORT).show();
                Intent intentEdit = new Intent(getApplicationContext(), EditPart.class);
                intentEdit.putExtra("editPartList", adapter.getItem(position));
                intentEdit.putExtra("tblName", "T200");
                startActivity(intentEdit);
            }
        });
    }

    private void addDefaultPart() {
        objTableT200.addNewPart("จานกระตุกชุด","340");
        objTableT200.addNewPart("เขี้ยวสตาร์ท","120");
        objTableT200.addNewPart("เชือกดึง","30");
        objTableT200.addNewPart("ถังน้ำมัน","280");
        objTableT200.addNewPart("หม้อกรองอากาศ","250");
        objTableT200.addNewPart("ลูกสูบ","220");
        objTableT200.addNewPart("คาร์บูเรเตอร์","480");
        objTableT200.addNewPart("เสื้อสูบ","650");
        objTableT200.addNewPart("ก๊อกน้ำมัน","120");
        objTableT200.addNewPart("ท่อไอเสีย","160");
        objTableT200.addNewPart("สวิตช์ปิดเปิด","80");
        objTableT200.addNewPart("คอยล์ + CDI","550");
        objTableT200.addNewPart("ฝาถังน้ำมัน","50");
        objTableT200.addNewPart("ทำสี","120");
        objTableT200.addNewPart("มือเร่ง","160");
        objTableT200.addNewPart("ใบมีด","150");
        objTableT200.addNewPart("คอตัดหญ้า","750");
        objTableT200.addNewPart("กระบอกหาง","580");
        objTableT200.addNewPart("แกนเพลา","280");
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
