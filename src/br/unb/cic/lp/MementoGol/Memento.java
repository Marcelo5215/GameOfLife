package br.unb.cic.lp.MementoGol;

import br.unb.cic.lp.gol.*;

public class Memento {
	private Cell[][] state;
	
	public Memento(Cell[][] stateToSave){
		state = stateToSave.clone();
	}
	
	public Cell[][] getSavedState(){
		return state;
	}
}

