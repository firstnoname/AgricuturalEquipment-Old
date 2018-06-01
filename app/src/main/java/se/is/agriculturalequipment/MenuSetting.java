package se.is.agriculturalequipment;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenuSetting extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_setting);

    }

    public void intentSelectSettingG200(View view) {
        Intent intentSettingG200 = new Intent(this, SettingPartsG200.class);
        startActivity(intentSettingG200);
    }

    public void intentSelectSettingGX160(View view) {
        Intent intentSettingGX160 = new Intent(this, SettingPartGX160.class);
        startActivity(intentSettingGX160);
    }

    public void intentSelectSettingGX35(View view) {
        Intent intentSettingGX35 = new Intent(this, SettingPartsGX35.class);
        startActivity(intentSettingGX35);
    }

    public void intentSelectSettingT200(View view) {
        Intent intentSettingT200 = new Intent(this, SettingPartsT200.class);
        startActivity(intentSettingT200);
    }

    public void intentSelectSettingTM31(View view) {
        Intent intentSettingTM31 = new Intent(this, SettingPartsTM31.class);
        startActivity(intentSettingTM31);
    }

}