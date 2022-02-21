package ensta.model.ship;

import ensta.model.Orientation;

public abstract class AbstractShip {

    private Orientation orientation;
    private int length;
    private char label;
    private String name;


    public AbstractShip(char label, String name, int length, Orientation orientation){
        this.name = name;
        this.label = label;
        this.length = length;
        this.orientation = orientation;
    }

    public Orientation getOrientation(){
        return orientation;
    }

    public int getLength(){
        return length;
    }

    public char getLabel(){
        return label;
    }

    public boolean isSunk() {
        return false;
    }

    public Object getName() {
        return null;
    }
    
}
