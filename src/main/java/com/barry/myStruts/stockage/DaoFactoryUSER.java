/**
 * 
 */
package com.barry.myStruts.stockage;

import java.lang.reflect.InvocationTargetException;
import java.util.Properties;

import com.barry.myStruts.service.Person;

/**
 * @author algas
 *
 */
public class DaoFactoryUSER {

	private static DaoFactoryUSER instance  = new DaoFactoryUSER();
	private static final String CLASS = "com.barry.myStruts.stockage.DaoJDBCImplUSER";
	Class<?> classe;
	Dao<Person> dao;
	Properties properties;
	/**
	 * initialise les attributs Dao,properties
	 */
	private DaoFactoryUSER() {
		properties = new Properties();
		//charger();
		try {
			try {
				try {
					//classe = (Class<CagePOJO>) classe.forName(properties.getProperty("CLASS")).getConstructor().newInstance(null);
					//classe = (Class<?>) Class.forName(properties.getProperty("CLASS"));
					classe = (Class<?>) Class.forName(CLASS);
					//dao = (Dao<CagePOJO>) classe.getConstructor(null).newInstance(null);
					dao = (Dao<Person>) classe.getDeclaredConstructor(null).newInstance(null);
					
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (NoSuchMethodException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SecurityException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	/**
	 * @return the properties
	 */
	public Properties getProperties() {
		return properties;
	}
/**
 * charge le fichier classConfig.properties qui contient le chemin de la classe à instancier
 * en se servant de la reflexion 
 */
//	public void charger() {
//		try {
//			//properties.load(new FileInputStream("classConfig.properties"));
//			properties.load(DaoFactory.class.getResourceAsStream("zoo.properties"));
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
	/**
	 * @return the instance
	 */
	public static DaoFactoryUSER getInstance() {
		return instance;
	}
	
	/*public Dao<CagePOJO>getDao(){
	
		return new DaoJDBCImpl();
		return new DaoMemoire();
	}*/
	
	/**
	 * 
	 * @return dao, retourne le Dao souhaitez, DaoMemoire, DaoJDBCImpl...
	 */
	public Dao<Person>getClassDao(){
			return dao;
		
	}

}
