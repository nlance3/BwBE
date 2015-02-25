package com.BwBE.BWBHelpers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class AssetLoader {
	
	public static Texture logoTexture, backgroundTexture, tileTexture, carrierTexture, bshipTexture, subTexture, scoutTexture, fisherTexture;
	public static TextureRegion logo, background, tileTR, carrierTR, bshipTR, subTR, scoutTR, fisherTR;
	public static Sprite bgSprite;
	public static FileHandle tilefh; 
	
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
		
		tilefh = Gdx.files.internal("data/tile.png");
		tileTexture = new Texture(tilefh);
		tileTexture.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		tileTR = new TextureRegion(AssetLoader.tileTexture, 0,0,100,100);
		
		carrierTexture = new Texture(Gdx.files.internal("data/carrier.png"));
		carrierTexture.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		carrierTR = new TextureRegion(carrierTexture);
		bshipTexture = new Texture(Gdx.files.internal("data/battleship.png"));
		bshipTexture.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		bshipTR = new TextureRegion(bshipTexture);
		subTexture = new Texture(Gdx.files.internal("data/sub.png"));
		subTexture.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		subTR = new TextureRegion(subTexture);
		scoutTexture = new Texture(Gdx.files.internal("data/scout.png"));
		scoutTexture.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		scoutTR = new TextureRegion(scoutTexture);
		fisherTexture = new Texture(Gdx.files.internal("data/fisherman.png"));
		fisherTexture.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		fisherTR = new TextureRegion(fisherTexture);
	}
	
	public static void dispose() {
		// We must dispose of the texture when we are finished.
		logoTexture.dispose();
	}
	
	public static void update() {
		// Since we're using settings from here derived from game height/width update everything when called.
		bgSprite.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

			
	}
}
