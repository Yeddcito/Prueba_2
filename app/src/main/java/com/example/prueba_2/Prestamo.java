package com.example.prueba_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class Prestamo extends AppCompatActivity {
    private Spinner spinCliente, spinCredito;
    private TextView verresultado;
    private Button calcularPrestamos, calcularDeudas;
    int saldoaxel, saldoroxana, creditohipotecario, creditoautomotriz;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prestamo2);
        spinCliente = (Spinner) findViewById(R.id.spncliente);
        spinCredito = (Spinner) findViewById(R.id.spncredito);
        verresultado = (TextView) findViewById(R.id.verprestamo);

        String[] listacliente = {"Axel", "Roxana"};
        String[] listacredito = {"Hipotecario", "Automotriz"};

        ArrayAdapter<String> adapt = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listacliente);
        spinCliente.setAdapter(adapt);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listacredito);
        spinCredito.setAdapter(adapter);
        saldoaxel = 750000;
        saldoroxana = 900000;
        creditoautomotriz = 500000;
        creditohipotecario = 1000000;


    }

    public void calcularprestamo(View v) {
        String scliente = spinCliente.getSelectedItem().toString();
        String scredito = spinCredito.getSelectedItem().toString();

        if (scliente.equals("Axel")) {
            if (scredito.equals("Hipotecario")) {

                int operacion = saldoaxel + creditohipotecario;
                String resultado = String.valueOf(operacion);
                verresultado.setText("Su saldo final, tras el prestamo sera= " + resultado);

            }
            if (scredito.equals("Automotriz")) {

                int operacion = saldoaxel + creditoautomotriz;
                String resultado = String.valueOf(operacion);
                verresultado.setText("Su saldo final, tras el prestamo sera= " + resultado);

            }

        }
        if (scliente.equals("Roxana")) {
            if (scredito.equals("Hipotecario")) {

                int operacion = saldoroxana + creditohipotecario;
                String resultado = String.valueOf(operacion);
                verresultado.setText("Su saldo final, tras el prestamo sera= " + resultado);

            }
            if (scredito.equals("Automotriz")) {

                int operacion = saldoroxana + creditoautomotriz;
                String resultado = String.valueOf(operacion);
                verresultado.setText("Su saldo final, tras el prestamo sera= " + resultado);

            }

        }


    }

    public void calculardeuda(View v) {
        String scliente = spinCliente.getSelectedItem().toString();
        String scredito = spinCredito.getSelectedItem().toString();

        if (scliente.equals("Axel")) {
            if(scredito.equals("Hipotecario")){
                int operacion= (saldoaxel+creditohipotecario)/12;
                String resultado = String.valueOf(operacion);
                verresultado.setText("Su deuda mensual sera de = "+ resultado);

            }
            if(scredito.equals("Automotriz")){
                int operacion= (saldoaxel+creditoautomotriz)/8;
                String resultado = String.valueOf(operacion);
                verresultado.setText("Su deuda mensual sera de = "+ resultado);

            }



        }
        if (scliente.equals("Roxana")) {
            if(scredito.equals("Hipotecario")){
                int operacion= (saldoroxana+creditohipotecario)/12;
                String resultado = String.valueOf(operacion);
                verresultado.setText("Su deuda mensual sera de = "+ resultado);

            }
            if(scredito.equals("Automotriz")){
                int operacion= (saldoroxana+creditoautomotriz)/8;
                String resultado = String.valueOf(operacion);
                verresultado.setText("Su deuda mensual sera de = "+ resultado);

            }



        }
    }
}