package de.ostfalia.swt.aufgabe6;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

public class testmain {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		InputStream in = null;
		OutputStream out = null;
		try {
			in = new FileInputStream("products.xml");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		out = new FileOutputStream("products2.xml");
		InputStream in2 = in;
		XmlIoImpl xml = new XmlIoImpl();
		System.out.println(xml.getProduct(in, 10).getDescription());
		in.close();
		List<Product> xx = xml.readProducts(in2);
		for(int i = 0;i<xx.size();i++){
			Product xxxx = xx.get(i);
			System.out.println(xxxx.getId()+" "+xxxx.getDescription()+" "+xxxx.getPrice());
		}
		
		
	    out.close();

	}

}
