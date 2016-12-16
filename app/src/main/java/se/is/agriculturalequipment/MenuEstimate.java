package se.is.agriculturalequipment;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MenuEstimate extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_estimate);
    }

    public void intentSelectEstimateG200(View view){
        Intent intentSelEstimateG200 = new Intent(this, EstimateG200.class);
        startActivity(intentSelEstimateG200);
    }



}
