/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domino2;

import java.util.LinkedList;
import java.util.List;

public final class Table {
	
	private static List <Tile> dominos;
	private int leftSide = -1, rightSide = -1;
        
        /**
         * Δημιουργεί μια λίτσα κενή που θα λειτουργήσει σαν το τραπέζι
         */
        
	public Table() {
		dominos = new LinkedList<Tile>(); 
	}
        
	
	public List<Tile> getDominos() {
		return dominos;
	}
        
        /**
         * 
         * @return τον αριθμό του πλακιδίου στην αρχή του table
         */

	public int getLeftSide() {
            if (isEmpty()){
                return -1;
            }
            else{
                return leftSide;
            }
        }
        
        /**
         * 
         * @return τον αριθμό του πλακιδίου στο τέλος του table
         */
	
	public int getRightSide() {
            if (isEmpty()){
                return -1;
            }
            else{
                return rightSide;
            }
	}
	
	public boolean isEmpty(){
		return dominos.isEmpty();
		
	}
	
	public int numDomTable(){
		return dominos.size();
	}
	
        /**
         * Προσθέτει το addedDom στην αρχή της λίστας. Αν το side1 είναι true γυρίζει το πλακίδιο
         * @param addedDom
         * @param side1 
         */
        
        public void addDominoLeft(Tile addedDom, boolean side1){
		
		dominos.add(0, addedDom); 
		if(side1){
                    addedDom.flipTile();
                    leftSide = addedDom.getSide2();
                    if (rightSide == -1){
                        rightSide = addedDom.getSide1();
                    }
                        
		}
		else{
                    leftSide = addedDom.getSide1();
                    if (rightSide == -1){
                        rightSide = addedDom.getSide2();
                    }
		}
		
	}
       

        /**
         * Προσθέτει το addedDom στο τέλος της λίστας. Αν το side1 είναι true γυρίζει το πλακίδιο
         * @param addedDom
         * @param side1 
         */
	public void addDominoRight(Tile addedDom, boolean side1){
		dominos.add(addedDom);
		
		if(side1){
                    addedDom.flipTile();
                    rightSide = addedDom.getSide1();
		}
		else{
                    rightSide = addedDom.getSide2();
		}
		
	}
        
        public void printTable(){
		if (isEmpty()){
                    System.out.println("The table is empty!");
                    System.out.println();
                }
                else{
                    System.out.println("Domino table : ");
                    for(Tile dom : dominos){
			dom.printHorizontal();
                    

		}
		
		System.out.println();
                }
		
        }
	
}