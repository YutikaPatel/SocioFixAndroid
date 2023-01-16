package com.example.project31;

import static android.media.tv.TvContract.AUTHORITY;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;
import androidx.core.content.PermissionChecker;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.project31.databinding.ActivityMainBinding;

import java.io.File;

public class Gallery_camera extends AppCompatActivity {

    Button camera;
    ImageView imageView;
    ProgressBar progressBar;

    private static final int CAMERA_REQUEST = 1888;
    private static final int MY_CAMERA_PERMISSION_CODE = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery_camera);

        Context contex= this;

        camera= findViewById(R.id.camera);
        imageView= findViewById(R.id.imageView);
        progressBar= findViewById(R.id.progressBar);
        ActivityResultLauncher<String> photoFromCamera;

//        ActivityMainBinding binding;
//        binding= ActivityMainBinding.inflate(getLayoutInflater());
//        setContentView(binding.getRoot());

        ActivityResultLauncher<Intent> photoFromCamera2= registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
            @Override
            public void onActivityResult(ActivityResult result) {
                Toast.makeText(getApplicationContext(),"before checking result ok status",Toast.LENGTH_SHORT).show();
                if (result.getResultCode() == RESULT_OK && result.getData() != null){

                    Toast.makeText(getApplicationContext(),"Aadhi Img set",Toast.LENGTH_SHORT).show();

                    Uri pickedimgUri = result.getData().getData();
                   // imageView.setImageURI(pickedimgUri);
                    Bitmap photo = (Bitmap) result.getData().getExtras().get("data");
                    imageView.setImageBitmap(photo);

                    progressBar.setVisibility(View.INVISIBLE);
                    Toast.makeText(getApplicationContext(),"h "+photo,Toast.LENGTH_SHORT).show();
                }
            }
        });



        photoFromCamera= registerForActivityResult(
                new ActivityResultContracts.GetContent(),
                new ActivityResultCallback<Uri>() {
                    @Override
                    public void onActivityResult(Uri result) {
                        try {
                            Toast.makeText(getApplicationContext(),"Aadhi Img set",Toast.LENGTH_SHORT).show();
                            Bitmap bitmap = MediaStore.Images.Media.getBitmap(getApplicationContext().getContentResolver(), result);
                            imageView.setImageBitmap(bitmap);
                            //imageView.setImageDrawable();

//                            String uri = "@drawable/ic_location";  // where myresource (without the extension) is the file
//
//                            int imageResource = getResources().getIdentifier(uri, null, getPackageName());
//
//                            Drawable res = getResources().getDrawable(imageResource);
//                            imageView.setImageDrawable(res);
//                            Log.d("zala","img zala");
                            Toast.makeText(getApplicationContext(),"Img set",Toast.LENGTH_SHORT).show();
                        }
                        catch(Exception e){
                            Log.d("fvfv","tu pagal hai");
                            Toast.makeText(getApplicationContext(),"Error",Toast.LENGTH_SHORT).show();
                        }


                    }


                }
        );

        camera.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {

                if (ContextCompat.checkSelfPermission((Activity)contex,Manifest.permission.CAMERA)  != PackageManager.PERMISSION_GRANTED)
                {
                    ActivityCompat.requestPermissions((Activity)contex,new String[]{Manifest.permission.CAMERA}, MY_CAMERA_PERMISSION_CODE);
                }
                else {
                    Toast.makeText(getApplicationContext(),"Before launching",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
                    photoFromCamera2.launch(intent);
                    Toast.makeText(getApplicationContext(),"Done launching",Toast.LENGTH_SHORT).show();
                    //startActivity(intent);


                }
            }
        });

    }

//    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults)
//    {
//        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
//        if (requestCode == MY_CAMERA_PERMISSION_CODE)
//        {
//            if (grantResults[0] == PackageManager.PERMISSION_GRANTED)
//            {
//                Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
//                startActivity(intent);
//            }
//            else
//            {
//                Toast.makeText(this, "camera permission denied", Toast.LENGTH_LONG).show();
//            }
//        }
//    }
}