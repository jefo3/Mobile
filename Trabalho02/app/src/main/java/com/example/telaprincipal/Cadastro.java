package com.example.telaprincipal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Cadastro extends AppCompatActivity {


    TextView edNome;
    TextView edNota;
    int id;
    boolean isUpdate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);


        edNome = findViewById(R.id.edNome);
        edNota = findViewById(R.id.edNota);
        isUpdate = false;

        if(getIntent().getExtras() != null) {

            String nome = getIntent().getExtras().get("nome").toString();
            String nota = getIntent().getExtras().get("nota").toString();

            edNome.setText(nome);
            edNota.setText(nota);

            id = (int) getIntent().getExtras().get("id");
            isUpdate = true;
        }
    }


    public void cancelar(View view){
        setResult(Constantes.RESULT_CANCEL);
        finish();
    }

    public void adicionar(View view){
        Intent intent = new Intent();

        String nome = edNome.getText().toString();
        float nota = Float.parseFloat(edNota.getText().toString());

        intent.putExtra("nome", nome);
        intent.putExtra("nota", nota);

        if(isUpdate){
            intent.putExtra("id", id);
        }

        setResult(Constantes.RESULT_ADD, intent);
        finish();
    }
}