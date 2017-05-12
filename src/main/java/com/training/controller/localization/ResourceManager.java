package com.training.controller.localization;

import java.io.UnsupportedEncodingException;
import java.util.Locale;
import java.util.ResourceBundle;


public enum ResourceManager {
	INSTANCE;
	ResourceBundle resourceBundle;
	private final String resourceName = "property.text";
	
	private ResourceManager(){
		resourceBundle = ResourceBundle.getBundle(resourceName, Locale.getDefault());
	}
	
	public void changeResource(Locale locale){
		resourceBundle = ResourceBundle.getBundle(resourceName, locale);
	}
	
	
	/**Gets a string for the given key from this resource bundle.
	 * Able to read from UTF-8 encoded resources.
	 * @param key
	 * @return the string for the given key
	 */
	public String getStringUTF8Encoded(String key){
		String value = resourceBundle.getString(key); 
		try {
			return new String(value.getBytes("ISO-8859-1"), "UTF-8");
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException("unsupported encoding",e);
		}
	}
	public String getString(String key){
		return resourceBundle.getString(key); 
		
	}

}
