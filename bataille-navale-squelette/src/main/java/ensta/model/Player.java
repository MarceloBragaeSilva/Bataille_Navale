package ensta.model;

import java.io.Serializable;
import java.util.List;

import ensta.model.ship.AbstractShip;
import ensta.view.InputHelper;

public class Player {
	/*
	 * ** Attributs
	 */
	private Board board;
	protected Board opponentBoard;
	private int destroyedCount;
	protected AbstractShip[] ships;
	private boolean lose;

	/*
	 * ** Constructeur
	 */
	public Player(Board board, Board opponentBoard, List<AbstractShip> ships) {
		this.setBoard(board);
		this.ships = ships.toArray(new AbstractShip[0]);
		this.opponentBoard = opponentBoard;
	}

	/*
	 * ** Méthodes
	 */

	/**
	 * Read keyboard input to get ships coordinates. Place ships on given
	 * coodrinates.
	 */
	public void putShips() {
		boolean done = false;
		int i = 0;

		do {
			AbstractShip ship = ships[i];
			String msg = String.format("placer %d : %s(%d)", i + 1, ship.getName(), ship.getLength());
			System.out.println(msg);
			InputHelper.ShipInput res = InputHelper.readShipInput();

            switch(res.orientation)
            {
                case "east":
                    ships[i].setOrientation(Orientation.EAST);
                break;

                case "west":
                    ships[i].setOrientation(Orientation.WEST);
                break;

                case "north":
                    ships[i].setOrientation(Orientation.NORTH);
                break;

                case "south":
                    ships[i].setOrientation(Orientation.SOUTH);
                break;
            }
				
			boolean posOkay = board.putShip(ships[i], new Coords(res.x+1, res.y)); 
			if(!posOkay)
				System.out.println("Mauvaise placement, ressayez-le");
			else{
				++i;
				board.print();
			}
			done = i == ships.length;
		} while (!done);
	}

	public Hit sendHit(Coords coords) {
		boolean done = false;
		Hit hit = null;

		do {
			System.out.println("\noù frapper?");
			InputHelper.CoordInput hitInput = InputHelper.readCoordInput();
			// TODO call sendHit on this.opponentBoard
			coords.setX(hitInput.x);
			coords.setY(hitInput.y);
			//System.out.println(coords.getX()+""+coords.getY());
			hit = this.opponentBoard.sendHit(coords);
			if(hit == Hit.MISS){
				this.board.setHit(false, coords);
				System.out.println("Miss");
				done = true;
			}
			else if (hit == Hit.STRIKE){
				this.board.setHit(true, coords);
				System.out.println("Hitted!");
			}
			else {
				this.board.setHit(true, coords);
				
				System.out.println("Ship "+ hit.toString()+" Destroyed");
				done = true;
			}

			board.print();
			opponentBoard.print();
			
			// TODO : Game expects sendHit to return BOTH hit result & hit coords.
			// return hit is obvious. But how to return coords at the same time ?
		} while (!done);

		return hit;
	}

	public AbstractShip[] getShips() {
		return ships;
	}

	public void setShips(AbstractShip[] ships) {
		this.ships = ships;
	}

	public Board getBoard() {
		return board;
	}

	public void setBoard(Board board) {
		this.board = board;
	}

	public int getDestroyedCount() {
		return destroyedCount;
	}

	public void setDestroyedCount(int destroyedCount) {
		this.destroyedCount = destroyedCount;
	}

	public boolean isLose() {
		return lose;
	}

	public void setLose(boolean lose) {
		this.lose = lose;
	}
}
