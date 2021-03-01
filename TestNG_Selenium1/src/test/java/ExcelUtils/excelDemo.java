package ExcelUtils;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class excelDemo
{
	static String projectLocation;
	static XSSFWorkbook workbook;
	static XSSFSheet sheet;

	public excelDemo(String excelPath, String sheetName)
	{
		try{
		workbook = new XSSFWorkbook(excelPath);
		sheet = workbook.getSheet(sheetName);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		}
	
	public static void main(String[] args) throws IOException {
		//getRowCount();
		//getCellDataString(0,0);
		//getCellDataNumber(1,1);
	}
	public static int getRowCount()
	{
		int rowCount=0;
		try
		{
			
			rowCount = sheet.getPhysicalNumberOfRows();
			System.out.println("Number of rows : "+rowCount);

		}
		catch(Exception exp)
		{
			System.out.println(exp.getMessage());
			System.out.println(exp.getCause());
			exp.printStackTrace();
		}
		return rowCount;
	}

	public static int getColCount()
	{
		int colCount=0;
		try
		{
			
			colCount = sheet.getRow(0).getPhysicalNumberOfCells();
			System.out.println("Number of columns : "+colCount);

		}
		catch(Exception exp)
		{
			System.out.println(exp.getMessage());
			System.out.println(exp.getCause());
			exp.printStackTrace();
		}
		return colCount;
	}
	public static String getCellDataString(int rowNum, int colNum) throws IOException
	{
//		projectLocation = System.getProperty("user.dir");
//		workbook = new XSSFWorkbook(projectLocation+"/excel/data.xlsx");
//		sheet = workbook.getSheet("Sheet1");
		String Celldata=null;
		try
		{
			
			Celldata = sheet.getRow(rowNum).getCell(colNum).getStringCellValue();
			//System.out.println(Celldata);
		}
		catch(Exception exp)
		{
			System.out.println(exp.getMessage());
			System.out.println(exp.getCause());
			exp.printStackTrace();
		}
		return Celldata;
	}
	
	public static void getCellDataNumber(int rowNum, int colNum) throws IOException
	{
//		projectLocation = System.getProperty("user.dir");
//		workbook = new XSSFWorkbook(projectLocation+"/excel/data.xlsx");
//		sheet = workbook.getSheet("Sheet1");
		try
		{
			
			double Celldata = sheet.getRow(rowNum).getCell(colNum).getNumericCellValue();
			//System.out.println(Celldata);
		}
		catch(Exception exp)
		{
			System.out.println(exp.getMessage());
			System.out.println(exp.getCause());
			exp.printStackTrace();
		}
	}
}
