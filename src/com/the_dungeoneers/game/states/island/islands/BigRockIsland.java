package com.the_dungeoneers.game.states.island.islands;

import com.the_dungeoneers.game.Game;
import com.the_dungeoneers.game.camera.Camera;
import com.the_dungeoneers.game.entities.Player;
import com.the_dungeoneers.game.states.island.Island;
import com.the_dungeoneers.game.states.levels.Level2;
import com.the_dungeoneers.game.states.levels.Level4;
import com.the_dungeoneers.game.states.levels.Level7;

/**
 * Created by Chris on 22/04/2017.
 */
public class BigRockIsland extends Island {
    
    public BigRockIsland(Game g, Player player, Camera camera){
        super(g, "Big Rock Island", player, camera);

        levels.put(new TreasureIsland(g, player, camera), new Level7(g, player, camera, this));
        levels.put(new YellowIsland(g, player, camera), new Level4(g, player, camera, this));
        levels.put(new VolcanoIsland(g, player, camera), new Level2(g, player, camera, this));
    }
}
