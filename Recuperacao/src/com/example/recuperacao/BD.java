package com.example.recuperacao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;


public class BD extends SQLiteOpenHelper {

	public static final String NOME_BD = "SNCT";
	public static final int VERSAO_BD = 1;
	
 public BD(Context context){
	 super(context, NOME_BD, null, VERSAO_BD);
	 
 }
	
	
	@Override
	public void onCreate(SQLiteDatabase db) {
	db.execSQL("create table tb_avaliacao"
	+ "(_id integer primary key autoincrement,"
	+ " nome_avaliador text not null,"
	+ " titulo_trabalho text not null,"
	+ " nota integer not null, comentario text not null);");	
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		
	db.execSQL("drop table tb_avaliacao;");
	onCreate(db);
		
	}

	
}
