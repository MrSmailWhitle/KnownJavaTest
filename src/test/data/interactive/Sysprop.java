package test.data.interactive;

import java.util.Iterator;
import java.util.Properties;
public class Sysprop {
	
	public static void main(String[] args){
		//Propertise or property is a map;
		//keyset is used to get the mapkey to make a set;
		Properties props=System.getProperties();
		int size=props.size();
		Iterator iter=props.keySet().iterator();
		while(iter.hasNext()){
			String key=(String) iter.next();
			System.out.println(key+" = "+props.get(key));
	}
		final String USER_HOME=System.getProperty("user.home");
		System.out.println(USER_HOME);
		//String bs=System.getProperty("BROWSER_TYPE");
		//System.out.println(bs);
		//System.setProperty("broser.type","firefox");
		String bs=System.getProperty("broser.type");
		System.out.println(bs);
		System.out.println(size);
		
	}
}
