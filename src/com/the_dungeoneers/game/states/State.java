package com.the_dungeoneers.game.states;

/**
 * Created by Eli on 20/04/2017.
 */
public interface State {
	
	void update();
	
	void drawUI();
	
	void drawEntities();
	
	void keyPressed();
	
	void keyReleased();
	
	void mousePressed();
}