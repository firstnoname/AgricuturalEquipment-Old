package se.is.agriculturalequipment;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class BuyEstimated extends AppCompatActivity {
    //Instant for use camera.
    private static final int ACTION_TAKE_PHOTO_B = 1;
    private static final String JPEG_FILE_PREFIX = "IMG_";
    private static final String JPEG_FILE_SUFFIX = ".jpg";
    String idxEngine;
    String dealingStatus = "";
    private String mCurrentPhotoPath;
    private AlbumStorageDirFactory mAlbumStorageDirFactory = null;
    private ImageView mImageView;
    //Image upload.
    private String idNo, name, amount, imageName, encodeImage;
    private String getAmount;
    private String[] strName;
    private String partName;
    //Instance for bind widget.
    private EditText edtAmount, edtName, edtIdentificationNo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_estimated);

        bindWidget();

        getValueFromSubmitEstimateG200();

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.FROYO) {
            mAlbumStorageDirFactory = new FroyoAlbumDirFactory();
        } else {
            mAlbumStorageDirFactory = new BaseAlbumDirFactory();
        }

    }

    private void getValueFromSubmitEstimateG200() {
        Intent intent = getIntent();

        idxEngine = intent.getStringExtra("idxEngine");

        getAmount = intent.getStringExtra("amount");
        edtAmount.setText(getAmount);

        strName = intent.getStringArrayExtra("partName");
        partName = Arrays.toString(strName);

        dealingStatus = intent.getStringExtra("dealStatus");

    }

    private void bindWidget() {
        mImageView = (ImageView) findViewById(R.id.imgIdentificationNo);
        edtIdentificationNo = (EditText) findViewById(R.id.edtIdentificationNo);
        edtName = (EditText) findViewById(R.id.edtName);
        edtAmount = (EditText) findViewById(R.id.edtAmount);
    }

    public void takePhoto(View view) {
        dispatchTakePictureIntent(ACTION_TAKE_PHOTO_B);
    }

    private void dispatchTakePictureIntent(int actionCode) {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        switch (actionCode) {
            case ACTION_TAKE_PHOTO_B:
                File f = null;

                try {
                    f = setUpPhotoFile();
                    mCurrentPhotoPath = f.getAbsolutePath();
                    takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(f));
                } catch (IOException e) {
                    e.printStackTrace();
                    f = null;
                    mCurrentPhotoPath = null;
                }
        }

        startActivityForResult(takePictureIntent, actionCode);

    }

    private File setUpPhotoFile() throws IOException {
        File f = createImageFile();
        mCurrentPhotoPath = f.getAbsolutePath();

        return f;
    }

    private File createImageFile() throws IOException {
        File albumF = getAlbumDir();
        File imageF = File.createTempFile(JPEG_FILE_PREFIX, JPEG_FILE_SUFFIX, albumF);
        return imageF;
    }

    private File getAlbumDir() {
        File storageDir = null;

        if (Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())) {
            storageDir = mAlbumStorageDirFactory.getAlbumStorageDir(getAlbumName());

            if (storageDir != null) {
                if (!storageDir.mkdirs()) {
                    if (!storageDir.exists()) {
                        Log.d("CameraSample", "failed to create directory");
                        return null;
                    }
                }
            }
        } else {
            Log.v("PhotoByIntent", "External storage is not mounted READ/WRITE.");
        }
        return storageDir;
    }

    private String getAlbumName() {
        return getString(R.string.album_name);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case ACTION_TAKE_PHOTO_B: {
                if (resultCode == RESULT_OK) {
                    handleBigCameraPhoto();
                }
                break;
            }
        }
    }

    private void handleBigCameraPhoto() {
        if (mCurrentPhotoPath != null) {
            setPic();
            galleryAddPic();
        }
    }

    private void galleryAddPic() {
        Intent mediaScanIntent = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
        File f = new File(mCurrentPhotoPath);
        Uri contentUri = Uri.fromFile(f);
        mediaScanIntent.setData(contentUri);
        this.sendBroadcast(mediaScanIntent);
    }

    private void setPic() {
        //Get size of ImageView.
        int targetW = mImageView.getWidth();
        int targetH = mImageView.getHeight();

        //Get the size of the image.
        BitmapFactory.Options bmOptions = new BitmapFactory.Options();
        bmOptions.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(mCurrentPhotoPath, bmOptions);
        int photoW = bmOptions.outWidth;
        int photoH = bmOptions.outHeight;

        //Figure out which way needs to be reduced less.
        int scaleFactor = 1;
        if ((targetW > 0) || (targetH > 0)) {
            scaleFactor = Math.min(photoW / targetW, photoH / targetH);
        }

        //Set bitmap options to scale the image decode target.
        bmOptions.inJustDecodeBounds = false;
        bmOptions.inSampleSize = scaleFactor;
        bmOptions.inPurgeable = true;

        //Decode the JPEG file into a Bitmap.
        Bitmap bitmap = BitmapFactory.decodeFile(mCurrentPhotoPath, bmOptions);

        //Associate the Bitmap to the ImageView.
        mImageView.setImageBitmap(bitmap);
        mImageView.setVisibility(View.VISIBLE);

    }

    public void prepareUpload(View view) {
        uploadValue();
    }

    private void uploadValue() {
        //Get values from EditText.
        idNo = edtIdentificationNo.getText().toString();
        name = edtName.getText().toString();
        amount = getAmount.toString();

        //Get image name from image path.
        File file = new File(mCurrentPhotoPath);
        imageName = file.getName();

        //Encode image to base64.
        imageEncodeToBase64();

        String method = "insert_profile";
        BackgroundTask backgroundTask = new BackgroundTask(this);
        backgroundTask.execute(method, idNo, name, amount, imageName, encodeImage, partName, idxEngine, dealingStatus);
        finish();
    }

    private void imageEncodeToBase64() {
        //Convert image into byte array.
        Bitmap bm = BitmapFactory.decodeFile(mCurrentPhotoPath);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bm.compress(Bitmap.CompressFormat.JPEG, 50, byteArrayOutputStream);//bm is the bitmap object.
        byte[] b = byteArrayOutputStream.toByteArray();

        //Encode image as byte array into base64.
        encodeImage = Base64.encodeToString(b, Base64.DEFAULT);
    }
}
