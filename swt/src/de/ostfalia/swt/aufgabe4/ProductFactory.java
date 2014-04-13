package de.ostfalia.swt.aufgabe4;

import java.util.List;

public abstract class ProductFactory {

	/**
	 *  Das Property 'product-factory' definiert den zu verwendenden Klassennamen  
	 */
	public static ProductFactory newInstance() {
		return null;
	}
	
	public abstract List<Product> getProducts();

}
