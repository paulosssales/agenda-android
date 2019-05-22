package br.senai.rn.agenda.activies;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import br.rn.senai.br.agenda.R;
import br.senai.rn.agenda.daos.AlunoDAO;
import br.senai.rn.agenda.models.Aluno;

public class FormularioAlunoActivity extends AppCompatActivity {

    private String TITULO_APPBAR = "Novo aluno";
    private TextView tViewTitulo;
    private EditText campoNome;
    private EditText campoTelefone;
    private EditText campoEmail;
    private Aluno aluno;
    private AlunoDAO dao = new AlunoDAO();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_aluno);
        setTitle(TITULO_APPBAR);

        inicializarComponentes();
        definirEventos();

    }

    private void definirEventos() {}

    private void limparCampos() {
        campoNome.setText("");
        campoTelefone.setText("");
        campoEmail.setText("");
    }

    private boolean isEmpty(EditText editText) {
        return editText.getText().toString().trim().isEmpty();
    }

    @NonNull
    private void salvarAluno() {
        TITULO_APPBAR  = "Editar aluno";
        dao.save(aluno);
        finish();
    }

    private void criarAluno(){
        String nome = campoNome.getText().toString();
        String telefone = campoTelefone.getText().toString();
        String email = campoEmail.getText().toString();

        aluno.setNome(nome);
        aluno.setTelefone(telefone);
        aluno.setEmail(email);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_formulario_aluno_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemSelectedId = item.getItemId();
        if (itemSelectedId == R.id.activity_formulario_aluno_menu_salvar){
            if (isEmpty(campoNome) && isEmpty(campoTelefone)) {
                Toast.makeText(
                        FormularioAlunoActivity.this,
                        getString(R.string.formulario_aluno_activity_toast_memsagem_save_empty),
                        Toast.LENGTH_LONG)
                        .show();
            } else {
                if (itemSelectedId == R.id.activity_formulario_aluno_menu_salvar){
                    salvarAluno();
                    criarAluno();
                    limparCampos();
                    finish();
                }
            }
        }
        return super.onOptionsItemSelected(item);
    }

    private void inicializarComponentes() {
        tViewTitulo = findViewById(R.id.activity_formulario_tv_titulo);
        campoNome = findViewById(R.id.activity_formulario_et_nome);
        campoTelefone = findViewById(R.id.activity_formulario_et_telefone);
        campoEmail = findViewById(R.id.activity_formulario_et_email);

        inicializarAluno();
    }

    private void inicializarAluno() {
        dao = new AlunoDAO();
        aluno = (Aluno) getIntent().getSerializableExtra("aluno");
        if (aluno != null) {
            campoNome.setText(aluno.getNome());
            campoTelefone.setText(aluno.getTelefone());
            campoEmail.setText(aluno.getEmail());
        }else{
            aluno = new Aluno();
        }
    }
}
