package com.the_dungeoneers.game.states.island.islands;

import com.the_dungeoneers.game.Game;
import com.the_dungeoneers.game.camera.Camera;
import com.the_dungeoneers.game.entities.Player;
import com.the_dungeoneers.game.states.island.Island;
import com.the_dungeoneers.game.states.island.IslandManager;
import com.the_dungeoneers.game.states.levels.*;

/**
 * Created by Chris on 22/04/2017.
 */
public class BigRockIsland extends Island {
    
    public BigRockIsland(Game g, Player player, Camera camera){
        super(g, "Big Rock Island", player, camera);
    }

    @Override
    public void setNeighbours() {
        levels.put(IslandManager.islands.get("PlaneIsland"), new Level9(g, player, camera, IslandManager.islands.get("PlaneIsland")));
        levels.put(IslandManager.islands.get("YellowIsland"), new Level5(g, player, camera, IslandManager.islands.get("YellowIsland")));
    }
}
