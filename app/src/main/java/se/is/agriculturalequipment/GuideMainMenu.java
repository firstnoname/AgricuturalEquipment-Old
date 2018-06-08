package se.is.agriculturalequipment;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class GuideMainMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide_main_menu);

    }

    public void intentGuideG200(View view){
        Intent intentGuideG200 = new Intent(this,GuideG200.class);
        startActivity(intentGuideG200);
    }

    public void intentGuideGX160(View view) {
        Intent intentGuideGX160 = new Intent(this, GuideGX160.class);
        startActivity(intentGuideGX160);
    }

    public void intentGuideT200(View view) {
        Intent intentGuideT200 = new Intent(this, GuideT200.class);
        startActivity(intentGuideT200);
    }

    public void intentGuideTM31(View view) {
        Intent intentGuideTM31 = new Intent(this, GuideTM31.class);
        startActivity(intentGuideTM31);
    }

    public void intentGuideGX35(View view) {
        Intent intentGuideGX35 = new Intent(this, GuideGX35.class);
        startActivity(intentGuideGX35);
    }
}
