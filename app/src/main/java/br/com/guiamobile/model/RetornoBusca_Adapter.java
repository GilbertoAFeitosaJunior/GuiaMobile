package br.com.guiamobile.model;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;
import java.util.zip.Inflater;

import br.com.guiamobile.R;

/**
 * Created by Gilberto on 27/04/2016.
 */
public class RetornoBusca_Adapter extends BaseAdapter {

    private Context context;
    private List<PontoTuristico> lista;
    private LayoutInflater layoutInflater;


    public RetornoBusca_Adapter(Context context, List<PontoTuristico> lista) {
        this.context = context;
        this.lista = lista;
        this.layoutInflater =  (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return lista.size();
    }

    @Override
    public Object getItem(int position) {
        return lista.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        View view = layoutInflater.inflate(R.layout.retorno_busca_adapter, null);

        PontoTuristico pontoTuristico =  lista.get(position);

        TextView titulo = (TextView) view.findViewById(R.id.titulo);
        titulo.setText(pontoTuristico.getTitulo());

        TextView descricao = (TextView) view.findViewById(R.id.descricao);
        descricao.setText(pontoTuristico.getDescricao());

        pontoTuristico.MostrarImagem(view, pontoTuristico.getPontoTuristicoID());


        //Alerar e alternar a cor do ListView;
        if(position % 2 == 0 ){
            view.setBackgroundColor(Color.RED);
        }


        return view;
    }
}
