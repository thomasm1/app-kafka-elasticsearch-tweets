package apps;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Reflection {

	public static void accessDataActions() {
		DateActions instance1 = DateActions.getInstance();
		DateActions instance2 = null;
		
		Constructor[] constructors = DateActions.class.getDeclaredConstructors();
		for(Constructor constructor: constructors) {
			constructor.setAccessible(true);
			try {
				instance2 = (DateActions) constructor.newInstance();
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
			    clazz = Class.forName("com.semanticsquare.jvm.User");		    
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
