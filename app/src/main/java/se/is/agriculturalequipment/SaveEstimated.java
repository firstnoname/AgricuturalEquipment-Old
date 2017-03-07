package se.is.agriculturalequipment;

import android.content.Intent;
import android.icu.text.DateFormat;
import android.icu.text.SimpleDateFormat;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.util.Date;

public class SaveEstimated extends AppCompatActivity {

    private EditText edtName, edtIDNo, edtAmount;
    private String[] receiveName, receivePrice;
    private String receiveAmount;
    public static final int REQUEST_CAMERA = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save_estimated);

        //Bind widget.
        bindWidget();

        //Get data from SubmitEstimateG200.java
        getData();

        edtAmount.setText(receiveAmount);

    }

    private void intentCamera() {
        Uri uri;
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        String timeStamp = "timeStamp";
        String imageFileName = "IMG_" + timeStamp + ".jpg";
        File f = new File(Environment.getExternalStorageDirectory(), "DCIM/Camera/" + imageFileName);
        uri = Uri.fromFile(f);
        intent.putExtra(MediaStore.EXTRA_OUTPUT, uri);
        startActivityForResult(Intent.createChooser(intent, "Take a picture"), REQUEST_CAMERA);
    }

    private void bindWidget() {
        edtName = (EditText) findViewById(R.id.edtName);
        edtIDNo = (EditText) findViewById(R.id.edtIdentificationNo);
        edtAmount = (EditText) findViewById(R.id.edtAmount);
    }

    private void getData() {
        Intent receiveIntent = this.getIntent();
        receiveName = receiveIntent.getStringArrayExtra("partName");
        receivePrice = receiveIntent.getStringArrayExtra("partPrice");
        receiveAmount = receiveIntent.getStringExtra("amount");
    }
}
