package se.is.agriculturalequipment;

import android.content.ContentResolver;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BuyEstimated extends AppCompatActivity {

    public static final int REQUEST_CAMERA = 2;
    Uri uri;
    private ImageView imageView;
    private EditText edtAmount, edtTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_estimated);

        bindWidget();

    }

    private void bindWidget() {
        imageView = (ImageView) findViewById(R.id.imgIdentificationNo);

        edtTest = (EditText) findViewById(R.id.edtName);
        edtAmount = (EditText) findViewById(R.id.edtAmount);
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

    public void onActivityResult(int requestCode, int resultCode, Intent data){
        if(requestCode == REQUEST_CAMERA && resultCode == RESULT_OK){
            getContentResolver().notifyChange(uri, null);
            ContentResolver cr = getContentResolver();
            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(cr, uri);
                imageView.setImageBitmap(bitmap);
                Toast.makeText(getApplicationContext(),uri.getPath(),Toast.LENGTH_SHORT).show();
            } catch (Exception e) {
                e.printStackTrace();
            }
            Bitmap photo = (Bitmap) data.getExtras().get("data");
            imageView.setImageBitmap(photo);
        }

    }//End of onActivityResult.
}
