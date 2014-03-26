package de.ostfalia.swt.aufgabe1;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Analyzer swt.Aufgabe1
 * 
 * @author Stephan Degener 20915159
 *
 */

public class Analyzer {
	
	

	/**
	 * 
	 * @param classname Klassenname
	 * 
	 * @return Menge aller Methoden / Leere Menge
	 */
	
	public Set<Method> getAllPublicMethods(String classname){
		Set<Method> mese = new HashSet<Method>();
		
		try {
			Class<?> c = Class.forName(classname);
			Method[] m = c.getDeclaredMethods();
			for(int i = 0; i<m.length;i++){
				if(m[i].getModifiers()==1){mese.add(m[i]);}
				}
			} 
		catch (ClassNotFoundException e) {
			return mese;
		}
		return mese;
	}
	
	/**
	 * 
	 * @param object Object
	 * @return Liste aller Interfaces
	 */
	
	public List<Class<?>> getInterfaces(Object object){
		List<Class<?>> lis = new ArrayList<Class<?>>();
		Class<?>[] cla = object.getClass().getInterfaces();
	   
		for(int i = 0;i<cla.length;i++){
			lis.add(cla[i]);
		}
		
		return  lis;
		
	}
	
	/**
	 * 
	 * @param clazz Klasse
	 * @return true fall toString überschrieben wurde
	 */
	
	
	public boolean isToStringOverwritten(Class<?> clazz){
		Method[] methods = clazz.getDeclaredMethods();
		for(int i = 0; i < methods.length; i++){
			if(methods[i].getName()=="toString"){return true;}
			}
		return false;
	}
	
	/**
	 * 
	 * @param clazz Klasse
	 * @return true falls Oberklasse (!=Objekt) vorhanden
	 */
	
	public boolean hasSuperclass(Class<?> clazz){
		if(clazz.getSuperclass()!=null&&clazz.getSuperclass()!=java.lang.Object.class){
			return true;
		
		}
		return false;
	}
	
	

}
