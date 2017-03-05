package test.data.interactive;


import java.io.InputStream;
import java.util.Iterator;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.Test;



public class ResolveXml {
	private Document doc;
	public ResolveXml(){
		InputStream in=getInputFileAsStream(this.getClass());
		SAXReader reader=new SAXReader();
		try{
			doc=reader.read(in);
		}catch(DocumentException e){e.printStackTrace();}
	}
	public static InputStream getInputFileAsStream(Class<?> testClass){
		String packageName="";
		if(testClass.getPackage()!=null){
			packageName=testClass.getPackage().getName()+".";
		}
		String resourceBase=(packageName+testClass.getSimpleName()).replace('.','/');
		//String resourceBase=testClass.getClass().getResource("/").getPath();

		String resourceName;
		ClassLoader classloader=testClass.getClassLoader();
		resourceName=resourceBase+".xml";
		System.out.println("search for default input file:"+resourceName);
		return classloader.getResourceAsStream(resourceName);
	}
	public String getLocator(String name){
		String locator=null;
	Element datasets=(Element)this.doc.selectSingleNode("//datasets");
		for(Iterator d=datasets.elementIterator("locators");d.hasNext();){
			Element data=(Element) d.next();
			for(Iterator e=data.elementIterator("locator");e.hasNext();){
				Element elem=(Element) e.next();
				String value=elem.valueOf(".");
				String nameString=elem.valueOf("@name");
				System.out.println("\n'"+nameString+"'");
				if(name.equalsIgnoreCase(nameString)){
					if(!elem.valueOf("@by").isEmpty()){
						locator=elem.valueOf("@by")+"="+value;
					}
					break;
				}
			}
			
		}
		return locator;
	}
	@Test
	public void testPaser(){
		String locator="pwdlocator";
		long curTime=System.currentTimeMillis();
		String resultString=this.getLocator(locator);
		long dalta=System.currentTimeMillis()-curTime;
		System.out.println("\n"+locator+"="+resultString+"'\nTime used(ms)::"+dalta);
		}
	}

