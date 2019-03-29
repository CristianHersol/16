package com.example.alumno_1.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView txteNombre, txtnEdad;
    CheckBox chkOpc1, chkOpc2;
    RadioGroup rdbgSexo;
    RadioButton rdbOpc1, rdbOpc2;
    Spinner spnMascotas;
    ListView lstOpciones;
    ImageView imgInicio;
    Button btnNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txteNombre = (TextView) findViewById(R.id.txteNombre);
        txtnEdad = (TextView) findViewById(R.id.txtnEdad);
        chkOpc1 = (CheckBox) findViewById(R.id.chkOpc1);
        chkOpc2 = (CheckBox) findViewById(R.id.chkOpc2);
        spnMascotas = (Spinner) findViewById(R.id.spnMascotas);
        lstOpciones = (ListView) findViewById(R.id.lstOpciones);
        imgInicio = (ImageView) findViewById(R.id.imgInicio);
        btnNext = (Button) findViewById(R.id.btnNext);
        rdbgSexo = (RadioGroup) findViewById(R.id.rdbgSexo);

        imgInicio.setOnClickListener(this);

        ArrayAdapter mascotas = ArrayAdapter.createFromResource(this, R.array.Mascotas, android.R.layout.simple_spinner_item);
        spnMascotas.setAdapter(mascotas);

        spnMascotas.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> lista, View view, int i, long l) {
                if (lista.getItemAtPosition(i).equals("Elige")){
                    ArrayAdapter listaElige = ArrayAdapter.createFromResource(MainActivity.this, R.array.Elige, android.R.layout.simple_spinner_item);
                    lstOpciones.setAdapter(listaElige);
                    imgInicio.setImageResource(R.drawable.infof);

                }
                else if(lista.getItemAtPosition(i).equals("Perros")){
                    ArrayAdapter listaPerros = ArrayAdapter.createFromResource(MainActivity.this, R.array.Perros, android.R.layout.simple_spinner_item);
                    lstOpciones.setAdapter(listaPerros);
                    imgInicio.setImageResource(R.drawable.cachorros);
                    perros();
                }
                else if (lista.getItemAtPosition(i).equals("Gatos")){
                    ArrayAdapter listaGatos = ArrayAdapter.createFromResource(MainActivity.this, R.array.Gatos, android.R.layout.simple_spinner_item);
                    lstOpciones.setAdapter(listaGatos);
                    imgInicio.setImageResource(R.drawable.gatitos);
                    gatos();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }

    public void perros(){
        lstOpciones.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i){
                    case 0: imgInicio.setImageResource(R.drawable.labrador); break;
                    case 1: imgInicio.setImageResource(R.drawable.pitbull); break;
                    case 2: imgInicio.setImageResource(R.drawable.pastor); break;
                }
            }
        });

    }

    public void gatos(){
        lstOpciones.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i){
                    case 0: imgInicio.setImageResource(R.drawable.bombay); break;
                    case 1: imgInicio.setImageResource(R.drawable.korat); break;
                    case 2: imgInicio.setImageResource(R.drawable.mauegipcio); break;
                }
            }
        });

    }

    public void next(View view){
        Intent intent = new Intent(view.getContext(),Informacion.class);

        intent.putExtra("Nombre", txteNombre.getText().toString());
        startActivity(intent);

        intent.putExtra("Nacimiento", txtnEdad.getText().toString());
        startActivity(intent);



        String sexo;

        if(rdbOpc1.isChecked()){
            sexo = "Masculino";
        }else if(rdbOpc2.isChecked()){
            sexo = "Femenino";
        }

    }

    @Override
    public void onClick(View view) {

        LayoutInflater vista = getLayoutInflater();
        Toast mensaje = new Toast(getApplicationContext());

        View acerca = vista.inflate(R.layout.activity_acercade, null);
        mensaje.setDuration(Toast.LENGTH_LONG);
        mensaje.setView(acerca);
        mensaje.show();
    }
}
