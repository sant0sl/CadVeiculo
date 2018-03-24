package com.cadveiculo.sant0sl.cadveiculo.Dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by sant0 on 23/03/2018.
 */

public class Conexao extends SQLiteOpenHelper {

    private static SQLiteDatabase instance;

    public static SQLiteDatabase getInstance(){
        return instance;
    }

    public Conexao(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        instance = getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String statement = "";
        statement+= " create table veiculo ( ";
        statement+= " id integer PRIMARY KEY AUTOINCREMENT, ";
        statement+= " placa varchar(8), ";
        statement+= " ano integer ";
        statement+= " ); ";

        sqLiteDatabase.execSQL(statement);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int versaoAntiga, int versaoNova) {

    }
}
