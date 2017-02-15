package steelcase.gittest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class AppTest 
{
	private WebDriver driver = null;
	
	@Test
	public void RegisterNewUser(){
		System.setProperty("webdriver.chrome.driver", "C:\\workspaceV\\Libraries\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://qastore.steelcase.com/");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		System.out.println("Opening Browser...");
        System.out.println("Looking for LOGIN button...");
        
        driver.findElement(By.partialLinkText("REGISTER")).click();
        System.out.println("Clicking Login/Register...");
        
        driver.findElement(By.partialLinkText("Register Now")).click();
        System.out.println("Clicking on Register Now...");
        
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        System.out.println("Waiting to load registration page...");
       
        String title = driver.findElement(By.xpath("//*[@id=\"top\"]/body/div[1]/div[2]/div[4]/div/div/div[2]/div/h1")).getText();
        if (title.equals("Create an Account")){
        	System.out.println("\nRegistration page loaded succesfully!!!");
        }
        else{
        	System.out.println("\nCouldn't find registration page :(");
        }
        driver.quit();
	}
}
