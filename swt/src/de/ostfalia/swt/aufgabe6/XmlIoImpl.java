package de.ostfalia.swt.aufgabe6;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.util.ArrayList;

import java.util.List;
import org.jdom2.*;

import org.jdom2.input.SAXBuilder;


public class XmlIoImpl implements XmlIo {

	@Override
	public void writeProducts(List<Product> products, OutputStream out)
			throws IOException {
		// TODO Auto-generated method stub
		
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
		// TODO Auto-generated method stub
		
	}

}
