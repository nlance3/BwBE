package com.BwBE.BWBHelpers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class AssetLoader {
	
	public static Texture logoTexture, buttonTexture;
	public static TextureRegion logo, newGame;
	
	public static void load() {
		
		logoTexture = new Texture(Gdx.files.internal("data/crosslancelogo.png"));
		logoTexture.setFilter(TextureFilter.Linear, TextureFilter.Linear);

		//logo = new TextureRegion(logoTexture, 0, 0, 800, 157);
		logo = new TextureRegion(logoTexture, 0, 0, 422, 640);
		
		//2048x2048
		buttonTexture = new Texture(Gdx.files.internal("data/BWBbuttons.png"));
		buttonTexture.setFilter(TextureFilter.Linear, TextureFilter.Linear);

		//logo = new TextureRegion(logoTexture, 0, 0, 800, 157);
		newGame = new TextureRegion(buttonTexture, 0, 0, 1080, 120);
		
	
	}
	
	public static void dispose() {
		// We must dispose of the texture when we are finished.
		logoTexture.dispose();
	}
}
