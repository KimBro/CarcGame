package main.business.tile;

import main.business.Location;

/**
 * Created by Kevin on 12/18/16.
 */
public class EmptyTile extends Tile{

    ContentType topEdge = null;
    ContentType rightEdge = null;
    ContentType bottomEdge = null;
    ContentType leftEdge = null;

    public EmptyTile(Location location){

        setLocation(location);
    }

    // TO DO
    // Add edge comparison when setting neighbor tile

    // set edges for tile placement check
    public void setTopTile(RealTile topTile) {
        super.setTopTile(topTile);
        topEdge = topTile.getBottomEdgeType();
    }

    public void setRightTile(RealTile rightTile) {
        super.setRightTile(rightTile);
        rightEdge = rightTile.getLeftEdgeType();
    }

    public void setBottomTile(RealTile bottomTile) {
        super.setBottomTile(bottomTile);
        bottomEdge = bottomTile.getTopEdgeType();
    }

    public void setLeftTile(RealTile leftTile) {
        super.setLeftTile(leftTile);
        leftEdge = leftTile.getRightEdgeType();
    }

    public boolean isReal(){
        return false;
    }
}
