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
import com.badlogic.gdx.scenes.scene2d.Actor;
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
	private Stage stage = new Stage();

	private Image[][] boardTiles = new Image[9][9];
	private TextureRegionDrawable tileTR;
    private Table board = new Table();
	private Ship[] ships = new Ship[4];
	private int shipCount;
	private int tileWidth;
    
	public GameScreen(BwBE game) {
		this.actionResolver = BwBE.actionResolver;
		shipCount = 4;
	}
	
	@Override
	public void show() {	
		batch = stage.getBatch();
	    board.setFillParent(true);
	    stage.addActor(board);
	    //board.setDebug(false);

		
		int width = Gdx.graphics.getWidth();
		int height = Gdx.graphics.getHeight();
		tileWidth = (int)Math.floor(width/10);
		int boardWidth = tileWidth * 9;

		int LRPadding = (width - boardWidth)/2; 
		int UDPadding = (height - boardWidth)/2; 


		board.padLeft(LRPadding);
		board.padRight(LRPadding);
		board.padTop(UDPadding);
		board.padBottom(UDPadding);

		
		tileTR = new TextureRegionDrawable(new TextureRegion(AssetLoader.tileTexture, 0,0,100,100));

		for(int i=0;i<9;i++) {
			for(int j=0;j<9;j++){
				//System.out.println("setting " + i + j + " to 0");
				boardTiles[i][j] = new Image();
				boardTiles[i][j].setScaling(Scaling.fit);
				boardTiles[i][j].setDrawable(tileTR);
				
				board.add(boardTiles[i][j]);
				
			}
			board.row();
		}

		TextureRegion[] TRs = new TextureRegion[5];
		TRs[0] = AssetLoader.carrierTR;
		TRs[1] = AssetLoader.bshipTR;
		TRs[2] = AssetLoader.subTR;
		TRs[3] = AssetLoader.scoutTR;
		TRs[4] = AssetLoader.fisherTR;

		for(int i=0;i<shipCount;i++) {
		//for(int i=0;i<1;i++) {
			ships[i] = new Ship(TRs[i],5-i,(float) (tileWidth/100.0));
			//Ships[i].setPlacement(0, 0, 0);
			stage.addActor(ships[i].shipImage);
		}
		ships[0].setPlacement(4, 4, 0);
		ships[1].setPlacement(4, 4, 1);
		ships[2].setPlacement(4, 4, 2);
		ships[3].setPlacement(4, 4, 3);

	

        //Gdx.input.setInputProcessor(stage);
		
		
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(1, 0, 1, 0);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		batch.begin();
		AssetLoader.bgSprite.draw(batch);
		batch.end();
		
		Vector2 loc;
		for(int i=0;i<shipCount;i++) {
		//for(int i=0;i<1;i++) {
			loc = boardTiles[ships[i].x][ships[i].y].localToStageCoordinates(new Vector2());
			ships[i].shipImage.setX(loc.x);
			ships[i].shipImage.setY(loc.y);
		}
			
		
		stage.act();
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
