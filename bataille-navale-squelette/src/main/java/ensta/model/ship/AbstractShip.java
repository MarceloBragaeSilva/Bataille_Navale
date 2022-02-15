package ensta.model.ship;

import ensta.model.Orientation;

public abstract class AbstractShip {

    private Orientation orientation;
    private int length;


    public Orientation getOrientation(){
        return orientation;
    }

    public int getLength(){
        return length;
    }

    public boolean isSunk() {
        return false;
    }

    public Object getName() {
        return null;
    }
    
}
