package ensta.ai;
import java.util.List;

import ensta.model.Board;
import ensta.model.Player;
import ensta.model.ship.AbstractShip;
import ensta.model.*;

public class PlayerAI extends Player {
    /* **
     * Attribut
     */
    private BattleShipsAI ai;

    /* **
     * Constructeur
     */
    public PlayerAI(Board ownBoard, Board opponentBoard, List<AbstractShip> ships) {
        super(ownBoard, opponentBoard, ships);
        ai = new BattleShipsAI(ownBoard, opponentBoard);
    }

    public void putShips(){
        ai.putShips(ships);
    }

    public Hit sendHit(Coords coords){
        return ai.sendHit(coords);
    }
}
