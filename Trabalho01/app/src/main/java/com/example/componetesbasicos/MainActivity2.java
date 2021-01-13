package com.example.componetesbasicos;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    FloatingActionButton fab;
    Toolbar toolbar;

    TextView Enum1;
    TextView Enum2;
    TextView Eresultado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Intent tela1 = new Intent(getApplicationContext(), MainActivity.class);
               startActivity(tela1);
            }
        });

        Enum1 = findViewById(R.id.Enum1);
        Enum2 = findViewById(R.id.Enum2);
        Eresultado = findViewById(R.id.Eresultado);
    }

    public void onclickCalc( View view){

        try{
            float n1 = Float.parseFloat(Enum1.getText().toString());
            float n2 = Float.parseFloat(Enum2.getText().toString());

            Enum1.setText("");
            Enum2.setText("");

            float soma = n1 + n2;

            Eresultado.setText(""+soma);
        }catch(java.lang.NumberFormatException e){
            Log.d("Error", "ERROR: "+e);
        }
    }
}