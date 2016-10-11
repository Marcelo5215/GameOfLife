package br.unb.cic.lp.gol.UI;

import java.util.Scanner;

import br.unb.cic.lp.gol.*;

public class TUI extends GameView{
	
	private static final String LINE = "+-----+";
	private static final String DEAD_CELL = "|     |";
	private static final String ALIVE_CELL = "|  o  |";

	private static final int INVALID_OPTION = 0;
	private static final int MAKE_CELL_ALIVE = 1;
	private static final int NEXT_GENERATION = 2;
	private static final int DINAMIC = 3;
	private static final int RESTORE = 4;
	private static final int HALT = 99;
	
	public TUI (GameController controller, GameEngine engine){
		super(controller, engine);
	}
	
	
	public void update() {
		printFirstRow();
		printLine();
		for (int i = 0; i < engine.getHeight(); i++) {
			for (int j = 0; j < engine.getWidth(); j++) {
				System.out.print(engine.isCellAlive(i, j) ? ALIVE_CELL : DEAD_CELL);
			}
			System.out.println("   " + i);
			printLine();
		}
	}
	
	protected void printFirstRow() {
		System.out.println("\n \n");
		for (int j = 0; j < engine.getWidth(); j++) {
			System.out.print("   " + j + "   ");
		}
		System.out.print("\n");
	}
	
	public void menu(){
		printOptions();
	}

	protected void printOptions() {
		Scanner s = new Scanner(System.in);
		int option;
		System.out.println("\n \n");

		do {
			System.out.println("Select one of the options: \n \n");
			System.out.println("[1] Make a cell alive");
			System.out.println("[2] Next generation");
			System.out.println("[3] Dinamic");
			System.out.println("[4] Restore");
			System.out.println("[99] Halt");

			System.out.print("\n \n Option: ");

			option = parseOption(s.nextLine());
		}while(option == 0);

		switch(option) {
			case MAKE_CELL_ALIVE : makeCellAlive(); break;
			case NEXT_GENERATION : nextGeneration(); break;
			case DINAMIC : dinamic(); break;
			case HALT : halt(); break;
			case RESTORE : restore();
		}
		s.close();
	}

	protected void makeCellAlive() {
		int i, j = 0;
		Scanner s = new Scanner(System.in);

		do {
			System.out.print("\n Inform the row number (0 - " + engine.getHeight() + "): " );

			i = s.nextInt();

			System.out.print("\n Inform the column number (0 - " + engine.getWidth() + "): " );

			j = s.nextInt();
		}while( !engine.validPosition(i, j) );

		controller.makeCellAlive(i, j);
		s.close();
	}	
	


	protected int parseOption(String option) {
		if(option.equals("1")) {
			return MAKE_CELL_ALIVE;
		}
		else if (option.equals("2")) {
			return NEXT_GENERATION;
		}
		else if (option.equals("3")){
			return DINAMIC;
		}
		else if (option.equals("99")) {
			return HALT;
		}
		else if(option.equals("4")){
			return RESTORE;
		} 
		else return INVALID_OPTION;
	}

	/* Imprime uma linha usada como separador das linhas do tabuleiro */
	protected void printLine() {
		for (int j = 0; j < engine.getWidth(); j++) {
			System.out.print(LINE);
		}
		System.out.print("\n");
	}

}
