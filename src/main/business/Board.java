package main.business;

import main.business.tile.EmptyTile;
import main.business.tile.RealTile;
import main.business.tile.Tile;
import java.util.HashMap;

/**
 * Created by Kevin on 12/17/16.
 */
public class Board {

    private HashMap<RealTile, Location> placedTiles;
    private HashMap<EmptyTile, Location> availableSpots;

    Board(RealTile startTile){

        placeTile(startTile, new Location(0,0));
    }

    public void placeTile(RealTile tile, Location location){

        placedTiles.put(tile, location);
    }

    public void rotateTileAtLocation(Tile tile){


    }

    public void placeMeeple(Tile tile, int zone){


    }

}
