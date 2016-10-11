package br.unb.cic.lp.MementoGol;

import br.unb.cic.lp.gol.*;

public class Originator {
	
	   private Cell[][] state;
	   int height;
	   int width;
	   
	   public Originator(int height, int width){
		   this.state = new Cell[height][width];
		   
		   for(int i = 0 ; i < height; i++){
	    	   for(int j = 0 ; j < width; j++){
		    	   this.state[i][j] = new Cell();
		       }   
	       }
		   
		   this.height = height;
		   this.width = width;
	   }

	   public void set(Cell[][] state) { 
		   
	       for(int i = 0 ; i < height; i++){
	    	   for(int j = 0 ; j < width; j++){
		    	   if(state[i][j].isAlive()){
		    		   this.state[i][j].revive();
		    	   }
		    	   else {
		    		   this.state[i][j].kill();
		    	   }
		       }   
	       }
	       
	   }

	   public Memento saveToMemento() {
	       return new Memento(state, height, width); 
	   }
	   
	   public Cell[][] restoreFromMemento(Memento m) {
	       state = m.getSavedState();
	       return state;
	   }
}

