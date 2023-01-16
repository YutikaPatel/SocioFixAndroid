package com.example.project31;

import androidx.appcompat.app.AppCompatActivity;

import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TimePicker;


public class CreatePost extends AppCompatActivity {

    EditText txtTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_post);

        txtTime=(EditText)findViewById(R.id.selectTime);

        ImageView post_image = (ImageView) findViewById(R.id.post_image);
        post_image.setClickable(true);
        post_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CreatePost.this, Gallery_camera.class);
                startActivity(intent);
            }
        });

        Spinner spinner = (Spinner) findViewById(R.id.sector_spinner);
// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.sector_array, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        spinner.setAdapter(adapter);
    }

    public void openGallery(View view){
//        Intent intent = new Intent(CreatePost.this, OpenGallery.class);
//        startActivity(intent);



    }
    public void selectTime(View view){
        // Launch Time Picker Dialog
        TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                new TimePickerDialog.OnTimeSetListener() {

                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay,
                                          int minute) {

                        txtTime.setText(hourOfDay + ":" + minute);
                    }
                }, 24, 60, false);
        timePickerDialog.show();
    }
    }

