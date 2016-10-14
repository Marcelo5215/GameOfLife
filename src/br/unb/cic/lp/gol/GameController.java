package br.unb.cic.lp.gol;

import java.security.InvalidParameterException;
import java.util.concurrent.TimeUnit;
import br.unb.cic.lp.MementoGol.*;
import br.unb.cic.lp.rules.*;

/**
 * Classe que atua como um controlador do
 * padrao MVC, separando os componentes da
 * camada de apresentacao e model.
 *
 * @author rbonifacio
 */
public class GameController {

	private Originator originator;
	private Caretaker caretaker;
 	private GameEngine engine;
	private GameView board;
	private Statistics statistics;
	
	public GameEngine getEngine() {
		return engine;
	}

	public void setEngine(GameEngine engine) {
		this.engine = engine;
		originator = new Originator(engine.getHeight(), engine.getWidth());
		caretaker = new Caretaker();
	}

	public GameView getBoard() {
		return board;
	}

	public void setBoard(GameView board) {
		this.board = board;
	}

	public void setStatistics(Statistics statistics) {
		this.statistics = statistics;
	}

	public void start() {
		board.update();
		board.menu();
	}

	public void halt() {
		//oops, nao muito legal fazer sysout na classe Controller
		System.out.println("\n \n");
		statistics.display();
		System.exit(0);
	}

	public void dinamic(){
		while(engine.numberOfAliveCells() != 0){
			engine.nextGeneration();
			board.update();
			try {
				TimeUnit.MILLISECONDS.sleep(500);
			} catch (InterruptedException e) {
    			System.out.println(e.getMessage());
			}
		}
	}

	public void makeCellAlive(int i, int j) {
		try {
			engine.makeCellAlive(i, j);
			board.update();
			board.menu();
		}
		catch(InvalidParameterException e) {
			System.out.println(e.getMessage());
		}
	}

	public void nextGeneration() {
		originator.set(engine.getCells());
		caretaker.add(originator.saveToMemento());
		engine.nextGeneration();
		board.update();
		board.menu();
	}
	
	public void restore(){
		engine.setCells(originator.restoreFromMemento(caretaker.get()));
		board.update();
		board.menu();
	}

	public void changeRule(){
		GameEngine newEngine = new lifeWithOutDeath(10, 10, statistics, engine.getCells());
		engine = newEngine;
		board.update();
		board.menu();
	}
}
