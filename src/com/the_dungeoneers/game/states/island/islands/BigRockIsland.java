package com.the_dungeoneers.game.states.island.islands;

import com.the_dungeoneers.game.Game;
import com.the_dungeoneers.game.camera.Camera;
import com.the_dungeoneers.game.entities.Player;
import com.the_dungeoneers.game.states.island.Island;

/**
 * Created by Chris on 22/04/2017.
 */
public class BigRockIsland extends Island {
    
    public BigRockIsland(Game g, Player player, Camera camera){
        super(g, "Big Rock Island", player, camera);
    }
}
