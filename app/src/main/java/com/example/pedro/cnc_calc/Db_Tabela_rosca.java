package com.example.pedro.cnc_calc;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by pedro on 26/06/15.
 */
public class Db_Tabela_rosca extends SQLiteOpenHelper {

    public static final String NOME_BANCO = "db_tabela_rosca";
    private static final int VERSAO_BANCO = 1;

    public static final String TABELA_METRICA_FINA = "metrica_fina";
    public static final String COLUNA_ID = "_id";
    public static final String COLUNA_MACHO = "m";
    public static final String COLUNA_D_BROCA = "d_broca";
    public static final String COLUNA_PASSO = "passo";

    public static final String TABELA_METRICA_GROSSA = "metrica_grossa";

    public static final String CRIA_TABELA_ROSCAS_MF = "CREATE TABLE " +TABELA_METRICA_FINA+ "(" +
            COLUNA_ID+ " INTEGER PRIMARY KEY AUTOINCREMENT," +
            COLUNA_MACHO+ " INTEGER," +
            COLUNA_D_BROCA+ " TEXT NOT NULL," +
            COLUNA_PASSO+ " TEXT NOT NULL)";

    /*public static final String CRIA_TABELA_ROSCAS_MG = "CREATE TABLE" +TABELA_METRICA_GROSSA + "( " +
            COLUNA_ID+ " INTEGER PRIMARY KEY AUTOINCREMENT," +
            COLUNA_MACHO+ "INTEGER NOT NULL," +
            COLUNA_D_BROCA+ "TEXT NOT NULL," +
            COLUNA_PASSO+ "TEXT NOT NULL)";*/



    public Db_Tabela_rosca(Context context) {
        super(context, NOME_BANCO, null, VERSAO_BANCO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CRIA_TABELA_ROSCAS_MF);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // para próximas versões
        db.execSQL(CRIA_TABELA_ROSCAS_MF);
        onCreate(db);
    }


}
