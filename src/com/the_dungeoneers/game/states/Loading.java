package com.the_dungeoneers.game.states;

import com.the_dungeoneers.game.Game;
import com.the_dungeoneers.game.states.island.IslandManager;
import processing.core.PConstants;
import processing.core.PImage;

/**
 * Created by Eli on 22/04/2017.
 */
public class Loading implements State{
	
	private int timer, counter;
	private PImage[] background;
	private PImage img;
	private Game g;
	private int transparency;
	private IslandManager i;
	
	public Loading(Game g){
		this.g = g;
		this.timer = g.millis();
		this.background = new PImage[9];
		for(int i=0; i<background.length; i++){
			background[i] = g.loadImage("images/Backgrounds/Loading/"+i+".png");
		}
		this.img = background[0];
		this.counter = 8;
		this.transparency = 0;
	}
	
	@Override
	public void update(){
		if(counter == 0){
			if(transparency == 0){
				i = new IslandManager(g);
			}else if(transparency == 255){
				g.states.startState(i);
			}
			
			g.fill(0, ++transparency);
			g.rectMode(PConstants.CORNER);
			g.rect(0, 0, g.width, g.height);
		}
	}
	
	@Override
	public void drawUI(){
		if(g.millis() > timer + 100 && counter > 0){
			img = background[--counter];
		}
		g.imageMode(PConstants.CORNER);
		g.image(img, 0, 0);
	}
	
	@Override
	public void drawEntities(){
		
	}
	
	@Override
	public void keyPressed(){
		
	}
	
	@Override
	public void keyReleased(){
		
	}
	
	@Override
	public void mousePressed(){
		
	}
}
