package br.senai.rn.agenda.daos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.senai.rn.agenda.models.Aluno;

public class AlunoDAO {

    private static Long contadorDeIds =1L;
    private final static List<Aluno> ALUNOS = new ArrayList<>();


    public void gerarLista(){
        Aluno aluno2 = new Aluno("Paulo", "988098823","paulo@gmail.com");
        Aluno aluno3 = new Aluno("Maria", "32295566","maria@gmail.com");
        Aluno aluno4 = new Aluno("Jonatam", "984562315","jn.22@gmail.com");
        save(aluno2);
        save(aluno3);
        save(aluno4);
//        ALUNOS.add(aluno2);
    }

    public void save(Aluno aluno) {
        if (aluno.getId() == null){
            aluno.setId(contadorDeIds);
            ALUNOS.add(aluno);
            contadorDeIds++;
        }else{
            int posicao = ALUNOS.indexOf(aluno);
            ALUNOS.set(posicao, aluno);
        }
    }

    public List<Aluno> obterTodos() {
        List<Aluno> alunos = new ArrayList<>(ALUNOS);
        Collections.sort(alunos);
        return new ArrayList<>(ALUNOS);
    }

    public void remover(Aluno alunoSelected) {
        Aluno alunoDevolvido = obterAluno(alunoSelected);
        if (alunoDevolvido != null){
            ALUNOS.remove(alunoDevolvido);
        }
    }

    private Aluno obterAluno(Aluno alunoSelected) {
        if (ALUNOS.contains(alunoSelected)){
            for (Aluno aluno: ALUNOS) {
                if (alunoSelected.equals(aluno)){
                    return aluno;
                }
            }
        }
        return null;
    }


}
