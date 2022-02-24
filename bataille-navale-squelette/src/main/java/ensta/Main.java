package ensta;

//import ensta.controller.Game;
import java.util.*;
import ensta.model.*;
import ensta.model.ship.*;


public class Main {

	public static void main(String args[]) {
        //Board board1 = new Board("Board1");
		//board1.print();

        //Board board2 = new Board("Board2", 6);
		//board2.print();
        
        Destroyer d1 = new Destroyer(Orientation.EAST);
        BattleShip b1 = new BattleShip(Orientation.WEST);
        Submarine s1 = new Submarine(Orientation.NORTH);
        Carrier c1 =  new Carrier(Orientation.SOUTH);

        //board1.putShip(d1, new Coords(10,7));
        //board1.putShip(b1, new Coords(1,10));
        //board1.putShip(s1, new Coords(8,1));
        //board1.putShip(c1, new Coords(10,3));
        //board1.print();


        List<AbstractShip> ships = new ArrayList<AbstractShip>();
        ships.add(new Destroyer());
        ships.add(new Submarine());
        //ships.add(new Submarine());
        //ships.add(new BattleShip());
        //ships.add(new Carrier());

        Board board1 = new Board("Board1");
        Board board2 = new Board("Board2");
        Player play1 = new Player(board1, board2, ships);
        Player play2 = new Player(board2, board1, ships);
        System.out.println("\n\nPlayer 1 put ships");
        play1.putShips();
        System.out.println("\n\nPlayer 2 put ships");
        play2.putShips();

        System.out.println("\n\nPlayer 1 turn");
        Hit hit = play1.sendHit(new Coords());
        System.out.println("\n\nPlayer 2 turn");
        hit = play2.sendHit(new Coords());




        

        //board.print();
        System.out.println("FINISHED GAME");
        
    }

}
