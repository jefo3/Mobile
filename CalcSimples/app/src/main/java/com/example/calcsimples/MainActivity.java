package com.example.calcsimples;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView idNumero1;
    TextView idNumero2;
    TextView idResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        idNumero1 = findViewById(R.id.idNumero1);
        idNumero2 = findViewById(R.id.idNumero2);
        idResultado = findViewById(R.id.idResultado);
    }

    public void onclickCalc( View view){

        try{
            float n1 = Float.parseFloat(idNumero1.getText().toString());
            float n2 = Float.parseFloat(idNumero2.getText().toString());

            idNumero1.setText("");
            idNumero2.setText("");

            float soma = n1 + n2;

            idResultado.setText(""+soma);
        }catch(java.lang.NumberFormatException e){
            Log.d("Error", "ERROR: "+e);
        }




    }
}