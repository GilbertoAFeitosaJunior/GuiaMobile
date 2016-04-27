package br.com.guiamobile.model;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Gilberto on 27/04/2016.
 */
public class PontoTuristicoOpenHelper extends SQLiteOpenHelper {

    private static String DATABASE_NOME = "db_PontoTuristico";
    private static int DATABASE_VERSAO = 1;

    public PontoTuristicoOpenHelper(Context context) {
        super(context, DATABASE_NOME, null, DATABASE_VERSAO);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(SQL_TBL_PONTO_TURISTICO); // Criando a Tabela.

        //Inserindo os Campos..
        db.execSQL(MARCO_ZERO);
        db.execSQL(CAIXA_CULTURAL);
        db.execSQL(ESTACAO_ANTIGA);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    //Criação da Tabela Ponto Turristico.-------------------
    public static String TBL_PONTO_TURISTICO = "tbl_pontoTuristico";
    private static String SQL_TBL_PONTO_TURISTICO =
            "CREATE TABLE tbl_pontoTuristico(" +
                    "id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," +
                    "titulo TEXT," +
                    "descricao TEXT," +
                    "historia TEXT" +
                    ");";
    // ----------------------------------------------------


    //01
    private static final String MARCO_ZERO =
            "INSERT INTO tbl_pontoTuristico (titulo,descricao,historia)" +
                    "values ('Marco Zero'," +
                    "'O Marco zero é o ponto inicial das estradas do estado de Pernambuco....'," +
                    "'O Recife nasceu neste local: um trecho de terra em meio a um oceano de manguezais de frente para uma barreira de arrecifes de traçado quase perfeito. O local ideal para a construção de um porto." +
                    "Daqui, a cidade começou a se expandir, aterrando aquelas águas que lhe renderiam comparações com Veneza e as terras da Holanda.'" +
                    ");";

    // ----------------------------------------------------

    //2
    private static final String CAIXA_CULTURAL =
            "INSERT INTO tbl_pontoTuristico (titulo,descricao,historia)" +
                    "values ('Caixa Cultural Recife'," +
                    "'É um belo exemplar de arquitetura eclética do início do século XX. Abrigou durante muito tempo a bolsa de valores dos estados de Pernambuco.......'," +
                    "'O Recife nasceu neste local: um trecho de terra em meio a um oceano de manguezais de frente para uma barreira de arrecifes de traçado quase perfeito. O local ideal para a construção de um porto." +
                    "Daqui, a cidade começou a se expandir, aterrando aquelas águas que lhe renderiam comparações com Veneza e as terras da Holanda.'" +
                    ");";

    // ----------------------------------------------------


    //3
    private static final String ESTACAO_ANTIGA =
            "INSERT INTO tbl_pontoTuristico (titulo,descricao,historia)" +
                    "values ('Antiga Estação Ferroviária'," +
                    "'Projeto do engenheiro Herculano Ramos, a Estação Central foi inaugurada em 1890 para servir à Estrada de Ferro Central de Pernambuco. No começo do século XX.......'," +
                    "'O Recife nasceu neste local: um trecho de terra em meio a um oceano de manguezais de frente para uma barreira de arrecifes de traçado quase perfeito. O local ideal para a construção de um porto." +
                    "Daqui, a cidade começou a se expandir, aterrando aquelas águas que lhe renderiam comparações com Veneza e as terras da Holanda.'" +
                    ");";
    // ----------------------------------------------------


}
