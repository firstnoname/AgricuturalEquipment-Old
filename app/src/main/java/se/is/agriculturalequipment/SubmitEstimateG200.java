package se.is.agriculturalequipment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class SubmitEstimateG200 extends AppCompatActivity {

    private Integer getEngine, getBodyColor, getFuelTankCap, getOilFilter, getStarter, getMuffler,
        getSparkPlug, getCarburetor, getCoilCDI, getBallValueSwitchOil, getAirFilter, getSwitchOnOff;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submit_estimate_g200);

        Bundle bundle = getIntent().getExtras();
        getEngine = bundle.getInt("Engine");
        getBodyColor = bundle.getInt("BodyColor");
        getFuelTankCap = bundle.getInt("FuelTangCap");
        getOilFilter = bundle.getInt("OilFilter");
        getStarter = bundle.getInt("Starter");
        getMuffler = bundle.getInt("Muffler");
        getSparkPlug = bundle.getInt("SparkPlug");
        getCarburetor = bundle.getInt("Carburetor");
        getCoilCDI = bundle.getInt("CoilCDI");
        getBallValueSwitchOil = bundle.getInt("BallValueSwitchOil");
        getAirFilter = bundle.getInt("AirFilter");
        getSwitchOnOff = bundle.getInt("SwitchOnOff");


//        Toast.makeText(SubmitEstimateG200.this, strBodyColor, Toast.LENGTH_SHORT).show();
    }
}
