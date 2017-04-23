//package com.the_dungeoneers.game.states.levels;
//
//import Collision.Polygon;
//import Collision.SAT_Collision;
//import Collision.Square;
//import com.the_dungeoneers.game.Game;
//import com.the_dungeoneers.game.camera.Camera;
//import com.the_dungeoneers.game.entities.Player;
//import com.the_dungeoneers.game.entities.enemies.Jellyfish;
//import com.the_dungeoneers.game.entities.enemies.Shark;
//import com.the_dungeoneers.game.entities.obstacles.ComboRock;
//import com.the_dungeoneers.game.states.island.Island;
//import com.the_dungeoneers.game.states.island.IslandManager;
//import processing.core.PVector;
//
//import static processing.core.PConstants.CORNER;
//
///**
// * Created by Chris on 22/04/2017.
// */
//public class Level7 extends Level {
//
//	private ComboRock[] rocks;
//	private Jellyfish[] jellyfishes;
//	private Shark shark;
//	private int sharkTimer;
//
//    public Level7(Game g, Player player, Camera camera, Island from, IslandManager im) {
//        super(g, player, camera, from, im);
//
//		bg = g.loadImage("images/Backgrounds/Levels/level7.png");
//
//		rocks = new ComboRock[]{
//				new ComboRock(g, new PVector(778, -48), 413, 298, true),
//				new ComboRock(g, new PVector(778, 584), 413, 298, false),
//				new ComboRock(g, new PVector(1499, -48), 413, 298, true),
//				new ComboRock(g, new PVector(1499, 584), 413, 298, false),
//				new ComboRock(g, new PVector(2257, -48), 413, 298, true),
//				new ComboRock(g, new PVector(2257, 584), 413, 298, false),
//		};
//
//		jellyfishes = new Jellyfish[]{
//				new Jellyfish(g, new PVector(1021,299), new PVector(0, 3), new PVector(), true),
//				new Jellyfish(g, new PVector(1149,299), new PVector(0, 3), new PVector(), false),
//				new Jellyfish(g, new PVector(1763,299), new PVector(0, 3), new PVector(), true),
//				new Jellyfish(g, new PVector(1891,299), new PVector(0, 3), new PVector(), false),
//		};
//
//		sharkTimer = -1;
//
//    }
//
//	@Override
//	public void update(){
//		super.update();
//		collision();
//
//		if(sharkTimer == -1){
//			sharkTimer = g.millis();
//		}
//
//		if(g.millis() > sharkTimer + 3000 && shark == null){
//			shark = new Shark(g, new PVector(3000,299), new PVector(), new PVector());
//		}
//
//		if(shark != null){
//			shark.update();
//		}
//
//		for(Jellyfish j : jellyfishes){
//			j.update();
//		}
//	}
//
//	private void collision(){
//		for(int i=0; i<6; i++){
//			if(i<4){
//				if(SAT_Collision.intersects(jellyfishes[i].bb, player.bb)){
//					successful = false;
//					running = false;
//					shark = null;
//				}
//			}
//			for (Polygon polygon : rocks[i]){
//				if(SAT_Collision.intersects(rocks[i].bb, player.bb)){
//					PVector playerPos = player.getPos();
//					float playerX = playerPos.x;
//					float playerY = playerPos.y;
//					float playerWd = player.bb.wd;
//					float playerHt = player.bb.ht;
//					float rockX = rocks[i].getPos().x;
//					float rockY = rocks[i].getPos().y;
//					float rockWd = rocks[i].wd;
//					float rockHt = rocks[i].ht;
//
//					if(playerX + playerWd >= rockX && playerX <= rockX + 30 && (playerY > rockY + 30 && playerY < rockY + rockHt - 30)){
//						player.setPos(new PVector(rockX - playerWd, playerY));
//					}else if(playerX + player.vel.x <= rockX + rockWd && (playerY > rockY + 30 && playerY < rockY + rockHt - 30)){
//						player.setPos(new PVector(rockX + rockWd, playerY));
//					}
//					if(playerY + playerHt >= rockY && playerY + playerHt <= rockY + 30){
//						player.setPos(new PVector(playerX, rockY - playerHt));
//					}else if(playerY <= rockY + rockHt && playerY >= rockY + rockHt - 30){
//						player.setPos(new PVector(playerX, rockY + rockHt));
//					}
//				}
//			}
//		}
//	}
//
//	@Override
//	public void drawUI(){
//	}
//
//	@Override
//	public void drawEntities(){
//
//		g.pushMatrix();
//			g.translate(camera.getPos().x, 0);
//			g.imageMode(CORNER);
//			g.image(bg, 0, 0);
//
//			if(shark != null){
//				shark.draw();
//			}
//
//			for(Jellyfish j : jellyfishes){
//				j.draw();
//			}
//
//		g.popMatrix();
//	}
//}
