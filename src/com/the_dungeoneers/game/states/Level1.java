package com.the_dungeoneers.game.states;


import Collision.Square;
import com.the_dungeoneers.game.Game;
import com.the_dungeoneers.game.camera.Camera;
import com.the_dungeoneers.game.entities.*;
import processing.core.PVector;

import java.util.ArrayList;

/**
 * First level
 */
public class Level1 extends GameState {

	ArrayList<Tile> boardTiles = new ArrayList<>();

	public Level1(Game g, Player player){
		super(g, player);
		generateTiles();
	}
	
	@Override
	public void update(){
		super.update();
	}
	
	@Override
	public void drawUI(){
		super.drawUI();
	}
	
	@Override
	public void drawEntities(){
		g.background(20, 0, 0);
		drawTiles();
		super.drawEntities();
	}


	private void drawTiles() {
		for (Tile t : boardTiles) {
			t.draw();
		}
	}

	void generateTiles() {
		boardTiles.add(new Floor(g, new PVector(0, g.height - 4*g.blockSize), 14*g.blockSize, 4*g.blockSize, g.color(24, 24, 29)));
		boardTiles.add(new Floor(g, new PVector(g.width - 12*g.blockSize, g.height - 4*g.blockSize), 14*g.blockSize, 4*g.blockSize, g.color(24, 24, 29)));
		boardTiles.add(new Lava(g, new PVector(14* g.blockSize, g.height - 2*g.blockSize), (g.width - 14*g.blockSize) - 12* g.blockSize, 2*g.blockSize, g.color(109,6,6)));
		boardTiles.add(new Exit(g, new PVector(g.width - 5*g.blockSize, g.height - 8*g.blockSize), g.blockSize, g.blockSize*4, g.color(29,168,8)));
	}

	@Override
	public void keyPressed(){
		super.keyPressed();
	}

	@Override
	public void mousePressed(){
	}
}
