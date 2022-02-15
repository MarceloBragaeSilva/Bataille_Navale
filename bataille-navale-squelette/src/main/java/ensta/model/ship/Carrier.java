package ensta.model.ship;

import ensta.model.Orientation;



public class Carrier extends AbstractShip {

    public Carrier(Orientation orientation){
        super('C',"Carrier",3,orientation);
    }

    public Carrier(){
        super('C',"Carrier",3,Orientation.EAST);
    }
}
