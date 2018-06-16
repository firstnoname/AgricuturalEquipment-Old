package se.is.agriculturalequipment.history;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import se.is.agriculturalequipment.R;
import se.is.agriculturalequipment.SingleItemG200;
import se.is.agriculturalequipment.adapter.AdapterHistoryG200;
import se.is.agriculturalequipment.app.AppController;
import se.is.agriculturalequipment.app.SingletonPattern;
import se.is.agriculturalequipment.model.G200;

public class HistoryG200Lists extends AppCompatActivity {

    private static final String url = "http://tomori.siameki.com/select_g200.php";
    ListView listview_g200;
    AdapterHistoryG200 adapterHistoryG200;
    TextView txtTest;
    private List<G200> g200List = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history_g200_lists);


//        edtTest = (EditText) findViewById(R.id.editText2);
        txtTest = (TextView) findViewById(R.id.textView12);

        listview_g200 = (ListView) findViewById(R.id.listView_g200);
        adapterHistoryG200 = new AdapterHistoryG200(this, g200List);
        listview_g200.setAdapter(adapterHistoryG200);

        listview_g200.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                /*Toast.makeText(HistoryG200Lists.this,
                        String.valueOf(adapterHistoryG200.getItemId(position)), Toast.LENGTH_SHORT).show();*/
                Intent intentEditG200 = new Intent(HistoryG200Lists.this, SingleItemG200.class);
                intentEditG200.putExtra("editG200", (Serializable) adapterHistoryG200.getItem(position));
                intentEditG200.putExtra("table_name", "g200");
//                Toast.makeText(HistoryG200Lists.this, adapterHistoryG200.getItem(position).toString()
//                        , Toast.LENGTH_SHORT).show();
                startActivity(intentEditG200);
                finish();
            }
        });

        RequestQueue queue = SingletonPattern.getInstance(this.getApplicationContext()).getRequestQueue();

        JsonArrayRequest jsArr = new JsonArrayRequest(url, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                Log.d("response: ", response.toString());
                for (int i = 0; i < response.length(); i++) {
                    JSONObject obj = null;
                    try {
                        obj = response.getJSONObject(i);
                        G200 g200 = new G200();
                        g200.setId_customer(obj.getString("id_customer"));
                        g200.setIdentification_no(obj.getString("identification_no"));
                        g200.setName(obj.getString("name"));
                        g200.setId_buy_g200(obj.getString("id_buy_g200"));
                        g200.setStarter(obj.getString("starter"));
                        g200.setFuelTank(obj.getString("fuelTank"));
                        g200.setAirFilter(obj.getString("airFilter"));
                        g200.setCarburetor(obj.getString("carburetor"));
                        g200.setCylinderSet(obj.getString("cylinderSet"));
                        g200.setBallValveSwitchOil(obj.getString("ballValveSwitchOil"));
                        g200.setMuffler(obj.getString("muffler"));
                        g200.setSwitchOnOff(obj.getString("switchOnOff"));
                        g200.setCoil(obj.getString("coil"));
                        g200.setFuelTankCap(obj.getString("fuelTankCap"));
                        g200.setNewPaint(obj.getString("newPaint"));
                        g200.setOilTankCap(obj.getString("oilTankCap"));
                        g200.setSparkPlug(obj.getString("sparkPlug"));
                        g200.setDealStatus(obj.getString("dealStatus"));
                        g200.setBuyDate(obj.getString("buyDate"));
                        g200.setAmount(obj.getString("amount"));
                        //Log.d("Buy date: ", g200.getBuyDate());
                        g200List.add(g200);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }

                adapterHistoryG200.notifyDataSetChanged();

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
