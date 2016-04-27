package br.com.guiamobile.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import br.com.guiamobile.R;
import br.com.guiamobile.controller.PontoTuristicoRepossitorio;
import br.com.guiamobile.model.PontoTuristico;
import br.com.guiamobile.model.RetornoBusca_Adapter;


/**
 * Created by Gilberto on 01/04/2016.
 */
public class RetornoDaBusca extends Activity implements AdapterView.OnItemClickListener {
    private String buscarNoBanco;
    private ListView listaDoBanco;
    private static final int PONTO_TURISTICO = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.retorno_da_busca);


        buscarNoBanco = getIntent().getStringExtra("buscarNoBanco");

        PontoTuristicoRepossitorio pontoTuristicoRepossitorio = new PontoTuristicoRepossitorio(this);

        List<PontoTuristico> lista = new ArrayList<>(pontoTuristicoRepossitorio.buscarPontoTurristico(buscarNoBanco));

        listaDoBanco = (ListView) findViewById(R.id.listaDoBanco);

        listaDoBanco.setEmptyView(findViewById(R.id.msg_lista_vazia));
        registerForContextMenu(this.listaDoBanco);
        listaDoBanco.setChoiceMode(ListView.CHOICE_MODE_SINGLE);

        RetornoBusca_Adapter retornoBusca_adapter = new RetornoBusca_Adapter(this, lista);

        listaDoBanco.setAdapter(retornoBusca_adapter);
        listaDoBanco.setOnItemClickListener(this);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        PontoTuristico pontoEscolhido = (PontoTuristico) parent.getItemAtPosition(position);

        Intent intent = new Intent(this, PontoTuristicoEscolhido.class);
        intent.putExtra("PontoEscolhido", pontoEscolhido);
        startActivityForResult(intent, PONTO_TURISTICO);


    }

    public void menuRetornoBusca(View view) {
        switch (view.getId()) {
            case R.id.button2:
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                finish();
                break;
        }
    }


}
