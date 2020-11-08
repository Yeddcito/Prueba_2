package com.example.prueba_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import java.util.ArrayList;


public class Menu   extends AppCompatActivity {

    private ViewFlipper vf;
    private int[] images = {R.drawable.a, R.drawable.b, R.drawable.c};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);


    }



    public void vinfo(View v) {
        Intent i = new Intent(this, Informacion.class);
        startActivity(i);
    }

    public void vseguridad(View v) {
        Intent i = new Intent(this, Seguridad.class);
        startActivity(i);
    }
    public void vcliente(View v) {
        Intent i = new Intent(this, Cliente.class);
        startActivity(i);
    }
    public void vprestamo(View v) {
        Intent i = new Intent(this, Prestamo.class);
        startActivity(i);
    }


}