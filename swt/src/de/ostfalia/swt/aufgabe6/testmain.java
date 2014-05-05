package de.ostfalia.swt.aufgabe6;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

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
		
		XmlIoImpl xml = new XmlIoImpl();
		xml.readProducts(in);
		
		in.close();
		out.close();

	}

}
