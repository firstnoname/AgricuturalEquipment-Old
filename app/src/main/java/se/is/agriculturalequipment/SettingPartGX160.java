package se.is.agriculturalequipment;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class SettingPartGX160 extends AppCompatActivity {

    private FloatingActionButton Fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting_part_gx160);

        bindWidget();

    }

    public void intentAddPartGX160(View view){
        Intent intentGX160 = new Intent(this, AddPartGX160.class);
        startActivity(intentGX160);
    }

    private void bindWidget() {
        Fab = (FloatingActionButton) findViewById(R.id.floatingActionButton);
    }
}
