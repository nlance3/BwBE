package com.BwBE.Screens;

import com.BwBE.BWBHelpers.ActionResolver;
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
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class GameScreen implements Screen{


	
	private BwBE game;
	public ActionResolver actionResolver;
	private Batch batch;
	private Skin skin = new Skin(Gdx.files.internal("data/uiskin.json"));
	private Stage stage = new Stage();
	private Table table = new Table();
	private Texture background = new Texture(Gdx.files.internal("data/gameBoard.png"));
	private TextureRegion region = new TextureRegion(background, 0, 0, 1080, 1920);
	private Sprite bg = new Sprite(region);
	private Label title = new Label("This is the where the game play happens :)", skin, "default");
	
	
	
	public GameScreen(BwBE game) {
		this.game = game;
		this.actionResolver = BwBE.actionResolver;
	}
	
	@Override
	public void show() {	
		batch = stage.getBatch();
		bg.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		
		
		
		
      //The elements are displayed in the order you add them.
        //The first appear on top, the last at the bottom.
       // table.add(title).padBottom(40).row();

        //table.setFillParent(true);
        //stage.addActor(table);

        //Gdx.input.setInputProcessor(stage);
		
		
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(1, 0, 1, 0);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		stage.act();
		batch.begin();
		bg.draw(batch);
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
