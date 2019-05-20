package br.senai.rn.agenda.models;

import android.support.annotation.NonNull;

import java.io.Serializable;

public class Aluno implements Serializable {
    private  String nome;
    private  String telefone;
    private  String email;

    public Aluno(String nome, String telefone, String email) {
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getEmail() {
        return email;
    }



    @Override
    public String toString() {
        return  getNome();
    }
}
