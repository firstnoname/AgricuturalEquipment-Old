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
import se.is.agriculturalequipment.SingleItemTM31;
import se.is.agriculturalequipment.adapter.AdapterHistoryGX35;
import se.is.agriculturalequipment.adapter.AdapterHistoryTM31;
import se.is.agriculturalequipment.app.SingletonPattern;
import se.is.agriculturalequipment.model.GX35;
import se.is.agriculturalequipment.model.TM31;

public class HistoryTM31List extends AppCompatActivity {

    private static final String url = "http://tomori.siameki.com/select_tm31.php";
    ListView listview_tm31;
    AdapterHistoryTM31 adapterHistoryTM31;
    private List<TM31> tm31List = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history_tm31_list);

        listview_tm31 = (ListView) findViewById(R.id.listView_tm31);
        adapterHistoryTM31 = new AdapterHistoryTM31(HistoryTM31List.this, tm31List);
        listview_tm31.setAdapter(adapterHistoryTM31);
        listview_tm31.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intentEditTM31 = new Intent(HistoryTM31List.this, SingleItemTM31.class);
                intentEditTM31.putExtra("editTM31", (Serializable) adapterHistoryTM31.getItem(position));
                intentEditTM31.putExtra("table_name", "tm31");
                startActivity(intentEditTM31);
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
                        TM31 tm31 = new TM31();
                        tm31.setId_customer(obj.getString("id_customer"));
                        tm31.setIdentification_no(obj.getString("identification_no"));
                        tm31.setName(obj.getString("name"));
                        tm31.setEngineStatus(obj.getString("engineStatus"));
                        tm31.setAirChamber(obj.getString("airChamber"));
                        tm31.setSealSet(obj.getString("sealSet"));
                        tm31.setAdjustSet(obj.getString("adjustSet"));
                        tm31.setDischargeMetal(obj.getString("dischargeMetal"));
                        tm31.setSuctionMetal(obj.getString("suctionMetal"));
                        tm31.setPistonSet(obj.getString("pistonSet"));
                        tm31.setStarterRopeReel(obj.getString("starterRopeReel"));
                        tm31.setPressureGauge(obj.getString("pressureGauge"));
                        tm31.setBallValveSwitch(obj.getString("ballValveSwitch"));
                        tm31.setOilFilter(obj.getString("oilFilter"));
                        tm31.setNewPaint(obj.getString("newPaint"));
                        tm31.setOilTankCap(obj.getString("oilTankCap"));
                        tm31.setDealStatus(obj.getString("dealStatus"));
                        tm31.setBuyDate(obj.getString("buyDate"));
                        tm31.setAmount(obj.getString("amount"));
                        tm31.setId_buy_tm31(obj.getString("id_buy_tm31"));

                        Log.d("Buy date: ", tm31.getBuyDate());
                        tm31List.add(tm31);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }

                adapterHistoryTM31.notifyDataSetChanged();

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
