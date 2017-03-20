package se.is.agriculturalequipment;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BuyEstimated extends AppCompatActivity {

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


    public void dispatchTakePictureIntent(View view) {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

    }

}
