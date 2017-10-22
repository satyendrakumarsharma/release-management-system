package com.satya.javafx.rms.properties;

import java.io.IOException;
import java.util.Properties;

/**
 * A <code>Singleton</code> class to hold command related properties.
 * 
 * @author Satyendra Sharma
 *
 */
public final class CommandProperty implements PropertyConfig {

	private static CommandProperty instance;
	private Properties prop;

	public synchronized static CommandProperty getInstance() {
		if (instance == null) {
			instance = new CommandProperty();
			instance.init();
		}
		return instance;
	}

	private void init() {
		this.prop = new Properties();
		try {
			this.prop.load(getClass().getClassLoader().getResourceAsStream("command.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public String get(String key) {
		return this.prop.getProperty(key);
	}

}
