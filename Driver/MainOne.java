package Driver;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.testng.TestListenerAdapter;
import org.testng.TestNG;
     


public class MainOne {
	
	public static void main (String[] args) {
		
		Calendar cal = Calendar.getInstance();
		DateFormat DF = new SimpleDateFormat("dd/MM/yyyy");
		Date TodayDate = cal.getTime();
		cal.add(Calendar.DATE, 65);
		Date FutDate = cal.getTime();
		
        if (TodayDate.after(FutDate)){
			
			System.out.println("JAR REACHED THE EXPIRATION DATE");
		}
        else {       	
        
		TestListenerAdapter tla = new TestListenerAdapter();
		TestNG testng = new TestNG();
		Class[] classes = new Class[] {Driver_Script.class};
		//testng.setTestClasses(new Class[] { Driver.Driver_Script.class});
		testng.setTestClasses(classes);
		testng.addListener(tla);
		testng.run();
        }
		
	}

}
