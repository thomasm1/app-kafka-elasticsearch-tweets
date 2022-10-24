package main.apps;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Reflection {

	public static void accessDataActions() {
		DateSingleton instance1 = DateSingleton.getInstance();
		DateSingleton instance2 = null;
		
		Constructor[] constructors = DateSingleton.class.getDeclaredConstructors();
		for(Constructor constructor: constructors) {
			constructor.setAccessible(true);
			try {
				instance2 = (DateSingleton) constructor.newInstance();
				break;
			} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
				e.printStackTrace();
			}
		}
		System.out.println(instance1.hashCode);
		System.out.println(instance2.hashCode);
	}
	
	// Class object access & meta-information access
		public static void accessClassObject() {
		    System.out.println("\nInside accessClassObject ...");
		    
		    // objectRef.getClass()
		 	String[] strArray = {"a", "b", "c"};
		 	System.out.println("\n strArray.getClass().getName(): " + strArray.getClass().getName());
		    
		    // Class.forName
		    Class clazz = null;
		    try {
			    clazz = Class.forName("main.apps.DateLegacy");
			} catch(ClassNotFoundException e) {
	            System.out.println("\nCan't find class ...");		
			}		
			System.out.println("\nclazz.getName(): " + clazz.getName());
			System.out.println("clazz.isInterface(): " + clazz.isInterface());
			System.out.println("clazz.getInterfaces(): " + clazz.getInterfaces().length);
			System.out.println("clazz.getSuperclass().getName(): " + clazz.getSuperclass().getName());
					
			// Exception is thrown bc Class.forName cannot be used on primitives
			try {
			    System.out.println("\nClass.forName(\"boolean\").getName(): " + Class.forName("boolean").getName());
			} catch(ClassNotFoundException e) {
	            System.out.println("\nClassNotFoundException due to Class.forName(\"boolean\").getName()");		
			}			
			
			// Using .class
			System.out.println("\nint.class.getName(): " + int.class.getName());
		}
	
	
	
	public static void main(String[] args) { 
		
		accessDataActions();
		accessClassObject();
		
		

	}
	
}
