package se.is.agriculturalequipment.history;

import android.content.Intent;
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

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import se.is.agriculturalequipment.R;
import se.is.agriculturalequipment.SingleItemGX35;
import se.is.agriculturalequipment.adapter.AdapterHistoryGX35;
import se.is.agriculturalequipment.app.SingletonPattern;
import se.is.agriculturalequipment.model.GX35;

public class HistoryT200List extends AppCompatActivity {

    private static final String url = "http://tomori.siameki.com/select_t200.php";
    private List<GX35> t200List = new ArrayList<>();
    ListView listview_t200;
    AdapterHistoryGX35 adapterHistoryT200;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history_t200_list);

        listview_t200 = (ListView) findViewById(R.id.listView_t200);
        adapterHistoryT200 = new AdapterHistoryGX35(HistoryT200List.this, t200List);
        listview_t200.setAdapter(adapterHistoryT200);
        listview_t200.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intentEditGX35 = new Intent(HistoryT200List.this, SingleItemGX35.class);
                intentEditGX35.putExtra("editGX35", (Serializable) adapterHistoryT200.getItem(position));
                startActivity(intentEditGX35);
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
                        GX35 t200 = new GX35();
                        t200.setId_customer(obj.getString("id_customer"));
                        t200.setIdentification_no(obj.getString("identification_no"));
                        t200.setName(obj.getString("name"));
                        t200.setStarter(obj.getString("starter"));
                        t200.setFuelTank(obj.getString("fuelTank"));
                        t200.setControlSwitch(obj.getString("controlSwitch"));
                        t200.setBrushCutterBlade(obj.getString("brushCutterBlade"));
                        t200.setAirFilter(obj.getString("airFilter"));
                        t200.setCarburetor(obj.getString("carburetor"));
                        t200.setCylinderSet(obj.getString("cylinderSet"));
                        t200.setBallValveSwitchOil(obj.getString("ballValveSwitchOil"));
                        t200.setMuffler(obj.getString("muffler"));
                        t200.setGearDiver(obj.getString("gearDiver"));
                        t200.setMainPipe(obj.getString("mainPipe"));
                        t200.setSwitchOnOff(obj.getString("switchOnOff"));
                        t200.setCoil(obj.getString("coil"));
                        t200.setFuelTankCap(obj.getString("fuelTankCap"));
                        t200.setNewPaint(obj.getString("newPaint"));
                        t200.setShaft(obj.getString("shaft"));
                        t200.setOilTankCap(obj.getString("oilTankCap"));
                        t200.setSparkPlug(obj.getString("sparkPlug"));
                        t200.setDealStatus(obj.getString("dealStatus"));
                        t200.setBuyDate(obj.getString("buyDate"));
                        t200.setAmount(obj.getString("amount"));

                        Log.d("Buy date: ", t200.getBuyDate());
                        t200List.add(t200);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }

                adapterHistoryT200.notifyDataSetChanged();

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
