package com.the_dungeoneers.game.states.island.islands;

import com.the_dungeoneers.game.Game;
import com.the_dungeoneers.game.camera.Camera;
import com.the_dungeoneers.game.entities.Player;
import com.the_dungeoneers.game.states.island.Island;
import com.the_dungeoneers.game.states.island.IslandManager;
import com.the_dungeoneers.game.states.levels.Level;
import com.the_dungeoneers.game.states.levels.Level1;
import com.the_dungeoneers.game.states.levels.Level3;
import com.the_dungeoneers.game.states.levels.Level9;

/**
 * Created by Chris on 22/04/2017.
 */
public class SkullIsland extends Island {
    
    public SkullIsland(Game g,  Player player, Camera camera){
        super(g, "Skull Island", player, camera);
    }


    @Override
    public void setNeighbours() {
        levels.put(IslandManager.islands.get("VolcanoIsland"), new Level1(g, player, camera, this));
        levels.put(IslandManager.islands.get("YellowIsland"), new Level3(g, player, camera, this));
    }
}
