package se.is.agriculturalequipment.history;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import se.is.agriculturalequipment.R;
import se.is.agriculturalequipment.adapter.AdapterHistoryG200;
import se.is.agriculturalequipment.adapter.AdapterHistoryGX35;
import se.is.agriculturalequipment.app.SingletonPattern;
import se.is.agriculturalequipment.model.G200;
import se.is.agriculturalequipment.model.GX35;

public class HistoryGX35List extends AppCompatActivity {

    private static final String url = "http://tomori.siameki.com/select_gx35.php";
    private List<GX35> gx35List = new ArrayList<>();
    ListView listview_gx35;
    AdapterHistoryGX35 adapterHistoryGX35;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history_gx35_list);

        listview_gx35 = (ListView) findViewById(R.id.listView_gx35);
        adapterHistoryGX35 = new AdapterHistoryGX35(HistoryGX35List.this, gx35List);
        listview_gx35.setAdapter(adapterHistoryGX35);
        listview_gx35.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                
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
                        GX35 gx35 = new GX35();
                        gx35.setId_customer(obj.getString("id_customer"));
                        gx35.setIdentification_no(obj.getString("identification_no"));
                        gx35.setName(obj.getString("name"));
                        gx35.setStarter(obj.getString("starter"));
                        gx35.setFuelTank(obj.getString("fuelTank"));
                        gx35.setControlSwitch(obj.getString("controlSwitch"));
                        gx35.setAirFilter(obj.getString("airFilter"));
                        gx35.setCarburetor(obj.getString("carburetor"));
                        gx35.setCylinderSet(obj.getString("cylinderSet"));
                        gx35.setBallValveSwitchOil(obj.getString("ballValveSwitchOil"));
                        gx35.setMuffler(obj.getString("muffler"));
                        gx35.setGearDiver(obj.getString("gearDiver"));
                        gx35.setMainPipe(obj.getString("mainPipe"));
                        gx35.setSwitchOnOff(obj.getString("switchOnOff"));
                        gx35.setCoil(obj.getString("coil"));
                        gx35.setFuelTankCap(obj.getString("fuelTankCap"));
                        gx35.setNewPaint(obj.getString("newPaint"));
                        gx35.setShaft(obj.getString("shaft"));
                        gx35.setOilTankCap(obj.getString("oilTankCap"));
                        gx35.setSparkPlug(obj.getString("sparkPlug"));
                        gx35.setDealStatus(obj.getString("dealStatus"));
                        gx35.setBuyDate(obj.getString("buyDate"));
                        gx35.setAmount(obj.getString("amount"));

                        Log.d("Buy date: ", gx35.getBuyDate());
                        gx35List.add(gx35);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }

                adapterHistoryGX35.notifyDataSetChanged();

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
