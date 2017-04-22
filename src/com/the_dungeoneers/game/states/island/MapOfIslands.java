package com.the_dungeoneers.game.states.island;

import Collision.Point;
import Collision.SAT_Collision;
import Collision.Square;
import com.the_dungeoneers.game.Game;
import com.the_dungeoneers.game.camera.Camera;
import com.the_dungeoneers.game.entities.Player;
import com.the_dungeoneers.game.states.State;
import com.the_dungeoneers.game.states.Upgrade;
import com.the_dungeoneers.game.states.island.islands.SkullIsland;
import com.the_dungeoneers.game.states.island.islands.VolcanoIsland;
import processing.core.PConstants;
import processing.core.PImage;
import processing.core.PVector;

/**
 * A map of islands
 */
public class MapOfIslands implements State {
	
	private static PImage map;
	private Game g;
	private IslandManager im;
	private Player player;
	private Camera camera;

	private Square volcanoBB;
	private Square skullBB;
	private Square yellowBB;
	private Square burningBB;
	private Square bigRock;
	private Square treasureBB;
	private Square planeBB;
	private Square backBB;


	public MapOfIslands(Game g, IslandManager im, Player player, Camera camera){
		this.g = g;
		this.im = im;
		this.camera = camera;
		this.player = player;
		map = g.loadImage("images/map.png");
		createCollisionMasks();
	}

	private void createCollisionMasks() {
		volcanoBB = new Square(g, new PVector(15, 460), 265, 235);
		skullBB = new Square(g, new PVector(240,185), 90, 100);
		yellowBB = new Square(g, new PVector(440, 300), 190, 70);
		burningBB = new Square(g, new PVector(425, 510), 110, 95);
		bigRock = new Square(g, new PVector(790, 120), 90, 105);
		treasureBB = new Square(g, new PVector(780, 535), 110, 90);
		planeBB = new Square(g, new PVector(1030, 250), 250, 371);
	}

	@Override
	public void update(){
		
	}
	
	@Override
	public void drawUI(){
		g.imageMode(PConstants.CORNER);
		g.image(map, 0, 0);
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
		if (volcanoBB.contains(new Point(g, new PVector(g.mouseX, g.mouseY)))) {
			im.changeIsland(IslandManager.islands.get("VolcanoIsland"));
		}
		else if (skullBB.contains(new Point(g, new PVector(g.mouseX, g.mouseY)))) {
			im.changeIsland(IslandManager.islands.get("SkullIsland"));
		}
		else if (yellowBB.contains(new Point(g, new PVector(g.mouseX, g.mouseY)))) {
			im.changeIsland(IslandManager.islands.get("YellowIsland"));
		}
		else if (burningBB.contains(new Point(g, new PVector(g.mouseX, g.mouseY)))) {
			im.changeIsland(IslandManager.islands.get("BurningIsland"));
		}
		else if (bigRock.contains(new Point(g, new PVector(g.mouseX, g.mouseY)))) {
			im.changeIsland(IslandManager.islands.get("BigRockIsland"));
		}
		else if (treasureBB.contains(new Point(g, new PVector(g.mouseX, g.mouseY)))) {
			im.changeIsland(IslandManager.islands.get("TreasureIsland"));
		}
		else if (planeBB.contains(new Point(g, new PVector(g.mouseX, g.mouseY)))) {
			im.changeIsland(IslandManager.islands.get("PlaneIsland"));
		}
	}


}
