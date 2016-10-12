package br.unb.cic.lp.Dependency;

import com.google.inject.AbstractModule;
import br.unb.cic.lp.gol.GameEngine;
import br.unb.cic.lp.rules.*;

public class AppInjector extends AbstractModule {

	@Override
	protected void configure() {
//		//bind GameEngine to quickLife implementation
//		bind(GameEngine.class).to(quickLife.class);
		
//		//bind GameEngine to rule90 implementation
//		bind(GameEngine.class).to(rule90.class);
		
		//bind GameEngine to HighLife implementation
		bind(GameEngine.class).to(highLife.class);
	}

}