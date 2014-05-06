package de.ostfalia.swt.aufgabe6;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.jdom2.*;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;



public class XmlIoImpl implements XmlIo {
	
	
	@Override
	public void writeProducts(List<Product> products, OutputStream out)
			throws IOException {
		Element root = new Element("products");
		Document doc = new Document(root);
		for(int i=0;i<products.size();i++){
			Element product = new Element("product");
			Element id = new Element("id");
			Element description = new Element("description");
			Element price = new Element("price");
			id.addContent(String.valueOf(products.get(i).getId()));
			description.addContent(products.get(i).getDescription());
			price.addContent(products.get(i).getPrice().toString());
			product.addContent(id);product.addContent(description);product.addContent(price);			
			root.addContent(product);
		}
		XMLOutputter outer = new XMLOutputter();
		outer.setFormat(Format.getPrettyFormat());
		outer.output(doc, out);
		
	}

	@Override
	public List<Product> readProducts(InputStream in) throws Exception {
		List<Product> products = new ArrayList<Product>();
		Document doc = new SAXBuilder().build(in);
		Element root = doc.getRootElement();
		List<Element> xx = root.getChildren("product");
		for(int i = 0; i<xx.size();i++){
			int id = Integer.parseInt(xx.get(i).getChildText("id"));
			String description = xx.get(i).getChildText("description");
			BigDecimal price = new BigDecimal(xx.get(i).getChildText("price"));
			products.add(new Product(id, description, price));
		}
		return products;
	}

	@Override
	public Product getProduct(InputStream in, Integer id) throws Exception {
		
		List<Product> products = readProducts(in);
		for(int i = 0;i<products.size();i++){
			if(products.get(i).getId()==id){return products.get(i);}
		}
		return null;
	}

	@Override
	public void increasePrices(InputStream in, OutputStream out,
			BigDecimal percent) throws Exception {
		List<Product> products = readProducts(in);
		for(int i=0;i<products.size();i++){
			Product p = products.get(i);
			BigDecimal bd = p.getPrice();
			BigDecimal mult = new BigDecimal(100).add(percent);
			p.setPrice(bd.divide(new BigDecimal(100)).multiply(mult).setScale(2, BigDecimal.ROUND_HALF_UP));
		}
		writeProducts(products, out);
	}

}
