package de.ostfalia.swt.aufgabe5;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class Bestellung {
	private String id;
	private Date datum; // Bestelldatum: heute
	private List<Bestellposition> bestellpositionen;
	private BigDecimal wert; // Gesamtwert der Bestellung
	
	public Bestellung(String id, Date datum, List<Bestellposition> bestellpositionen) {
		this.id=id;this.datum=datum;this.bestellpositionen=bestellpositionen;
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
		return bestellpositionen;
	}

	/**
	 * @return the wert
	 */
	public BigDecimal getWert() {
		return wert;
	}
	
}
