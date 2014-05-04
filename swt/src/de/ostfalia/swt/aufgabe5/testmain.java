package de.ostfalia.swt.aufgabe5;

import java.lang.reflect.Field;
import java.math.BigDecimal;

public class testmain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Product p = new Produkt(5, "des", new BigDecimal(50));
		Bestellposition bsp = new Bestellposition("bla", p, 5);
		p.setDescription("des2");
		System.out.println(bsp.getProduct().getDescription());
		Field[] ff = p.getClass().getDeclaredFields();
	
		for(int i=0;i<ff.length;i++){System.out.println(ff[i]);}
	
		
	}

}
