package com.example.recuperacao;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class Splash extends Activity implements Runnable 
{
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.splash);
	
	Handler splash = new Handler();
	splash.postDelayed(Splash.this, 4000);
	
	}

	public void run(){
		
		startActivity(new Intent(Splash.this, MainActivity.class));
        finish();
	}
	

}
