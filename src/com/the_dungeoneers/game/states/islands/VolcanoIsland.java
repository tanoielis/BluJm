package com.the_dungeoneers.game.states.islands;

import com.the_dungeoneers.game.Game;
import com.the_dungeoneers.game.states.levels.Level1;
import com.the_dungeoneers.game.states.levels.Level2;

/**
 * Home island
 */
public class VolcanoIsland extends Island {

    public VolcanoIsland(Game g) {
        super(g, "Volcano Island");

        levels.put(new DistantIsland(g), new Level1(g));
        levels.put(new BurningIsland(g), new Level2(g));
    }
}
