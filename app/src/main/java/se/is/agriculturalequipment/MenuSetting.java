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

    public void intentSelectSettingG200(View view){
        Intent intentSettingG200 = new Intent(this, SettingPartsG200.class);
        startActivity(intentSettingG200);
    }

}