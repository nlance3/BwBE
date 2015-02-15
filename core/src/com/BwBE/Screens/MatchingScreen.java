package com.BwBE.Screens;

import com.BwBE.BWBHelpers.ActionResolver;
import com.BwBE.game.BwBE;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.BwBE.BWBHelpers.AssetLoader;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class MatchingScreen implements Screen{

	
	private BwBE game;
	public ActionResolver actionResolver;
	
	private Skin skin = new Skin(Gdx.files.internal("data/uiskin.json"));
	private Stage stage = new Stage();
	private Table table = new Table();
	private Batch batch;
	private TextButton buttonSkip = new TextButton("Skip waiting screen", skin, "default");
	private Label title = new Label("Matching.  Please wait bro.", skin, "default");
	
	
	
	public MatchingScreen(BwBE game) {
		this.game = game;
		this.actionResolver = BwBE.actionResolver;
	}
	
	@Override
	public void show() {	
		batch = stage.getBatch();

		float width = Gdx.graphics.getWidth();
		float height = Gdx.graphics.getHeight();
		float desiredWidth = width * .7f;
		float desiredHeight = height * .1f;
		
		buttonSkip.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
            	((Game)Gdx.app.getApplicationListener()).setScreen(new GameScreen(game));
            }
        });
		
		
      //The elements are displayed in the order you add them.
        //The first appear on top, the last at the bottom.
        table.add(title).padBottom(40).row();
        table.add(buttonSkip).size(desiredWidth,desiredHeight).padBottom(20).row();


        table.setFillParent(true);
        stage.addActor(table);

        Gdx.input.setInputProcessor(stage);
		
		
	}

	@Override
	public void render(float delta) {
		batch.begin();
		AssetLoader.bgSprite.draw(batch);
		batch.end();
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
