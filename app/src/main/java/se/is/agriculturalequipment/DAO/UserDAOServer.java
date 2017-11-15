package se.is.agriculturalequipment.DAO;

import android.content.Context;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

import se.is.agriculturalequipment.model.User;

/**
 * Created by BlackClover on 11/15/2017.
 */

public class UserDAOServer {
    Context mContext;



    public UserDAOServer(Context context) {
        mContext = context;
    }

    public void addUser(User user){
        final User mUser = user;
        RequestQueue queue = Volley.newRequestQueue(mContext);
        String url = "http://tomori.siameki.com/insert_user.php";

        StringRequest stringRequest = new StringRequest(Request.Method.POST,
                url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(mContext, response, Toast.LENGTH_SHORT).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(mContext, error.toString(), Toast.LENGTH_SHORT).show();
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("nameUser", mUser.getNameUser());
                params.put("username", mUser.getUsername());
                params.put("password", mUser.getPassword());
                params.put("userRole", mUser.getUserRole());

                return params;
            }
        };

        queue.add(stringRequest);
    }

    public void updateUser(User user){
        final User updateUserServ = user;
        RequestQueue queue = Volley.newRequestQueue(mContext);
        String url = "http://tomori.siameki.com/update_user.php";

        StringRequest stringRequest = new StringRequest(Request.Method.POST,
                url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(mContext, response, Toast.LENGTH_SHORT).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(mContext, "Update failed. " + error, Toast.LENGTH_SHORT).show();
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("id", String.valueOf(updateUserServ.getId()));
                params.put("nameUser", updateUserServ.getNameUser());
                params.put("username", updateUserServ.getUsername());
                params.put("password", updateUserServ.getPassword());
                params.put("userRole", updateUserServ.getUserRole());

                return params;
            }
        };

        queue.add(stringRequest);
    }
}
