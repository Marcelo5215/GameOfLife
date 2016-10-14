package br.unb.cic.lp.gol;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.google.inject.Binder;
import com.google.inject.Module;
import com.google.inject.Provides;
import com.google.inject.name.Names;

import br.unb.cic.lp.rules.Diamoeba;
import br.unb.cic.lp.rules.highLife;
import br.unb.cic.lp.rules.lifeWithOutDeath;
import br.unb.cic.lp.rules.quickLife;
import br.unb.cic.lp.rules.seeds;

public class GameControllerModule implements Module {
	@Override
	public void configure(Binder binder) {
		InputStream stream = GameControllerModule.class.getResourceAsStream("/app.properties");
		Properties appProperties = new Properties();
		try {
			appProperties.load(stream);
			Names.bindProperties(binder, appProperties);
		} catch (IOException e) {
			binder.addError(e);
		}
	}
	@Provides
	private GameEngine providesGameEngine(Diamoeba diamoeba, highLife highLife,
			lifeWithOutDeath lifeWithOutDeath, quickLife quickLife, seeds seeds) {
		double currentRule = Math.random();
		if(currentRule < 0.2) {
			return diamoeba;
		}
		else if(currentRule < 0.4) {
			return highLife;
		}
		else if(currentRule < 0.6) {
			return lifeWithOutDeath;
		}
		else if(currentRule < 0.8) {
			return quickLife;
		}
		else if(currentRule < 1) {
			return seeds;
		}
		return diamoeba;
	}

}
