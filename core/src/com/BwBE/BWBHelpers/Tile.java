package com.BwBE.BWBHelpers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Scaling;
import com.BwBE.BWBHelpers.AssetLoader;
import com.BwBE.BWBHelpers.Ship;

/*mask info:
*0:nothing
*1:miss
*2:ship something
*/
public class Tile {
	
	private Sprite spr;
	public int status;
	
	public Tile(Texture img) {
		spr = new Sprite(img);

	}
	
	
	public void draw(Batch batch) {
		spr.draw(batch);
		
	}
	
	public void setSize(int x, int y) {
		spr.setSize(x,y);
	}
	
	public void setPosition(int x, int y) {
		spr.setPosition(x,y);
	}
	
	
	
}
