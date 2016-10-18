/*
 * HighLife rule: a dead cell comes to life if it is surrounded by 6 living cells
 * 
 * Modificado em: 6/10/2016  0:00   Marcelo
 */

package br.unb.cic.lp.rules;

import com.google.inject.Inject;
import com.google.inject.name.Named;

import br.unb.cic.lp.gol.*;

public class highLife extends GameEngine{
	
	@Inject
	public highLife(@Named("height") int height,@Named("width") int width, Statistics statistics){
		super(height, width, statistics);
	}

	//DEFINICAO DOS METODOS ABSTRATOS (REGRAS) 
        @Override
	protected boolean shouldKeepAlive(int i, int j) {
		return (cells[i][j].isAlive())
				&& (numberOfNeighborhoodAliveCells(i, j) == 2 || numberOfNeighborhoodAliveCells(i, j) == 3);
	}
	
        @Override
	protected boolean shouldRevive(int i, int j) {
		return (!cells[i][j].isAlive())
				&& (numberOfNeighborhoodAliveCells(i, j) == 6);
	}
}
