package com.example.project31;

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentResolver;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.project31.databinding.ActivityMainBinding;

public class GalleryActivity extends AppCompatActivity {

    Button camera;
    ImageView imageView;
//    ActivityResultLauncher<String> photoFromCamera;
//    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);
//        binding= ActivityMainBinding.inflate(getLayoutInflater());
//        setContentView(binding.getRoot());
//        camera= findViewById(R.id.camera);
//        imageView= findViewById(R.id.imageView);
//        photoFromCamera= registerForActivityResult(
//                new ActivityResultContracts.GetContent(),
//                new ActivityResultCallback<Uri>() {
//                    @Override
//                    public void onActivityResult(Uri result) {
//                        try {
//                            Bitmap bitmap = MediaStore.Images.Media.getBitmap(getApplicationContext().getContentResolver(), result);
//                            imageView.setImageBitmap(bitmap);
//                        }
//                        catch(Exception e){
//                            Log.d("fvfv","tu pagal hai");
//                        }
//
//
//                    }
//
//
//                }
//        );
//
//        camera.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
//                startActivity(intent);
//            }
//        });
    }
}