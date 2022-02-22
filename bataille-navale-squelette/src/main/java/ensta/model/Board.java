package ensta.model;

import ensta.model.ship.AbstractShip;

public class Board implements IBoard {

	private static final int DEFAULT_SIZE = 10;
	private String nom;
	private int size;
	private char board_ships[][];
	private boolean board_hits[][];
	
    public Board(String Nom, int size){
        this.nom = Nom;
		this.size = size;
		this.board_ships = new char[size][size];
        this.board_hits = new boolean[size][size];

        for(int i = 0; i < size; i++){
            for (int j = 0; j< size; j++){
                this.board_ships[i][j] = '.'; 
                this.board_hits[i][j] = false;
            }
        }
    }


    public Board(String Nom){
        this.nom = Nom;
		this.size = DEFAULT_SIZE;
        this.board_ships = new char[size][size];
        this.board_hits = new boolean[size][size];

        for(int i = 0; i < 10; i++){
            for (int j = 0; j< 10; j++){
                this.board_ships[i][j] = '.'; 
                this.board_hits[i][j] = false;
            }
        }
    }

    public void print(){
		/*	y0|A  B  C  D  E  F
		    y1|
			y2|
			y3|
			y4|
			y5|
			y6|
			   __ __ __ __ __ __>
			   x1 x2 x3 x4 x5 x6
		*/

        System.out.println(this.nom);
        System.out.print("Navires:");
		for (int i=0; i<this.size; i++)
			System.out.print("  ");
		System.out.println("     Frappes:");
        char letterColumn = 64;

        for(int y=0; y <= this.size; y++){     //for each line
			// print for Navires
            if (y != 0){
                if (y >= 10) {System.out.print(y + " ");}
				else 		 {System.out.print(y + "  ");}
            }
            for (int x=0; x <= this.size; x++) {
                if (y == 0){
                    if(x == this.size) {System.out.print(" " + letterColumn + "           ");}
					else if (x==0)     {System.out.print("  ");}
                    else               {System.out.print(" " + letterColumn);}
                    letterColumn++;
                }else if (y != 0 && x!= 0 && x!= this.size)
                    System.out.print(this.board_ships[x-1][y-1] + " ");      
                else if (y != 0 && x == this.size)
                    System.out.print(this.board_ships[x-1][y-1] + "           ");
            }

			//print for Frappes
            letterColumn = 64;
            if (y != 0){
                if (y >= 10) {System.out.print(y + " ");}
                else         {System.out.print(y + "  ");}
            }
            for (int x=0; x <= this.size; x++) {
                if (y == 0){
					if (x==0)     {System.out.print("  ");}
                    else          {System.out.print(" " + letterColumn);}
                    letterColumn++;
                }else if (y != 0 && x!= 0){
					if(this.board_hits[y-1][x-1] == false)
						System.out.print( ". ");
					else System.out.print( "X ");
                }
            }    
            System.out.println();
        }

    }

	public boolean canPutShip(AbstractShip ship, Coords coords) {
		Orientation o = ship.getOrientation();
		int dx = 0, dy = 0;
		if (o == Orientation.EAST) {
			if (coords.getX() + 1 - ship.getLength() < 0 || coords.getX() >= this.size) {
				return false;
			}
			dx = -1;
		} else if (o == Orientation.SOUTH) {
			if (coords.getY() + 1 - ship.getLength() < 0 || coords.getY() >= this.size) {
				return false;
			}
			dy = -1;
		} else if (o == Orientation.NORTH) {
			if (coords.getY() + ship.getLength() > this.size || coords.getY() < 0) {
				return false;
			}
			dy = 1;
		} else if (o == Orientation.WEST) {
			if (coords.getX() + ship.getLength() > this.size || coords.getX() < 0) {
				return false;
			}
			dx = 1;
		}
		Coords iCoords = new Coords(coords);

		for (int i = 0; i < ship.getLength(); ++i) {
			if (this.hasShip(iCoords)) {
				return false;
			}
			iCoords.setX(iCoords.getX() + dx);
			iCoords.setY(iCoords.getY() + dy);
		}

		return true;
	}

	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean putShip(AbstractShip ship, ensta.model.Coords coords) {
		Orientation o = ship.getOrientation();
		System.out.println(o);
		if (this.canPutShip(ship, coords)){
			if(o == Orientation.NORTH){
				for(int i = 0; i < ship.getLength(); i++){
					board_ships[coords.getX()][coords.getY()+i] = ship.getLabel();
				}
				return true;
			}
			else if(o == Orientation.EAST){
				for(int i = 0; i < ship.getLength(); i++){
					board_ships[coords.getX()-i][coords.getY()] = ship.getLabel();
				}
				return true;
			}
			else if(o == Orientation.WEST){
				for(int i = 0; i < ship.getLength(); i++){
					board_ships[coords.getX()+i][coords.getY()] = ship.getLabel();
				}
				return true;
			}
			else if(o == Orientation.SOUTH){
				for(int i = 0; i < ship.getLength(); i++){
					board_ships[coords.getX()][coords.getY()-i] = ship.getLabel();
				}
				return true;
			}
		}

		return false;
	}

	@Override
	public boolean hasShip(ensta.model.Coords coords) {
		if (board_ships[coords.getX()][coords.getY()] != '.'){
            return true;
        }else 
            return false;
	}

	@Override
	public void setHit(boolean hit, ensta.model.Coords coords) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Boolean getHit(ensta.model.Coords coords) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Hit sendHit(ensta.model.Coords res) {
		// TODO Auto-generated method stub
		return null;
	}

}
