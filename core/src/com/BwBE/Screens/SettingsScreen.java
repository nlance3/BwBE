package com.BwBE.Screens;

import com.BwBE.BWBHelpers.ActionResolver;
import com.BwBE.game.BwBE;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class SettingsScreen implements Screen{

	private BwBE game;
	public ActionResolver actionResolver;
	
	private Skin skin = new Skin(Gdx.files.internal("data/uiskin.json"));
	private Stage stage = new Stage();
	private Table table = new Table();
	
	private TextButton buttonMenu = new TextButton("Main Menu", skin, "default"),
			buttonSound = new TextButton("Turn Sound On", skin, "default"),
			buttonFacebook = new TextButton("Facebook", skin, "default"),
			buttonGoogle = new TextButton("Google Plus", skin, "default"),
			buttonMapType = new TextButton("Classic Map", skin, "default"),
			buttonGameSpeed = new TextButton("Classic Speed", skin, "default");
	private Label title = new Label("Boats with Buds", skin, "default");
	
	
	
	public SettingsScreen(BwBE game) {
		this.game = game;
		this.actionResolver = BwBE.actionResolver;
	}
	
	@Override
	public void show() {	
		
		buttonMenu.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                ((Game)Gdx.app.getApplicationListener()).setScreen(new MenuScreen(game));
            }
        });
        buttonSound.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                buttonSound.setText("Sound is off");
                //future work: toggle sound button between on and off.  Store the chosen setting.
            }
        });
        buttonFacebook.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
            	//facebook action here
            }
        });
        buttonGoogle.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                //G+ action here
            }
        });
        buttonMapType.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                buttonMapType.setText("Islands Map");
                //future work: toggle between islands and classic.  Store the chosen setting.
            }
        });
        buttonGameSpeed.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                buttonGameSpeed.setText("Speed Game");
                //future work: toggle between classic and speed.  Store the chosen setting.
            }
        });
        
		
      //The elements are displayed in the order you add them.
        //The first appear on top, the last at the bottom.
        table.add(title).padBottom(40).row();
        table.add(buttonMenu).size(150,60).padBottom(20).row();
        table.add(buttonSound).size(150,60).padBottom(20).row();
        table.add(buttonFacebook).size(150,60).padBottom(20).row();
        table.add(buttonGoogle).size(150,60).padBottom(20).row();
        table.add(buttonMapType).size(150,60).padBottom(20).row();
        table.add(buttonGameSpeed).size(150,60).padBottom(20).row();

        table.setFillParent(true);
        stage.addActor(table);

        Gdx.input.setInputProcessor(stage);
		
		
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(1, 0, 1, 1);
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
