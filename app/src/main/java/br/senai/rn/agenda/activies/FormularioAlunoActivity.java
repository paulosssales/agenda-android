package br.senai.rn.agenda.activies;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import br.rn.senai.br.agenda.R;
import br.senai.rn.agenda.daos.AlunoDAO;
import br.senai.rn.agenda.models.Aluno;

public class FormularioAlunoActivity extends AppCompatActivity {

    private final String TITULO_APPBAR = "Novo aluno";
    private EditText campoNome;
    private EditText campoTelefone;
    private EditText campoEmail;
    private Button botaoSalvar;
    final AlunoDAO dao = new AlunoDAO();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_aluno);
        setTitle(TITULO_APPBAR);

        inicializarComponentes();
        definirEventos();

    }

    private void definirEventos() {
        botaoSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (isEmpty(campoNome) && isEmpty(campoTelefone)) {
                    Toast.makeText(
                            FormularioAlunoActivity.this,
                            getString(R.string.formulario_aluno_activity_toast_memsagem_save_empty),
                            Toast.LENGTH_LONG)
                            .show();
                } else {

                    Aluno alunoCriado = salvarAluno();
                    persistirAluno(alunoCriado);
                    limparCampos();
                    finish();
                }

            }
        });

    }

    private void persistirAluno(Aluno aluno) {
        dao.save(aluno);
    }

    private void limparCampos() {
        campoNome.setText("");
        campoTelefone.setText("");
        campoEmail.setText("");
    }

    private boolean isEmpty(EditText editText) {
        return editText.getText().toString().trim().isEmpty();
    }

    @NonNull
    private Aluno salvarAluno() {
        String nome = campoNome.getText().toString();
        String telefone = campoTelefone.getText().toString();
        String email = campoEmail.getText().toString();
        return new Aluno(nome, telefone, email);
    }

    private void inicializarComponentes() {
        campoNome = findViewById(R.id.activity_formulario_et_nome);
        campoTelefone = findViewById(R.id.activity_formulario_et_telefone);
        campoEmail = findViewById(R.id.activity_formulario_et_email);
        botaoSalvar = findViewById(R.id.activity_formulario_bt_salvar);

        Aluno aluno = (Aluno) getIntent().getSerializableExtra("aluno");
        if (aluno != null) {
            campoNome.setText(aluno.getNome());
            campoTelefone.setText(aluno.getTelefone());
            campoEmail.setText(aluno.getEmail());
        }
    }
}
