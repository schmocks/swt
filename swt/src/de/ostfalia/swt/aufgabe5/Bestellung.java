package de.ostfalia.swt.aufgabe5;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Bestellung {
	private String id;
	private Date datum; // Bestelldatum: heute
	private List<Bestellposition> bestellpositionen;
	private BigDecimal wert; // Gesamtwert der Bestellung
	
	public Bestellung(String id, Date datum, List<Bestellposition> bestellpositionen) {
		this.id=id;this.datum=datum;this.bestellpositionen=bestellpositionen;
		double temp = 0;
		for(int i = 0;i<bestellpositionen.size();i++){
			temp+=(bestellpositionen.get(i).getPreis()).doubleValue();
		}
		
		this.wert=new BigDecimal(temp);

	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @return the datum
	 */
	public Date getDatum() {
		return datum;
	}

	/**
	 * @return the bestellpositionen
	 */
	public List<Bestellposition> getBestellpositionen() {
		List<Bestellposition> temp = new ArrayList<Bestellposition>(){
			private static final long serialVersionUID = 1L;
			@Override
			public Bestellposition remove(int index) {throw new UnsupportedOperationException();};
			public void add(int index, Bestellposition element){throw new UnsupportedOperationException();}
			public boolean add(Bestellposition b){throw new UnsupportedOperationException();}
			public boolean remove(Object o){throw new UnsupportedOperationException();}
		};
		temp.addAll(bestellpositionen);
		return temp;
	}

	/**
	 * @return the wert
	 */
	public BigDecimal getWert() {
		
		return wert;
	}
	
}
