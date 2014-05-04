package de.ostfalia.swt.aufgabe3;

import java.math.BigDecimal;

public class Produkt implements Product{
	private Integer id;
	private BigDecimal price;
	private String description;
	
	@Override
	public Integer getId() {
		return id;
	}

	public void setId(Integer id){
		this.id=id;
	}
	
	@Override
	public String getDescription() {
		return description;
	}

	@Override
	public void setDescription(String description) {
		this.description=description;
		
	}

	@Override
	public BigDecimal getPrice() {
		return price;
	}

	@Override
	public void setPrice(BigDecimal price) {
		this.price=price;
	}

}
