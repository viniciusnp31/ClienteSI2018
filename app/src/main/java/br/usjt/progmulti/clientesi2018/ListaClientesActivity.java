package br.usjt.progmulti.clientesi2018;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ListaClientesActivity extends Activity {
    public static final String NOME = "br.usjt.arqdesis.clientep1.nome";
    ArrayList<String> lista;
    Activity atividade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_clientes);
        atividade = this;
        Intent intent = getIntent();
        String chave = intent.getStringExtra(MainActivity.NOME);
        lista = buscaClientes(chave);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, lista);
        ListView listView = (ListView) findViewById(R.id.listview);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                // manda para a tela de detalhe
                Intent intent = new Intent(atividade, DetalheClientesActivity.class);
                intent.putExtra(NOME, lista.get(position));

                startActivity(intent);

            }

        });

    }

    public ArrayList<String> buscaClientes(String chave){
        ArrayList<String> lista = geraListaClientes();
        if (chave == null || chave.length() == 0){
            return lista;
        } else {
            ArrayList<String> subLista = new ArrayList<>();
            for(String nome:lista){
                if(nome.toUpperCase().contains(chave.toUpperCase())){
                    subLista.add(nome);
                }
            }
            return subLista;
        }
    }

    public ArrayList<String> geraListaClientes(){
        ArrayList<String> lista = new ArrayList<>();
        lista.add("Carlos Drummond de Andrade");
        lista.add("Manuel Bandeira");
        lista.add("Olavo Bilac");
        lista.add("VinÃ­cius de Moraes");
        lista.add("CecÃ­lia Meireles");
        lista.add("Castro Alves");
        lista.add("GonÃ§alves Dias");
        lista.add("Ferreira Gullar");
        lista.add("Machado de Assis");
        lista.add("MÃ¡rio de Andrade");
        lista.add("Cora Coralina");
        lista.add("Manoel de Barros");
        lista.add("JoÃ£o Cabral de Melo Neto");
        lista.add("Casimiro de Abreu");
        lista.add("Paulo Leminski");
        lista.add("Ãlvares de Azevedo");
        lista.add("Guilherme de Almeida");
        lista.add("Alphonsus de GuimarÃ£es");
        lista.add("MÃ¡rio Quintana");
        lista.add("GregÃ³rio de Matos");
        lista.add("Augusto dos Anjos");
        return lista;
    }
}

