package se.is.agriculturalequipment;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

/**
 * Created by iFirst on 19/4/2560.
 */

public class BackgroundTask extends AsyncTask<String,Void,String> {

    Context ctx;

    BackgroundTask(Context ctx) {
        this.ctx = ctx;
    }

    protected String doInBackground(String... params) {

//        String insert_profile_url = "http://10.0.2.2/AgricuturalEquipmentServer/insert_profile.php";
        String insert_profile_url = "http://tomori.siameki.com/insert_profile.php";

        String method = params[0];
        if (method.equals("insert_profile")) {
            String idNo = params[1];
            String name = params[2];
            String amount = params[3];
            String imageName = params[4];
            String encodedImage = params[5];

            try {
                URL url = new URL(insert_profile_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                OutputStream os = httpURLConnection.getOutputStream();

                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(os, "UTF-8"));

                String data = URLEncoder.encode("idNo","UTF-8") + "=" + URLEncoder.encode(idNo,"UTF-8")+"&"+
                        URLEncoder.encode("name","UTF-8") + "=" + URLEncoder.encode(name,"UTF-8")+"&"+
                        URLEncoder.encode("amount","UTF-8") + "=" + URLEncoder.encode(amount,"UTF-8")+"&"+
                        URLEncoder.encode("image_name","UTF-8") + "=" + URLEncoder.encode(imageName,"UTF-8")+"&"+
                        URLEncoder.encode("encoded_image","UTF-8") + "=" + URLEncoder.encode(encodedImage,"UTF-8");

                /*String data = URLEncoder.encode("idNo","UTF-8") + "=" + URLEncoder.encode(idNo,"UTF-8")+"&"+
                        URLEncoder.encode("name","UTF-8") + "=" + URLEncoder.encode(name,"UTF-8")+"&"+
                        URLEncoder.encode("encoded_image","UTF-8") + "=" + URLEncoder.encode("SGVsbG9=","UTF-8")+"&"+
                        URLEncoder.encode("image_name","UTF-8") + "=" + URLEncoder.encode(imageName,"UTF-8")+"&";*/

                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();
                os.close();
                InputStream is = httpURLConnection.getInputStream();
                is.close();

                return "Insert values success.";
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public BackgroundTask() {
        super();
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected void onPostExecute(String result) {
        Toast.makeText(ctx, result, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }
}
