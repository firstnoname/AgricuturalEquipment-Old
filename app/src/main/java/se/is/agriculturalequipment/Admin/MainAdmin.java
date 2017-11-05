package se.is.agriculturalequipment.Admin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import se.is.agriculturalequipment.R;

public class MainAdmin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_admin);

        Button btnOwner = (Button) findViewById(R.id.btnOwner);
        Button btnEmp = (Button) findViewById(R.id.btnEmp);

        btnOwner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentOwner = new Intent(getApplicationContext(), OwnerPage.class);
                startActivity(intentOwner);
            }
        });

        btnEmp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }


}
