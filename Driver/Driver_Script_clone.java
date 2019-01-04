package Driver;

import java.io.File;
import java.lang.reflect.Method;
import java.util.ArrayList;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageObjects.BaseClass;
import utility.Constant;
import utility.ExcelUtils;
import utility.Extend_Report;
import utility.Log;
import utility.Utils;


public class Driver_Script_clone {
	public WebDriver driver;
	private String sTestCaseName;
	private int iTestCaseRow;	
	
	ArrayList<String> arr = new ArrayList<String>();
	String page_name;
	
  @BeforeMethod
  public void beforeMethod() throws Exception {
	  
	  	DOMConfigurator.configure("log4j.xml");	 
	  	sTestCaseName = this.toString();
	  	sTestCaseName = Utils.getTestCaseName(this.toString());	  	
	  	ExcelUtils.GetTCExecute(arr);	  	
	  	
        }
  
  @SuppressWarnings({ "unused", "rawtypes" })
  
@Test
  public void f() throws Exception {
	 
	// search for real path:
	  String currentDir = System.getProperty("user.dir");
	  String Path_ALMOTA = currentDir+"//src//Jar//OTA32bit.vbs";
       	  
	//******************Commentes by richa for multiple screen implementation********
	/*  for(String  z:arr)
		  
		 {
			  ArrayList<String> keywords1 = new ArrayList<String>();
			 
			 try{
				 Class noparams[] = {};
				 String ExcelPath = Constant.Path_Excel + Constant.File_TestData;
				 int ntestcase = ExcelUtils.get_column("TestCaseName","Test_Case",ExcelPath);			
				 iTestCaseRow = ExcelUtils.getRowContains(z,ntestcase,"Test_Case",ExcelPath);						 
				  
				  ExcelUtils.GetKeywords(keywords1,iTestCaseRow);			  
				  for(String  k:keywords1)
				  {
					  //***************Commented by richa for the new implementation of 20 screen************************
					  	//split string based on _
					 	boolean k2=k.contains("_");
					 	//if (k2)
					  						  		
					  		page_name = k.split("_")[0];
		             		String page_iterator = k.split("_")[1];	
		             		ExcelUtils.create_ClassFiles(page_name);
					  	
					  	//else
					 	
					  		ExcelUtils.create_ClassFiles(k);
					 		  		
					  					  	
					  
				  }
				  
			
				 
			  }catch (Exception e){
				  System.out.println("Driver Script Error " +e.toString());
				  
				 
		 }
	}*/
	  for(String  i:arr)
	 {
		 // System.out.println(Constant.Newtestcase);   
		  ArrayList<String> keywords = new ArrayList<String>();
			 
			 try{
				 Class noparams[] = {};
				 Extend_Report.Set_Header(i); 
				 
				 //****************Commented by richa ********************//
				/* String ExcelPath = Constant.Path_Excel + Constant.File_TestData;
				 int ntestcase = ExcelUtils.get_column("TestCaseName","Test_Case",ExcelPath);			
				 iTestCaseRow = ExcelUtils.getRowContains(i,ntestcase,"Test_Case",ExcelPath);*/
				 //*******************************************************//
				 
				    String ExcelPath = Constant.Path_Excel + Constant.File_RunManager;  
					int nBrowserNo = ExcelUtils.get_column("Login_Browser_Type","Run_Manager",ExcelPath);	
					int ntestcaseNo = ExcelUtils.get_column("Test Case Name","Run_Manager",ExcelPath);
					int iTestCaseRow = ExcelUtils.getRowContains(i,ntestcaseNo,"Run_Manager",ExcelPath);
					Constant.sBrowserName = ExcelUtils.getCellData(iTestCaseRow,nBrowserNo);
					int AppUrl = ExcelUtils.get_column("Web_Url","Run_Manager",ExcelPath);
					Constant.ENV_URL = ExcelUtils.getCellData(iTestCaseRow,AppUrl);
				  driver = Utils.OpenBrowser(iTestCaseRow);		
				//  new BaseClass(driver);
				  ExcelPath = Constant.Path_Excel + Constant.File_TestData;
				  iTestCaseRow = ExcelUtils.getRowContains(i,ntestcaseNo,"Test_Case",ExcelPath);
				  Log.startTestCase(i); 
				  ExcelUtils.GetKeywords(keywords,iTestCaseRow);				  
			  for(String  k:keywords)
			  {
				  
				  	//split string based on _
				  	boolean k2=k.contains("-");
				  	if (k2)
				  	{
				  		int val_run=ExcelUtils.getRowContains_manager(i, 0, "Run_Manager");
						 
						 String status=ExcelUtils.getCellData(val_run, 2);
						 
						 if (!(status.equalsIgnoreCase("")))
						 {
							 ExcelUtils.setCellData_Manager("", val_run, 2);
						 }
						 Constant.page_name = k.split("_")[0];
				  		String page_name = k.split("_")[0];
	             		String page_iterator = k.split("_")[1];	
	             		//ExcelUtils.create_ClassFiles(page_name);
				  		System.out.println(" Executing Component Name :  " + page_name);
				  		System.out.println(" Executing Component Iteration :  " + page_iterator);
					  	Extend_Report.AddReport("Calling Component  :"+ page_name, "info"); 
					  	String k1="appModules"+"."+page_name;
					  	String dogClassName = k1;
				        Class<?> dogClass = Class.forName(dogClassName); // convert string classname to class
				        Object dog = dogClass.newInstance(); // invoke empty constructor
				        String methodName = "";
				        methodName = "Execute";
				        Method setNameMethod = dog.getClass().getMethod(methodName,int.class,String.class);
				        int rowval = ExcelUtils.getRowContains_iterator(i,0,page_name,page_iterator);
				        String Tcpath=Constant.currentDir;				        
						boolean success = (new File(Constant.Path_ScreenShot+i)).mkdirs();				     
				        Constant.TC_Name=Constant.Path_ScreenShot+i+"//";   
				      
				        setNameMethod.invoke(dog,rowval,i); // pass arg
				  			
				  	}
				  	else
				  	{
				  		int val_run=ExcelUtils.getRowContains_manager(i, 0, "Run_Manager");
						 
						 String status=ExcelUtils.getCellData(val_run, 6);
						 
						 if (!(status.equalsIgnoreCase("")))
						 {
							 ExcelUtils.setCellData_Manager("", val_run, 6);
						 }
				  		//ExcelUtils.create_ClassFiles(k);
				  		Constant.page_name = k;
				  		System.out.println(" Executing Component Name :  " + k);
					  	Extend_Report.AddReport("Calling Component  :"+ k, "info"); 
					  	String k1="appModules"+"."+k;
					  	String dogClassName = page_name;
					  	//dogClassName.contains(page_name);
				        Class<?> dogClass = Class.forName(dogClassName); // convert string classname to class
				        
				        Object dog = dogClass.newInstance(); // invoke empty constructor
				        String methodName = "";
				        methodName = "Execute";
				        Method setNameMethod = dog.getClass().getMethod(methodName,int.class,String.class);
				        ExcelPath = Constant.Path_Excel + Constant.File_TestData;
				        int rowval = ExcelUtils.getRowContains(i,0,k,ExcelPath);	
				        String Tcpath=Constant.currentDir;
				       
				        boolean success = (new File(Constant.Path_ScreenShot+i)).mkdirs();				     
				        Constant.TC_Name=Constant.Path_ScreenShot+i+"//";
				       // System.out.println(Constant.TC_Name);
				        setNameMethod.invoke(dog,rowval,i); // pass arg
				   	 
				  	}
				  	
				  
			  }
			  
		
			  
			  Log.endTestCase(i);			  
		  		if (driver!=null)
				  {
		  			driver.quit();
				  }	 
		    
		  	Extend_Report.Clean_Up();
		  	
		  }catch (Exception e){
			  
					
			  System.out.println("Driver Script Error " +e.toString());
			  Log.endTestCase(sTestCaseName);
			  
		  		if (driver!=null)
				  {
		  			driver.quit();
				  }	 
		  		 ExcelUtils.setExcelFile(Constant.Path_Excel+Constant.File_RunManager, "Run_Manager");		
				 
				 int val_run=ExcelUtils.getRowContains_manager(i, 0, "Run_Manager");
				 
				 ExcelUtils.setCellData_Manager("FAIL", val_run, 6);
		  		Extend_Report.Clean_Up();  
			  Log.error(e.getMessage());
			  
			/*  ****Commented by richa  ...ALM should be updated after all the exceution is completed
			  Runtime.getRuntime().exec(new String[] {
				      "wscript.exe", Path_ALMOTA
				      });  	 */ 
			 
		  }
			
		 ExcelUtils.setExcelFile(Constant.Path_Excel+Constant.File_RunManager, "Run_Manager");		
		 
		 int val_run=ExcelUtils.getRowContains_manager(i, 0, "Run_Manager");
		 
		 String status=ExcelUtils.getCellData(val_run, 6);	
		
		 System.out.println("Status :" +status);
		 
		 if (!(status.equalsIgnoreCase("FAIL")))
		 {
			 ExcelUtils.setCellData_Manager("PASS", val_run, 6);
			 
			 /*  ****Commented by richa  ...ALM should be updated after all the exceution is completed 
			 Runtime.getRuntime().exec(new String[] {
				      "wscript.exe", Path_ALMOTA
				      });  	 */ 
		 }
		 else if(status.equalsIgnoreCase(""))
		 {
			 ExcelUtils.setCellData_Manager("PASS", val_run, 6); 
			/* Runtime.getRuntime().exec(new String[] {
				      "wscript.exe", Path_ALMOTA
				      });  	 */
		 }
	 }
	  
	  
	  Runtime.getRuntime().exec(new String[] {
		      "wscript.exe", Path_ALMOTA
		      });  
	  
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
