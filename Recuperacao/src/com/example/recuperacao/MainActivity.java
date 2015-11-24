package com.example.recuperacao;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationCompat.Builder;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.*;

public class MainActivity extends Activity {
	
	private Avaliador av = new Avaliador();
	private EditText nome;
	private EditText titulo;
	private EditText nota;
	private EditText coment;
	private Button avaliar;
	private Button contar;
	
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	    
		nome = (EditText) findViewById(R.id.nomeEditText);
		titulo = (EditText) findViewById(R.id.tituloEditText);
		nota = (EditText) findViewById(R.id.notaEditText);
		coment = (EditText) findViewById(R.id.comentarioEditText);
		avaliar = (Button) findViewById(R.id.button1);
		contar = (Button) findViewById(R.id.button2);
		
		
		Intent intent = getIntent();
		if (intent != null){
			Bundle bundle = intent.getExtras();
			if (bundle != null){
				
				av.setId(bundle.getInt("id"));
				av.setComent(bundle.getString("coment"));
				av.setNome(bundle.getString("nome"));
				av.setTitulo(bundle.getString("titulo"));
				av.setNota(bundle.getInt("nota"));
				
		
			nome.setText(av.getNome());
			titulo.setText(av.getTitulo());
			coment.setText(av.getComent());
			nota.setText(av.getNota());
			
		avaliar.setVisibility(View.GONE);	
		contar.setVisibility(View.VISIBLE);
				
			}
			
		}
		
		
		
		
	}
	
	public void InserirAvaliador(View view){
		
		av.setNome(nome.getText().toString());
		av.setComent(coment.getText().toString());
		av.setTitulo(titulo.getText().toString());
		
		BD2 bd = new BD2(this);
		bd.Inserir(av);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
 public void Notificacao (View view){
	 
  NotificationManager not = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
 
 NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
 PendingIntent intent = PendingIntent.getActivity(this, 0, new Intent(this, MainActivity.class), 0);
 
 
    builder.setTicker("Nova notificacao");
    builder.setContentTitle("Avaliaçoes");
    builder.setContentText("Quantidade de avaliações registradas");
    builder.setSmallIcon(R.drawable.ic_launcher);
    builder.setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.rhavy));
    builder.setContentIntent(intent);
    Notification no = builder.build();
    no.flags = Notification.FLAG_AUTO_CANCEL;
    not.notify(R.drawable.ic_launcher,no);
    
 
 }
	
	
	
	
	
	
}
