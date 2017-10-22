package com.satya.javafx.rms.properties;

import java.io.IOException;
import java.util.Properties;

/**
 * A <code>Singleton</code> class to hold security related properties.
 * 
 * @author Satyendra Sharma
 *
 */
public final class SecurityProperty implements PropertyConfig {

	private static SecurityProperty instance;
	private Properties prop;

	public synchronized static SecurityProperty getInstance() {
		if (instance == null) {
			instance = new SecurityProperty();
			instance.init();
		}
		return instance;
	}

	private void init() {
		this.prop = new Properties();
		try {
			this.prop.load(getClass().getClassLoader().getResourceAsStream("security.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public String get(String key) {
		return this.prop.getProperty(key);
	}

}
