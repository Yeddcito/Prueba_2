package com.example.prueba_2;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;

public class Informacion extends AppCompatActivity {
    private VideoView video;

//https://www.universoandroidhn.com/2018/03/android-videoview-tutorial-example.html
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informacion);

        video = (VideoView)findViewById(R.id.video1);

        String ruta = "android.resource://" + getPackageName() + "/" + R.raw.video;
        Uri uri = Uri.parse(ruta);
        video.setVideoURI(uri);


        MediaController media = new MediaController(this);
        video.setMediaController(media);





    }
    public void vmapa (View v){
        Intent a= new Intent(this, Localizacion.class);
        startActivity(a);
    }

}
