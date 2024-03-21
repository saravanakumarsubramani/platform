package Reusability;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/*import Admin.Login;
import Admin.Single_Invite;
*/
public class Read_Excel_Data {

	static int sheets;
	static int rows;
	static int column;
	static XSSFSheet sheet;
	static XSSFRow row;
	static XSSFCell cell;
	static String value;
	static int line = 2;
	static List<String> username = new ArrayList<String>();
	static List<String> password = new ArrayList<String>();
	static List<String> campusdata1 = new ArrayList<String>();
	static List<String> campusdata2 = new ArrayList<String>();
	static List<String> campusdata3 = new ArrayList<String>();
	static List<String> campusdata4 = new ArrayList<String>();

	public static void ReadData(String exceldata) throws IOException, InterruptedException {
		DataFormatter formatter = new DataFormatter();
		FileInputStream excel = new FileInputStream(exceldata);
		XSSFWorkbook book = new XSSFWorkbook(excel);
		sheets = book.getNumberOfSheets();
		for (int i = 0; i < sheets; i++) {
			sheet = book.getSheetAt(i);
			rows = sheet.getLastRowNum();
			for (int j = 1; j <= rows; j++) {
				row = sheet.getRow(j);
				column = row.getLastCellNum();
				for (int k = 0; k < column; k++) {
					cell = row.getCell(k);
					if (line % 2 == 0) {
						username.add(formatter.formatCellValue(cell));
						System.out.println("username: " + cell);
					} else {
						password.add(formatter.formatCellValue(cell));
						System.out.println("password: " + cell);
					}
					line++;
				}
			}
		}
		for (int i = 0; i < username.size(); i++) {
			//Login.Credentials(username.get(i), password.get(i));
		}
	}

	public static void ReadDatacampusdata(String exceldata1) throws Exception {
		DataFormatter formatter = new DataFormatter();
		FileInputStream excel = new FileInputStream(exceldata1);
		XSSFWorkbook book1 = new XSSFWorkbook(excel);
		sheets = book1.getNumberOfSheets();
		for (int i = 1; i < sheets; i++) {
			sheet = book1.getSheetAt(i);
			rows = sheet.getLastRowNum();
			for (int j = 0; j <= rows; j++) {
				row = sheet.getRow(j);
				column = row.getLastCellNum();
				for (int k = 0; k < column; k++) {
					cell = row.getCell(k);
					if (k == 0) {
						campusdata1.add(formatter.formatCellValue(cell));
						System.out.println("campusdata1: " + cell);
					} else if (k == 1) {
						campusdata2.add(formatter.formatCellValue(cell));
						System.out.println("campusdata2: " + cell);
					} else if (k == 2) {
						campusdata3.add(formatter.formatCellValue(cell));
						System.out.println("campusdata3: " + cell);
					} else if (k == 3) {
						campusdata4.add(formatter.formatCellValue(cell));
						System.out.println("campusdata4: " + cell);
					}
				}
			}
		}
		for (int z = 0; z < campusdata1.size(); z++) {
			//Single_Invite.Student_Single_Invite(campusdata1.get(z), campusdata2.get(z), campusdata3.get(z),
					//campusdata4.get(z));
		}
	}

}
