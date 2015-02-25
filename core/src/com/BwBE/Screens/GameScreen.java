package com.BwBE.Screens;

import com.BwBE.BWBHelpers.ActionResolver;
import com.BwBE.BWBHelpers.AssetLoader;
import com.BwBE.BWBHelpers.Ship;
import com.BwBE.game.BwBE;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Scaling;

public class GameScreen implements Screen{

	//stuff for background that's common across all screens
	private Batch batch;
	
	public ActionResolver actionResolver;

	private Image[][] boardTiles = new Image[9][9];
	private TextureRegion tileTR;
    private Sprite[][] board = new Sprite[9][9];
	private Ship[] ships = new Ship[4];
	private int shipCount;
	private int tileWidth, LRPadding, UDPadding;
    
	public GameScreen(BwBE game) {
		this.actionResolver = BwBE.actionResolver;
		shipCount = 4;
	}
	
	public int getTileX(int x) {
		return this.LRPadding + (x * this.tileWidth);
	}
	
	public int getTileY(int y) {
		return this.UDPadding + (y * this.tileWidth);
	}
	
	public int getTileXx(int x) {
		return this.LRPadding + (x * this.tileWidth);
	}
	
	public int getTileYy(int y) {
		return this.UDPadding + (y * this.tileWidth);
	}
	
	
	@Override
	public void show() {	
		batch = new SpriteBatch();
	    
		
		
		int width = Gdx.graphics.getWidth();
		int height = Gdx.graphics.getHeight();
		tileWidth = (int)Math.floor(width/10);
		int boardWidth = tileWidth * 9;

		LRPadding = (width - boardWidth)/2; 
		UDPadding = (height - boardWidth)/2; 

		
		for(int i=0;i<9;i++) {
			for(int j=0;j<9;j++){
				//System.out.println("setting " + i + j + " to 0");
				board[i][j] = new Sprite(new Texture (AssetLoader.tilefh));
				board[i][j].setSize(tileWidth, tileWidth);
				System.out.println(this.getTileX(i) + " : " + this.getTileY(j));
				board[i][j].setPosition(this.getTileX(i),this.getTileY(j));
				
			}
		}

		Texture[] TRs = new Texture[5];
		TRs[0] = AssetLoader.carrierTexture;
		TRs[1] = AssetLoader.bshipTexture;
		TRs[2] = AssetLoader.subTexture;
		TRs[3] = AssetLoader.scoutTexture;
		TRs[4] = AssetLoader.fisherTexture;

		for(int i=0;i<shipCount;i++) {
		//for(int i=0;i<1;i++) {
			ships[i] = new Ship(TRs[i],5-i,tileWidth);
		}
		ships[0].setPlacement(4, 4, 0);
		ships[1].setPlacement(3, 5, 1);
		ships[2].setPlacement(2, 4, 2);
		ships[3].setPlacement(3, 3, 3);

	

        //Gdx.input.setInputProcessor(stage);
		
		
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(1, 0, 1, 0);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		batch.begin();
		AssetLoader.bgSprite.draw(batch);
		for(int i=0;i<9;i++) {
			for(int j=0;j<9;j++){
				board[i][j].draw(batch);
			}
		}
		
		
		
		//for(int i=0;i<shipCount;i++) {
		for(int i=0;i<shipCount;i++) {
			//System.out.println(ships[i].shipImage.getOriginX() + " " + ships[i].shipImage.getOriginY());
			ships[i].shipImage.setPosition(this.getTileX(ships[i].x),this.getTileY(ships[i].y));
			//ships[i].shipImage.setOrigin(this.getTileX(ships[i].x),this.getTileY(ships[i].y));
			//ships[i].shipImage.setPosition(0,0);

			ships[i].shipImage.draw(batch);
			
		}
		batch.end();

		
	

	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

}
