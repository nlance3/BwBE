package com.BwBE.BWBHelpers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.BwBE.BWBHelpers.AssetLoader;

public class Ship {
	public static Image shipSprite;
	
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
		if(d == 1){
			dispx = originx;
			dispy = originy + 1;
			shipImage.setRotation(90);
		} else if(d == 2){
			dispx = originx - 1;
			dispy = originy + 1;
			shipImage.setRotation(180);
		} else if(d == 3){
			dispx = originx - 1;
			dispy = originy;
			shipImage.setRotation(270);
		} else if(d == 0){
			dispx = originx;
			dispy = originy;
		}		
	}
	
	
	public void draw() {
		// Since we're using settings from here derived from game height/width update everything when called.
		//if not placed
		if(!this.isPlaced) {
			
		}
		
	}

	public void setPosition(int x, int y) {
		// TODO Auto-generated method stub
		float rot = shipImage.getRotation();
		shipImage.setRotation(0);
		shipImage.setPosition(x, y);
		shipImage.setRotation(rot);
		
	}
}
