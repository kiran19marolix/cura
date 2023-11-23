package testcase;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.basetest.Basetest;
import com.pageobjects.LoginPage;
import com.utils.Utils;

public class LoginTest extends Basetest {
    LoginPage lp;
	
	public LoginTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		initialization();
	    lp = new LoginPage();
	    
	}
	
	@Test (priority = 1)
	public void loginvalidation() {
		lp.verifylogin();
		
		String urltest = driver.getCurrentUrl();
		Assert.assertEquals(urltest, "https://katalon-demo-cura.herokuapp.com/#appointment");
	}
	
	@Test (priority = 2)
	public void invalidloginvalidation() {
		lp.invalidverifylogin();
		
		String urltest = driver.getCurrentUrl();
		Assert.assertEquals(urltest, "https://katalon-demo-cura.herokuapp.com/#appointment");
		
	}
	
	@AfterMethod
	public void teardown(ITestResult result) {
		if(result.getStatus() == ITestResult.FAILURE) {
			
			String filename = result.getMethod().getMethodName() + "-"  + ".png";
			Utils.takescreenshot(filename);
		}
	}
}
