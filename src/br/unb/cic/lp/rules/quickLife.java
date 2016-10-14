/*
 * quickLife rule: Normal
 *
 * Modificado em: 6/10/2016  0:00   Marcelo
 */


package br.unb.cic.lp.rules;

import br.unb.cic.lp.gol.*;

public class quickLife extends GameEngine{

	public quickLife(int height, int width, Statistics statistics){
		super(height, width, statistics);
	}

	public quickLife(int height, int width, Statistics statistics, Cell[][] newCells) {
		super(height, width, statistics, newCells);
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
				&& (numberOfNeighborhoodAliveCells(i, j) == 3);
	}
}
