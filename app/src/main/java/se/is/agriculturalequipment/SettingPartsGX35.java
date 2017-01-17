package se.is.agriculturalequipment;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class SettingPartsGX35 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting_parts_gx35);
    }

    public void intentAddPartGX35(View view){
        Intent intentGX35 = new Intent(this, AddPartGX35.class);
        startActivity(intentGX35);
        finish();
    }
}
