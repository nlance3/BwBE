package com.BwBE.BWBHelpers;

import com.BwBE.Screens.GameScreen;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class Ship {
	
	public Sprite shipImage;
	public boolean isPlaced;
	public int x,y,d,sp,dispx,dispy;
	
	public Ship(Texture txr, int spaces, float size) {
		shipImage = new Sprite(txr);
		System.out.println(shipImage.getHeight());
		shipImage.setSize(size*spaces,size);
		shipImage.setOrigin(size/2,size/2);
		//System.out.println(scaling);

		//shipImage.setOrigin(18,18);
		sp = spaces;
		isPlaced = false;
	}
	
	//dir 0 = right
	//dir 1 = up
	//dir 2 = left
	//dir 3 = down
	public void setPlacement(int originx, int originy, int dir) {
		d=dir;
		x = originx;
		y = originy;
		isPlaced = true;
		shipImage.setRotation(d*90f);
				
	}
	
	
	public void draw(Batch batch) {
		// Since we're using settings from here derived from game height/width update everything when called.
		//if not placed
		if(!this.isPlaced) {
			
		} else { 
			this.setPosition(GameScreen.getTileX(this.x),GameScreen.getTileY(this.y));
			shipImage.draw(batch); 
		}
		
		
	}

	public void setPosition(int x, int y) {
		if(!this.isPlaced) {
			
		} else {shipImage.setPosition(x, y);}
			
		
		
	}
}
