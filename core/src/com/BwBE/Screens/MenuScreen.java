package com.BwBE.Screens;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.BwBE.BWBHelpers.AssetLoader;
import com.BwBE.game.BwBE;
import com.BwBE.BWBHelpers.ActionResolver;


public class MenuScreen implements Screen{
	
	private BwBE game;
	public ActionResolver actionResolver;
	
	private Skin skin = new Skin(Gdx.files.internal("data/uiskin.json"));
	private Stage stage = new Stage();
	private Table table = new Table();
	
	private TextButton buttonNewGame = new TextButton("Start New Game", skin, "default"),
			buttonSplash = new TextButton("Splash Again", skin, "default"),
			buttonToast = new TextButton("Show Me Some Toast", skin, "default"),
			buttonSettings = new TextButton("Game Settings", skin, "default"),
			buttonExit = new TextButton("Exit", skin, "default");
	private Label title = new Label("Boats with Buds", skin, "default");
	
	
	
	public MenuScreen(BwBE game) {
		this.game = game;
		this.actionResolver = BwBE.actionResolver;
	}
	
	@Override
	public void show() {	
		
		buttonNewGame.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
            	((Game)Gdx.app.getApplicationListener()).setScreen(new NewGameScreen(game));
            }
        });
		
		buttonSplash.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                ((Game)Gdx.app.getApplicationListener()).setScreen(new SplashScreen(game));
            }
        });
        buttonToast.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                actionResolver.toastMe();
            }
        });
        buttonSettings.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
            	((Game)Gdx.app.getApplicationListener()).setScreen(new SettingsScreen(game));
            }
        });
        buttonExit.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                Gdx.app.exit();
                // or System.exit(0);
            }
        });
        
		
      //The elements are displayed in the order you add them.
        //The first appear on top, the last at the bottom.
        table.add(title).padBottom(40).row();
        table.add(buttonNewGame).size(150,60).padBottom(20).row();
        table.add(buttonSplash).size(150,60).padBottom(20).row();
        table.add(buttonToast).size(150,60).padBottom(20).row();
        table.add(buttonSettings).size(150,60).padBottom(20).row();
        table.add(buttonExit).size(150,60).padBottom(20).row();

        table.setFillParent(true);
        stage.addActor(table);

        Gdx.input.setInputProcessor(stage);
		
		
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
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
