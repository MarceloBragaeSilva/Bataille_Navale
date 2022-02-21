package ensta;

//import ensta.controller.Game;
import ensta.model.Board;
import ensta.model.Coords;
import ensta.model.Orientation;
import ensta.model.ship.BattleShip;
import ensta.model.ship.Carrier;
import ensta.model.ship.Destroyer;
import ensta.model.ship.Submarine;


public class Main {

	public static void main(String args[]) {
        Board board1 = new Board("Board1");
		//board1.print();

        //Board board2 = new Board("Board2", 6);
		//board2.print();
        
        Destroyer d1 = new Destroyer(Orientation.EAST);
        BattleShip b1 = new BattleShip(Orientation.WEST);
        Submarine s1 = new Submarine(Orientation.NORTH);
        Carrier c1 =  new Carrier(Orientation.SOUTH);

        board1.putShip(d1, new Coords(10,7));
        board1.putShip(b1, new Coords(1,10));
        board1.putShip(s1, new Coords(8,1));
        board1.putShip(c1, new Coords(10,3));
        board1.print();
        System.out.println("FINISHED GAME");
        
    }

}
