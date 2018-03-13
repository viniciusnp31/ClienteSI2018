package br.usjt.progmulti.clientesi2018;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

/**
 * @author 201511080 Vinícius Neves Pereira SIN3AN-MCA1
 */

public class MainActivity extends Activity {
    public static final String NOME = "br.usjt.progmulti.clientesi2018.nome";
    private EditText txtNome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtNome = findViewById(R.id.busca_nome_cliente);
    }

    public void buscarClientes(View view) {
        String nome = txtNome.getText().toString();
        Intent intent = new Intent(this, ListaClientesActivity.class);
        intent.putExtra(NOME, nome);
        startActivity(intent);
    }
}
