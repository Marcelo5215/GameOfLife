package br.unb.cic.lp.gol;

import br.unb.cic.lp.rules.*;

public class Main {

	public static void main(String args[]) {
		GameController controller = new GameController();
		
		Statistics statistics = new Statistics();

		GameEngine engine = new quickLife(3, 3, statistics);	
		
		GameView board = new GameView(controller, engine);
		
		controller.setBoard(board);
		controller.setEngine(engine);
		controller.setStatistics(statistics);
		
		controller.start();
	}
}
