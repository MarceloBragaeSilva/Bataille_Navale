package ensta;

//import ensta.controller.Game;
import ensta.model.Board;

public class Main {

	public static void main(String args[]) {
        Board board1 = new Board("Board1");
		board1.print();

        Board board2 = new Board("Board2", 6);
		board2.print();
        System.out.println("FINISHED GAME");
    }

}
