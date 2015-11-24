package com.example.recuperacao;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class BD2 {
	
	private SQLiteDatabase db;
	
 public BD2(Context context){
	BD aux = new BD(context); 
	db = aux.getWritableDatabase(); 
 }
 
 
 public void Inserir(Avaliador av){
	 
	 ContentValues valores = new ContentValues();
	 valores.put("nome_avaliador", av.getNome());
	 valores.put("titulo_trabalho", av.getTitulo());
	 valores.put("nota", av.getNota());
	 valores.put("comentario", av.getComent());
	  db.insert("tb_avaliacao", null, valores);
 }
 

 public List<Avaliador> Buscar(){
	 List<Avaliador> lista = new ArrayList<Avaliador>();
	String[] colunas = new String[] {"_id", "nome_avaliador",
			                         "titulo_trabalho", "nota","comentario"};
	
	Cursor c = db.query
	("tb_avaliacao", colunas, null, null, null, null, "nome_avaliador");
	
	if(c.getCount() >0 ){
		c.moveToFirst();
		
	do{
		
		Avaliador av = new Avaliador();
		av.setId(c.getInt(0));
		av.setNome(c.getString(1));
		av.setTitulo(c.getString(2));
		av.setNota(c.getInt(3));
		av.setComent(c.getString(4));
		
	}while(c.moveToNext());
		
	}
	
	
	return lista;
	

 	
	 
 }
 

 
 
 
 
 
 

}
