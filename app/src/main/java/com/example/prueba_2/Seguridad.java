package com.example.prueba_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.security.MessageDigest;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class Seguridad extends AppCompatActivity {
    private EditText edit;
    private TextView text;
    private Button btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seguridad);

        edit = (EditText) findViewById(R.id.contra);
        text = (TextView) findViewById(R.id.encriptado);
    }
    private SecretKeySpec generateKey (String password)throws Exception{

        MessageDigest sh = MessageDigest.getInstance("SHA-256");
        byte[] key = password.getBytes("UTF-8");
        key = sh.digest(key);

        SecretKeySpec secretKeySpec = new SecretKeySpec(key, "AES");
        return secretKeySpec;

    }
    public String Encriptar(String datos, String password)throws Exception{

        if(!edit.getText().toString().isEmpty())
        {
            SecretKeySpec secretKey = generateKey(password);

            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);

            byte[] datosEncriptadosBytes = cipher.doFinal(datos.getBytes());
            String datosEncriptadosString = Base64.encodeToString(datosEncriptadosBytes, Base64.DEFAULT);

            return datosEncriptadosString;
        }
        else
        {
            Toast.makeText(this,"Debe ingresar Contraseña", Toast.LENGTH_LONG).show();
            return null;
        }
    }
    public void encript(View v)
    {
        try{
            String mensaje = Encriptar(edit.getText().toString(), text.getText().toString());
            text.setText(mensaje);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}