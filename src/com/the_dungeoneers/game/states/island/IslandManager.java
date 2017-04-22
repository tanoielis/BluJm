package com.the_dungeoneers.game.states.island;

import Collision.*;
import com.the_dungeoneers.game.Game;
import com.the_dungeoneers.game.camera.Camera;
import com.the_dungeoneers.game.entities.Player;
import com.the_dungeoneers.game.states.State;
import com.the_dungeoneers.game.states.Upgrade;
import com.the_dungeoneers.game.states.island.islands.*;
import com.the_dungeoneers.game.states.levels.Level;
import processing.core.PConstants;
import processing.core.PImage;
import processing.core.PVector;

import java.util.HashMap;

/**
 * Island Manager
 */
public class IslandManager implements State {
	
	private Game g;
	public Island currentIsland;
	private Island end;
	public static HashMap<String, Island> islands;
	private static PImage background;
	private ComboPolygon mapBB;
	private Square hutBB;
	private Player player;
	private Camera camera;
	private int day;
	private int transparency;

	public IslandManager(Game g){
		this.g = g;
        this.background = g.loadImage("images/Backgrounds/islandBg.png");

		this.player = new Player(g, new PVector(220, 520), new PVector(), new PVector());
		this.camera = new Camera(g, player);

		waterHutBoundingBoxes();
        createIslands();

        // Start and End Islands
		this.currentIsland = islands.get("VolcanoIsland");
		this.end = islands.get("PlaneIsland");
		
		this.day = 1;

		this.transparency = 255;
	}

	private void waterHutBoundingBoxes() {
		mapBB = new ComboPolygon(g, 0, new Square(g, new PVector(790,440), 490, 280),
				new Triangle(g, new PVector(790, 535), new PVector(790, 720), new PVector(535, 720))
		);

		hutBB = new Square(g, new PVector(160, 280), 125, 200);
	}

	private void createIslands() {

		islands = new HashMap<>();
		islands.put("VolcanoIsland", new VolcanoIsland(g, player, camera));
		islands.put("YellowIsland", new YellowIsland(g, player, camera));
		islands.put("BurningIsland", new BurningIsland(g, player, camera));
		islands.put("BigRockIsland", new BigRockIsland(g, player, camera));
		islands.put("SkullIsland", new SkullIsland(g, player, camera));
		islands.put("TreasureIsland", new TreasureIsland(g, player, camera));
		islands.put("PlaneIsland", new PlaneIsland(g, player, camera));
		
		for(Island i : islands.values()){
			i.setNeighbours(this);
		}
	}
	
	public void changeIsland(Island island) {
		if(currentIsland.levels.containsKey(island)){
			attempt(island);
		}
	}
	
	private boolean attempt(Island island){
		Level level = currentIsland.levels.get(island);
		g.states.startState(level);
		return level.successful;
	}
	
	public void attempt(boolean succesful, Island island, Level level){
		day++;
		player.upgradePoints++;
		if(succesful){
			currentIsland = island;
		}
		
		level.successful = false;
		level.running = true;
		player.right = false;
		player.up = false;
		player.down = false;
		player.right = false;
		player.setPos(new PVector(220, 520));
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
		g.textAlign(PConstants.RIGHT, PConstants.TOP);
		g.textSize(60);
		g.fill(243,203,116);

		g.text("Day: "+day, g.width, 0);
		g.text(currentIsland.name, g.width, 50);

		if(transparency <= 0){
			transparency = 0;
		}else{
			g.fill(0, (transparency-=2));
			g.rectMode(PConstants.CORNER);
			g.rect(0, 0, g.width, g.height);
		}

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
					g.states.startState(new MapOfIslands(g, this, player, camera));
				}
			}
		}

		else {
			if (hutBB.contains(new Point(g, new PVector(g.mouseX, g.mouseY)))) {
				g.states.startState(new Upgrade(g, player));
			}
		}
		currentIsland.mousePressed();
	}
}
