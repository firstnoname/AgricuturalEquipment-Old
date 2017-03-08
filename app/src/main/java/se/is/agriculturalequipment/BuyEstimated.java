package se.is.agriculturalequipment;

import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BuyEstimated extends AppCompatActivity {
    public static final int REQUEST_CAMERA = 2;
    Uri uri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_estimated);

    }

    public void takePhoto(View view) {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String imageFileName = "IMG_" + timeStamp + ".jpg";
        File f = new File(Environment.getExternalStorageDirectory(), "DCIM/Camera/" + imageFileName);
        uri = Uri.fromFile(f);
        intent.putExtra(MediaStore.EXTRA_OUTPUT, uri);
        startActivityForResult(Intent.createChooser(intent, "Take a picture with"), REQUEST_CAMERA);

    }
}
