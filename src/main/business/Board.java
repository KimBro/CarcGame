package main.business;

import main.business.tile.EmptyTile;
import main.business.tile.RealTile;
import main.business.tile.Tile;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Kevin on 12/17/16.
 */
public class Board {

    private HashMap<Integer, HashMap<Integer, Tile>> xTileLocation;
    private List<EmptyTile> availableSpots;

    // Constructor
    // Board is initialized with starting tile at 0,0
    Board(RealTile startTile){

        xTileLocation = new HashMap<>();
        availableSpots = new LinkedList<>();

        placeTile(startTile, new Location(0,0));
    }

    // Place tile at location
    public void placeTile(RealTile tile, Location location){

        HashMap<Integer, Tile> yTileLocation;
        int xLoc = location.getX();
        int yLoc = location.getY();

        // Make sure our hashmap exists for that x location
        if(xTileLocation.get(xLoc) != null){

            yTileLocation = xTileLocation.get(xLoc);
        }else{

            // if not, create it
            yTileLocation = new HashMap<>();
        }

        // TO DO
        // CHECK TO MAKE SURE LOCATION IS EMPTY TILE
        // AND
        // REMOVE EMPTY TILE ONCE REPLACED

        // put tile at location
        yTileLocation.put(yLoc, tile);

        // tell tile about it's location and set neighbors
        tile.setLocation(location);
        setNeighborTiles(tile);

        // TO DO
        // SET GROUPS
    }

    // Set neighbor tiles for placed RealTile
    //
    // Tells tiles that they are adjacent to one another
    // Creates new empty tiles if needed
    private void setNeighborTiles(RealTile tile){

        // get location of tile
        int xLoc = tile.getLocation().getX();
        int yLoc = tile.getLocation().getY();

        // get adjacent tiles
        Tile topTile = getTileAtLocation(xLoc, (yLoc + 1));
        Tile rightTile = getTileAtLocation((xLoc + 1), yLoc);
        Tile bottomTile = getTileAtLocation(xLoc, (yLoc - 1));
        Tile leftTile = getTileAtLocation((xLoc - 1), yLoc);

        // TOP TILE
        if(topTile == null){ // create EmptyTile neighbor if needed

            topTile = new EmptyTile(new Location(xLoc, (yLoc + 1)));
            EmptyTile newSpot = (EmptyTile)topTile;

            addAvailableSpot(newSpot);
            setNeighborTiles(newSpot);
        }

        // set as neighbors
        topTile.setBottomTile(tile);
        tile.setTopTile(topTile);

        // RIGHT TILE
        if(rightTile == null){ // create EmptyTile neighbor if needed

            rightTile = new EmptyTile(new Location((xLoc + 1), yLoc));
            EmptyTile newSpot = (EmptyTile)rightTile;

            addAvailableSpot(newSpot);
            setNeighborTiles(newSpot);
        }

        // set as neighbors
        rightTile.setLeftTile(tile);
        tile.setRightTile(rightTile);

        // BOTTOM TILE
        if(bottomTile == null){ // create EmptyTile neighbor if needed

            bottomTile = new EmptyTile(new Location(xLoc, (yLoc - 1)));
            EmptyTile newSpot = (EmptyTile)bottomTile;

            addAvailableSpot(newSpot);
            setNeighborTiles(newSpot);
        }

        // set as neighbors
        bottomTile.setTopTile(tile);
        tile.setBottomTile(bottomTile);

        // LEFT TILE
        if(leftTile == null){ // create EmptyTile neighbor if needed

            leftTile = new EmptyTile(new Location((xLoc - 1), yLoc));
            EmptyTile newSpot = (EmptyTile)leftTile;

            addAvailableSpot(newSpot);
            setNeighborTiles(newSpot);
        }

        // set as neighbors
        leftTile.setRightTile(tile);
        tile.setLeftTile(leftTile);
    }

    // set neighbor tiles for created EmptyTile
    private void setNeighborTiles(EmptyTile emptyTile){

        // get location of emptyTile
        int xLoc = emptyTile.getLocation().getX();
        int yLoc = emptyTile.getLocation().getY();

        // get adjacent tiles
        Tile topTile = getTileAtLocation(xLoc, (yLoc + 1));
        Tile rightTile = getTileAtLocation((xLoc + 1), yLoc);
        Tile bottomTile = getTileAtLocation(xLoc, (yLoc - 1));
        Tile leftTile = getTileAtLocation((xLoc - 1), yLoc);

        // Set neighbors
        // TOP TILE
        if(topTile != null && topTile.isReal()){ // only set neighbor if it is RealTile

            // set as neighbors
            topTile.setBottomTile(emptyTile);
            emptyTile.setTopTile(topTile);
        }

        // RIGHT TILE
        if(rightTile != null && rightTile.isReal()){ // only set neighbor if it is RealTile

            // set as neighbors
            rightTile.setLeftTile(emptyTile);
            emptyTile.setRightTile(rightTile);
        }

        // BOTTOM TILE
        if(bottomTile != null && bottomTile.isReal()){ // only set neighbor if it is RealTile

            // set as neighbors
            bottomTile.setTopTile(emptyTile);
            emptyTile.setBottomTile(bottomTile);
        }

        // LEFT TILE
        if(leftTile != null && leftTile.isReal()){ // only set neighbor if it is RealTile

            // set as neighbors
            leftTile.setRightTile(emptyTile);
            emptyTile.setLeftTile(leftTile);
        }
    }

    // add empty tile to available location
    public void addAvailableSpot(EmptyTile newSpot){
        availableSpots.add(newSpot);
    }

    public void rotateTileAtLocation(Tile tile){


    }

    public void placeMeeple(Tile tile, int zone){


    }

    // returns tile at the given x and y location
    // returns null if no tile found
    public Tile getTileAtLocation(int xLoc, int yLoc){

        if(xTileLocation.get(xLoc) == null){
            return null;
        }

        HashMap<Integer, Tile> yTileLocation = xTileLocation.get(xLoc);

        Tile tile = yTileLocation.get(yLoc);

        return tile;
    }

}
