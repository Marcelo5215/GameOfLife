package br.unb.cic.lp.rules;

import com.google.inject.Inject;
import com.google.inject.name.Named;

import br.unb.cic.lp.gol.*;

public class lifeWithOutDeath extends GameEngine{
	
	
	@Inject
	public lifeWithOutDeath(@Named("height") int height,@Named("width") int width, Statistics statistics){
		super(height, width, statistics);
	}


	
	//DEFINICAO DOS METODOS ABSTRATOS (REGRAS) 
        @Override
	protected boolean shouldKeepAlive(int i, int j) {
		return true;
	}
	
        @Override
	protected boolean shouldRevive(int i, int j) {
		return (!cells[i][j].isAlive())
				&& (numberOfNeighborhoodAliveCells(i, j) == 3);
	}
}
