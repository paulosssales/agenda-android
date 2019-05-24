package br.senai.rn.agenda.activies;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import br.rn.senai.br.agenda.R;
import br.senai.rn.agenda.adapter.ListaAlunoAdapter;
import br.senai.rn.agenda.daos.AlunoDAO;
import br.senai.rn.agenda.models.Aluno;

import static br.rn.senai.br.agenda.R.color.colorBlue;
import static br.rn.senai.br.agenda.R.layout.item_aluno;

public class ListaAlunosActivity extends AppCompatActivity {

    private final String TITULO_APPBAR = "Lista de alunos";
    private AlunoDAO dao;
//    private ArrayAdapter<Aluno> adapter;
    private ListView listaAlunos;
    private ListaAlunoAdapter adapter;
    private FloatingActionButton botaoAdicionar;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        setTitle(TITULO_APPBAR);

        inicializarComponentes();
        definirEventos();

        if (dao.obterTodos().isEmpty()){
            dao.gerarLista();
        }

    }

    @Override
    protected void onResume() {
        super.onResume();
//        adapter.clear();
        adapter.addAll(dao.obterTodos());
    }

    private void definirEventos() {
        botaoAdicionar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ListaAlunosActivity.this, FormularioAlunoActivity.class));
            }
        });

        listaAlunos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Aluno aluno = dao.obterTodos().get(position);
                Log.i("position",""+aluno);

                Intent intent = new Intent(ListaAlunosActivity.this, FormularioAlunoActivity.class);
                intent.putExtra("aluno",aluno);
                startActivity(intent);

                Toast.makeText(
                        ListaAlunosActivity.this,
                        aluno.getNome(),
                        Toast.LENGTH_LONG)
                        .show();
            }
        });

    }

    @Override
    public boolean onContextItemSelected(final MenuItem item) {
        int menuSelecionadoId = item.getItemId();

        if (menuSelecionadoId == R.id.activity_lista_aluno_menu_remover) {
            new AlertDialog.Builder(this)
                    .setTitle("Removendo aluno")
                    .setMessage("Deseja realmente remover o aluno?")
                    .setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            AdapterView.AdapterContextMenuInfo menuInfo =
                                    (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
                            Aluno alunoSelected = adapter.getItem(menuInfo.position);
                            dao.remover(alunoSelected);
                            adapter.remove(alunoSelected);
                        }
                    }).setNegativeButton("Não", null)
                    .show();
        }
        return super.onContextItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.activity_lista_aluno_menu, menu);
    }

    private void inicializarComponentes() {
        dao = new AlunoDAO();
        botaoAdicionar = findViewById(R.id.activity_main_fab_novo_aluno);
        listaAlunos = findViewById(R.id._dynamic_main_list_alunos);

        configurarAdapter(listaAlunos);

        registerForContextMenu(listaAlunos);
    }

    private void configurarAdapter(ListView view) {
        adapter = new ListaAlunoAdapter(this);
        view.setAdapter(adapter);
    }

}
