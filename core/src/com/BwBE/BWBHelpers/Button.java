package com.BwBE.BWBHelpers;

import com.BwBE.Screens.GameScreen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class Button {
	
	public Sprite txUp,txDn;
	public boolean isUp, isGrey;
	public int x,y,d,sp;
	
	
	public Button(Texture txrUp, int xloc,int yloc) {
		txUp = new Sprite(txrUp);
		x = xloc;
		y = yloc;
		isGrey = false;
	}
	
	public void draw(Batch batch) {
		txUp.setColor(Color.WHITE);
		if(isGrey) {
			txUp.setColor(Color.GRAY);
		} else if(!isUp) {
			txUp.setColor(Color.RED);
		}
		
		txUp.draw(batch);
		
	}

	
	
	
}