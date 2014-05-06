package de.ostfalia.swt.aufgabe4;

import java.math.BigDecimal;

public class test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		ProduktMitStringId p = new ProduktMitStringId();
		p.setDescription("Test");
		p.setPrice(new BigDecimal(10));
		p.setId("123453");
		
		ProduktMitEAN pe = new ProduktMitEAN();
		pe.setDescription("Test");
		pe.setPrice(new BigDecimal(10));
		pe.setEan((long)500);
		

	}

}
