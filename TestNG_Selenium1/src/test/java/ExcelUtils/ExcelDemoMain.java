package ExcelUtils;

import java.io.IOException;

public class ExcelDemoMain {

	public static void main(String[] args) throws IOException {
		String projectLocation = System.getProperty("user.dir");
		excelDemo excel = new excelDemo(projectLocation+"/excel/data.xlsx", "Sheet1");
		excel.getRowCount();
		excel.getColCount();
		excel.getCellDataString(1, 0);
		excel.getCellDataNumber(1, 1);
		
		

	}

}
	