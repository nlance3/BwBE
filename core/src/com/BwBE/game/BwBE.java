package com.BwBE.game;

import com.BwBE.BWBHelpers.ActionResolver;
import com.BwBE.BWBHelpers.AssetLoader;
import com.BwBE.Screens.SplashScreen;
import com.badlogic.gdx.Game;

public class BwBE extends Game {
	
	public static ActionResolver actionResolver;
	
	public BwBE(ActionResolver actionResolver){
		this.actionResolver = actionResolver;
	}
	
	@Override
	public void create() {
		actionResolver.toastMe("Created");
		AssetLoader.load();
		setScreen(new SplashScreen(this));
		
	}

	@Override
	public void dispose() {
		super.dispose();
		AssetLoader.dispose();
	}
}
