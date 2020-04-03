package com.example.dumps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;



public class MainActivity extends AppCompatActivity {

    Button open_camera;
    ImageView img_view;
    private static final int pic_id = 123;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        open_camera=(Button)findViewById(R.id.cam_but);
        img_view=(ImageView)findViewById(R.id.picview);

        open_camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent camera_intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(camera_intent, pic_id);
            }
        });


    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        if(requestCode==pic_id && resultCode==RESULT_OK){
            Bitmap photo = (Bitmap) data.getExtras().get("data");
            img_view.setImageBitmap(photo);
        }

    }


}
