package ensta;

//import ensta.controller.Game;
import ensta.model.Board;
import ensta.model.ship.BattleShip;
import ensta.model.ship.Carrier;
import ensta.model.ship.Destroyer;
import ensta.model.ship.Submarine;


public class Main {

	public static void main(String args[]) {
        Board board1 = new Board("Board1");
		board1.print();

        Board board2 = new Board("Board2", 6);
		board2.print();

        Destroyer destroyer1 = new Destroyer();
        System.out.println( destroyer1.getOrientation());
        System.out.println("FINISHED GAME");
    }

}
