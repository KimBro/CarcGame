package main.business.tile;



/**
 * Created by Kevin on 12/17/16.
 */
abstract public class Tile {

    private Tile topTile = null;
    private Tile rightTile = null;
    private Tile bottomTile = null;
    private Tile leftTile = null;

    public Tile getBottomTile() {
        return bottomTile;
    }

    public Tile getTopTile(){
        return topTile;
    }

    public Tile getLeftTile() {
        return leftTile;
    }

    public Tile getRightTile() {
        return rightTile;
    }

    public void setBottomTile(Tile bottomTile) {
        this.bottomTile = bottomTile;
    }

    public void setLeftTile(Tile leftTile) {
        this.leftTile = leftTile;
    }

    public void setRightTile(Tile rightTile) {
        this.rightTile = rightTile;
    }

    public void setTopTile(Tile topTile) {
        this.topTile = topTile;
    }


}
