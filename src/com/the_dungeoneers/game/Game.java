package com.the_dungeoneers.game;

import processing.core.*;
import Collision.*;

import java.util.ArrayList;
import java.util.List;

public class Game extends PApplet{

	boolean intersection = false;

	List<Polygon> polygons = new ArrayList<>();

	@Override
	public void settings() {
		size(1000, 1000);
	}

	@Override
	public void setup() {
		createPolygons();
	}

	@Override
	public void draw() {
		background(255);

		drawPolygons();
	}
	private void createPolygons() {
		polygons.add(new Square(this, 500,650, 50, 50, color(255,0,0), 0));
		polygons.add(new Square(this, 590,600, 100, 100, color(0,255,0), 70));

		polygons.add(new Triangle(this, 700,650, 800, 650, (700 + 800)/2, 550, color(255,0,0), 0));
	}

	private void drawPolygons() {
		for (Polygon poly : polygons) {
			for (Polygon polygon1 : polygons) {
				if (SAT_Collision.intersects(poly, polygon1)) {
					if (!intersection) {
						intersection = true;
						System.out.println("Intersection detected");
					}
				}
			}
			poly.draw();
		}
	}
	
	public static void main(String[] args){
		PApplet.main("com.the_dungeoneers.game.Game");
	}
}
