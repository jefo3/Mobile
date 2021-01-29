package com.example.telaprincipal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Aluno> listaAluno;
    ArrayAdapter<?> adapter;
    ListView edListView;
    int selected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        selected = -1;

        listaAluno = new ArrayList<Aluno>();

        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listaAluno);

        edListView = findViewById(R.id.edListView);
        edListView.setAdapter(adapter);
        edListView.setSelector(android.R.color.holo_blue_bright );

        edListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selected = position;
            }
        });

    }

    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inf = getMenuInflater();
        inf.inflate(R.menu.menu_activity_main, menu);

        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.add:
                addAluno();
                break;
            case R.id.editar:
                atualizeAluno();
                break;
            case R.id.del:
                delAluno();
                break;
            case R.id.sobre:
                break;
        }

        return true;
    }

    protected void onActivityResult (int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);


            if(resultCode == Constantes.RESULT_ADD){

                if(data.getExtras() != null){
                    String nome = data.getExtras().get("nome").toString();
                    float nota = (float) data.getExtras().get("nota");

                    if(requestCode == Constantes.REQUEST_ADD && resultCode == Constantes.RESULT_ADD){
                        Aluno aluno = new Aluno(nome, nota);

                        listaAluno.add(aluno);
                        adapter.notifyDataSetChanged();
                    }else if(requestCode == Constantes.REQUEST_EDIT && resultCode == Constantes.RESULT_ADD){
                        int matricula = (int) data.getExtras().get("id");

                        for(Aluno x: listaAluno){
                            if(x.getMatricula() == matricula){
                                x.setNome(nome);
                                x.setNota(nota);
                            }
                        }

                        adapter.notifyDataSetChanged();
                    }

                }


           }




    }

    private void addAluno(){
        Intent telaCadastro = new Intent(this, Cadastro.class);
        startActivityForResult(telaCadastro, Constantes.REQUEST_ADD);
    }

    private void delAluno(){
        if(selected >= 0){
            listaAluno.remove(selected);
            adapter.notifyDataSetChanged();
        }else{
            Toast.makeText(MainActivity.this, "NAO SELECIONOU NENHUM ITEM", Toast.LENGTH_LONG).show();
        }
    }

    private void atualizeAluno(){
        if(selected >= 0){

            Intent intent = new Intent(this, Cadastro.class);

            intent.putExtra("nome", listaAluno.get(selected).getNome());
            intent.putExtra("nota", listaAluno.get(selected).getNota());
            intent.putExtra("id", listaAluno.get(selected).getMatricula());

            startActivityForResult(intent, Constantes.REQUEST_EDIT);
        }
    }
}