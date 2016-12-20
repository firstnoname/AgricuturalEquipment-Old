package se.is.agriculturalequipment;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SettingPartsG200 extends AppCompatActivity {

    private FloatingActionButton fab;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting_parts_g200);

        bindWidget();

    }

    public void intentAddPartG200(View view){
        Intent intentAddPart = new Intent(this, AddPartG200.class);
        startActivity(intentAddPart);
    }

    private void bindWidget() {
        fab = (FloatingActionButton) findViewById(R.id.floatingActionButton);
    }
}
