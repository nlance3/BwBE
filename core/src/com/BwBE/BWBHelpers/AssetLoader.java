package com.BwBE.BWBHelpers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class AssetLoader {
	
	public static Texture logoTexture, backgroundTexture, tileTexture;
	public static TextureRegion logo, background, tileTR;
	public static Sprite bgSprite;
	
	public static void load() {
		
		logoTexture = new Texture(Gdx.files.internal("data/crosslancelogo.png"));
		logoTexture.setFilter(TextureFilter.Linear, TextureFilter.Linear);

		//logo = new TextureRegion(logoTexture, 0, 0, 800, 157);
		logo = new TextureRegion(logoTexture, 0, 0, 422, 640);
		
		backgroundTexture = new Texture(Gdx.files.internal("data/bgnd.png"));
		backgroundTexture.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		background = new TextureRegion(backgroundTexture, 0, 0, 1080, 1920);
		bgSprite = new Sprite(background);
		bgSprite.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		
		
		tileTexture = new Texture(Gdx.files.internal("data/tile.png"));
		tileTexture.setFilter(TextureFilter.Linear, TextureFilter.Linear);
	}
	
	public static void dispose() {
		// We must dispose of the texture when we are finished.
		logoTexture.dispose();
	}
}
