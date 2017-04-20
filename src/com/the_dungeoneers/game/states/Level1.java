package com.the_dungeoneers.game.states;


import Collision.Square;
import com.the_dungeoneers.game.Game;
import com.the_dungeoneers.game.camera.Camera;
import com.the_dungeoneers.game.entities.Player;
import com.the_dungeoneers.game.entities.Tile;
import processing.core.PVector;

import java.util.ArrayList;

/**
 * First level
 */
public class Level1 extends GameState {

	ArrayList<Tile> boardTiles = new ArrayList<>();

	public Level1(Game g, Player player){
		super(g, player);
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
		g.background(43, 0, 0);
		super.drawEntities();
	}

	@Override
	public void keyPressed(){
		super.keyPressed();
	}
	
	@Override
	public void mousePressed(){
		
	}
}
