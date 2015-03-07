package com.BwBE.BWBHelpers;

import com.BwBE.Screens.GameScreen;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class Ship {
	
	public Sprite shipImage;
	public boolean isPlaced, isMoving;
	public int x,y,d,sp;
	public int upx,upy;
	
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
	
	
	public Ship(Texture txr, int spaces, float size, int x, int y) {
		shipImage = new Sprite(txr);
		System.out.println(shipImage.getHeight());
		shipImage.setSize(size*spaces,size);
		shipImage.setOrigin(size/2,size/2);
		//System.out.println(scaling);
		upx = x;
		upy = y;
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
		int last;
		switch(d){
		case 0: //right
			last = originx+sp;
			if(last >=9){
				x = originx-last+9;
			} break;
		case 1: //right
			last = originy+sp;
			if(last >=9){
				y = originy-last+9;
			} break;
		case 2: //right
			last = originx-sp;
			if(last < 0){
				x = sp-1;
			} break;
		case 3: //right
			last = originy-sp;
			if(last < 0){
				y = sp-1;
			} break;
		}
		
		isPlaced = true;
		shipImage.setRotation(d*90f);
		setPosition(GameScreen.getTileX(x),GameScreen.getTileY(y));

				
	}
	
	
	public void draw(Batch batch) {
		// Since we're using settings from here derived from game height/width update everything when called.
		//if not placed
		if(!this.isPlaced && !this.isMoving) {
			setPosition(upx,upy);
			shipImage.draw(batch);
		} else  { 
			shipImage.draw(batch); 
		}
		
		
	}

	public void setPosition(int x, int y) {
		shipImage.setPosition(x, y);
			
		
		
	}
}
