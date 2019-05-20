package br.senai.rn.agenda.daos;

import java.util.ArrayList;
import java.util.List;

import br.senai.rn.agenda.models.Aluno;

public class AlunoDAO {

    private final static List<Aluno> ALUNOS = new ArrayList<>();


    public void gerarLista(){
        Aluno aluno2 = new Aluno("Paulo", "988098823","paulo@gmail.com");
        ALUNOS.add(aluno2);
    }

    public void save(Aluno aluno) {
        ALUNOS.add(aluno);
    }

    public List<Aluno> obterTodos() {
        return new ArrayList<>(ALUNOS);
    }
}
