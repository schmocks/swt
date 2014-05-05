package de.ostfalia.swt.aufgabe5;


import java.math.BigDecimal;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class testmain {

	
	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		List<Bestellposition> bestellpositionen = new LinkedList<Bestellposition>();
		Date datum = new Date();
		
		Product p0 = new Produkt(5, "P0", new BigDecimal(5));
		Product p1 = new Produkt(78, "P1", new BigDecimal(50));
		Product p2 = new Produkt(2, "P2", new BigDecimal(100));
		Product p3 = new Produkt(15, "P3", new BigDecimal(12));
		Bestellposition ppp = new Bestellposition("test", p0, 20);
		System.out.println(ppp.getPreis());
		bestellpositionen.add(ppp);
		bestellpositionen.add(new Bestellposition("bla", p0, 15));
		bestellpositionen.add(new Bestellposition("blb", p0, 25));
		bestellpositionen.add(new Bestellposition("blc", p2, 235));
		bestellpositionen.add(new Bestellposition("bld", p1, 45));
		bestellpositionen.add(new Bestellposition("ble", p3, 15));
		Bestellung best = new Bestellung("12", datum, bestellpositionen);
	System.out.println(best.getWert());
		System.out.println(best.getDatum());
		bestellpositionen = best.getBestellpositionen();
		bestellpositionen.remove(3);
		System.out.println(ppp.getClass().hashCode());
		
		
	}
	
	
	
}
	