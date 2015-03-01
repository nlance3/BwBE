package com.BwBE.Screens;

import com.BwBE.BWBHelpers.ActionResolver;
import com.BwBE.BWBHelpers.AssetLoader;
import com.BwBE.BWBHelpers.Ship;
import com.BwBE.BWBHelpers.Tile;
import com.BwBE.game.BwBE;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;


public class GameScreen implements Screen,InputProcessor {

	//stuff for background that's common across all screens
	private Batch batch;
	
	public ActionResolver actionResolver;
	
	private Tile[][] board = new Tile[9][9];
	private Ship[] ships = new Ship[5];
	private int shipCount, activeShip, newActiveShip;
	private static int tileWidth, LRPadding, UDPadding;
    
	public GameScreen(BwBE game) {
		this.actionResolver = BwBE.actionResolver;
		shipCount = 5;
		activeShip = -1;
		batch = new SpriteBatch();
	    
		
		
		int width = Gdx.graphics.getWidth();
		int height = Gdx.graphics.getHeight();
		tileWidth = (int)Math.floor(width/10);
		int boardWidth = tileWidth * 9;

		LRPadding = (width - boardWidth)/2; 
		UDPadding = (height - boardWidth)/2; 

		
		for(int i=0;i<9;i++) {
			for(int j=0;j<9;j++){
				//System.out.println("setting " + i + j + " to 0");
				board[i][j] = new Tile(new Texture (AssetLoader.tilefh));
				board[i][j].setSize(tileWidth, tileWidth);
				System.out.println(GameScreen.getTileX(i) + " : " + GameScreen.getTileY(j));
				board[i][j].setPosition(GameScreen.getTileX(i),GameScreen.getTileY(j));
				
			}
		}

		Texture[] TRs = new Texture[5];
		TRs[0] = AssetLoader.carrierTexture;
		TRs[1] = AssetLoader.bshipTexture;
		TRs[2] = AssetLoader.subTexture;
		TRs[3] = AssetLoader.scoutTexture;
		TRs[4] = AssetLoader.fisherTexture;

		for(int i=0;i<shipCount;i++) {
		//for(int i=0;i<1;i++) {
			ships[i] = new Ship(TRs[i],5-i,tileWidth);
			ships[i].setPlacement(0, i, 0);
		}
		
		
	}
	
	public static int getTileX(int x) {
		return GameScreen.LRPadding + (x * GameScreen.tileWidth);
	}
	
	public static int getTileY(int y) {
		return GameScreen.UDPadding + (y * GameScreen.tileWidth);
	}
	
	public static int getTileXc(int x) {
		return GameScreen.LRPadding + (x * GameScreen.tileWidth) + tileWidth/2;
	}
	
	public static int getTileYc(int y) {
		return GameScreen.UDPadding + (y * GameScreen.tileWidth) + tileWidth/2;
	}
	
	
	@Override
	public void show() {	
		Gdx.input.setInputProcessor(this);

	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(1, 0, 1, 0);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		batch.begin();
		AssetLoader.bgSprite.draw(batch);
		for(int i=0;i<9;i++) {
			for(int j=0;j<9;j++){
				board[i][j].draw(batch);
			}
		}
		
		
		//for(int i=0;i<shipCount;i++) {
		for(int i=0;i<shipCount;i++) {
			ships[i].draw(batch);
		}
		if(activeShip>=0){ships[activeShip].draw(batch);}
		batch.end();

		
	

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
	}

	@Override
	public boolean keyDown(int keycode) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		// TODO Auto-generated method stub
		return false;
	}

	/*on a touch check the old state
	 * Check to see if the touch down is on a ship. If it is change the active ship
	 * If not see if we have an active ship
	 *  If so; can draw a ship from the touch point
	 *  If not:unselect active ship 
	 */
	
	private Vector2 firstTouch = new Vector2();
	private Vector2 deltaTouch = new Vector2();
	private Vector2 touchDelta = new Vector2();
	private boolean hit = false, hitOnActive = false;
	private boolean possDraw = false, newPossDraw = false;
	
	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		screenY = Gdx.graphics.getHeight() - screenY;
		System.out.println(screenX + "x" + screenY);
		firstTouch.x=screenX;
		firstTouch.y=screenY;
		hit = false;
		hitOnActive = false;
		newActiveShip = -1;
		//check for a hit first:
		for(int i=0;i<shipCount;i++) {
			Rectangle rect = ships[i].shipImage.getBoundingRectangle();
			int llx = Math.round(rect.x);
			int lly = Math.round(rect.y);
			int urx = Math.round(rect.x+rect.width);
			int ury = Math.round(rect.y+rect.height);
			
			//actionResolver.toastMe("@" + llx + "x" + lly + " : " + urx + "x" + ury);
			if(screenX > llx && screenX < urx && screenY > lly && screenY < ury) {
				hit = true;
				if(i==activeShip){
					hitOnActive = true;
					touchDelta.x=screenX-ships[i].shipImage.getX();
					touchDelta.y=screenY-ships[i].shipImage.getY();
					System.out.println(touchDelta.x);
					System.out.println(touchDelta.y);
				} else {hit=true;}
				newActiveShip = i;
			}
		}
		
		if(activeShip >= 0 && !hit) {
			if(screenX>=LRPadding && screenX <=Gdx.graphics.getWidth()-LRPadding && screenY>=UDPadding && screenY<=Gdx.graphics.getHeight()-UDPadding) {
				possDraw = true;
			}
		}
		
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		screenY = Gdx.graphics.getHeight() - screenY;
		if(!(possDraw  || hitOnActive) || firstTouch.dst2(new Vector2(screenX,screenY)) <9) {updateState(); System.out.println("skipping"); return false;}
		// TODO Auto-generated method stub
		deltaTouch.x = screenX - firstTouch.x;
		deltaTouch.y = screenY - firstTouch.y;
		if(hitOnActive) {
			System.out.println("HOA");
			Vector2 test = new Vector2();
			float dst2,min = Float.MAX_VALUE;
			int x=0,y=0;
			for(int i=0;i<9;i++){
				for(int j=0;j<9;j++){
					test.x=GameScreen.getTileX(i)+touchDelta.x;
					test.y=GameScreen.getTileY(j)+touchDelta.y;
					dst2 = test.dst2(screenX,screenY);
					if(Math.min(dst2,min) == dst2) {
						min = dst2;
						x=i;
						y=j;
					}
				}
			}
			ships[activeShip].setPlacement(x, y, ships[activeShip].d);
		} else if(activeShip >= 0) {
			float angle = deltaTouch.angle();
			int dir;
			//System.out.println(deltaTouch.x+" "+deltaTouch.y);

			if(angle<45 || angle >= 315) {
				dir = 0;
			} else if (angle<135 && angle >= 45) {
				dir = 1;
			} else if (angle<225 && angle >= 135) {
				dir = 2;
			} else {
				dir = 3;
			}
		
			System.out.println(angle + " " + dir);
			if(possDraw) {
				Vector2 test = new Vector2();
				float dst2,min = Float.MAX_VALUE;
				int x=0,y=0;
				for(int i=0;i<9;i++){
					for(int j=0;j<9;j++){
						test.x=GameScreen.getTileXc(i);
						test.y=GameScreen.getTileYc(j);
						dst2 = test.dst2(firstTouch);
						if(Math.min(dst2,min) == dst2) {
							min = dst2;
							x=i;
							y=j;
						}
					}
				}
				ships[activeShip].setPlacement(x, y, dir);
			}
			newPossDraw = false;
			newActiveShip = activeShip;

		}
		
		updateState();
		return false;
	}
	
	private void updateState() {
		possDraw = newPossDraw;
		
		if(activeShip != newActiveShip){
			if(activeShip>=0){
				ships[activeShip].shipImage.setColor(Color.WHITE);
			}
			if(newActiveShip>=0){
				ships[newActiveShip].shipImage.setColor(Color.RED);
			}
		}
		activeShip = newActiveShip;
		hitOnActive = false;
		hit=false;
		
		//zero the board
		for(int i=0;i<9;i++) {
			for(int j=0;j<9;j++){
				board[i][j].status = 0;
			}
		}
		
		for(int i=0;i<shipCount;i++){
			if(!ships[i].isPlaced){continue;}
			int d = ships[i].d;
			int sp = ships[i].sp;
			int x = ships[i].x;
			int y = ships[i].y;
			for(int j=0; j<sp; j++){
				switch(d){
				case 0:
					board[x+j][y].status++;
					break;
				case 1:
					board[x][y+j].status++;
					break;
				case 2:
					board[x-j][y].status++;
					break;
				case 3:
					board[x][y-j].status++;
					break;
				}
			}
		}
		printBoard();
		boolean valid = checkState();
		
	}
	
	public void printBoard(){
		for(int i=8;i>=0;i--) {
			for(int j=0;j<9;j++){
				System.out.print(board[j][i].status);
			}
			System.out.println();
		}
	}
	
	public boolean checkState() {
		for(int i=0;i<9;i++) {
			for(int j=0;j<9;j++){
				if(board[i][j].status>1) {return false;}
			}
		}
		return true;
	}
	
	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		// TODO Auto-generated method stub
		screenY = Gdx.graphics.getHeight() - screenY;
		if(hitOnActive) {
			System.out.println(activeShip);
			ships[activeShip].setPosition(screenX-(int)touchDelta.x, screenY-(int)touchDelta.y);
		}
		
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		// TODO Auto-generated method stub
		return false;
	}

}
