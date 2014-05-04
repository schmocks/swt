package de.ostfalia.swt.aufgabe5;

import java.math.BigDecimal;

public class Bestellposition {
	private String id;
	private Product product;
	private int anzahl;
	private String bezeichnung;
	private BigDecimal preis;
	
	public Bestellposition(String id, Product product , int anzahl) {
		this.id=id;this.anzahl=anzahl;
		Produkt xx = product;
		
		xx.setDescription(product.getDescription());
		xx.setPrice(product.getPrice());
		this.product=xx;
		this.preis=product.getPrice().multiply(new BigDecimal(anzahl));
	}

	private Product cloneProduct(Product product){
		Product xx = product;
		xx.setDescription(product.getDescription());
		return null;
	}
	/**
	 * @return this id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @return the product
	 */
	public Product getProduct() {
		return product;
	}

	/**
	 * @return the anzahl
	 */
	public int getAnzahl() {
		return anzahl;
	}

	/**
	 * @return the bezeichnung
	 */
	public String getBezeichnung() {
		return bezeichnung;
	}

	/**
	 * @return the preis
	 */
	public BigDecimal getPreis() {
		return preis;
	}
}
