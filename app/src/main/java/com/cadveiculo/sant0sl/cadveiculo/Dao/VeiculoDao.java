package com.cadveiculo.sant0sl.cadveiculo.Dao;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.cadveiculo.sant0sl.cadveiculo.Classes.Veiculo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sant0 on 09/03/2018.
 */

public class VeiculoDao {

    public void Salvar(Veiculo veiculo){
        SQLiteDatabase sqLiteDatabase = Conexao.getInstance();

        ContentValues values = new ContentValues();
        values.put("placa", veiculo.getPlaca());
        values.put("ano", veiculo.getAno());

        if(veiculo.getId()==null){
            sqLiteDatabase.insert("veiculo", null, values);
        }else{
            sqLiteDatabase.update("veiculo", values, "id=?", new String[]{veiculo.getId().toString()});
        }

    }

    public void Excluir(Veiculo veiculo){
        SQLiteDatabase sqLiteDatabase = Conexao.getInstance();

        ContentValues values = new ContentValues();
        values.put("id", veiculo.getId());

        if(veiculo.getId()!=null){
            sqLiteDatabase.delete("veiculo","id=?", new String[]{veiculo.getId().toString()});
        }
    }

    public List<Veiculo> listar(){
        SQLiteDatabase sqLiteDatabase = Conexao.getInstance();

        Cursor c = sqLiteDatabase.query("veiculo",new String[]{"id","placa","ano"},
                null,null,null,null,"id");

        ArrayList<Veiculo> veiculos = new ArrayList<Veiculo>();

        if(c.moveToFirst()) {
            do {
                Veiculo v = new Veiculo();
                v.setId(c.getInt(0));
                v.setPlaca(c.getString(1));
                v.setAno(c.getInt(2));
                veiculos.add(v);
            } while (c.moveToNext());
        }

        return veiculos;
    }
}
