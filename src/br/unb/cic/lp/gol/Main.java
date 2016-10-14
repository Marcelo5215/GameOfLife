package br.unb.cic.lp.gol;

import br.unb.cic.lp.rules.*;
import br.unb.cic.lp.gol.UI.*;

public class Main {

	public static void main(String args[]) {
		GameController controller = new GameController();

		Statistics statistics = new Statistics();

		GameEngine engine = new quickLife(10, 10, statistics);
		
		GameView board = new TUI(controller, engine);

		controller.setBoard(board);
		controller.setEngine(engine);
		controller.setStatistics(statistics);

		controller.start();
	}
}
