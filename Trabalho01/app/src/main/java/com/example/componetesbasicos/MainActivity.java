package com.example.componetesbasicos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {

    ToggleButton Etoggle;

    AutoCompleteTextView text;

    RadioButton Emasc;
    RadioButton Efem;

    TextView Etextpress;

    WebView Eweb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String str[] = {"Abacaxi","Banana","Coco","Damasco","Escropari",
                        "Figo","Goiaba","Imbu","Jatobá","Kiwi","Limão"};

        Etoggle = findViewById(R.id.EtoggleButton3);

        text = findViewById(R.id.Etext);

        Emasc = findViewById(R.id.Emasc);
        Efem = findViewById(R.id.Efem);

        //para fazer autocomplete de palavra
        ArrayAdapter<String> adp = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, str);

        text.setThreshold(1);
        text.setAdapter(adp);

        Etextpress = findViewById(R.id.EtextPress);
        Etextpress.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                Toast.makeText(getApplicationContext(), "VOCE PRESSIONOU", 2000).show();
                return true;
            }
        });

        Etextpress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "VOCE CLICOU", 1000).show();
            }
        });

        Eweb = findViewById(R.id.Eweb);
        Eweb.loadUrl("https://www.google.com/");

    }

    public void onCheckedChanged(View view) {
        if (Etoggle.isChecked()) {
            Toast.makeText(MainActivity.this, "LIGADO", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(MainActivity.this, "DESLIGADO", Toast.LENGTH_SHORT).show();
        }
    }

    public void onClickSexo(View view){
        String sexo = "";
        if(Emasc.isChecked()) sexo = "Masculino";
        if(Efem.isChecked()) sexo = "Femenino";

        Toast.makeText(MainActivity.this, "Sexo: " + sexo, Toast.LENGTH_LONG).show();
    }

    public void goTela2(View view){
        Intent tela2 = new Intent(getApplicationContext(), MainActivity2.class);
        startActivity(tela2);

    }
}