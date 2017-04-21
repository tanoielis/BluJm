package com.the_dungeoneers.game.states;

import com.the_dungeoneers.game.Game;
import com.the_dungeoneers.game.entities.player.Properties;
import com.the_dungeoneers.game.util.Button;

import static processing.core.PApplet.max;
import static processing.core.PApplet.min;
import static processing.core.PConstants.CORNER;

/**
 * Created by Eli on 21/04/2017.
 */
public class Upgrade implements State{
	
	private Game g;
	
	private Button upgradeLungs, upgradeSpeed, upgradeAgility;
	
	public Upgrade(Game g){
		this.g = g;
		upgradeAgility = new Button(g, 50, 200, "Agility");
		upgradeLungs = new Button(g, 50, 350, "Lungs");
		upgradeSpeed = new Button(g, 50, 500, "Speed");
	}
	
	@Override
	public void update(){
		
	}
	
	@Override
	public void drawUI(){
		g.background(0);
		upgradeLungs.draw();
		upgradeSpeed.draw();
		upgradeAgility.draw();
		g.ellipseMode(CORNER);
		g.fill(216, 223, 51);
		g.stroke(255);
		for(int i=0; i<max(Properties.agility, Properties.lungs, Properties.speed); i++){
			if(i < Properties.agility){
				g.ellipse(160 + i*50 + i*10, 200, 50, 50);
			}
			if(i < Properties.speed){
				g.ellipse(160 + i*50 + i*10, 500, 50, 50);
			}
			if(i < Properties.lungs){
				g.ellipse(160 + i*50 + i*10, 350, 50, 50);
			}
		}
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
		if(upgradeLungs.clicked(g.mouseX, g.mouseY)){
			Properties.lungs++;
		}else if(upgradeAgility.clicked(g.mouseX, g.mouseY)){
			Properties.agility++;
		}else if(upgradeSpeed.clicked(g.mouseX, g.mouseY)){
			Properties.speed++;
		}
	}
}
