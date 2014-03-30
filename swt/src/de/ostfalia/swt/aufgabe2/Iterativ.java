package de.ostfalia.swt.aufgabe2;

public class Iterativ implements Factorial{

	@Override
	public long factorial(long n) {
		long x=1;
		for(int i = 1; i<n; i++){
			x+=x*i;
		}
		return x;
	}

}
