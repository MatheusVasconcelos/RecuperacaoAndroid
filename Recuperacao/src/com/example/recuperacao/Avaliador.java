package com.example.recuperacao;

public class Avaliador {

 private String	nome;
 private String	titulo;
 private String	coment;
 private int nota;
 private int id;
 
 public Avaliador() {
  this(null,null,null,0,0);
}

 public Avaliador (String nome, String titulo, String coment, int nota, int id){
	
	 this.nome = nome;
	 this.titulo = titulo;
	 this.coment = coment;
	 this.nota = nota;
	 this.id = id;
	 
 }

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getNome() {
	return nome;
}

public void setNome(String nome) {
	this.nome = nome;
}

public String getTitulo() {
	return titulo;
}

public void setTitulo(String titulo) {
	this.titulo = titulo;
}

public String getComent() {
	return coment;
}

public void setComent(String coment) {
	this.coment = coment;
}

public int getNota() {
	return nota;
}

public void setNota(int nota) {
	this.nota = nota;
}

@Override
public String toString() {
	return "Avaliador [nome=" + nome + ", titulo=" + titulo + ", coment="
			+ coment + ", nota=" + nota + "]";
}

 
	
}
