package com.satya.javafx.rms.properties;

import java.io.IOException;
import java.util.Properties;

/**
 * A <code>Singleton</code> class to hold database related properties.
 * 
 * @author Satyendra Sharma
 *
 */
public final class DatabaseProperty implements PropertyConfig {

	private static DatabaseProperty instance;
	private Properties prop;

	public synchronized static DatabaseProperty getInstance() {
		if (instance == null) {
			instance = new DatabaseProperty();
			instance.init();
		}
		return instance;
	}

	private void init() {
		this.prop = new Properties();
		try {
			this.prop.load(getClass().getClassLoader().getResourceAsStream("database.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public String get(String key) {
		return this.prop.getProperty(key);
	}

}
