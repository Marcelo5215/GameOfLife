package br.unb.cic.lp.gol;

import br.unb.cic.lp.rules.*;

import com.google.inject.Guice;
import com.google.inject.Injector;

import br.unb.cic.lp.gol.UI.*;

public class Main {

	public static void main(String args[]) {

		Statistics statistics = new Statistics();
		Injector injector = Guice.createInjector(new GameControllerModule());
		GameController controller = injector.getInstance(GameController.class);
		GameView board = new TUI(controller, controller.getEngine());

		controller.setBoard(board);
		controller.setStatistics(statistics);

		controller.start();
	}
}
