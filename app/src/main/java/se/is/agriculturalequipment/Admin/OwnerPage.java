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

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import se.is.agriculturalequipment.DAO.UserDAO;
import se.is.agriculturalequipment.DAO.UserDAOServer;
import se.is.agriculturalequipment.R;
import se.is.agriculturalequipment.adapter.AdapterUserList;
import se.is.agriculturalequipment.app.SingletonPattern;
import se.is.agriculturalequipment.model.User;

public class OwnerPage extends AppCompatActivity {

    String url = "http://tomori.siameki.com/getAll_user.php";
    List<User> ownerList = new ArrayList<>();
    ListView listview_owner;
    AdapterUserList adapter;

    String strWhere = "Owner";
    FloatingActionButton btnAddOwner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_owner_page);

        listview_owner = (ListView) findViewById(R.id.listview_owner);
        btnAddOwner = (FloatingActionButton) findViewById(R.id.btnAddOwner);

        adapter = new AdapterUserList(this, ownerList);
        listview_owner.setAdapter(adapter);

        btnAddOwner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentAddUser = new Intent(getApplicationContext(), AddUser.class);
                startActivity(intentAddUser);
            }
        });

    }//End onCreate.

   @Override
    protected void onResume() {
        super.onResume();

        /*UserDAO userDAO = new UserDAO(getApplicationContext());
        userDAO.open();
        ArrayList<User> myListUser = userDAO.getAllUser(strWhere);
        final AdapterUserList adapter = new AdapterUserList(this,myListUser);
        listview_owner.setAdapter(adapter);
        userDAO.close();*/

        //This block it's not work. Becuz myListUser cant get return from UserDAOServer.
        /*UserDAOServer userDAOServer = new UserDAOServer(getApplicationContext());
        final ArrayList<User> myListUser = userDAOServer.getAllUser(strWhere);*/

        //Get user from server.
       // It's should be call UserDAOServer.
       RequestQueue queue = SingletonPattern.getInstance(this.getApplicationContext()).getRequestQueue();

       /*JsonArrayRequest jsArr = new JsonArrayRequest(url, new Response.Listener<JSONArray>() {
           @Override
           public void onResponse(JSONArray response) {
               for (int i=0; i<response.length(); i++) {
                   JSONObject obj = null;

                   try {
                       obj = response.getJSONObject(i);
                       User owner = new User();

                       owner.setId(obj.getInt("id"));
                       owner.setNameUser(obj.getString("nameUser"));
                       owner.setUsername(obj.getString("username"));
                       owner.setPassword(obj.getString("password"));
                       owner.setUserRole(obj.getString("userRole"));

                       ownerList.add(owner);
                   } catch (JSONException e) {
                       e.printStackTrace();
                   }
               }

               adapter.notifyDataSetChanged();
           }
       }, new Response.ErrorListener() {
           @Override
           public void onErrorResponse(VolleyError error) {

           }
       });*/

       StringRequest jsArr = new StringRequest(Request.Method.POST, url,
               new Response.Listener<String>() {
                   @Override
                   public void onResponse(String response) {
                       Log.d("Response post", response);

                       try {
                           JSONObject jsonObject = new JSONObject(response);
                           JSONArray jsArray = jsonObject.getJSONArray("response");
                           JSONObject data = jsArray.getJSONObject(0);

                       } catch (JSONException e) {
                           e.printStackTrace();
                       }
                   }
               }, new Response.ErrorListener() {
           @Override
           public void onErrorResponse(VolleyError error) {
               Log.d("Response post error", error.toString());
           }
       });

       queue.add(jsArr);

       /*---- End get json from server. ----*/


       listview_owner.setOnItemClickListener(new AdapterView.OnItemClickListener() {
           @Override
           public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               Intent intentUpdateUser = new Intent(getApplicationContext(), UpdateUser.class);
               intentUpdateUser.putExtra("selectedUser", adapter.getItem(position));
               startActivity(intentUpdateUser);
               //Log.d("fromAdapter ", adapter.getItem(position).getNameUser());
           }
       });
    }
}
