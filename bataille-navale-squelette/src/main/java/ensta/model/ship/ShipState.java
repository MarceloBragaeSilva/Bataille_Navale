package ensta.model.ship;

import ensta.util.*;

public class ShipState {
    
    protected AbstractShip shipRef;
    protected boolean struck;

    public ShipState(){
        this.shipRef = null;
        this.struck = false;
    }

    public void addStrike(){
        if(!this.struck)
            this.shipRef.addStrike();
        else
            System.out.println("Already hit!");
        this.struck = true;
    }

    public boolean isStruck(){
        if (shipRef == null)
            return false;
        else return this.struck;

    }

    public String toString() {
        if(this.shipRef != null && this.isStruck())
        return ColorUtil.colorize(this.shipRef.getLabel(), ColorUtil.Color.RED);
        else if (this.shipRef != null && !this.isStruck())
        return ColorUtil.colorize(this.shipRef.getLabel(), ColorUtil.Color.WHITE);
        else return ColorUtil.colorize(".", ColorUtil.Color.WHITE);
    }

    public boolean isSunk(){
        if (shipRef == null)
            return false;
        else return this.shipRef.isSunk();
    }

    public AbstractShip getShip(){
        return this.shipRef;
    }

    public void setShip(AbstractShip ship){
        this.shipRef = ship;
    }

}
