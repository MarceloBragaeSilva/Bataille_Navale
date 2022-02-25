package ensta.model;

import java.util.Random;
public class Coords {

    private int X;
    private int Y;

    public Coords(){
        this(1,1);
    }

    public Coords(int X, int Y){
        this.X = X-1;
        this.Y = Y-1;
    }

    public Coords(Coords coords){
        this(coords.X+1, coords.Y+1);
    }

    public int getX(){
        return X;
    }

    public int getY(){
        return Y;
    }

    public void setX(int X){
        this.X = X;
    }

    public void setY(int Y){
        this.Y = Y;
    }

    public void setCoords(Coords coords) {
        this.X = coords.getX();
        this.Y = coords.getY();
    }

    public boolean isInBoard(int size) {
        if(this.X>0 && this.X<=size && this.Y>0 && this.Y<=size)
             return true;
        else return false;
    }

    public static Coords randomCoords(int size) {
        Random rand = new Random();

        return new Coords(rand.nextInt(size)+1,
        rand.nextInt(size)+1);
    }
    
}
