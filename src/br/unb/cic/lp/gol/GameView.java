package br.unb.cic.lp.gol;

/**
 * Atua como um componente de apresentacao (view), exibindo o estado atual do
 * game com uma implementacao baseada em caracteres ASCII.
 *
 * @author rbonifacio
 */
public abstract class GameView {

	protected GameEngine engine;
	protected GameController controller;

	/**
	 * Construtor da classe GameBoard
	 */
	public GameView(GameController controller, GameEngine engine) {
		this.controller = controller;
		this.engine = engine;
	}

	/**
	 * Atualiza o componente view (representado pela classe GameBoard),
	 * possivelmente como uma resposta a uma atualizacao do jogo.
	 */
	public abstract void update();

	public abstract void menu();
	
	protected abstract void printOptions();

	protected abstract void makeCellAlive();

	protected void nextGeneration() {
		controller.nextGeneration();
	}

	protected void dinamic(){
		controller.dinamic();
	}

	protected void halt() {
		controller.halt();
	}
	
	protected void restore(){
		controller.restore();
	}
	
	protected void changeRule(){
		controller.changeRule();
	}

	protected abstract int parseOption(String option);

	/* Imprime uma linha usada como separador das linhas do tabuleiro */
	protected abstract void printLine();

	/*
	 * Imprime os identificadores das colunas na primeira linha do tabuleiro
	 */
	protected abstract void printFirstRow();
}
