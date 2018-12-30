package weathermap;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class openWeatherMap {

	static WebDriver driver;
	String baseUrl = "https://openweathermap.org/";

	@BeforeMethod

	public void siteLaunch() {

		System.setProperty("webdriver.chrome.driver", "D:\\chrome driver\\chromedriver.exe");

		driver= new ChromeDriver();

		driver.get(baseUrl);	  

		driver.manage().window().maximize();

	}


		//Test case 3 - Verifies that website successfully returns weather details for the city.
	@Test(priority=2)
	public void validSearch()
	{
		driver.findElement(By.id("nav-search")).click();
		driver.findElement(By.xpath("//*[@id=\"q\"]")).sendKeys("Mumbai");

		driver.findElement(By.xpath("//*[@id=\"nav-search-form\"]/div/span")).click();

		String expectedSearchTitle = "Find - OpenWeatherMap";

		// fetch the title of the web page and save it into a string variable
		String actualSearchTitle = driver.getTitle();

		//Asserts page title
		assert(actualSearchTitle.contentEquals(expectedSearchTitle));

		System.out.println("Page title : " + actualSearchTitle);

		// fetch the text of the element and save it into the string variable
		String searchResult = driver.findElement(By.xpath("//*[@id=\"forecast_list_ul\"]/table/tbody/tr/td[2]")).getText();

		String searchValue=driver.findElement(By.xpath("//*[@id=\"search_str\"]")).getText();

		//check the search result is same as search value
		if(searchResult.contains(searchValue))
		{
			System.out.println("Search result matches with search value");

		}
		
		else 
		{
			System.out.println("Search result doesn't match with search value");
		}

		//Go back to Home
		driver.findElement(By.xpath("//*[@id=\"undefined-sticky-wrapper\"]/div/div/div/div[1]/a/img")).click();

	}

	// Test case 1 - Verifies that all important information is there
	@Test(priority=0)
	public void verifyInfoOnHome() {

		//declare and initialize the variable to store the expected title
		String expectedTitle = "Сurrent weather and forecast - OpenWeatherMap";

		// fetch the title of the web page and save it into a string variable
		String actualTitle = driver.getTitle();

		// compare the expected title of the page with the actual title of the page and print the result
		if (expectedTitle.equals(actualTitle))

		{
			System.out.println("Verification Successful - The correct title is displayed on the web page.");
		}

		else

		{
			System.out.println("Verification Failed - An incorrect title is displayed on the web page.");
		}

		// verify if the “Support Center” button is displayed

		boolean supportCenterPresence=driver.findElement(By.linkText("Support Center")).isDisplayed();

		System.out.println(supportCenterPresence);

		// verify if the “Search” text box is dsiplayed

		WebElement searchTextBox = driver.findElement(By.id("nav-search"));

		boolean searchTextBoxPresence=searchTextBox.isDisplayed();

		System.out.println("Search box presence: "+searchTextBoxPresence);

		// verify if the “Sign in” text box is displayed

		boolean signInPresence = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[1]/a[3]")).isDisplayed();

		System.out.println("Sign in option presence: "+signInPresence);

		// verify if the “Sign in” text box is displayed

		boolean signUpPresence = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[1]/a[2]")).isDisplayed();

		System.out.println("Sign up option presence: "+signUpPresence);

		// verify that the “Search button” is displayed 

		WebElement tempUnits = driver.findElement(By.id("metric"));

		boolean celsiusUnitSelect=tempUnits.isSelected();

		if(celsiusUnitSelect==true)
		{
			System.out.println("Tempeture of the city is shown in Celsius units");
		}

		else {
			System.out.println("Tempeture of the city is shown in Fahrenheit units");
		}

		// verify that brand logo is present

		boolean logo=driver.findElement(By.xpath("//*[@id=\"undefined-sticky-wrapper\"]/div/div/div/div[1]/a/img")).isDisplayed();

		System.out.println("Brand logo presence: "+logo);

		// verify that weather temp is displayed
		boolean tempWidget = driver.findElement(By.xpath("//*[@id=\"weather-widget\"]/h3")).isDisplayed();
		if(tempWidget!=false)
		{
			String weatherTemp = driver.findElement(By.xpath("//*[@id=\"weather-widget\"]/h3")).getText();
			System.out.println("weather in your city is " +weatherTemp);
		}

		else
			System.out.println("Weather information is not present");

		// verify that brand logo is present

		boolean menuWeather=driver.findElement(By.linkText("Weather")).isDisplayed();

		System.out.println(menuWeather);

		// verify that Search box and Search button is present

		//WebDriverWait waitVariable = new WebDriverWait(driver, 20);
		//waitVariable.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"q\"]")));

		boolean searchBox=driver.findElement(By.xpath("//*[@id=\"q\"]")).isDisplayed();

		boolean searchButton=driver.findElement(By.xpath("//*[@id=\"searchform\"]/button")).isDisplayed();

		System.out.println("Search box presence: " + searchBox);

		System.out.println("Search button presence: " + searchButton);

		// verify that "Current location" is present

		boolean currentLocLink=driver.findElement(By.xpath("//*[@id=\"searchform\"]/span/button")).isDisplayed();

		System.out.println("Current location link presence" + currentLocLink);

		//This Asserts the presence of Header "Current weather and forecasts in your city"

		Assert.assertTrue(driver.getPageSource().contains("Current weather and forecasts in your city"));

		// Verify presence of all tabs 

		boolean mainTab=driver.findElement(By.linkText("Main")).isDisplayed();
		if(mainTab==true) {
			System.out.println("Main tab is present");
		}
		else
		{
			System.out.println("Main tab is not present");
		}

		boolean dailyTab=driver.findElement(By.linkText("Daily")).isDisplayed();
		if(dailyTab==true) {
			System.out.println("Daily tab is present");
		}
		else
		{
			System.out.println("Daily tab is not present");
		}

		boolean hourlyTab=driver.findElement(By.linkText("Hourly")).isDisplayed();
		if(hourlyTab==true) {
			System.out.println("Hourly tab is present");
		}
		else
		{
			System.out.println("Hourly tab is not present");
		}

		boolean chartTab=driver.findElement(By.linkText("Chart")).isDisplayed();
		if(chartTab==true) {
			System.out.println("Chart tab is present");
		}
		else
		{
			System.out.println("Chart tab is not present");
		}

		boolean mapTab=driver.findElement(By.linkText("Map")).isDisplayed();
		if(mapTab==true) {
			System.out.println("Map tab is present");
		}
		else
		{
			System.out.println("Map tab is not present");
		}

		boolean chart=driver.findElement(By.xpath("//*[@id=\"widget\"]/div/div/div[3]/div[2]/span/span/div[1]/div")).isDisplayed();
		if(chart==true)
		{
		System.out.println("Weather Chart is present");
		}

		else {
			System.out.println("Weather chart is not present");
		}

		boolean forecastIcons = driver.findElement(By.xpath("//*[@id=\"widget\"]/div/div/div[3]/div[2]/span/span/div[2]")).isDisplayed();
		if(forecastIcons==true)
		{
			System.out.println("Forecast Icons are present");
		}

		else
		{
			System.out.println("Forecast Icons are not present");
		}
	}


	// Test case 2 - Verifies that website suggests city is Not found
	@Test(priority=1)
	public void invalidSearch()
	{
		driver.findElement(By.id("nav-search")).click();;
		driver.findElement(By.xpath("//*[@id=\"q\"]")).sendKeys("abc");//*[@id="q"]

		driver.findElement(By.xpath("//*[@id=\"nav-search-form\"]/div/span")).click();

		String expectedSearchTitle = "Find - OpenWeatherMap";

		// fetch the title of the web page and save it into a string variable
		String actualSearchTitle = driver.getTitle();

		//Asserts page title
		assert(actualSearchTitle.contentEquals(expectedSearchTitle));

		System.out.println("Page title : " + actualSearchTitle);

		String actualErrMsg = driver.findElement(By.xpath("//*[@id=\"forecast_list_ul\"]/div")).getText();

		// Asserts error message for invalid search 
		if(actualErrMsg.contains("Not found"))
		{
			System.out.println("Result for search value is: " + actualErrMsg);

			driver.findElement(By.xpath("//*[@id=\"undefined-sticky-wrapper\"]/div/div/div/div[1]/a/img")).click();
		}

	}

	
	//Test case - 4 To verify user sign up

	@Test(priority=3)
	public void userSignUp() throws InterruptedException
	{
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div[1]/a[2]")).click();
		Assert.assertEquals(driver.getTitle(), "Members");

		WebElement userName = driver.findElement(By.id("user_username"));
		WebElement email = driver.findElement(By.id("user_email"));
		WebElement password = driver.findElement(By.id("user_password"));
		WebElement cnfrmPassword = driver.findElement(By.id("user_password_confirmation"));

		userName.sendKeys("username_Test");
		email.sendKeys("test.id@gmail.com");
		password.sendKeys("test@123");
		cnfrmPassword.sendKeys("test@123");

		WebElement ageChkBox = driver.findElement(By.id("agreement_is_age_confirmed"));

		Thread.sleep(5000);
		boolean ageCheckboxIsSelected = ageChkBox.isSelected();

		System.out.println("age checkbox status: "+ageCheckboxIsSelected);

		ageChkBox.click();

		WebElement tcChkBox = driver.findElement(By.id("agreement_is_accepted"));

		boolean tcCheckboxIsSelected = tcChkBox.isSelected();

		System.out.println("T&C checkbox status: "+tcCheckboxIsSelected);

		tcChkBox.click();

		JavascriptExecutor js = (JavascriptExecutor) driver;  

		WebElement scrollEle = driver.findElement(By.xpath("//*[@id=\"new_user\"]/div[11]/input"));
		//This will scroll the page till the element is found		
		js.executeScript("arguments[0].scrollIntoView();", scrollEle);

		//boolean capBox = driver.findElement(By.xpath("//*[@id=\"recaptcha-anchor-label\"]/text()")).isDisplayed();//*[@id="new_user"]/div[10]////*[@id="new_user"]/div[10]/div
		//*[@id="new_user"]/div[10]/div/div

		//iframe element
		WebElement iframeEle = driver.findElement(By.xpath("//*[@id=\"new_user\"]/div[10]/div/div/div/iframe"));
		driver.switchTo().frame(iframeEle);
		driver.findElement(By.xpath("/html/body/div[2]/div[3]")).click();
		//System.out.println(capBox);
		driver.switchTo().defaultContent();
		Thread.sleep(5000);

		driver.findElement(By.xpath("//*[@id=\"new_user\"]/div[11]/input")).click();

		if(driver.findElement(By.xpath("//*[@id=\"poll_modal\"]/div/div")).isDisplayed())
		{
			driver.findElement(By.xpath("//*[@id=\"poll_modal\"]/div/div/div[3]/form/input[1]")).click();

			String helloUsrname = driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/a[2]")).getText();

			assert(helloUsrname.contentEquals("Hello"));//html/body/div[2]/div[3]/div[2]/div
		}

	}

	@AfterMethod
	public void afterMethod() {
		driver.close();
	}

}
