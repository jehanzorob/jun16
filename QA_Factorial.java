package may25;

import  org.testng.Assert;
import static org.testng.Assert.assertEquals;
import java.util.concurrent.TimeUnit;
//import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

public class QA_Factorial {

	public static void main(String[] args) throws Exception  {
		
		SoftAssert softAssert = new SoftAssert();
		
		System.setProperty("webdriver.chrome.driver", "D:\\SeleniumCourse\\src\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://qainterview.pythonanywhere.com/");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		//@test
		String expectedResult = "Factorial";
	    String actualResult = driver.getTitle();
	    System.out.println(actualResult);
		try {assertEquals(actualResult, expectedResult);}
		catch(AssertionError ae ) {
		//takeScreenshot("verifySearchBtnDisabled");
		System.out.println("Regression Failed");
		softAssert.fail("Regression Failed :" + ae);
		}
		
        //@test
			
			WebElement introText = driver.findElement(By.cssSelector("body > div.container.toppy > div:nth-child(1) > div > h1"));		
			String actualAppIntro = introText.getText();
			System.out.println(actualAppIntro);
			String expectedAppIntro = "The greatest factorial calculator!";
			try {assertEquals(actualAppIntro, expectedAppIntro);}
			catch(AssertionError ae) {
				//takeScreenshot("verifySearchBtnDisabled");
				System.out.println("Regression Failed");
				softAssert.fail("Regression Failed :" + ae);
			}
					
		//@test
			
			WebElement inputfield = driver.findElement(By.name("number"));
		    inputfield.sendKeys("0");
		    WebElement btnCalculate = driver.findElement(By.id("getFactorial"));
		    btnCalculate.click();
		   
		    String expectedZeroFactorial = "The factorial of 0 is: 1";
		    Thread.sleep(1000);
		    String actualCalulation = driver.findElement(By.id("resultDiv")).getText();
		    System.out.println(actualCalulation);
		    try {assertEquals(actualCalulation, expectedZeroFactorial);}
			catch(AssertionError ae) {
				//takeScreenshot("verifySearchBtnDisabled");
				System.out.println("Regression Failed");
				softAssert.fail("Regression Failed :" + ae);
			}
		  //@test
		   String expectedErrorMSG = "Please enter an integer";
		   inputfield.clear();
		   inputfield.sendKeys("0K");
		   btnCalculate.click();
		   actualCalulation =driver.findElement(By.id("resultDiv")).getText();
		   System.out.println(actualCalulation);
		   try {assertEquals(actualCalulation, expectedErrorMSG);}
			catch(AssertionError ae) {
				//takeScreenshot("verifySearchBtnDisabled");
				System.out.println("Regression Failed");
				softAssert.fail("Regression Failed :" + ae);
			} 
		    
		    driver.close();
			 
		}
		

	     
	}

	


