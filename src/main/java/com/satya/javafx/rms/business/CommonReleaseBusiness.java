package com.satya.javafx.rms.business;

import org.apache.commons.lang3.StringUtils;

import com.satya.javafx.rms.properties.DatabaseProperty;
import com.satya.javafx.rms.properties.PropertyConfig;

/**
 * @author Satyendra Sharma
 *
 */
public class CommonReleaseBusiness {

	private PropertyConfig dbProp = DatabaseProperty.getInstance();

	public int countEnvironments() {
		String[] env = getEnvironments();
		return (env != null) ? env.length : 0;
	}

	public String[] getEnvironments() {
		String[] env = null;
		String environments = dbProp.get("db.environments");
		if (StringUtils.isNotBlank(environments)) {
			env = StringUtils.split(environments, ',');
		}
		return env;
	}

}
