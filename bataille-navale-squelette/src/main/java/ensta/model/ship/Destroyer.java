package ensta.model.ship;

import ensta.model.Orientation;

public class Destroyer extends AbstractShip {
    public Destroyer(Orientation orientation){
        super('D',"Destroyer",2,orientation);
    }

    public Destroyer(){
        super('D',"Destroyer",2,Orientation.EAST);
    }
}
