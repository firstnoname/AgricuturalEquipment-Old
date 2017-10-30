package se.is.agriculturalequipment.history;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import se.is.agriculturalequipment.HistoryActivity;
import se.is.agriculturalequipment.R;
import se.is.agriculturalequipment.SingleItemG200;

public class HistoryGX160List extends AppCompatActivity {

    Button btnTest;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history_gx160_list);

        btnTest = (Button) findViewById(R.id.btnTest);
        btnTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HistoryGX160List.this, SingleItemG200.class);
                startActivity(intent);


            }
        });
    }
}
