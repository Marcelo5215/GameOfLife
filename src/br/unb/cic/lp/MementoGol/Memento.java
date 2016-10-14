package br.unb.cic.lp.MementoGol;

import br.unb.cic.lp.gol.*;

public class Memento {
	private Cell[][] state;
	
	public Memento(Cell[][] stateToSave, int height, int width){
		
		this.state = new Cell[height][width];
		
		for(int i = 0 ; i < height; i++){
			for(int j = 0 ; j < width; j++){
				
				this.state[i][j] = new Cell();
				
				if(stateToSave[i][j].isAlive()){
					this.state[i][j].revive();
				}
		    }   
	    }
		
	}
	
	public Cell[][] getSavedState(){
		return state;
	}
}

