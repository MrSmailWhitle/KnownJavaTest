package test.data.interactive;

import java.util.ArrayList;
import java.util.List;
import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;

public class ResolveExcel {
	private Sheet sheet;
	private List<String> datalist=new ArrayList<>();
	public ResolveExcel(Sheet sheet){
		this.sheet=sheet;
		setSheetDataSet();
	}
	protected String getCellText(Row row,int column){
		String cellText="";
		Cell cell=row.getCell(column,Row.CREATE_NULL_AS_BLANK);
		switch(cell.getCellType()){
		case cell.CELL_TYPE_STRING:
			cellText=cell.getStringCellValue().trim();
			break;
		case cell.CELL_TYPE_BLANK:
			cellText="";
			break;
		case cell.CELL_TYPE_BOOLEAN:
			cellText=Boolean.toString(cell.getBooleanCellValue());
			break;
		case cell.CELL_TYPE_NUMERIC:
			if(DateUtil.isCellDateFormatted(cell)){
				cellText=String.valueOf(cell.getBooleanCellValue());
				
			}else{
				cell.setCellType(cell.CELL_TYPE_STRING);
				String value=cell.getStringCellValue();
					if(value.indexOf(".")>-1){
						cellText=String.valueOf(new Double(value)).trim();
					}else{
						cellText=value.trim();
					}
			}
			break;
		case cell.CELL_TYPE_ERROR:
			cellText="";
			break;
		case cell.CELL_TYPE_FORMULA:
			cell.setCellType(cell.CELL_TYPE_STRING);
			cellText=cell.getStringCellValue();
			if(cellText!=null){
				cellText=cellText.replaceAll("#N/A", "").trim();
				
			}
			break;
		default:
			cellText="";
			break;
		}
		return cellText;
	}
	private void setSheetDataSet() {
		// TODO Auto-generated method stub
		int columnNum=0;
		if(sheet.getRow(0)!=null){
			columnNum=sheet.getRow(0).getLastCellNum()-sheet.getRow(0).getFirstCellNum();
		}
		if(columnNum>0){
			for(Row row:sheet){
				String[] singleRow=new String[columNum];
				int n=0;
				for(int i=0;i<columnNum;i++){
					singleRow[n]=this.getCellText(row,i);
					n++;
				}
				
			}
		}
		if("".equals(singleRow[0])){
			continue;
		}
		datalist.add(singleRow);
			
		}
		
	}
 }
 public List<String[]> getSheetDataSet(){
	 return datalist;
 }
 public int getRowCount(){
	 return sheet.getLastRowNum();
 }
 public int getColumnCount(){
	 Row row=sheet.getRow(0);
	 if(row!=null&&row.getLastCellNum()>0){
		 return row.getLastCellNum();
		 
	 }
	 return 0;
 }
 public String[] getRowData(int rowIndex){
	 String[] dataArray=null;
	 if(rowIndex>this.getRowCount()){
		 return dataArray;
	 }else{
		 dataArray=new String[this.getColumnCount()];
		 return this.datalist.get(rowIndex);
	 }
	 
 }
 public String[] getColumnData(int colIndex){
	 String[] dataArray=null;
	 if(colIndex>this.getColumnCount()){
		 return dataArray;
		 
	 }else{
		 if(this.datalist!=null&&this.datalist.size()>0){
			 dataArray=new String[this.getColumnCount()+1];
			 int index=0;
			 for(String[] rowData:datalist){
				 if(rowData!=null){
					 dataArray[index]=rowData[colIndex];
					 index++;
					 
				 }
			 }
		 }
	 }
	 return dataArray;
 }
 public String getText(int row,int column){
	 return getRowData(row)[column];
	 
 }
}
