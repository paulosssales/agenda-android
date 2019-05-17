package br.senai.rn.agenda.activies;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import br.rn.senai.br.agenda.R;

public class FormularioAlunoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_aluno);

        Button btSalvar = findViewById(R.id.activity_formulario_bt_salvar);
        btSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(
                        FormularioAlunoActivity.this,
                        "Botão clicado",
                        Toast.LENGTH_LONG
                )
                .show();
            }
        });

    }
}
