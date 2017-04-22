package com.the_dungeoneers.game.states.island;

import Collision.*;
import com.the_dungeoneers.game.Game;
import com.the_dungeoneers.game.camera.Camera;
import com.the_dungeoneers.game.entities.Player;
import com.the_dungeoneers.game.states.State;
import com.the_dungeoneers.game.states.Upgrade;
import com.the_dungeoneers.game.states.island.islands.*;
import com.the_dungeoneers.game.states.levels.Level;
import processing.core.PImage;
import processing.core.PVector;

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
	private ComboPolygon mapBB;
	private Square hutBB;
	private Player player;
	private Camera camera;

	public IslandManager(Game g){
		this.g = g;
        this.background = g.loadImage("images/islandBg.png");


        mapBB = new ComboPolygon(g, 0, new Square(g, new PVector(790,440), 490, 280),
                new Triangle(g, new PVector(790, 535), new PVector(790, 720), new PVector(535, 720))
        );

		hutBB = new Square(g, new PVector(160, 280), 125, 200);

        createIslands();
		currentIsland = islands.get(0);
		end = islands.get(islands.size() - 1);
	}

	private void createIslands() {

		islands = new ArrayList<>();
		islands.add(new VolcanoIsland(g, player, camera));
		islands.add(new DistantIsland(g, player, camera));
		islands.add(new BurningIsland(g, player, camera));
		islands.add(new BigRockIsland(g, player, camera));
		islands.add(new SkullIsland(g, player, camera));
		islands.add(new TreasureIsland(g, player, camera));
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
		if (g.mouseX >= g.width/2) {
			for (Polygon polygon : mapBB.polys) {
				if (polygon.contains(new Point(g, new PVector(g.mouseX, g.mouseY)))) {
					g.states.startState(new MapOfIslands(g, this));
				}
			}
		}

		else {
			if (hutBB.contains(new Point(g, new PVector(g.mouseX, g.mouseY)))) {
				g.states.startState(new Upgrade(g));
			}
		}
		currentIsland.mousePressed();
	}
}
