package de.ostfalia.swt.aufgabe4;

import java.math.BigDecimal;

public class ProductAdapterString implements Product{
	
	private String description;
	private BigDecimal price;
	private Integer Id;
	
	
	
	public ProductAdapterString(ProduktMitStringId prod) throws IllegalArgumentException { 
		try{
			Integer.parseInt(prod.getId());
		} catch (NumberFormatException e){
			throw new IllegalArgumentException(prod.getId() + " is not compatible to Integer");
		}
		this.description=prod.getDescription();
		this.price=prod.getPrice();
		this.Id=Integer.parseInt(prod.getId());
		
		
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

