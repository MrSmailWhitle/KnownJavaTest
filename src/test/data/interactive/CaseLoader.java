package test.data.interactive;
import test.data.interactive.MockAPI;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.lang.reflect.Method;

public class CaseLoader {
static{
	loadExcel();
}
private static ResolveExcel sheetData;
private static void loadExcel() {
	// TODO Auto-generated method stub
	String path="";
	String sheetname="";
	Excelpaser reader=null;
	long now=System.currentTimeMillis();
	try{
		InputStream in=new FileInputStream(path);
		reader=new Excelpaser(in);
	}catch(FileNotFoundException e){
		e.printStackTrace();
	}
	if(reader!=null){
		sheetData=reader.getSheetDataByName(sheetname);
	long dalta=System.currentTimeMillis()-now;
	System.out.println("/n time used in ms::"+dalta);
	}
	
}
public static String[] getCallList(){
	return sheetData.getColumnData(0);
}
public static String[] getParams(int rowIndex){
	return sheetData.getRowData(rowIndex);
}
public static void main(String[] args){
	Class<?> clazz=MockAPI.class;
	Method[] methods=clazz.getDeclaredMethods();
	String[] callList=getCallList();
	for(int i=1;i<callList.length;i++){
		for(Method m:methods){
			if(m.getName().equalsIgnoreCase(callList[i])){
				try{
					m.invoke(new MockAPI(), (Object)getParams(i));
				}catch(Exception ex){
					ex.printStackTrace();
				}
			}
			
		}
		
	}
}
}
