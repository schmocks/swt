package de.ostfalia.swt.aufgabe7;

import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Arrays;

import javax.tools.JavaCompiler;
import javax.tools.JavaCompiler.CompilationTask;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;

public class Creator {
	
	/**
	 * Erzeugt im Verzeichnis workingDir eine Klasse className
	 * mit der Klassendefinition classDefinition
	 * 
	 * @param workingDir Das Verzeichnis
	 * @param className Der voll qualifizierte Klassenname
	 * @param classDefinition Die Definition der Klasse
	 * @return Die erzeugt Datei
	 * @throws Exception
	 */
	
	public File createClassFile(File workingDir, String className, String classDefinition) throws Exception{
		String classPath = classPathOnly(className).replace('.', '/');
		File x = new File(workingDir, classPath) ;
		if(x.exists()){x.delete();}x.mkdirs();
		File jsf = new File(x , classNameOnly(className)+".java" ); 
		Writer p = new FileWriter(jsf);
		p.write(classDefinition);p.close();
		JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
		StandardJavaFileManager fileManager = compiler.getStandardFileManager( null, null, null );
		Iterable<? extends JavaFileObject> units;
		units = fileManager.getJavaFileObjectsFromFiles( Arrays.asList(jsf));
		CompilationTask task = compiler.getTask( null, fileManager, null, null, null, units );
		task.call();
		fileManager.close();
		File jcf = new File(jsf.getParent()+"/"+classNameOnly(className)+".class");
		jsf.delete();
		System.out.println();
		return jcf;
	}
	
	/**
	 * Compiliert die in classFile übergebene Klasse
	 * @param classFile
	 * @return true falls Compilation erfolgreich
	 */
		
	@SuppressWarnings("resource")
	public boolean compileClassFile(File classFile){
		URLClassLoader classLoader = null;
		Class<?> loadedClass = null;
		try {
			classLoader = new URLClassLoader(new URL[]{new File(classFile.getParent()).toURI().toURL()});
		} 
		catch (MalformedURLException e) {return false;
		}
               
		try {
			loadedClass = classLoader.loadClass(classPathOnly(classFile.getName()));
		} 
		catch (ClassNotFoundException e) {return false;}
		catch (ClassFormatError e){return false;}
		
		try {
			loadedClass.newInstance();
			
			return true;
        } 
		catch (InstantiationException e) {return false;} 
        catch (IllegalAccessException e) {return false;}
       
	}
	
	/**
	 * @param className voll qualifizierter Klassenname
	 * @return Name der Klasse
	 */
	
	private String classNameOnly(String className){
		int t=0;
		for(int i = className.length()-1;i>0;i--){
			if(className.charAt(i)=='.'){t = i+1;return className.substring(t);}
		}
		return null;
	}
	
	/**
	 * @param className voll qualifizierter Klassenname
	 * @return Pfad der Klasse
	 */
	
	private String classPathOnly(String className){
		int t=0;
		for(int i = className.length()-1;i>0;i--){
			if(className.charAt(i)=='.'){t = i;return className.substring(0, t);}
		}
		return null;
	}
	

}
