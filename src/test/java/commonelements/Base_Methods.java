package commonelements;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Base_Methods {

	static Properties testdata;
	protected static String loginButtonLocator;
	protected static String signupWithEmailButtonLocator;
	protected static String userNameFieldLocator;
	protected static String passwordFieldLocator;
	protected static String signupButtonLocator;
	protected static String username;
	protected static String password;

	
	static String excelFilePath = "/Users/balamuralibalaguru/Padma/Eclipse/pomproject/src/test/resources/excel/TestData.xlsx";
	static String propertiesFilePath = "/Users/balamuralibalaguru/Padma/Eclipse/pomproject/src/test/resources/propertyfiles/POM_Project_ElementLocators.properties";
	static String screenShotFilespath = "/Users/balamuralibalaguru/Padma/Eclipse/pomproject/src/test/resources/screenshot/";
	static String textfilePath = "/Users/balamuralibalaguru/Padma/Eclipse/pomproject/src/test/resources/textfile/LogFile.txt";

	File logfile = new File(textfilePath);
	
	
	/**
	 * propertiesFileSetup - This method load and setup all Element Locators from
	 * Properties File
	 * 
	 * @param Does not include any parameter
	 * @author Padma
	 * 
	 */
	
	public void propertiesFileSetup() throws IOException {

		testdata = new Properties();
		FileInputStream properties_file = new FileInputStream(propertiesFilePath);
		testdata.load(properties_file);

		loginButtonLocator = testdata.getProperty("loginButtonLocator");
		signupWithEmailButtonLocator = testdata.getProperty("signupWithEmailButtonLocator");
		System.out.println("signupWithEmailButtonLocator******" +signupWithEmailButtonLocator);
		userNameFieldLocator = testdata.getProperty("userNameFieldLocator");
		passwordFieldLocator = testdata.getProperty("passwordFieldLocator");
		signupButtonLocator = testdata.getProperty("signupButtonLocator");

	}

	/**
	 * readDataFromExcelFile - This method read Test Data (Username and Password)
	 * from Excel File
	 * 
	 * @param Test data row number of Excel file (int rownum)
	 * @author Padma
	 * 
	 */

	public static void readDataFromExcelFile(int rownum) throws IOException {

		File excelfile = new File(excelFilePath);
		FileInputStream inputStream = new FileInputStream(excelfile);

		XSSFWorkbook wb = new XSSFWorkbook(inputStream);
		XSSFSheet sheet = wb.getSheet("sheet1");

		username = sheet.getRow(rownum).getCell(0).getStringCellValue();
		password = sheet.getRow(rownum).getCell(1).getStringCellValue();
		

	}

	/**
	 * writeintoExcelFile - This method write Test Result into Excel File
	 * 
	 * @param Row number to be updated and Result(Pass or Fail) (int rownum , String
	 *            result)
	 * @author Padma
	 * 
	 */

	public static void writeintoExcelFile(int rownum, String result) throws IOException {

		File excelfile = new File(excelFilePath);
		FileInputStream inputStream = new FileInputStream(excelfile);
		XSSFWorkbook wb = new XSSFWorkbook(inputStream);

		XSSFSheet sheet = wb.getSheet("sheet1");
		XSSFRow row1 = sheet.getRow(rownum);

		XSSFCell cell = (XSSFCell) row1.createCell(2);
		cell.setCellValue(result);

		FileOutputStream outputStream = new FileOutputStream(excelfile);
		wb.write(outputStream);
		wb.close();
	}

	/**
	 * takeScreenShot - This method takes screenshot of the page
	 * 
	 * @param Does not include any parameter
	 * @author Padma
	 * 
	 */

	public static void takeScreenShot(WebDriver driver) throws IOException {

		String extension = ".jpeg";
		String datetime = getDateTime();

		System.out.println("path:" + screenShotFilespath);
		
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File(screenShotFilespath + datetime + extension));
		

	}

	/**
	 * getDateTime - This method used to take current date and time to be used in
	 * screenshot file name
	 * 
	 * @param Does not include any parameter
	 * @author Padma
	 * 
	 */

	private static String getDateTime() {
		SimpleDateFormat dateformat = new SimpleDateFormat("dd_MM_YYYY_h_m_s");
		Date date = new Date();
		String datetimeofscreenshot = dateformat.format(date);
		
		return datetimeofscreenshot;
	}
	
	public void writeLogintoTextFile(String message) {
		
		Date date = new Date();
		try {
			
			FileWriter myWriter = new FileWriter(logfile, true);
			BufferedWriter bw = new BufferedWriter(myWriter);
			bw.write(date.toString()+":" +message);
			bw.newLine();
			bw.close();	
			
			} catch (IOException e) {
				System.out.println("An error occured");
				e.printStackTrace();
				
			}
	}
	
	

}
