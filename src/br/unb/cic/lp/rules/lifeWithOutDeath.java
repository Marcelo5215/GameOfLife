package br.unb.cic.lp.rules;

import br.unb.cic.lp.gol.*;

public class lifeWithOutDeath extends GameEngine{
	
	
	public lifeWithOutDeath(int height, int width, Statistics statistics){
		super(height, width, statistics);
	}
	
	public lifeWithOutDeath(int height, int width, Statistics statistics, Cell[][] newCells) {
		super(height, width, statistics, newCells);
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
