package it.olly.springboot.cloudwatchlog.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Utility to load properties from a file and set them into system.properties
 * 
 * @author alessio olivieri
 *
 */
public class SysConfig {

	/**
	 * Loads properties from a resource, using class.getResourceAsStream(resource),
	 * and put them into system.properties <br>
	 * NOTE: resource can have placeholders like ${placeholder}. it searches
	 * "placeholder" on system.properties and then (if system.properties is null or
	 * void) checks also on system.env
	 * 
	 * @param resource file to be loaded
	 */
	public static final void setSystemPropertiesFromResource(String resource) {
		Matcher matcher = Pattern.compile("(\\$\\{[^\\}]*\\})").matcher(resource);
		while (matcher.find()) {
			String group = matcher.group();
			String found = group.substring(2, group.length() - 1);
			String replacer = System.getProperty(found);
			if (replacer == null || replacer.trim().length() < 1) {
				replacer = System.getenv().get(found);
			}
			if (replacer == null)
				replacer = "";
			resource = resource.replace(group, replacer);
		}

		try (InputStream resourceAsStream = SysConfig.class.getResourceAsStream(resource)) {
			if (resourceAsStream == null)
				return;
			Properties props = new Properties();
			props.load(resourceAsStream);
			props.forEach((k, v) -> {
				System.setProperty(String.valueOf(k), String.valueOf(v));
			});
		} catch (IOException e) {
		}

	}
}
