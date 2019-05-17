package br.senai.rn.agenda.daos;

import java.util.ArrayList;
import java.util.List;

import br.senai.rn.agenda.models.Aluno;

public class AlunoDAO {

    private final static List<Aluno> ALUNOS = new ArrayList<>();

    public void save(Aluno aluno) {
        ALUNOS.add(aluno);
    }

    public List<Aluno> obterTodos() {
        return new ArrayList<>(ALUNOS);
    }
}
