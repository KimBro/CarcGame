package main.business.tile;

import main.business.Location;
import java.util.ArrayList;

/**
 * Created by Kevin on 12/17/16.
 */
public class RealTile extends Tile{

    private boolean placed;
    private ArrayList<Content> contents;

    RealTile(){
        placed = false;

        for(int i = 0; i < 9; i++){

            contents.add(null);
        }
    }

    public void setContents(ArrayList<Content> contents) {
        this.contents = contents;
    }

    public void setLocation(Location location){

        super.setLocation(location);
        placed = true;
    }

    // rotate tile 90 degrees
    public boolean rotate(){

        // only rotate if tile has not been placed
        if(!placed) {

            // rotate each content location

            // save contents
            Content content1 = contents.get(0);
            Content content2 = contents.get(1);
            Content content3 = contents.get(2);
            Content content4 = contents.get(3);
            // Content 5 always stays in same place
            Content content6 = contents.get(5);
            Content content7 = contents.get(6);
            Content content8 = contents.get(7);
            Content content9 = contents.get(8);

            // replace contents
            contents.set(0, content7); // 1 replaced by 7
            contents.set(1, content4); // 2 replaced by 4
            contents.set(2, content1); // 3 replaced by 1
            contents.set(3, content8); // 4 replaced by 8
            // content 5 is unchanged
            contents.set(5, content2); // 6 replaced by 2
            contents.set(6, content9); // 7 replaced by 9
            contents.set(7, content6); // 8 replaced by 6
            contents.set(8, content3); // 9 replaced by 3

            return true;

        }else{

            return false;
        }
    }

    public ContentType getTopEdgeType(){

        return contents.get(1).getType();
    }

    public ContentType getRightEdgeType(){

        return contents.get(5).getType();
    }

    public ContentType getBottomEdgeType(){

        return contents.get(7).getType();
    }

    public ContentType getLeftEdgeType(){

        return contents.get(3).getType();
    }

}
