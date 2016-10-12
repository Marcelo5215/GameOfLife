/*
 * Rulo 90: http://mathworld.wolfram.com/Rule90.html
 * One of the elementary cellular automaton rules introduced by Stephen Wolfram in 1983
 * 
 * Modificado em: 6/10/2016  0:22   Marcelo
 */

package br.unb.cic.lp.rules;

import br.unb.cic.lp.gol.*;

public class rule90 extends GameEngine{
	
	public rule90(){
		super();
	}
	
	//DEFINICAO DOS METODOS ABSTRATOS (REGRAS) 
	protected boolean shouldKeepAlive(int i, int j) {
		return (cells[i][j].isAlive())
				&& (numberOfNeighborhoodAliveCells(i, j) == 2 || numberOfNeighborhoodAliveCells(i, j) == 3);
	}
	
	protected boolean shouldRevive(int i, int j) {
		return (checkPatterns(i, j));
	}
	
	
	//AINDA N ENTENDI O METODO, MAS SE BASEIA EM PADROES PARA DETERMINAR O
	//ESTADO DA PROXIMA GERACAO
	//TODO
	private boolean checkPatterns(int i, int j){
		boolean ret = false;
		
		
		
		
		return ret;
	}
}

