package ensta.model.ship;

import ensta.model.Orientation;

public abstract class AbstractShip {

    private Orientation orientation;
    private int length;
    private char label;
    private String name;
    private int strikeCount = 0;


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

    public void setLabel(char label){
        this.label = label;
    }

    public boolean isSunk() {
        if(this.strikeCount >= this.length)
            return true;
        else return false;
    }

    public Object getName() {
        return name;
    }

    public void setOrientation(Orientation o) {
        orientation = o;
    }

    public void addStrike(){
        this.strikeCount++;
    }
    
}
