package de.ostfalia.swt.aufgabe4;

import java.math.BigDecimal;

public class ProductAdapterEAN implements Product {
	
	private String description;
	private BigDecimal price;
	private Integer Id;
	
	
	
	public ProductAdapterEAN(ProduktMitEAN prod) throws IllegalArgumentException { 
		if(prod.getEan()<Integer.MIN_VALUE||prod.getEan()>Integer.MAX_VALUE){
			throw new IllegalArgumentException(prod.getEan() + " is not compatible to Integer");
		}
		else{
			this.description=prod.getDescription();
			this.price=prod.getPrice();
			long i = prod.getEan();
			this.Id=(int) i;
		}

	}
	
	@Override
	public Integer getId() {
		return Id;
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
