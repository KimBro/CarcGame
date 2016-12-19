package main.business.tile;

import main.business.Location;

/**
 * Created by Kevin on 12/18/16.
 */
public class EmptyTile extends Tile{

    public EmptyTile(Location location){

        setLocation(location);
    }

    // TO DO
    // Add edge comparison when setting neighbor tile
    public void setBottomTile(Tile bottomTile) {
        super.setBottomTile(bottomTile);
    }

    public void setLeftTile(Tile leftTile) {
        super.setLeftTile(leftTile);
    }

    public void setRightTile(Tile rightTile) {
        super.setRightTile(rightTile);
    }

    public void setTopTile(Tile topTile) {
        super.setTopTile(topTile);
    }

}
