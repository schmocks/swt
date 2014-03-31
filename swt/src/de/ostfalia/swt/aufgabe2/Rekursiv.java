package de.ostfalia.swt.aufgabe2;

public class Rekursiv implements Factorial{

	@Override
	public long factorial(long n) {
		if(n==1){
			return 1;
		}
		return factorial(n-1)*n;
	}

}
