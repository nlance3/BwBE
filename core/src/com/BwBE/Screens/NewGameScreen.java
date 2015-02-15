package com.BwBE.Screens;

import com.BwBE.BWBHelpers.ActionResolver;
import com.BwBE.game.BwBE;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.BwBE.BWBHelpers.AssetLoader;

public class NewGameScreen implements Screen{
	private BwBE game;
	public ActionResolver actionResolver;
	
	private Batch batch;
	private Skin skin = new Skin(Gdx.files.internal("data/uiskin.json"));
	private Stage stage = new Stage();
	private Table table = new Table();
	
	private TextButton buttonMenu = new TextButton("Main Menu", skin, "default"),
			buttonRandom = new TextButton("Random", skin, "default"),
			buttonFriend = new TextButton("Friend", skin, "default"),
			buttonLocal = new TextButton("Local", skin, "default"),
			buttonMapType = new TextButton("Classic Map", skin, "default"),
			buttonGameSpeed = new TextButton("Classic Speed", skin, "default"),
			buttonStartGame = new TextButton("Start Game", skin, "default");
	private Label title = new Label("Choose your game style", skin, "default"),
					title2 = new Label("Whom to play?", skin, "default");
	boolean isFast, isIslands;
	
	
	public NewGameScreen(BwBE game) {
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
		
		isFast = false;
		isIslands = false;
		
		buttonMenu.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                ((Game)Gdx.app.getApplicationListener()).setScreen(new MenuScreen(game));
            }
        });
        buttonRandom.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                //future work: add a check box
            }
        });
        buttonFriend.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
            	//future work: add a check box
            }
        });
        buttonLocal.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
            	//future work: add a check box
            }
        });
        buttonMapType.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
            	isIslands = !isIslands;
                if (isIslands) {
                	buttonMapType.setText("Islands Map");
                } else {
                	buttonMapType.setText("Classic Map"); 
                }
            }
        });
        buttonGameSpeed.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
            	isFast = !isFast;
                if (isFast) {
                	buttonGameSpeed.setText("Classic Game");
                } else {
                	buttonGameSpeed.setText("Speed Game"); 
                }
                
                //buttonGameSpeed.setText("Speed Game");
                //future work: toggle between classic and speed.  Store the chosen setting.
            }
        });
        buttonStartGame.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                ((Game)Gdx.app.getApplicationListener()).setScreen(new MatchingScreen(game));
            }
        });
        
		
      //The elements are displayed in the order you add them.
        //The first appear on top, the last at the bottom.
        table.add(title).padBottom(40).row();
        table.add(buttonMapType).size(desiredWidth,desiredHeight).padBottom(20).row();
        table.add(buttonGameSpeed).size(desiredWidth,desiredHeight).padBottom(20).row();
        table.add(title2).padBottom(40).row();
        table.add(buttonRandom).size(desiredWidth,desiredHeight).padBottom(20).row();
        table.add(buttonFriend).size(desiredWidth,desiredHeight).padBottom(20).row();
        table.add(buttonLocal).size(desiredWidth,desiredHeight).padBottom(20).row();
        table.add(buttonStartGame).size(desiredWidth,desiredHeight).padBottom(20).row();

        table.setFillParent(true);
        stage.addActor(table);

        Gdx.input.setInputProcessor(stage);
		
		
	}

	@Override
	public void render(float delta) {		
		AssetLoader.update();
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