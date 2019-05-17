package br.senai.rn.agenda.activies;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import br.rn.senai.br.agenda.R;
import br.senai.rn.agenda.daos.AlunoDAO;

public class ListaAlunosActivity extends AppCompatActivity {

    private ListView listaAlunos;
    private Button botaoAdicionar;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        setTitle("Lista de alunos");

        final AlunoDAO dao = new AlunoDAO();

        botaoAdicionar.findViewById(R.id.activity_main_fab_novo_aluno);

        botaoAdicionar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ListaAlunosActivity.this, FormularioAlunoActivity.class));
            }
        });

        listaAlunos = (ListView) findViewById(R.id._dynamic_main_list_alunos);

        listaAlunos.setAdapter(new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                dao.obterTodos()
        ));

    }
}
