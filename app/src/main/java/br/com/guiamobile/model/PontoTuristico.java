package br.com.guiamobile.model;

import android.app.Activity;
import android.view.View;
import android.widget.ImageView;

import java.io.Serializable;

import br.com.guiamobile.R;

/**
 * Created by Gilberto on 27/04/2016.
 *
 * @author Gilberto Feitosa Junior
 *         "Essa é uma classe modelo do ponto turistico"
 */
public class PontoTuristico extends Activity implements Serializable {

    private Integer pontoTuristicoID;
    private String titulo;
    private String descricao;
    private String historia;

    public PontoTuristico(Integer pontoTuristicoID, String titulo, String descricao, String historia) {
        this.pontoTuristicoID = pontoTuristicoID;
        this.titulo = titulo;
        this.descricao = descricao;
        this.historia = historia;
    }


    public Integer getPontoTuristicoID() {
        return pontoTuristicoID;
    }

    public void setPontoTuristicoID(Integer pontoTuristicoID) {
        this.pontoTuristicoID = pontoTuristicoID;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getHistoria() {
        return historia;
    }

    public void setHistoria(String historia) {
        this.historia = historia;
    }


    /**
     * @param id   Recebe um dado do tipo Integer
     * @param view receve o layout do contexto
     */
    public void MostrarImagem(View view, Integer id) {
        ImageView imageView = (ImageView) view.findViewById(R.id.imagem);

        switch (id) {
            case 1:
                imageView.setImageResource(R.drawable.marco_zero);
                break;
            case 2:
                imageView.setImageResource(R.drawable.centro_cultural_caixa);
                break;
            case 3:
                imageView.setImageResource(R.drawable.estacao_antiga_ferroviarial);
                break;
        }
    }
}
