package br.com.guiamobile.controller;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import br.com.guiamobile.model.PontoTuristico;
import br.com.guiamobile.model.PontoTuristicoOpenHelper;

/**
 * Created by Gilberto on 27/04/2016.
 */
public class PontoTuristicoRepossitorio {

    private PontoTuristicoOpenHelper pontoTuristicoOpenHelper;

    public PontoTuristicoRepossitorio(Context context) {
        this.pontoTuristicoOpenHelper = new PontoTuristicoOpenHelper(context);
    }


    /**
     * @param busca Rebe uma String.
     * @return Retorna um LIST<PontoTuristico> referente a String que foi passada como  paramento.
     */
    public List<PontoTuristico> buscarPontoTurristico(String busca) {
        SQLiteDatabase db = pontoTuristicoOpenHelper.getWritableDatabase();

        String selectSQL = "SELECT * FROM tbl_pontoTuristico WHERE titulo LIKE '%" + busca + "%'";
        Cursor cursor = db.rawQuery(selectSQL, null);
        List<PontoTuristico> lista = new ArrayList<>();

        while (cursor.moveToNext()) {

            Integer id = cursor.getInt(cursor.getColumnIndex("id"));
            String titulo = cursor.getString(cursor.getColumnIndex("titulo"));
            String descricao = cursor.getString(cursor.getColumnIndex("descricao"));
            String historia = cursor.getString(cursor.getColumnIndex("historia"));

            PontoTuristico pontoTuristico = new PontoTuristico( id , titulo, descricao, historia);
            lista.add(pontoTuristico);
        }
        return lista;
    }
}
