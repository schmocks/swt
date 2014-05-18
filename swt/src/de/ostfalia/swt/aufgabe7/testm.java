package de.ostfalia.swt.aufgabe7;

import java.io.File;
import java.io.FileWriter;
import java.io.Writer;


public class testm {

	public static void main(String[] args) throws Exception{
		
		File workingDir = new File("C:/JAVATEMP");
		String className = "de.swt.wurst.SuperKlasse";
		String classDefinition = "public class SuperKlasse{\n\npublic static void main(String[] args) {\nSystem.out.println(0);}\n}";
		Creator c = new Creator();
		File classFile = c.createClassFile(workingDir, className, classDefinition);
		
		File test = new File(workingDir, "test");
		test.mkdirs();
		File testclass = new File(test, "x.class");
		Writer p = new FileWriter(testclass);
		p.write("stuff");p.close();
		System.out.println(c.compileClassFile(classFile));
		System.out.println(c.compileClassFile(testclass));
	}

}
