package ensta.model;

import ensta.model.ship.*;
import ensta.util.*;

public class Board implements IBoard {

	private static final int DEFAULT_SIZE = 10;
	private String nom;
	private int size;
	private ShipState ships[][];
	private Boolean hits[][];
	
    public Board(String Nom, int size){
        this.nom = Nom;
		this.size = size;
		this.ships = new ShipState[size][size];
        this.hits = new Boolean[size][size];

        for(int i = 0; i < size; i++){
            for (int j = 0; j< size; j++){
                this.ships[i][j] = new ShipState(); 
                this.hits[i][j] = null;
            }
        }
    }


    public Board(String Nom){
        this.nom = Nom;
		this.size = DEFAULT_SIZE;
        this.ships = new ShipState[size][size];
        this.hits = new Boolean[size][size];

        for(int i = 0; i < 10; i++){
            for (int j = 0; j< 10; j++){
                this.ships[i][j] = new ShipState(); 
                this.hits[i][j] = null;
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
                    System.out.print(this.ships[x-1][y-1] + " ");      
                else if (y != 0 && x == this.size)
                    System.out.print(this.ships[x-1][y-1] + "           ");
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
					if(this.hits[x-1][y-1] == null)
						System.out.print( ". ");
					else if (hits[x-1][y-1])
						System.out.print(ColorUtil.colorize("X ", ColorUtil.Color.RED));
					else System.out.print(ColorUtil.colorize("X ", ColorUtil.Color.WHITE));
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
		//System.out.println(o);
		if (this.canPutShip(ship, coords)){
			if(o == Orientation.NORTH){
				for(int i = 0; i < ship.getLength(); i++){
					ships[coords.getX()][coords.getY()+i].setShip(ship);
					ships[coords.getX()][coords.getY()+i].getShip().setLabel(ship.getLabel());
				}
				return true;
			}
			else if(o == Orientation.EAST){
				for(int i = 0; i < ship.getLength(); i++){
					ships[coords.getX()-i][coords.getY()].setShip(ship);
					ships[coords.getX()-i][coords.getY()].getShip().setLabel(ship.getLabel());
				}
				return true;
			}
			else if(o == Orientation.WEST){
				for(int i = 0; i < ship.getLength(); i++){
					ships[coords.getX()+i][coords.getY()].setShip(ship);
					ships[coords.getX()+i][coords.getY()].getShip().setLabel(ship.getLabel());
				}
				return true;
			}
			else if(o == Orientation.SOUTH){
				for(int i = 0; i < ship.getLength(); i++){
					ships[coords.getX()][coords.getY()-i].setShip(ship);
					ships[coords.getX()][coords.getY()-i].getShip().setLabel(ship.getLabel());
				}
				return true;
			}
		}
		
		return false;
	}

	@Override
	public boolean hasShip(ensta.model.Coords coords) {
		if (ships[coords.getX()][coords.getY()].getShip() != null){
            return true;
        }else 
            return false;
	}

	@Override
	public void setHit(boolean hit, ensta.model.Coords coords) {
		// TODO Auto-generated method stub
		this.hits[coords.getX()][coords.getY()] = hit;
	}

	@Override
	public Boolean getHit(ensta.model.Coords coords) {
		return this.hits[coords.getX()][coords.getY()];
	}

	@Override
	public Hit sendHit(ensta.model.Coords coords) {
		int x = coords.getX();
		int y = coords.getY();
		if (this.ships[x][y].getShip() == null)
            return Hit.MISS;
        else{
            this.ships[x][y].addStrike();
            if(this.ships[x][y].isSunk())
                return Hit.fromInt(this.ships[x][y].getShip().getLength());
            else if (this.ships[x][y].isStruck())
                return Hit.STRIKE;
            else 
                return Hit.MISS;
		}
	}

}
