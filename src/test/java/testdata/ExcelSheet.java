package testdata;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelSheet {
	
	public static Workbook book;
	
	public static Sheet sheet;

	public static Object[][] readdata(String Sheetname){
		
		FileInputStream file=null;
		try {
			file=new FileInputStream("C:\\Users\\Test\\Desktop\\Eclipse\\Ecommerce_Amazon\\src\\test\\java\\testdata\\Details.xlsx");
			
			
		}
		
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
		
		 book = WorkbookFactory.create(file);
		}
		catch(IOException a) {
			a.printStackTrace();
		}
		
		
	
		
	sheet = book.getSheet(Sheetname);
	Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
	
	int row= sheet.getLastRowNum();
	int cell=sheet.getRow(0).getLastCellNum();
	
	for(int i=0;i<row;i++) {

	sheet.getRow(i);
		
	for(int k=0;k<cell;k++) {
		
		data[i][k]=sheet.getRow(i+1).getCell(k).toString();
		}
	}
	return data;
	

	
	}}

