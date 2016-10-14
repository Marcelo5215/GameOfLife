package br.unb.cic.lp.gol;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.google.inject.Binder;
import com.google.inject.Module;
import com.google.inject.name.Names;

import br.unb.cic.lp.rules.Diamoeba;

public class GameControllerModule implements Module {

	@Override
	public void configure(Binder binder) {
		binder.bind(GameEngine.class).to(Diamoeba.class);
		InputStream stream = GameControllerModule.class.getResourceAsStream("/app.properties");
		Properties appProperties = new Properties();
		try {
			appProperties.load(stream);
			Names.bindProperties(binder, appProperties);
		} catch (IOException e) {
			binder.addError(e);
		}
		

	}

}
