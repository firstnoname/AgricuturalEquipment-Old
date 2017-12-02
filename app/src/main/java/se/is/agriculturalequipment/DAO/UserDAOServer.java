package se.is.agriculturalequipment.DAO;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import se.is.agriculturalequipment.app.SingletonPattern;
import se.is.agriculturalequipment.model.User;

/**
 * Created by BlackClover on 11/15/2017.
 */

public class UserDAOServer {
    Context mContext;

    public UserDAOServer(Context context) {
        mContext = context;
    }

    public ArrayList<User> getAllUser(String where){
        final ArrayList<User> userList = new ArrayList<>();
        String url = "http://tomori.siameki.com/getAll_user.php";

        RequestQueue queue = SingletonPattern.getInstance(mContext).getRequestQueue();

        JsonArrayRequest jsArr = new JsonArrayRequest(url, new Response.Listener<JSONArray>(){

            @Override
            public void onResponse(JSONArray response) {
                //Set JSONArray to object.
                for (int i = 0; i < response.length(); i++) {
                    JSONObject obj = null;

                    try {
                        obj = response.getJSONObject(i);

                        User getUser = new User();
                        getUser.setId(obj.getInt("id"));
                        getUser.setNameUser(obj.getString("nameUser"));
                        getUser.setUsername(obj.getString("username"));
                        getUser.setPassword(obj.getString("password"));
                        getUser.setUserRole(obj.getString("userRole"));

                        userList.add(getUser);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }

            }

        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(mContext, error.toString(), Toast.LENGTH_SHORT).show();
            }
        });

        queue.add(jsArr);

        return userList;
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
        //TODO file update_user.php still not working.
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
