package se.is.agriculturalequipment.Admin;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import se.is.agriculturalequipment.DAO.UserDAO;
import se.is.agriculturalequipment.DAO.UserDAOServer;
import se.is.agriculturalequipment.R;
import se.is.agriculturalequipment.adapter.AdapterUserList;
import se.is.agriculturalequipment.app.SingletonPattern;
import se.is.agriculturalequipment.model.User;

public class OwnerPage extends AppCompatActivity {
    String strWhere = "Owner";
    ListView listview_owner;
    FloatingActionButton btnAddOwner;

    String url = "http://tomori.siameki.com/getAll_user.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_owner_page);

        listview_owner = (ListView) findViewById(R.id.listview_owner);
        btnAddOwner = (FloatingActionButton) findViewById(R.id.btnAddOwner);

        btnAddOwner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentAddUser = new Intent(getApplicationContext(), AddUser.class);
                startActivity(intentAddUser);
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();

        /*UserDAO userDAO = new UserDAO(getApplicationContext());
        userDAO.open();
        ArrayList<User> myListUser = userDAO.getAllUser(strWhere);
        final AdapterUserList adapter = new AdapterUserList(this,myListUser);
        listview_owner.setAdapter(adapter);
        userDAO.close();*/

        //UserDAOServer userDAOServer = new UserDAOServer(getApplicationContext());
        //final ArrayList<User> myListUser = userDAOServer.getAllUser(strWhere);
        //Log.d("myListUser : ", String.valueOf(myListUser.size()));

        //Get user from server.
        final ArrayList<User> myListUser = new ArrayList<>();
        RequestQueue queue = SingletonPattern.getInstance(this.getApplicationContext()).getRequestQueue();

        JsonArrayRequest jsArr = new JsonArrayRequest(url, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                //Log.d("User response ", response.toString());
                for (int i =0; i < response.length(); i++) {
                    JSONObject obj = null;

                    try {
                        obj = response.getJSONObject(i);
                        User ownerUser = new User();

                        ownerUser.setId(obj.getInt("id"));
                        ownerUser.setNameUser(obj.getString("nameUser"));
                        ownerUser.setUsername(obj.getString("username"));
                        ownerUser.setPassword(obj.getString("password"));
                        ownerUser.setUserRole(obj.getString("userRole"));

                        myListUser.add(ownerUser);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        queue.add(jsArr);
        final AdapterUserList adapter = new AdapterUserList(this, myListUser);
        listview_owner.setAdapter(adapter);

        listview_owner.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intentUpdate = new Intent(getApplicationContext(), UpdateUser.class);
                intentUpdate.putExtra("selectedUser", adapter.getItem(position));
                intentUpdate.putExtra("where", strWhere);
                startActivity(intentUpdate);
            }
        });
    }
}
