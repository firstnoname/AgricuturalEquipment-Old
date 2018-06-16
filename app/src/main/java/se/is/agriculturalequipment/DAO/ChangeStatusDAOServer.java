package se.is.agriculturalequipment.DAO;

import android.content.Context;
import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by iFirst on 6/16/2018.
 */

public class ChangeStatusDAOServer {
    Context mContext;
    String str_response = "";
    String id_who_buy = "";
    String tbl_name = "";
    public ChangeStatusDAOServer(Context context) {
        mContext = context;
    }

    public String updateDealStatus(final String id_who_buy, final String tbl_name){

        this.id_who_buy = id_who_buy;
        this.tbl_name = tbl_name;

        RequestQueue queue = Volley.newRequestQueue(mContext);
        String url_update_dealStatus = "http://tomori.siameki.com/update_dealStatus.php";

        StringRequest stringRequest = new StringRequest(Request.Method.POST, url_update_dealStatus,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        str_response = response;
                        Log.d("Test bug dealStatus", response);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                str_response = error.toString();
                Log.d("Test bug dealStatus", error.toString());
            }
        }){
            @Override
            protected Map<String,String> getParams() throws AuthFailureError{
                Map<String, String> params = new HashMap<>();
                params.put("id_who_buy", id_who_buy);
                params.put("table_name", tbl_name);
                return params;
            }
        };

        queue.add(stringRequest);

        return str_response;
    }
}
