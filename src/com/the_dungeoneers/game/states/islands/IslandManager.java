package com.the_dungeoneers.game.states.islands;

import com.the_dungeoneers.game.Game;
import com.the_dungeoneers.game.states.State;
import com.the_dungeoneers.game.states.levels.Level;
import processing.core.PImage;

import java.util.ArrayList;
import java.util.List;

/**
 * Island Manager
 */
public class IslandManager implements State {
	
	private Game g;
	private Island currentIsland;
	private Island end;
	private static List<Island> islands;
	private static PImage background;

	public IslandManager(Game g){
		this.g = g;
        this.background = g.loadImage("images/islandBg.png");

        createIslands();
		currentIsland = islands.get(0);
		end = islands.get(islands.size() - 1);
	}

	private void createIslands() {

		islands = new ArrayList<>();
		islands.add(new VolcanoIsland(g));
		islands.add(new DistantIsland(g));
		islands.add(new BurningIsland(g));
		// ADD HERE

		islands.add(new PlaneIsland(g));
	}
	
	public void changeIsland(Island island) {
		if(currentIsland.levels.containsKey(island)){
			if(attempt(island)){
				currentIsland = island;
			}
		}
	}
	
	private boolean attempt(Island island){
		Level level = currentIsland.levels.get(island);
		g.states.startState(currentIsland.levels.get(island));
		return level.successful;
	}
	
	@Override
	public void update(){
		if(currentIsland == end){
			//todo GAMEOVER DUDE, GAAAAAMEE OVER!
		}
		currentIsland.update();
	}
	
	@Override
	public void drawUI(){

		g.image(background, 0, 0);
	}
	
	@Override
	public void drawEntities(){
		currentIsland.drawEntities();
	}
	
	@Override
	public void keyPressed(){
		currentIsland.keyPressed();
	}
	
	@Override
	public void keyReleased(){
		currentIsland.keyReleased();
	}
	
	@Override
	public void mousePressed(){
		currentIsland.mousePressed();
	}
}
