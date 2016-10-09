package br.unb.cic.lp.MementoGol;

import br.unb.cic.lp.gol.*;

public class Originator {
	
	   private Cell[][] state;

	   public void set(Cell[][] state, int height, int width) {
		   state = new Cell[height][width];
	       this.state = state.clone(); 
	   }

	   public Memento saveToMemento() {
	       return new Memento(state); 
	   }
	   public Cell[][] restoreFromMemento(Memento m) {
	       state = m.getSavedState().clone();
	       return state;
	   }
}

