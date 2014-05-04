package de.ostfalia.swt.aufgabe5;

import java.math.BigDecimal;

public interface Product {

	Integer getId();

	String getDescription();
	void setDescription(String description);

	BigDecimal getPrice();
	void setPrice(BigDecimal price);

}