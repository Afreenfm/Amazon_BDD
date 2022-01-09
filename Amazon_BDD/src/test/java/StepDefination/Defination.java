package StepDefination;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ByClassName;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.internal.FindsByClassName;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;

public class Defination {

	public static WebDriver driver;
	public WebElement element;

	//Before hook − Set up the web driver and other prerequisites to run the test.
	@Before public void setUp(){ 
		
		
		WebDriverManager.chromedriver().setup();
		driver =  new ChromeDriver();
		driver.manage().window().maximize();
		

	}
	

@Given("i should open the browser")
public void i_should_open_the_browser() {
	//opens amazon
	driver.get("https://www.amazon.com");
}
//Pre-requisite
@Given("navigate to home page of amazon.com and signup")
public void navigate_to_home_page_of_amazon_com_and_signup() throws InterruptedException, IOException {
	//Login //
	//clicks on signin 
	driver.findElement(By.linkText("Sign in")).click();
	//enters email 
	driver.findElement(By.xpath("//*[@id='ap_email']")).sendKeys("Indiakarnataka18@gmail.com");
	//clicks on continue
	driver.findElement(By.xpath("//*[@id='continue']")).click();	
	//clicks on pwd
	driver.findElement(By.xpath("//*[@id='ap_password']")).sendKeys("Tom2jerry!");
	//clicks on submit
	driver.findElement(By.xpath("//*[@id='signInSubmit']")).click();
	//compares values
	 String name = driver.findElement(By.id("nav-link-accountList-nav-line-1")).getText();
	    System.out.println(name);
	    Assert.assertEquals(name, "Hello, Tom");
	    Thread.sleep(3000);
	    File screenshot =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshot, new File("C:\\Users\\Admin\\Desktop\\image\\1.png"));
}

				
//TC_001
		@When("enter searchtext as {string}")
		public void enter_searchtext_as(String searchtext) throws InterruptedException {
			//compare search text n auto searched result
			WebElement elementtotype = driver.findElement(By.id("twotabsearchtextbox"));
			Actions act = new Actions(driver);
			act.sendKeys(elementtotype, searchtext).build().perform();
			Thread.sleep(3000);
  
 }
		@Then("i should c searchedtext as {string}")
		public void i_should_c_searchedtext_as(String searchtext) throws InterruptedException, IOException {
			Thread.sleep(3000);
			System.out.println(searchtext);
			Thread.sleep(3000);
			String expected = driver.findElement(By.className("s-suggestion-container")).getText();
			System.out.println(expected);
			String sub = expected.substring(0,1);
			Thread.sleep(3000);
			Assert.assertEquals(searchtext, sub);
			System.out.println("both r equal");
			File screenshot =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenshot, new File("C:\\Users\\Admin\\Desktop\\image\\2.png"));
		}
	
		
//TC_002
		

		@When("enter product in search text")
		public void enter_product_in_search_text() {
			//click on search bar n enters value
		 driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']")).sendKeys("Pen");
		 
		}

		@When("click on search icon")
		public void click_on_search_icon() throws InterruptedException, IOException {
			//clicks on search icon
		   driver.findElement(By.id("nav-search-submit-button")).click();
		   Thread.sleep(3000);
		   File screenshot =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenshot, new File("C:\\Users\\Admin\\Desktop\\image\\3.png"));
		}
		
		
//search history
		//tc_001
		@When("click on Accounts&lists and then on Account")
		public void click_on_accounts_lists_and_then_on_account() throws InterruptedException {
			Thread.sleep(3000);
			//click on account list
			driver.findElement(By.id("nav-link-accountList")).click();
			
			
			
		}

		@When("click Browsing history")
		public void click_browsing_history() throws InterruptedException, IOException {
			Thread.sleep(3000);
			//click on browsing history
			driver.findElement(By.id("nav-recently-viewed")).click();
			File screenshot =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenshot, new File("C:\\Users\\Admin\\Desktop\\image\\4.png"));
		}
			
//tc_002
			@When("Go to user Account")
			public void go_to_user_account() throws InterruptedException {
				Thread.sleep(4000);
				//click on account list
				driver.findElement(By.id("nav-link-accountList")).click();
				Thread.sleep(3000);
				//click on browsing history
				driver.findElement(By.id("nav-recently-viewed")).click();
				Thread.sleep(3000);
			}

			@When("Click on Turn recently viewed items\\(Browsing History)to OFF")
			public void click_on_turn_recently_viewed_items_browsing_history_to_off() throws InterruptedException, IOException {
				//clicks on manage history
				driver.findElement(By.xpath("//*[@class ='a-icon a-icon-section-expand']")).click();
				//Thread.sleep(3000);
				//driver.findElement(By.xpath("//*[@class = 'a-icon a-icon-section-collapse']")).click();
				Thread.sleep(3000);
				//clicks on on/off
				driver.findElement(By.xpath("//*[@class='a-switch-label a-declarative']")).click();
				Thread.sleep(3000);
				File screenshot =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(screenshot, new File("C:\\Users\\Admin\\Desktop\\image\\5.png"));
			}
		
			
//search side bar
//tc_001		
			@When("I Enter search text in search field")
			public void i_enter_search_text_in_search_field() throws InterruptedException {
				 Thread.sleep(3000);
				//click on search bar n enters value
				 driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']")).sendKeys("books");
					//clicks on search icon
				   driver.findElement(By.id("nav-search-submit-button")).click();
				   Thread.sleep(3000);
			}

			@Then("Click on All Categories")
			public void click_on_all_categories() throws InterruptedException, IOException {
				//click on books dropdown
			   driver.findElement(By.xpath("//*[@class = 'nav-search-scope nav-sprite']")).click();
			   Thread.sleep(3000);
			   //select all frm dropdown
			 
			   WebElement cc = driver.findElement(By.xpath("//*[@class='nav-search-dropdown searchSelect nav-progressive-attrubute nav-progressive-search-dropdown']")); //for dropdown boxes
				Select sel1= new Select(cc);
				sel1.selectByVisibleText("All Departments");
				File screenshot =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(screenshot, new File("C:\\Users\\Admin\\Desktop\\image\\6.png"));
			   
			}
			
//tc_002
			
			@When("I Enter search text in search field and click on search icon")
			public void i_enter_search_text_in_search_field_and_click_on_search_icon() throws InterruptedException {
				Thread.sleep(3000);
				 driver.navigate().to("https://www.amazon.in");
					Thread.sleep(3000);
					//click on search bar n enters value
					 driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']")).sendKeys("books");
						//clicks on search icon
					   driver.findElement(By.id("nav-search-submit-button")).click();
					   Thread.sleep(3000);
				
				   
			}
			@Then("click on Sort by and select low to high")
			public void click_on_sort_by_and_select_low_to_high() throws InterruptedException, IOException {
			 driver.findElement(By.xpath("//*[@id ='a-autoid-0-announce']")).click();
			 Thread.sleep(3000);
			 driver.findElement(By.xpath("//*[@id ='s-result-sort-select_1']")).click();
			 
			 File screenshot =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(screenshot, new File("C:\\Users\\Admin\\Desktop\\image\\7.png"));
			}
			
			//After hook − Close the webdriver and do the cleanup process
			@After public void cleanUp() throws InterruptedException{ 
				 Thread.sleep(3000);
			      driver.close(); 
			   }
	}


