package test.data.interactive;

import java.util.HashMap;
import java.util.Map;
import test.data.interactive.MockTestLinkApi;
public class MockAPI {
private MockTestLinkApi api=new MockTestLinkApi();
public static final String[] loginArray={"","","username","password","",""};
public static final String[] InsProjectArray={"id","name","notes","profix","isActive","isPublic"};
public boolean login(String[] valuses){
	Map<String,String> map=getParamMap(loginArray,valuses);
	if(map!=null){
		return api.login(map);
	}
	else return false;
}
public boolean InsProject(String[] valuses){
	Map<String,String> map=getParamMap(InsProjectArray,valuses);
	if(map!=null){
		return api.InsProject(map);
	}
	else return false;
}
private Map<String, String> getParamMap(String[] params, String[] valuses) {
	// TODO Auto-generated method stub
	
	if(params.length>valuses.length){
		System.out.println("value number is less than param number");
	}
	Map<String,String> map=new HashMap<String,String>();
	for(int i=1;i<params.length;i++){
		if(params[i]!=""){
			map.put(params[i], valuses[i]);
		}
	}
	return map;
}

}
