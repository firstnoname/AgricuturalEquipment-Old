package se.is.agriculturalequipment;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

import se.is.agriculturalequipment.history.HistoryG200Lists;
import se.is.agriculturalequipment.history.HistoryGX160List;
import se.is.agriculturalequipment.history.HistoryGX35List;
import se.is.agriculturalequipment.history.HistoryT200List;
import se.is.agriculturalequipment.history.HistoryTM31List;

public class HistoryActivity extends AppCompatActivity {

    ArrayList<String> exData;
    ProgressDialog progressDialog;
    Button hisG200, hisGX160, hisGX35, hisT200, hisTM31;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);


        exData = new ArrayList<String>();

        //Variable for using Volley.
        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "http://tomori.siameki.com/test_selTwoTable.php";

        //Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        /*Toast.makeText(HistoryActivity.this, "Response is : " +
                                response.substring(0, 500), Toast.LENGTH_SHORT).show();*/
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(HistoryActivity.this, "Connection error.", Toast.LENGTH_SHORT).show();
            }
        });
        queue.add(stringRequest);

        /*new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... params) {

                try {
                    URL url = new URL("http://tomori.siameki.com/history_select_all.php");

                    URLConnection urlConnection = url.openConnection();

                    HttpURLConnection httpURLConnection = (HttpURLConnection) urlConnection;
                    httpURLConnection.setAllowUserInteraction(false);
                    httpURLConnection.setInstanceFollowRedirects(true);
                    httpURLConnection.setRequestMethod("GET");
                    httpURLConnection.connect();

                    InputStream inputStream = null;

                    if (httpURLConnection.getResponseCode() == HttpURLConnection.HTTP_OK)
                        inputStream = httpURLConnection.getInputStream();

                    BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream,
                            "iso-8859-1"), 8);

                    StringBuilder stringBuilder = new StringBuilder();
                    String line = null;
                    while ((line = reader.readLine()) != null) {
                        stringBuilder.append(line + "\n");
                    }

                    inputStream.close();
                    Log.d("JSON Result::", stringBuilder.toString());

                    JSONObject jsonObject = new JSONObject(stringBuilder.toString());
                    JSONArray externalArray = jsonObject.getJSONArray("server_response");

                    for (int i =0;i<externalArray.length();i++) {
                        JSONObject jsonObj = externalArray.getJSONObject(i);
                        exData.add(jsonObj.getString("name"));
                    }

                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                return null;
            }

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                progressDialog = new ProgressDialog(HistoryActivity.this);
                progressDialog.setCancelable(false);
                progressDialog.setMessage("Downloading ... ");
                progressDialog.show();
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);

                ArrayAdapter<String> adapter = new ArrayAdapter<String>(HistoryActivity.this,
                        android.R.layout.simple_list_item_1, android.R.id.text1, exData);
                history_listview.setAdapter(adapter);
                progressDialog.dismiss();

            }

        }.execute();*/
    }

    public void intentHisG200(View view) {
        Intent intentHisG200 = new Intent(this, HistoryG200Lists.class);
        startActivity(intentHisG200);
    }

    public void intentHisGX160(View view) {
        Intent intentHisGX60 = new Intent(this, HistoryGX160List.class);
        startActivity(intentHisGX60);
    }

    public void intentHisGX35(View view) {
        Intent intentHisGX35 = new Intent(this, HistoryGX35List.class);
        startActivity(intentHisGX35);
    }

    public void intentHisT200(View view) {
        Intent intentHisT200 = new Intent(this, HistoryT200List.class);
        startActivity(intentHisT200);
    }

    public void intentHisTM31(View view) {
        Intent intentHisTM31 = new Intent(this, HistoryTM31List.class);
        startActivity(intentHisTM31);
    }

}
