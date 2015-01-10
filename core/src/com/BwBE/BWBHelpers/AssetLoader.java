package com.BwBE.BWBHelpers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class AssetLoader {
	
	public static Texture logoTexture;
	public static TextureRegion logo;
	
	public static void load() {
		
		logoTexture = new Texture(Gdx.files.internal("data/crosslancelogo.png"));
		logoTexture.setFilter(TextureFilter.Linear, TextureFilter.Linear);

		//logo = new TextureRegion(logoTexture, 0, 0, 800, 157);
		logo = new TextureRegion(logoTexture, 0, 0, 422, 640);
		
	
	}
	
	public static void dispose() {
		// We must dispose of the texture when we are finished.
		logoTexture.dispose();
	}
}
