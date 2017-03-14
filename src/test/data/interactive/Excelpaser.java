package test.data.interactive;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excelpaser {
	private Workbook wb=null;
	private HashMap<String,ResolveExcel> sheetDataMap=new HashMap<String,ResolveExcel>();
	private int sheetnum=-1;
	public Excelpaser(InputStream in){
		try {
			wb=WorkbookFactory.create(in);
			sheetnum=wb.getNumberOfSheets();
			setSheetDataMap();
		} catch (EncryptedDocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	private void setSheetDataMap() {
		// TODO Auto-generated method stub
		for(int sheetIndex=0;sheetIndex<sheetnum;sheetIndex++){
			String sheetname=wb.getSheetName(sheetIndex);
			ResolveExcel rs=new ResolveExcel(wb.getSheetAt(sheetIndex));
			sheetDataMap.put(sheetname, rs);
		}
		
	}
	public ResolveExcel getSheetDataByName(String sheetname){
		return sheetDataMap.get(sheetname);		
	}
	public int getSheetIndex(String sheetname){
		int index=wb.getSheetIndex(sheetname);
		return index;
	}
	public String getText(String sheetname,int row,int column){
		return getSheetDataByName(sheetname).getText(row,column);
		
	}
}
