package br.unb.cic.lp.rules;

import br.unb.cic.lp.gol.*;

public class seeds extends GameEngine{

	public seeds(int height, int width, Statistics statistics){
		super(height, width, statistics);
	}
	
	public seeds(int height, int width, Statistics statistics, Cell[][] newCells) {
		super(height, width, statistics, newCells);
	}
	
	//DEFINICAO DOS METODOS ABSTRATOS (REGRAS) 
		protected boolean shouldKeepAlive(int i, int j) {
			if(cells[i][j].isAlive() == true){
				return false;
			}
			else
				return true;
		}
		
		protected boolean shouldRevive(int i, int j) {
			return (!cells[i][j].isAlive())
					&& (numberOfNeighborhoodAliveCells(i, j) == 2);
		}
	
}
