package ensta;

import java.util.*;
import ensta.model.*;
import ensta.model.ship.*;
import ensta.ai.*;
import ensta.util.*;

public class TestGame {
    public TestGame()
    {
        Board board = new Board("BoardEx");
        board.print();

        List<AbstractShip> ships = new ArrayList<AbstractShip>();
        ships.add(new Destroyer());
        ships.add(new Submarine());
        ships.add(new Submarine());
        ships.add(new BattleShip());
        ships.add(new Carrier());

        BattleShipsAI testAI = new BattleShipsAI(board, board);

        testAI.putShips(ships.toArray(new AbstractShip[ships.size()]));

        int destroyedShips = 0;

        Coords coords = new Coords();

        Hit hit;

        do {

            hit = testAI.sendHit(coords);
            //System.out.println("Cords"+ coords.getX()+""+coords.getY());

            if( board.hasShip(coords) && board.shipSunk(coords))
                destroyedShips++;

            boolean incoming = false; 
            String msg;
            ColorUtil.Color color = ColorUtil.Color.RESET;
            if(hit == null){
                msg = "There is a hit here!";
            }else{
                switch (hit) {
                case MISS:
                    msg = hit.toString();
                    break;
                case STRIKE:
                    msg = hit.toString();
                    color = ColorUtil.Color.RED;
                    break;
                default:
                    msg = hit.toString() + " coulé";
                    color = ColorUtil.Color.RED;
                }
                msg = String.format("%s Frappe en %c%d : %s", incoming ? "<=" : "=>", ((char) (64 + coords.getX()+1)),
                        (coords.getY()+1), msg);
            }
            System.out.println(ColorUtil.colorize(msg, color));


            board.print();

            sleep(500);

        }while (destroyedShips != ships.size());

        //board.print();
    }


    private static void sleep(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
   
}
