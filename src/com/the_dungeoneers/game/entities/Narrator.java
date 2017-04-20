package com.the_dungeoneers.game.entities;

import java.util.HashMap;
import java.util.Map;

/**
 *  Narrator
 */
public class Narrator{
	
	private static Map<Integer, String[]> dialogue;
	private static int level = 0;
	private static int count;
	
	public Narrator(){
		dialogue = new HashMap<>();
		initalizeDialogue();
		nextLevel();
	}
	
	private void initalizeDialogue(){
		//Level 1
		String[] lvl1 = {
				"Oh no there is lava in the way of your exit!",
				"Here have a boat, it will help get you across!",
				"Oops. I lied."
		};
		
		dialogue.put(1, lvl1);
	}
	
	public String talk(){
		if (count < dialogue.get(level).length) {
			return dialogue.get(level)[count++];
		} else {
			return "";
		}
	}
	
	public void nextLevel(){
		level++;
		count = 0;
	}
	
}
