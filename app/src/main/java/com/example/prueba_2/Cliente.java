package com.example.prueba_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Cliente extends AppCompatActivity {
    private EditText codix, nombre, salariox;
//https://www.tutorialesprogramacionya.com/javaya/androidya/androidstudioya/detalleconcepto.php?codigo=16&inicio=0
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cliente);

        codix = (EditText) findViewById(R.id.codigoed);
        nombre = (EditText) findViewById(R.id.nombreed);
        salariox = (EditText) findViewById(R.id.salarioed);


    }
    public void GuardarCliente(View view) {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "fichero", null, 1);
        SQLiteDatabase db = admin.getWritableDatabase();

        if (!codix.getText().toString().isEmpty()) {
            ContentValues cont = new ContentValues();

            cont.put("codigo", codix.getText().toString());
            cont.put("nombre", nombre.getText().toString());
            cont.put("salario", salariox.getText().toString());

            db.insert("clientes", null, cont);
            db.close();

            Toast.makeText(this, "Has guardado un cliente", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Debe ingresar el codigo del Cliente", Toast.LENGTH_SHORT).show();
        }

    }

    public void MostrarCliente(View view) {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "fichero", null, 1);
        SQLiteDatabase db = admin.getWritableDatabase();

        String codigo = codix.getText().toString();

        if (!codigo.isEmpty()) {
            Cursor fila = db.rawQuery("SELECT codigo, nombre, salario FROM clientes WHERE codigo=" + codigo, null);

            if (fila.moveToFirst()) {
                codix.setText(fila.getString(0));
                nombre.setText(fila.getString(1));
                salariox.setText(fila.getString(2));
            } else {
                Toast.makeText(this, "No hay campos en la tabla Clientes", Toast.LENGTH_SHORT).show();
            }

        } else {
            Toast.makeText(this, "No hay Clientes con el codigo asociado", Toast.LENGTH_SHORT).show();
        }

    }

    public void EliminarCliente(View view) {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "fichero", null, 1);
        SQLiteDatabase db = admin.getWritableDatabase();

        String codigo = codix.getText().toString();

        db.delete("clientes", "codigo=" + codigo, null);
        db.close();

        Toast.makeText(this, "Has eliminado a un Cliente", Toast.LENGTH_SHORT).show();
    }

    public void ModificarCliente(View view) {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "fichero", null, 1);
        SQLiteDatabase db = admin.getWritableDatabase();

        String codigo = codix.getText().toString();

        ContentValues cont = new ContentValues();

        cont.put("codigo", codix.getText().toString());
        cont.put("nombre", nombre.getText().toString());
        cont.put("salario", salariox.getText().toString());

        if (!codigo.isEmpty()) {
            db.update("clientes", cont, "codigo=" + codigo, null);
            db.close();

            Toast.makeText(this, "Se ha actualizado un Cliente", Toast.LENGTH_SHORT).show();
        }
    }




}
