package de.ostfalia.swt.aufgabe6;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.util.Iterator;
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
		
		Document doc =(Document) new SAXBuilder().build(in);
		Element root = doc.getRootElement();
		String producte = root.getChild("product").getChildText("id");
		System.out.println(producte);
		List <?> pinfo = root.getContent();
		Iterator<?> It = pinfo.iterator();
		while ( It.hasNext() )
		  System.out.println( It.next().toString() );
		
		return null;
	}

	@Override
	public Product getProduct(InputStream in, Integer id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void increasePrices(InputStream in, OutputStream out,
			BigDecimal percent) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
