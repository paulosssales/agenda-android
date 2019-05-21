package br.senai.rn.agenda.models;

import android.support.annotation.NonNull;

import java.io.Serializable;
import java.util.Objects;

public class Aluno implements Serializable, Comparable<Aluno> {

    private Long id;
    private  String nome;
    private  String telefone;
    private  String email;

    public Aluno() {
    }

    public Aluno(String nome, String telefone, String email) {
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Aluno aluno = (Aluno) o;
        return Objects.equals(id, aluno.id);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return  getNome();
    }

    @Override
    public int compareTo(Aluno aluno) {
        return nome.compareTo(aluno.nome);
    }
}
