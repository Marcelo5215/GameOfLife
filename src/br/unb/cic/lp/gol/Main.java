package br.unb.cic.lp.gol;

import com.google.inject.Guice;
import com.google.inject.Injector;

import br.unb.cic.lp.gol.UI.*;
import br.unb.cic.lp.Dependency.*;
public class Main {

	public static void main(String args[]) {

		Statistics statistics = new Statistics();

				
		Injector injector = Guice.createInjector(new AppInjector());		
		
		GameController controller = injector.getInstance(GameController.class);
		
//		controller.setEngine(engine);
		GameView board = new TUI(controller, controller.getEngine());
		controller.setBoard(board);
		controller.setStatistics(statistics);
		
		controller.start();
	}
	
	
}
