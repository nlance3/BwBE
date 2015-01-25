package com.BwBE.game.android;

import android.os.Bundle;
import android.widget.Toast;

import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;
import com.BwBE.BWBHelpers.ActionResolver;
import com.BwBE.game.BwBE;

public class AndroidLauncher extends AndroidApplication implements ActionResolver{
	
	@Override
	protected void onCreate (Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		AndroidApplicationConfiguration config = new AndroidApplicationConfiguration();
		initialize(new BwBE(this), config);
	}
	

	public void toastMe(){
		try{
		runOnUiThread(new Runnable(){
			public void run(){
				Toast.makeText(getApplicationContext(), "This is toast", Toast.LENGTH_SHORT).show();
			}
		});
		}catch (Exception e){
		}

	}
}
