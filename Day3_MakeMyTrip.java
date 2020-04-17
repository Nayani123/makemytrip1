package seleniumPractiseSessions;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Day3_MakeMyTrip {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		//1.Launch URL
		driver.get("https://www.makemytrip.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//2.Click Hotels
		driver.findElementByXPath("//span[@class='chNavIcon appendBottom2 chSprite chHotels']").click();
		
		//3.Enter city as Goa, and choose Goa, India
		driver.findElementById("city").click();
		driver.findElementByXPath("//input[@aria-autocomplete='list']").sendKeys("Goa");
		driver.findElementByXPath("//p[text()='Goa, India']").click();
		
		//4.Enter Check in date as Next month 15th (May 15) and Check out as start date+5
		driver.findElementByXPath("(//div[text()='15'])[2]").click();
		String check_in = driver.findElementByXPath("(//div[text()='15'])[2]").getText();
		System.out.println(check_in);
		
		//int StartDate = Integer.parseInt(check_in);
		
		
		driver.findElementByXPath("//div[@aria-label='Wed May 20 2020']").click();
		
		//5.Click on ROOMS & GUESTS and click 2 Adults and one Children(age 12). Click Apply Button.
		driver.findElementById("guest").click();
		driver.findElementByXPath("//li[@data-cy='adults-2']").click();
		driver.findElementByXPath("//li[@data-cy='children-1']").click();
		WebElement dropdown = driver.findElementByClassName("ageSelectBox");
		Select dropdown1=new Select(dropdown);
		dropdown1.selectByVisibleText("12");
		driver.findElementByXPath("//button[text()='APPLY']").click();
		
		//6.Click Search button
        driver.findElementByXPath("//button[text()='Search']").click();
        Thread.sleep(3000);
        driver.findElementByXPath("//a[@class='mapCont']").click();
        driver.findElementByXPath("//span[@class='mapClose']").click();
		
		//7.Select locality as Baga
        JavascriptExecutor  js=(JavascriptExecutor) driver;  //page scrolldown
        js.executeScript("window.scrollBy(0,500)");
        Thread.sleep(2000);
        driver.findElementByXPath("//label[@for='mmLocality_checkbox_35']").click();
        
    
        
       //8. Select 5 start in Star Category under Select Filters
       
        JavascriptExecutor  js1=(JavascriptExecutor) driver;  //page scrolldown
        js1.executeScript("window.scrollBy(0,1000)");
        Thread.sleep(2000);
   
		driver.findElement(By.xpath("//label[text()='5 Star']")).click();
		Thread.sleep(3000);
		
		
		//9.Click on the first resulting hotel and go to the new window
		driver.findElementById("htl_id_seo_201801171522004728").click();
		JavascriptExecutor  js2=(JavascriptExecutor) driver;  //page scrolldown
        js2.executeScript("window.scrollBy(0,1000)");
		//driver.findElementById("htl_id_seo_201610141546046148").click();
		Set<String> firsthote = driver.getWindowHandles();
		List<String> firsthotel1=new ArrayList<String>(firsthote);
		driver.switchTo().window(firsthotel1.get(1));
		
		//10.Print the Hotel Name
		String hotelname = driver.findElementByXPath("//h1[text()='The Park Baga River Goa']").getText();
		//String hotelname = driver.findElementById("htl_id_seo_201610141546046148").getText();
		System.out.println(hotelname);
		
		
		 //11.Click MORE OPTIONS link and Select 3Months plan and close
		driver.findElementByXPath("//span[@class='latoBold font10 blueText pointer']").click();
		driver.findElementByXPath("(//span[text()='SELECT'])[1]").click();
		driver.findElementByXPath("//span[@class='close']").click();  
	
		
		//12.Click on BOOK THIS NOW
		//driver.findElementById("htl_id_seo_201610141546046148").click();
		//driver.findElementByLinkText("BOOK THIS NOW").click();
		
		//13. Print the Total Payable amount
		
		//14.Close the browser
        driver.quit();
		
		
		
		
		
		
		
		
		
		
		
		
		

	}

}
