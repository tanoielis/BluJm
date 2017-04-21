package com.the_dungeoneers.game.util;

import Collision.Point;
import Collision.Square;
import com.the_dungeoneers.game.Game;
import processing.core.PConstants;
import processing.core.PVector;

/**
 * Generic Button
 */
public class Button{
	
	private Game g;
	private float x, y, wd, ht;
	private Square bb;
	private String txt;
	
	public Button(Game g, float x, float y, float wd, float ht, String txt){
		this.g = g;
		this.x = x;
		this.y = y;
		this.wd = wd;
		this.ht = ht;
		this.bb = new Square(g, x, y, wd, ht);
		this.txt = txt;
	}
	
	public Button(Game g, float x, float y, String txt){
		this(g, x, y, 100, 50, txt);
	}
	
	public Button(Game g, PVector pos, String txt){
		this(g, pos.x, pos.y, txt);
	}
	
	public Button(Game g, PVector pos, float wd, float ht, String txt){
		this(g, pos.x, pos.y, wd, ht, txt);
	}
	
	public boolean clicked(float x, float y){
		return bb.contains(new Point(g, x, y));
	}
	
	public boolean clicked(PVector pos){
		return clicked(pos.x, pos.y);
	}
	
	public void draw(){
		g.stroke(255);
		g.fill(225, 219, 186);
		g.rectMode(PConstants.CORNER);
		g.rect(x, y, wd, ht);
		g.fill(0);
		g.textAlign(PConstants.CENTER, PConstants.CENTER);
		g.textSize(30);
		g.text(txt, x + wd/2, y + ht/2);
	}
}
