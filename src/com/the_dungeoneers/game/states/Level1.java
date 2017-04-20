package com.the_dungeoneers.game.states;


import com.the_dungeoneers.game.Game;
import com.the_dungeoneers.game.camera.Camera;
import com.the_dungeoneers.game.entities.Player;

/**
 * First level
 */
public class Level1 extends GameState{
	
	public Level1(Game g, Player player, Camera camera){
		super(g, player, camera);
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
		super.drawEntities();
	}
	
	@Override
	public void keyPressed(){
		super.keyPressed();
	}
}
