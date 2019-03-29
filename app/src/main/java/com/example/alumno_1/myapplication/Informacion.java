package com.example.alumno_1.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class Informacion extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informacion);

        final TextView txtNombre, txtEdad, txtSexo, txtPasatiempo, txtMascota;

        txtNombre = (TextView) findViewById(R.id.txtNombre);
        txtEdad = (TextView) findViewById(R.id.txtEdad);
        txtSexo = (TextView) findViewById(R.id.txtSexo);

        Bundle recibirinfo = getIntent().getExtras();

        String nombreImp = recibirinfo.getString("Nombre");
        String edadImp = recibirinfo.getString("Nacimiento");
        String sexoImp = recibirinfo.getString("Sexo");

        txtNombre.setText(nombreImp);
        txtEdad.setText(edadImp);
        txtSexo.setText(sexoImp);

    }
}
