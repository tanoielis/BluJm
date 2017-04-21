package com.the_dungeoneers.game.states;

import Collision.Point;
import Collision.Square;
import com.sun.deploy.uitoolkit.impl.fx.ui.CertificateDialog;
import com.the_dungeoneers.game.Game;
import processing.core.PConstants;

import java.security.cert.CertificateNotYetValidException;

/**
 * Mainmenu
 */
public class Mainmenu implements State{
	
	private Square play;
	private Game g;
	
	public Mainmenu(Game g){
		this.g = g;
		play = new Square(g, g.width/2-200, g.height/2-50, 400, 100);
	}
	
	@Override
	public void update(){
		
	}
	
	@Override
	public void drawUI(){
		g.background(0);
		g.fill(255);
		g.rectMode(PConstants.CENTER);
		g.rect(g.width/2, g.height/2, 400, 100);
		g.fill(0);
		g.textAlign(PConstants.CENTER, PConstants.CENTER);
		g.textSize(60);
		g.text("Play", g.width/2, g.height/2);
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
		if(play.contains(new Point(g, g.mouseX, g.mouseY))){
			g.states.startState(new Island(g));
		}
	}
}
