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

    public void intentSelectEstimateG200(View view) {
        Intent intentSelEstimateG200 = new Intent(this, EstimateG200.class);
        startActivity(intentSelEstimateG200);
    }

    public void intentSelectEstimateGX160(View view) {
        Intent intentSelEstimateGX160 = new Intent(this, EstimateGX160.class);
        startActivity(intentSelEstimateGX160);
    }

    public void intentSelectEstimateGX35(View view) {
        Intent intentSelEstimateGX35 = new Intent(this, EstimateGX35.class);
        startActivity(intentSelEstimateGX35);
    }

    public void intentSelectEstimateT200(View view) {
        Intent intentSelEstimateT200 = new Intent(this, EstimateT200.class);
        startActivity(intentSelEstimateT200);
    }

    public void intentSelectEstimateTM31(View view) {
        Intent IntentSelEstimateTM31 = new Intent(this, EstimateTM31.class);
        startActivity(IntentSelEstimateTM31);
    }

}
