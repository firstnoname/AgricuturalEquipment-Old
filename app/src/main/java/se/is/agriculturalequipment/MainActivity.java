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
        addDefaultPartG200();
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

}
