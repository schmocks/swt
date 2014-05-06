package de.ostfalia.swt.aufgabe6;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.util.List;
import java.util.Random;

public class testmethode {
	
	public void TestOne() throws Exception{
		System.out.println("*******TEST writeProducts*******");
		InputStream in = null;
		OutputStream out = null;
		in = new FileInputStream("products.xml");
		out = new FileOutputStream("productsOUT.xml");
		XmlIoImpl xml = new XmlIoImpl();
		xml.writeProducts(xml.readProducts(in), out);
		out.close();
		in.close();
	}

	public void TestTwo() throws Exception{
		System.out.println("*******TEST readProducts*******");
		InputStream in = null;
		try {
			in = new FileInputStream("products.xml");
		} catch (FileNotFoundException e) {
			System.out.println("File not Found");
		}
		XmlIoImpl xml = new XmlIoImpl();
		List<Product> xx = xml.readProducts(in);
		for(int i = 0;i<xx.size();i++){
			Product xxxx = xx.get(i);
			System.out.println(xxxx.getId()+" "+xxxx.getDescription()+" "+xxxx.getPrice());
		}
		in.close();
	}
	
	public void TestThree() throws Exception{
		System.out.println("*******TEST getProduct*******");
		InputStream in = null;
		try {
			in = new FileInputStream("products.xml");
		} catch (FileNotFoundException e) {
			System.out.println("File not Found");
		}
		XmlIoImpl xml = new XmlIoImpl();
		Product xx = xml.getProduct(in, new Random().nextInt(77));
		System.out.println(xx.getId()+" "+xx.getDescription()+" "+xx.getPrice());
		in.close();
	}
	
	public void TestFour() throws Exception{
		int random = new Random().nextInt(101);
		BigDecimal percent = new BigDecimal(random);
		System.out.println("*******TEST increasePrices "+random+ "% *******");
		InputStream in = null;
		OutputStream out = null;
		in = new FileInputStream("products.xml");
		out = new FileOutputStream("productsOUT.xml");
		XmlIoImpl xml = new XmlIoImpl();
		xml.increasePrices(in, out, percent);
		in.close();
		out.close();
	}
}
