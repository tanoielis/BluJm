package com.the_dungeoneers.game.states;

import Collision.Point;
import Collision.Square;
import com.the_dungeoneers.game.Game;
import com.the_dungeoneers.game.entities.Player;
import com.the_dungeoneers.game.util.Button;
import processing.core.PImage;
import processing.core.PVector;

import static processing.core.PApplet.max;
import static processing.core.PConstants.CORNER;
import static processing.core.PConstants.RIGHT;
import static processing.core.PConstants.TOP;

/**
 * Upgrage menu
 */
public class Upgrade implements State{
	
	private Game g;
	
	private Button upgradeLungs, upgradeSpeed, upgradeAgility;
	private Square backBB;
	private Player player;
	private PImage img;
	
	public Upgrade(Game g, Player player){
		this.g = g;
		this.upgradeAgility = new Button(g, 50, 200, "Agility");
		this.upgradeLungs = new Button(g, 50, 350, "Lungs");
		this.upgradeSpeed = new Button(g, 50, 500, "Speed");
		this.backBB = new Square(g, new PVector(25,25), 160, 75);
		this.player = player;
		this.img = g.loadImage("images/Backgrounds/upgrade.png");
	}
	
	@Override
	public void update(){
		
	}
	
	@Override
	public void drawUI(){
		g.imageMode(CORNER);
		g.image(img, 0, 0);
		upgradeLungs.draw();
		upgradeSpeed.draw();
		upgradeAgility.draw();
		g.ellipseMode(CORNER);
		g.fill(226, 200, 51);
		g.stroke(255);
		for(int i=0; i<max(player.agility, player.lungs, player.speed); i++){
			if(i < player.agility){
				g.ellipse(160 + i*50 + i*10, 200, 50, 50);
			}
			if(i < player.speed){
				g.ellipse(160 + i*50 + i*10, 500, 50, 50);
			}
			if(i < player.lungs){
				g.ellipse(160 + i*50 + i*10, 350, 50, 50);
			}
		}
		g.textAlign(RIGHT, TOP);
		g.fill(0);
		g.text("Upgrade Points: "+player.upgradePoints, g.width, 0);
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
		if(player.upgradePoints > 0){
			if(upgradeLungs.clicked(g.mouseX, g.mouseY) && player.lungs < 5){
				player.lungs++;
				player.upgradePoints--;
			}else if(upgradeAgility.clicked(g.mouseX, g.mouseY) && player.agility < 5){
				player.agility++;
				player.upgradePoints--;
			}else if(upgradeSpeed.clicked(g.mouseX, g.mouseY) && player.speed < 5){
				player.speed++;
				player.upgradePoints--;
			}
		}

		if (backBB.contains(new Point(g, new PVector(g.mouseX, g.mouseY)))) {
			g.states.endState();
		}
	}
}
