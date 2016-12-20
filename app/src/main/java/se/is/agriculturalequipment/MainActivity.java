package se.is.agriculturalequipment;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void intentHistory(View view){

    }

    public void intentMenuEstimate(View view){
        Intent intentMenuEstimate = new Intent(this, MenuEstimate.class);
        startActivity(intentMenuEstimate);
    }

    public void intentMenuSetting(View view){
        Intent intentMenuSetting = new Intent(this, MenuSetting.class);
        startActivity(intentMenuSetting);
    }
}
