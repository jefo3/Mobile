package com.example.telaprincipal;

public class Aluno {

    private int matricula;
    private String nome;
    private float nota;

    private static int geradorMatricula = 0;

    public Aluno(){

    }

    public Aluno(String nome, float nota){
        this.matricula = geradorMatricula++;
        this.nome = nome;
        this.nota = nota;
    }

    public int getMatricula() {
        return this.matricula;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getNota() {
        return this.nota;
    }

    public void setNota(float nota) {
        this.nota = nota;
    }

    @Override
    public String toString() {
        return
                "MATRICULA: " + matricula +"\n" +
                "NOME: " + nome + "\n" +
                "NOTA: " + nota;
    }
}
