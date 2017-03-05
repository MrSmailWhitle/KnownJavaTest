package test.data.interactive;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class GetEnv {
	public static void main(String[] args){
		Map<String,String> env=new HashMap<>();
		env=System.getenv();
		int siz=env.keySet().size();
		Iterator<String> envKesys=env.keySet().iterator();
		while(envKesys.hasNext()){
			String key=(String) envKesys.next();
			String value=env.get(key);
			System.out.println(key+"="+value);
			
		}
		System.out.println(siz);
	}

}
