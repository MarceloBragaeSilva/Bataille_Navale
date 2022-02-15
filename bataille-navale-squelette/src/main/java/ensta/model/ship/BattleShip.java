package ensta.model.ship;

import ensta.model.Orientation;

public class BattleShip extends AbstractShip{

    public BattleShip(Orientation orientation){
        super('B',"BattleShip",3,orientation);
    }

    public BattleShip(){
        super('B',"BattleShip",3,Orientation.EAST);
    }
}
