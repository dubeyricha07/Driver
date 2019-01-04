package Driver;



import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


	
 public class verifyObject {
	 public WebDriver firefox;
	// public WebDriver driver;
	 public URL TestUrl;
	
	@Test
	
	public void Main() throws InterruptedException, IOException
	
	{
		 
		
		firefox.findElement(By.name("j_username")).sendKeys("cso");
		firefox.findElement(By.name("j_password")).sendKeys("password");
		firefox.findElement(By.id("login")).click();
		firefox.findElement(By.id("inquiry-link")).click();
		WebElement Edit_Username = firefox.findElement(By.name("policyPhases"));
		Select select = new Select(Edit_Username);
		select.selectByVisibleText("Approval");
		
		
		
		/*firefox.findElement(By.xpath(".//*[@id='userImg']")).click();		
		firefox.findElement(By.xpath("//a[contains(@onclick,'newApplication')]")).click();
		String Parentwindow = firefox.getWindowHandle();
		Set<String> windowhandles = firefox.getWindowHandles();
		Iterator<String> iterator = windowhandles.iterator();
		while (iterator.hasNext()){
			String handle = iterator.next();
			if(!handle.contains(Parentwindow)){
				firefox.switchTo().window(handle);
				firefox.findElement(By.id("agreeToTerms")).click();
				firefox.findElement(By.id("agreementConfirm")).click();
			}
		}
		
		firefox.findElement(By.id("lmiProposalUI.proposalConfiguration.applicationType1")).click();
		firefox.findElement(By.id("saveProceedAppButton")).click();
		firefox.findElement(By.id("addRealEstateButton")).click();
		firefox.findElement(By.id("findAddressButton_0")).click();
		String Parentwindow1 = firefox.getWindowHandle();
		Set<String> windowhandles1 = firefox.getWindowHandles();
		Iterator<String> iterator1 = windowhandles1.iterator();
		
		while (iterator1.hasNext()){
			String handle1 = iterator1.next();
			firefox.switchTo().window(handle1);
			 String Parentwindowtitle = firefox.getTitle();
			if(Parentwindowtitle.contains("QAS")){
				
				firefox.findElement(By.id("Singleline")).click();
				firefox.findElement(By.id("searchText")).sendKeys("Unit8, 36 Cowper street, Parramatta, 2150 NSW");
				
				}
		}
		
				
		firefox.findElement(By.id("saveProceedAppButton")).click();
				
		
	/*	firefox.findElement(By.id("j_username")).sendKeys("cso");
		firefox.findElement(By.id("j_password")).sendKeys("password");
		firefox.findElement(By.id("login")).click();
		firefox.findElement(By.id("x-auto-16_x-auto-19")).click();*/
		
	/*	WebElement Edit_Username=firefox.findElement(By.xpath("//*[@class='rv-summary-table x-component']"));
		List<WebElement> allrows = Edit_Username.findElements(By.tagName("tr"));
		
		for (WebElement row :allrows ){
			List<WebElement> cells = row.findElements(By.tagName("td"));
			for (WebElement cell: cells){
				String cellValue = cell.getText();
				Constant.dataToWrite.add(cellValue);
			}
		}
		
		
		WebElement Edit_Username1=firefox.findElement(By.xpath("//Div[@class='x-window-body x-window-body-noheader x-window-body-noborder']"));
		Constant.val=Edit_Username1.getText();
		Constant.dataToWrite.add("Screen Msg:");
		Constant.dataToWrite.add(Constant.val);
		
		Date date = new Date();
		SimpleDateFormat dt1 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		String date1 = dt1.format(date);
		//date1 = date1.replaceAll("\\s", "");
		Constant.dataToWrite.add("Execution Date:");
		Constant.dataToWrite.add(date1);
		Constant.stockArr = new String[Constant.dataToWrite.size()];
		Constant.stockArr = Constant.dataToWrite.toArray(Constant.stockArr);
		
		writeExcel("C:\\Users\\889128\\Desktop\\Selenium Luna\\selenium", "Datawrite.xlsx", "Sheet1", Constant.stockArr);
		

		  
	      
		
		
		/*firefox.findElement(By.id("btn-continue")).click();
			
		WebElement name  = firefox.findElement(By.xpath("//*[contains(@name,'lient')]"));
		Actions builder2 = new Actions(firefox);
		builder2.sendKeys(Keys.chord(Keys.CONTROL,"a")).build().perform();
		name.sendKeys("ACCU");
		WebElement name1  = firefox.findElement(By.xpath("//*[contains(@name,'lient')]"));
		Actions builder1 = new Actions(firefox);
		builder1.sendKeys(Keys.chord(Keys.CONTROL,"a")).build().perform();
		name1.sendKeys("AUSTRALIAN CENTRAL CREDIT UNION S0200");
		firefox.findElement(By.id("btn-dialog-ok")).click();
		firefox.findElement(By.id("data-entry-tabs__Borrower_tab")).click();
		firefox.findElement(By.id("btn-icon-add-individual")).click();
		
		firefox.findElement(By.id("ib-cur-btn-icon-find-address")).click();
		firefox.findElements(By.tagName("iframe"));
		
		firefox.switchTo().frame(firefox.findElement(By.xpath("//iframe[@class='gwt-Frame x-component']")));
	
		
		WebElement button1 = firefox.findElement(By.id("Singleline"));
		button1.click();
		firefox.switchTo().defaultContent();
		/*WebElement AButton = firefox.findElement(By.id("btn-assess"));
		 String classvalue = AButton.getAttribute("class");
		 boolean msg = classvalue.contains("disabled");
		 if(classvalue.contains("disabled"))
		 {
			while (classvalue.contains("disabled")== true)
			{
				Thread.sleep(1000);
				
			}
			
			System.out.println("out of loop");
		 }
		 */
		//************************************PDF Validation********************************************
		
		/*TestUrl = new URL("http://www.axmag.com/download/pdfurl-guide.pdf");
		driver.navigate().to(TestUrl);
		BufferedInputStream Testfile = new BufferedInputStream(TestUrl.openStream());
		PDFParser TestPDF = new PDFParser(Testfile);
		TestPDF.parse();
	    String Textstring = new PDFTextStripper().getText(TestPDF.getDocument());
	    Boolean val = Textstring.contains("<pagewidth>400</pagewidth>");
		System.out.println("Content in the PDF match ?" + val);*/
		
		//**************************PDF VALIDATION CODE ENDS ******************************************
		
		// ************Code for ai affinity*********************
		/*driver.findElement(By.name("username")).sendKeys("ranjani.m");
		driver.findElement(By.name("password")).sendKeys("Summer36");
		driver.findElement(By.xpath("/html/body/div/div[2]/form/table[2]/tbody/tr/td[2]/button/span[2]/span")).click();
		WebElement DD1 = driver.findElement(By.id("LegalEntity_No"));
		Select select = new Select(DD1);
		select.selectByVisibleText("WAW Credit Union");
		WebElement DD2 = driver.findElement(By.id("FI_ACCOUNT"));
		 select = new Select(DD2);
		select.selectByVisibleText("WAW New Business");
		 DD2 = driver.findElement(By.id("FI_PRODUCT"));
		 select = new Select(DD2);
		select.selectByVisibleText("Household");
		driver.findElement(By.cssSelector("nobr > table.buttonMainTable > tbody > tr > td.buttonTdMiddle > button.buttonTdButton")).click();
		driver.findElement(By.id("BuildingcoverInd_Yes")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("SumInsuredAmt")).sendKeys(String.valueOf(50000));
		Thread.sleep(1000);
		driver.findElement(By.id("ContentsCoverInd_Yes")).click();
		Thread.sleep(1000);
		driver.findElement(By.name("$PpyWorkPage$pProductData$pComponent$gHouseholders$pOptionData$l1$pComponent$gHouseholders$pOptionData$l1$pProduct$pContentsCover$pContentsSumInsured$pSumInsuredAmt")).sendKeys("500000");
		Thread.sleep(1000);
		driver.findElement(By.id("ValuablesCoverInd_Yes")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("MiscValuablesCoverInd_Yes")).click();
		Thread.sleep(1000);
		DD2 = driver.findElement(By.id("UnspecifiedValInsurance"));
		 select = new Select(DD2);
		select.selectByVisibleText("$750 per item, $3,000 per event");
		driver.findElement(By.id("SpecifiedValuablesCoverInd_Yes")).click();
		Thread.sleep(1000);
		driver.findElement(By.name("$PpyWorkPage$pProductData$pComponent$gHouseholders$pOptionData$l1$pComponent$gHouseholders$pOptionData$l1$pProduct$pSpecifiedValuablesCover$pSpecifiedSumInsured$pSumInsuredAmt")).sendKeys("10000");
		driver.findElement(By.id("FreeformAddrLine1")).sendKeys("Lee");
		Thread.sleep(1000);
		driver.findElement(By.id("FreeformAddrLine2")).sendKeys("Sydney");
		driver.findElement(By.name("dynButton")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[contains(text(),'1 LEE STREET')]")).click();
		driver.findElement(By.xpath("//button/u[contains(text(),'N')]")).click();
		DD2 = driver.findElement(By.id("OccupancyType"));
		 select = new Select(DD2);
		select.selectByVisibleText("I own and live in the home");
		Thread.sleep(1000);
		DD2 = driver.findElement(By.id("PropertyType"));
		 select = new Select(DD2);
		select.selectByVisibleText("House");
		Thread.sleep(1000);
		DD2 = driver.findElement(By.id("BuildingConstruction"));
		 select = new Select(DD2);
		select.selectByVisibleText("Concrete/Cement/Besser/Hebel/Masonry Block");
		Thread.sleep(1000);
		DD2 = driver.findElement(By.id("RoofConstruction"));
		 select = new Select(DD2);
		select.selectByVisibleText("Concrete");
		Thread.sleep(1000);
		DD2 = driver.findElement(By.id("BuildingAge"));
		 select = new Select(DD2);
		select.selectByVisibleText("2000 or later");
		Thread.sleep(1000);
		driver.findElement(By.id("BusinessUseInd_Yes")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("SuburbanBlockInd_Yes")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("FirstMortgageInd_Yes")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button/u[contains(text(),'N')]")).click();
		DD2 = driver.findElement(By.id("BusinessType"));
		 select = new Select(DD2);
		select.selectByVisibleText("Home Office");
		Thread.sleep(1000);
		driver.findElement(By.id("SmallHoldingSizeInd_No")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("TownWaterInd_Yes")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("ProduceGrownInd_No")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("IncomeGeneratedInd_No")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("DamInd_No")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button/u[contains(text(),'N')]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='RULE_KEY']/div/table/tbody/tr[2]/td[2]/nobr/div/table/tbody/tr/td[3]/input[2]")).click();*/
		
		
	
	
		
		
		
		
		
	}
	
	public void  writeExcel(String filepath, String fileName, String sheetName,String[] datatowrite) throws IOException{
        File file = new File(filepath+"\\"+fileName);
		
		//Create and object of file inputstream class to read excel file
		
		FileInputStream inputstream = new FileInputStream(file);
		Workbook Guruworkbook = null;
		//Find the file extension by splitting the file name and get only the extension
		
		String fileExtensionName = fileName.substring(fileName.indexOf("."));
		//Check the condition if the file is xlsx
		if(fileExtensionName.equals(".xlsx")){
			// Create object for XSSworkbook
			Guruworkbook = new XSSFWorkbook(inputstream);
			
		}
		// Check condition if the file xls
		else if (fileExtensionName.equals(".xls")){
			Guruworkbook = new HSSFWorkbook(inputstream);
		}
		
		//Read excel sheet by sheet name
		Sheet sheet =  Guruworkbook.getSheet(sheetName);
		
		//Get the current count of rows in the excel sheet
		
		int rowCount = sheet.getLastRowNum()-sheet.getFirstRowNum();
		
		// get the first row from the excel sheet
		Row row = sheet.getRow(0);
		
		// create a new row and append it at last of the sheet.
		Row newRow = sheet.createRow(rowCount+1);
		
		// Create a loop over the cell of newly created row
		for (int j =0 ; j< row.getLastCellNum(); j++){
			
			//Fill data in the row
			Cell cell = newRow.createCell(j);
			cell.setCellValue(datatowrite[j]);
		}
		
		// close input string
		
		inputstream.close();
		
		// Create an object for fileoutputstring to write the date
		
		FileOutputStream outputstream = new FileOutputStream(file);
		
		//Write data in excel sheet
		Guruworkbook.write(outputstream);
		
		//Close the output string.
		outputstream.close();
		
		
	}
	
	@BeforeMethod 
	
	public void beforemethod() throws MalformedURLException{
		
		
		//********Code for iexplore LMI workbench*******************
		/*String currentDir = System.getProperty("user.dir");
		System.setProperty("webdriver.ie.driver", currentDir +"//src//Jar//IEDriverServer.exe");
		DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
		capabilities.setCapability(InternetExplorerDriver.INITIAL_BROWSER_URL,""); 
		capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
		capabilities.setCapability("requireWindowFocus", true);
		capabilities.setCapability("ignoreZoomSetting", true); 
		driver = new InternetExplorerDriver(capabilities);*/
		
		//*****************Mozilla Code****************************************
		
		//System.setProperty(GeckoDriverService.GECKO_DRIVER_EXE_PROPERTY,"C:\\Users\\889128\\Desktop\\Selenium Luna\\Project LMI\\Vishnu4.0\\src\\Jar\\geckodriver.exe");
		//******** Code for Portable firefox code *******************************
		System.setProperty("webdriver.firefox.marionette","C:\\Users\\889128\\Desktop\\Selenium Luna\\Project LMI\\Vishnu4.0\\src\\Jar\\geckodriver.exe");
		DesiredCapabilities capabilities = DesiredCapabilities.firefox();
		FirefoxBinary binary = new FirefoxBinary(new File("C:\\Users\\889128\\Desktop\\Selenium Luna\\New folder\\FirefoxPortable40\\FirefoxPortable.exe") );
		FirefoxProfile profile= new FirefoxProfile();
		 capabilities.setCapability("marionette",false);
		profile.setPreference("xpinstall.signatures.required", false);
		profile.setAcceptUntrustedCertificates(true);
		
	//	 firefox = new FirefoxDriver(binary,profile);
	//	 firefox.manage().window().maximize();
		
	//	firefox.get("http://dl-jbs-lmi-002.auspac.net:9080/lmiOnline/");
		//**************************Mozilla Code ends************************************************
		
		//**********************IE Code***************************************************************
	/*	System.setProperty("webdriver.ie.driver", "C:\\Users\\889128\\Desktop\\Selenium Luna\\Project LMI\\Vishnu4.0\\bin\\Jar\\IEDriverServer.exe");
		DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();		
		capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
		capabilities.setCapability("requireWindowFocus", true);
		capabilities.setCapability("ignoreZoomSetting", true); 
		driver = new InternetExplorerDriver(capabilities);
		
		driver.manage().window().maximize();*/
		
		//***********************IE Code Ends**********************************************************
                
	}
	
	@AfterMethod
	  public void afterMethod() throws Exception {	   
		
		  //Log.endTestCase(sTestCaseName);
		  
		  //		if (driver!=null)
			//	  {
		  //			driver.close();
		//		  }
		 
		    
		 //   Extend_Report.Clean_Up();
		 
		   
	  		}
	
	}
	
 