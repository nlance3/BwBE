package com.BwBE.Screens;

import com.BwBE.BWBHelpers.ActionResolver;
import com.BwBE.BWBHelpers.AssetLoader;
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
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class GameScreen implements Screen{

	//stuff for background that's common across all screens
	private Batch batch;
	
	private BwBE game;
	public ActionResolver actionResolver;
	private Skin skin = new Skin(Gdx.files.internal("data/uiskin.json"));
	private Stage stage = new Stage();

	private Label title = new Label("This is the where the game play happens :)", skin, "default");
	
	private Image[][] boardTiles = new Image[9][9];
	private TextureRegion tileTR;
    private Table board = new Table();
	
	public GameScreen(BwBE game) {
		this.game = game;
		this.actionResolver = BwBE.actionResolver;
	}
	
	@Override
	public void show() {	
		batch = stage.getBatch();
	    board.setFillParent(true);
	    stage.addActor(board);
	    board.setDebug(true);

		
		int width = Gdx.graphics.getWidth();
		int height = Gdx.graphics.getHeight();
		int tileWidth = (int)Math.floor(width/9) ;
		int boardWidth = tileWidth * 9;
		int boardHeight = tileWidth * 9;
		System.out.println(tileWidth);

		int LRPadding = (width - boardWidth)/2; 
		int UDPadding = (height - boardWidth)/2; 

		System.out.println(LRPadding);

		board.padLeft(LRPadding);
		board.padRight(LRPadding);

		
		tileTR = new TextureRegion(AssetLoader.tileTexture, 0,0,25,25);

		for(int i=0;i<9;i++) {
			for(int j=0;j<9;j++){
				//System.out.println("setting " + i + j + " to 0");
				boardTiles[i][j] = new Image(tileTR);
				//boardTiles[i][j].
				board.add(boardTiles[i][j]);
			}
			board.row();
		}

		
		
		
		
		
	

        //Gdx.input.setInputProcessor(stage);
		
		
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(1, 0, 1, 0);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		stage.act();
		batch.begin();
		AssetLoader.bgSprite.draw(batch);
		

	
		
		
		batch.end();			
		stage.draw();
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
		stage.dispose();
		
	}

}
