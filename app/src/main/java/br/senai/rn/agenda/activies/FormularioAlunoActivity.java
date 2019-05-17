package br.senai.rn.agenda.activies;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import br.rn.senai.br.agenda.R;
import br.senai.rn.agenda.daos.AlunoDAO;
import br.senai.rn.agenda.models.Aluno;

public class FormularioAlunoActivity extends AppCompatActivity {

    private EditText campoNome;
    private EditText campoTelefone;
    private EditText campoEmail;
    private Button botaoSalvar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_aluno);

        final AlunoDAO dao = new AlunoDAO();

        campoNome = findViewById(R.id.activity_formulario_et_nome);
        campoTelefone = findViewById(R.id.activity_formulario_et_telefone);
        campoEmail = findViewById(R.id.activity_formulario_et_email);

        botaoSalvar = findViewById(R.id.activity_formulario_bt_salvar);

        botaoSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nome = campoNome.getText().toString();
                String telefone = campoTelefone.getText().toString();
                String email = campoEmail.getText().toString();

                campoNome.setText("");
                campoTelefone.setText("");
                campoEmail.setText("");

                Aluno alunoCriado = new Aluno(nome, telefone, email);
                dao.save(alunoCriado);

                startActivity(new Intent(FormularioAlunoActivity.this, ListaAlunosActivity.class));

            }
        });

    }
}
