package se.is.agriculturalequipment.history;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import se.is.agriculturalequipment.HistoryActivity;
import se.is.agriculturalequipment.R;
import se.is.agriculturalequipment.SingleItemG200;
import se.is.agriculturalequipment.adapter.AdapterHistoryG200;
import se.is.agriculturalequipment.app.SingletonPattern;
import se.is.agriculturalequipment.model.G200;

public class HistoryGX160List extends AppCompatActivity {

    private static final String url = "http://tomori.siameki.com/select_gx160.php";
    ListView listview_gx160;
    AdapterHistoryG200 adapterHistoryGX160;
    TextView txtTest;
    private List<G200> gx160List = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history_gx160_list);

        txtTest = (TextView) findViewById(R.id.textView12);

        listview_gx160 = (ListView) findViewById(R.id.listView_gx160);
        adapterHistoryGX160 = new AdapterHistoryG200(this, gx160List);
        listview_gx160.setAdapter(adapterHistoryGX160);
        listview_gx160.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intentEditGX160 = new Intent(HistoryGX160List.this, SingleItemG200.class);
                intentEditGX160.putExtra("editG200", (Serializable) adapterHistoryGX160.getItem(position));
                intentEditGX160.putExtra("table_name", "gx160");
                startActivity(intentEditGX160);
            }
        });

        RequestQueue queue = SingletonPattern.getInstance(this.getApplicationContext()).getRequestQueue();

        JsonArrayRequest jsArr = new JsonArrayRequest(url, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                Log.d("response: ", response.toString());
//                txtTest.setText(response.toString());
                for (int i = 0; i < response.length(); i++) {
                    JSONObject obj = null;
                    try {
                        obj = response.getJSONObject(i);
                        G200 gx160 = new G200();
                        gx160.setId_customer(obj.getString("id_customer"));
                        gx160.setIdentification_no(obj.getString("identification_no"));
                        gx160.setName(obj.getString("name"));
                        gx160.setId_buy_g200(obj.getString("id_buy_gx160"));
                        gx160.setStarter(obj.getString("starter"));
                        gx160.setFuelTank(obj.getString("fuelTank"));
                        gx160.setAirFilter(obj.getString("airFilter"));
                        gx160.setCarburetor(obj.getString("carburetor"));
                        gx160.setCylinderSet(obj.getString("cylinderSet"));
                        gx160.setBallValveSwitchOil(obj.getString("ballValveSwitchOil"));
                        gx160.setMuffler(obj.getString("muffler"));
                        gx160.setSwitchOnOff(obj.getString("switchOnOff"));
                        gx160.setCoil(obj.getString("coil"));
                        gx160.setFuelTankCap(obj.getString("fuelTankCap"));
                        gx160.setNewPaint(obj.getString("newPaint"));
                        gx160.setOilTankCap(obj.getString("oilTankCap"));
                        gx160.setSparkPlug(obj.getString("sparkPlug"));
                        gx160.setDealStatus(obj.getString("dealStatus"));
                        gx160.setBuyDate(obj.getString("buyDate"));
                        gx160.setAmount(obj.getString("amount"));


                        Log.d("Buy date: ", gx160.getBuyDate());
                        gx160List.add(gx160);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }

                adapterHistoryGX160.notifyDataSetChanged();

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("error: ", error.toString());
            }
        });

        queue.add(jsArr);
    }
}
