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
	
	public Image shipImage;
	public boolean isPlaced;
	public  int x,y,d,sp;
	
	public Ship(TextureRegion image, int spaces) {
		shipImage = new Image(image);
		sp = spaces;
		isPlaced = false;
	}
	
	//dir 0 = right
	//dir 1 = up
	//dir 2 = left
	//dir 3 = down
	public void setPlacement(int originx, int originy, int dir) {
		d=dir;
		isPlaced = true;
		if(d == 1){
			y = originy - sp;
			x = originx;
			shipImage.rotateBy(90);
		} else if(d == 2){
			x = originx - sp;
			y = originy;
			shipImage.rotateBy(180);
		} else if(d == 3){
			x = originx;
			y = originy;
			shipImage.rotateBy(270);
		} else if(d == 0){
			x = originx;
			y = originy;
		}		
	}
	
	
	public void draw() {
		// Since we're using settings from here derived from game height/width update everything when called.
		//if not placed
		if(!this.isPlaced) {
			
		}
		
	}
}
