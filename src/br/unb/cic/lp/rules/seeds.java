package br.unb.cic.lp.rules;

import com.google.inject.Inject;
import com.google.inject.name.Named;

import br.unb.cic.lp.gol.*;

public class seeds extends GameEngine{

	@Inject
	public seeds(@Named("height") int height,@Named("width") int width, Statistics statistics){
		super(height, width, statistics);
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
