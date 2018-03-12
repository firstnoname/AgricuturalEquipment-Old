package se.is.agriculturalequipment.login;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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

import java.util.HashMap;
import java.util.Map;

import se.is.agriculturalequipment.R;
import se.is.agriculturalequipment.util.Singleton;

/**
 * Created by ifirst on 29/12/2017 AD.
 */

public class LoginActivity extends AppCompatActivity{

    EditText txtUsername, txtPassword;
    Button btnLogin;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        txtUsername = (EditText) findViewById(R.id.edtUsername);
        txtPassword = (EditText) findViewById(R.id.edtPassword);
        btnLogin = (Button) findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = txtUsername.getText().toString();
                String password = txtPassword.getText().toString();
                checkLogin(username,password);
                //Toast.makeText(LoginActivity.this, "Hello Login", Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void checkLogin(final String username, final String password) {
        //if everything is fine.
        //Toast.makeText(this, username, Toast.LENGTH_SHORT).show();
        RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
        String url_check_login = "http://tomori.siameki.com/user_check_login.php";
        Log.d("check login ", "Click login");

        /*JsonArrayRequest jsArr = new JsonArrayRequest(url_check_login, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                Log.d("check login ", response.toString());
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("check login ", error.toString());
            }
        })*/
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url_check_login,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(LoginActivity.this, "Login Success." + response, Toast.LENGTH_SHORT).show();
                        Log.d("test", "Values from server :: " + response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(LoginActivity.this, "Login failed : " + error, Toast.LENGTH_SHORT).show();
                    }
                })
        {
            @Override
            protected Map<String, String> getParams() throws  AuthFailureError{
                Map<String, String> params = new HashMap<>();
                params.put("username", username);
                params.put("password", password);

                return params;
            }
        };

        queue.add(stringRequest);

    }//End of checkLogin.

}
