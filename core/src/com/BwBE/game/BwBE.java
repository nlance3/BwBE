package com.BwBE.game;

import com.BwBE.BWBHelpers.AssetLoader;
import com.BwBE.Screens.SplashScreen;
import com.badlogic.gdx.Game;

public class BwBE extends Game {
	
	@Override
	public void create() {
		AssetLoader.load();
		setScreen(new SplashScreen(this));
	}

	@Override
	public void dispose() {
		super.dispose();
		AssetLoader.dispose();
	}
}
