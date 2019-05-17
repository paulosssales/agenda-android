package br.senai.rn.agenda.activies;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import br.rn.senai.br.agenda.R;
import br.senai.rn.agenda.daos.AlunoDAO;

public class Main extends AppCompatActivity {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        setTitle("Lista de alunos");

        final AlunoDAO dao = new AlunoDAO();

        ListView listaAlunos = (ListView) findViewById(R.id._dynamic_main_list_alunos);

        listaAlunos.setAdapter(new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                dao.obterTodos()
        ));

    }
}
