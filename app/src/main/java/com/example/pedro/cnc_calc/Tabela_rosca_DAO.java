package com.example.pedro.cnc_calc;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.sql.SQLException;

/**
 * Created by pedro on 26/06/15.
 */
public class Tabela_rosca_DAO {
    private Db_Tabela_rosca DB_TABELA_ROSCA;
    private SQLiteDatabase db;

    private static final String LogCat = "Log Cat";

    public Tabela_rosca_DAO(Context context){
        DB_TABELA_ROSCA = new Db_Tabela_rosca(context);

    }

    public void open() throws SQLException{
        DB_TABELA_ROSCA.getWritableDatabase();
    }

    public void close(){
        DB_TABELA_ROSCA.close();
    }

    public void popular_tabela_MF(Metrica_fina metrica_fina){
        db = DB_TABELA_ROSCA.getWritableDatabase();

        ContentValues cv = new ContentValues();
        cv.put(DB_TABELA_ROSCA.COLUNA_MACHO, metrica_fina.getMacho());
        cv.put(DB_TABELA_ROSCA.COLUNA_D_BROCA, metrica_fina.getD_broca());
        cv.put(DB_TABELA_ROSCA.COLUNA_PASSO, metrica_fina.getPasso());

        db.insert(DB_TABELA_ROSCA.TABELA_METRICA_FINA, null, cv);
        db.close();
    }

    public void popular_tabela_MG(Metrica_fina metrica_fina){
        db = DB_TABELA_ROSCA.getReadableDatabase();

        ContentValues cv = new ContentValues();
        cv.put(DB_TABELA_ROSCA.COLUNA_MACHO, metrica_fina.getMacho());
        cv.put(DB_TABELA_ROSCA.COLUNA_D_BROCA, metrica_fina.getD_broca());
        cv.put(DB_TABELA_ROSCA.COLUNA_PASSO, metrica_fina.getPasso());

        db.insert(DB_TABELA_ROSCA.TABELA_METRICA_GROSSA, null, cv);
        db.close();
    }

    public Boolean VerificaRegistro() {
        try {
            db = DB_TABELA_ROSCA.getReadableDatabase();
            Cursor cursor = db.rawQuery("SELECT * FROM " + DB_TABELA_ROSCA.TABELA_METRICA_FINA, null);
            if (cursor.getCount() != 0) {

                Log.i(LogCat, "Contem registro");
                cursor.moveToFirst();
                cursor.close();
                return true;
            } else{
                Log.i(LogCat, "Não contem registro");
                return false;
            }
        } catch (Exception e) {
            return false;
        } finally {
            db.close();
        }
    }


    public Cursor getCursor_Metrica(){
        db = DB_TABELA_ROSCA.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " +DB_TABELA_ROSCA.TABELA_METRICA_FINA, null);
        if (cursor != null){
            cursor.moveToFirst();
        }
        return cursor;
    }
}
