package se.is.agriculturalequipment;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        addDefaultPartG200();
//        addDefaultPartGX35();
//        addDefaultPartGX160();
//        addDefaultPartT200();
//        addDefaultPartTM31();


    }

    public void intentHistory(View view){
        Intent intentMenuHistory = new Intent(this, HistoryActivity.class);
        startActivity(intentMenuHistory);
    }

    public void intentMenuEstimate(View view){
        Intent intentMenuEstimate = new Intent(this, MenuEstimate.class);
        startActivity(intentMenuEstimate);
    }

    public void intentMenuSetting(View view){
        Intent intentMenuSetting = new Intent(this, MenuSetting.class);
        startActivity(intentMenuSetting);
    }

    public void addDefaultPartG200(){
        TableG200 objG200 = new TableG200(this);
        objG200.addNewPart("จานกระตุกชุด", "450");
        objG200.addNewPart("ถังน้ำมัน", "700");
        objG200.addNewPart("หม้อกรองอากาศ", "250");
        objG200.addNewPart("คาร์บูเรเตอร์", "450");
        objG200.addNewPart("เสื้อสูบ", "2200");
        objG200.addNewPart("ก๊อกน้ำมัน", "150");
        objG200.addNewPart("ท่อไอเสีย", "160");
        objG200.addNewPart("สวิตช์ปิดเปิด", "120");
        objG200.addNewPart("คอยล์", "580");
        objG200.addNewPart("ฝาถังน้ำมัน", "50");
        objG200.addNewPart("ทำสี", "120");
        objG200.addNewPart("ฝาถังน้ำมันเครื่อง", "50");
        objG200.addNewPart("ปลั๊กหัวเทียน", "50");
//        Toast.makeText(this, "Add default!!", Toast.LENGTH_SHORT).show();
    }
    public void addDefaultPartGX160(){
        TableGX160 objGX160 = new TableGX160(this);
        objGX160.addNewPart("จานกระตุกชุด", "420");
        objGX160.addNewPart("ถังน้ำมัน", "650");
        objGX160.addNewPart("หม้อกรองอากาศ", "300");
        objGX160.addNewPart("คาร์บูเรเตอร์", "420");
        objGX160.addNewPart("เสื้อสูบ", "1800");
        objGX160.addNewPart("ก๊อกน้ำมัน", "150");
        objGX160.addNewPart("ท่อไอเสีย", "150");
        objGX160.addNewPart("สวิตช์ปิดเปิด", "120");
        objGX160.addNewPart("คอยล์", "550");
        objGX160.addNewPart("ฝาถังน้ำมัน", "50");
        objGX160.addNewPart("ทำสี", "120");
        objGX160.addNewPart("ฝาถังน้ำมันเครื่อง", "50");
        objGX160.addNewPart("ปลั๊กหัวเทียน", "50");
//        Toast.makeText(this, "Add default!!", Toast.LENGTH_SHORT).show();
    }

    public void addDefaultPartGX35(){
        TableGX35 objGX35 = new TableGX35(this);
        objGX35.addNewPart("จานกระตุกชุด", "350");
        objGX35.addNewPart("ถังน้ำมัน", "350");
        objGX35.addNewPart("มือเร่ง", "180");
        objGX35.addNewPart("ใบมีด", "150");
        objGX35.addNewPart("หม้อกรองอากาศ", "250");
        objGX35.addNewPart("คาร์บูเรเตอร์", "550");
        objGX35.addNewPart("เสื้อสูบ", "850");
        objGX35.addNewPart("ก๊อกน้ำมัน", "120");
        objGX35.addNewPart("ท่อไอเสีย", "210");
        objGX35.addNewPart("คอตัดหญ้า", "800");
        objGX35.addNewPart("กระบอกหาง", "580");
        objGX35.addNewPart("สวิตช์ปิดเปิด", "80");
        objGX35.addNewPart("คอยล์", "550");
        objGX35.addNewPart("ฝาถังน้ำมัน", "50");
        objGX35.addNewPart("ทำสี", "80");
        objGX35.addNewPart("แกนเพลา", "280");
        objGX35.addNewPart("ฝาถังน้ำมันเครื่อง", "50");
        objGX35.addNewPart("ปลั๊กหัวเทียน", "50");
//        Toast.makeText(this, "Add default!!", Toast.LENGTH_SHORT).show();
    }

    public void addDefaultPartT200(){
        TableT200 objT200 = new TableT200(this);
        objT200.addNewPart("จานกระตุกชุด", "340");
        objT200.addNewPart("ถังน้ำมัน", "280");
        objT200.addNewPart("มือเร่ง", "160");
        objT200.addNewPart("ใบมีด", "150");
        objT200.addNewPart("หม้อกรองอากาศ", "200");
        objT200.addNewPart("คาร์บูเรเตอร์", "480");
        objT200.addNewPart("เสื้อสูบ", "650");
        objT200.addNewPart("ก๊อกน้ำมัน", "120");
        objT200.addNewPart("ท่อไอเสีย", "160");
        objT200.addNewPart("คอตัดหญ้า", "750");
        objT200.addNewPart("กระบอกหาง", "580");
        objT200.addNewPart("สวิตช์ปิดเปิด", "80");
        objT200.addNewPart("คอยล์", "550");
        objT200.addNewPart("ฝาถังน้ำมัน", "50");
        objT200.addNewPart("ทำสี", "50");
        objT200.addNewPart("แกนเพลา", "280");
        objT200.addNewPart("ฝาถังน้ำมันเครื่อง", "50");

//        Toast.makeText(this, "Add default!!", Toast.LENGTH_SHORT).show();
    }

    public void addDefaultPartTM31(){
        TableTM31 objTM31 = new TableTM31(this);
        objTM31.addNewPart("หม้อลม", "350");
        objTM31.addNewPart("ลูกยางชุด", "220");
        objTM31.addNewPart("ตัวตั้งโปโล", "580");
        objTM31.addNewPart("ท่อนดูด", "350");
        objTM31.addNewPart("ท่อนส่ง", "550");
        objTM31.addNewPart("ลูกสูบ", "220");
        objTM31.addNewPart("มู่เล่ย์", "280");
        objTM31.addNewPart("เกย์วัดความดัน", "180");
        objTM31.addNewPart("ก๊อกน้ำ", "65");
        objTM31.addNewPart("ฝาปิดน้ำมันเครื่อง ", "50");
        objTM31.addNewPart("ทำสี", "80");
        objTM31.addNewPart("ฝาถังน้ำมันเครื่อง", "50");

//        Toast.makeText(this, "Add default!!", Toast.LENGTH_SHORT).show();
    }


}
