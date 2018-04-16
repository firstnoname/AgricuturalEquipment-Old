package se.is.agriculturalequipment.Admin;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import se.is.agriculturalequipment.DAO.UserDAO;
import se.is.agriculturalequipment.R;
import se.is.agriculturalequipment.adapter.AdapterUserList;
import se.is.agriculturalequipment.app.SingletonPattern;
import se.is.agriculturalequipment.model.User;
import se.is.agriculturalequipment.util.Singleton;

public class EmployeePage extends AppCompatActivity {

    //String strWhere = "Employee";
    //ListView listview_emp;
//    FloatingActionButton btnAddEmp;

    String url = "http://tomori.siameki.com/getAll_user.php";
    List<User> empList = new ArrayList<>();
    ListView listview_emp;
    AdapterUserList adapter;

    String strWhere = "Employee";
    FloatingActionButton btnAddEmp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_page);

        //Bind widget.
        listview_emp = (ListView) findViewById(R.id.listview_employee);
        btnAddEmp = (FloatingActionButton) findViewById(R.id.btnAddEmployee);


    }

    @Override
    protected void onResume() {
        super.onResume();

        /*UserDAO userDAO = new UserDAO(getApplicationContext());
        userDAO.open();
        ArrayList<User> myListUser = userDAO.getAllUser(strWhere);
        final AdapterUserList adapter = new AdapterUserList(this, myListUser);
        listview_emp.setAdapter(adapter);
        userDAO.close();

        listview_emp.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intentUpdate = new Intent(getApplicationContext(), UpdateUser.class);
                intentUpdate.putExtra("selectedUser", adapter.getItem(position));
                startActivity(intentUpdate);
            }
        });*/
        empList.clear();
        adapter = new AdapterUserList(this, empList);
        listview_emp.setAdapter(adapter);

        btnAddEmp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentAddUser = new Intent(getApplicationContext(), AddUser.class);
                startActivity(intentAddUser);
            }
        });

        //Add employee to server database.
        RequestQueue queue = SingletonPattern.getInstance(this.getApplicationContext()).getRequestQueue();

        StringRequest postReq = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        try {
                            JSONArray jsArr = new JSONArray(response);

                            for (int i=0; i<jsArr.length(); i++) {
                                User emp = new User();
                                JSONObject valueObj = jsArr.getJSONObject(i);
                                emp.setId(valueObj.getInt("id"));
                                emp.setNameUser(valueObj.getString("nameUser"));
                                emp.setUsername(valueObj.getString("username"));
                                emp.setPassword(valueObj.getString("password"));
                                emp.setUserRole(valueObj.getString("userRole"));

                                empList.add(emp);
                            }

                            adapter.notifyDataSetChanged();

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("Error ", error.toString());
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("where", strWhere);

                return params;
            }
        };

        queue.add(postReq);

        listview_emp.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intentUpdateUser = new Intent(getApplicationContext(), UpdateUser.class);
                intentUpdateUser.putExtra("selectedUser", adapter.getItem(position));
                intentUpdateUser.putExtra("from", "Employee");
                startActivity(intentUpdateUser);
                finish();
            }
        });

    }//End of Resume method.
}
