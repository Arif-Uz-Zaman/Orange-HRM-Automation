package com.test;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DashBoardPageTest {

	WebDriver driver;
	
	

	@BeforeClass
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "C:\\\\Driver\\\\chromedriver-win64\\\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.elementToBeClickable(By.name("username")));
		WebElement emailPhoneField = driver.findElement(By.name("username"));
        emailPhoneField.click(); // Ensure the field is focused
        emailPhoneField.clear();
        WebElement passwordField = driver.findElement(By.name("password"));

        // Enter the provided credentials
        emailPhoneField.sendKeys("Admin");
        passwordField.sendKeys("admin123");
        
        // Locate and click on the login button
        WebElement loginButton = driver.findElement(By.xpath("//button[@type=\"submit\"]"));
        loginButton.click();
        
        try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			
		}
		
		
	}
	
	
	@Test(priority=2,groups="Page Tiitle")
	public void test_DashboardNavigation() {
		//verify navigation to the Dash board page
		String Expected_page_Title = "Dashboard";
		String Actual_page_Title= driver.findElement(By.xpath("//span[@class=\"oxd-topbar-header-breadcrumb\"]")).getText();
		
		Assert.assertEquals(Actual_page_Title,Expected_page_Title);
	}
	
	@Test(priority=3,dependsOnMethods="test_DashboardNavigation",groups="Board Visibility")
	public void test_Time_at_Work_BoardVisibility() {
		//verifying the board is visible on dashboard
		boolean status = driver.findElement(By.xpath("//p[text()=\"Time at Work\"]")).isDisplayed();
		Assert.assertTrue(status,"Board is not visiable");
		
		
	}
	
	@Test(priority=4,dependsOnMethods="test_Time_at_Work_BoardVisibility",groups="Icon Functionality")
	public void test_Stopwatch_IconRedirection() {
		// navigate stopwatch icon within "Time at Work" board
		
		driver.findElement(By.xpath("//button//i[@class=\"oxd-icon bi-stopwatch\"]")).click();
		
		//wait until page title is visible
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@class=\"oxd-topbar-header-breadcrumb\"]")));
		String Expected_page_Title = "Attendance";
		String Actual_Page_Title = driver.findElement(By.xpath("//span[@class=\"oxd-topbar-header-breadcrumb\"]//h6[@class=\"oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module\"]")).getText();
		System.out.println(Actual_Page_Title);
		Assert.assertEquals(Actual_Page_Title,Expected_page_Title);
		
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[8]/a")).click();
	}
	
	@Test(priority=5,dependsOnMethods="test_DashboardNavigation",groups="Board Visibility")
	public void test_My_Actions_BoardVisibility() {
		//verifying the board is visible on dashboard
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(3));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//p[text()=\"My Actions\"]")));
		boolean status = driver.findElement(By.xpath("//p[text()=\"My Actions\"]")).isDisplayed();
		Assert.assertTrue(status,"Board is not visiable");
		
		
	}
	
	@Test(priority=6,dependsOnMethods="test_DashboardNavigation",groups="Board Visibility")
	public void test_Quick_Launch_BoardVisibility() {
		//verifying the board is visible on dashboard
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(3));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//p[text()=\"Quick Launch\"]")));
		boolean status = driver.findElement(By.xpath("//p[text()=\"Quick Launch\"]")).isDisplayed();
		Assert.assertTrue(status,"Board is not visiable");
		
		
	}
	
	@Test(priority=7,dependsOnMethods="test_Quick_Launch_BoardVisibility",groups="Icon Visibility")
	public void test_Assign_Leave_IconVisibility_In_QuickLaunchBoard() {
		//verifying the board is visible on dashboard
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(3));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//p[text()=\"Assign Leave\"]")));
		boolean status = driver.findElement(By.xpath("//button[@title=\"Assign Leave\"]")).isDisplayed();
		boolean status1 = driver.findElement(By.xpath("//p[text()=\"Assign Leave\"]")).isDisplayed();
		
		Assert.assertTrue(status,"Board is not visiable");
		Assert.assertTrue(status1,"Text is not visiable");
		
		
	}
	
	@Test(priority=8,dependsOnMethods="test_Assign_Leave_IconVisibility_In_QuickLaunchBoard",groups="Icon Functionality")
	public void test_Assign_Leave_IconFunctionality() {
		//verifying assign leave icon is working

		driver.findElement(By.xpath("//button[@title=\"Assign Leave\"]")).click();
		
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(3));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span//h6[text()=\"Leave\"]")));
		
		String Expected_page_Title="Leave";
		String Actual_Page_Title = driver.findElement(By.xpath("//span//h6[text()=\"Leave\"]")).getText();
		
		String Expected_Page_Section = "Assign Leave";
		
		String Actual_Page_Section = driver.findElement(By.xpath("//ul//li//a[@class=\"oxd-topbar-body-nav-tab-item\" and text()=\"Assign Leave\"]")).getText(); 
		
		Assert.assertEquals(Actual_Page_Title, Expected_page_Title);
		Assert.assertEquals(Actual_Page_Section,Expected_Page_Section);
		
		// back to Dashboard Page
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[8]/a")).click();
		
	}
	
	@Test(priority=9,dependsOnMethods="test_Quick_Launch_BoardVisibility",groups="Icon Visibility")
	public void test_Leave_List_IconVisibility_In_QuickLaunchBoard() {
		//verifying the board is visible on dashboard
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(3));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//p[text()=\"Leave List\"]")));
		boolean status = driver.findElement(By.xpath("//button[@title=\"Leave List\"]")).isDisplayed();
		boolean status1 = driver.findElement(By.xpath("//p[text()=\"Leave List\"]")).isDisplayed();
		
		Assert.assertTrue(status,"Board is not visiable");
		Assert.assertTrue(status1,"Text is not visiable");
		
		
	}
	
	
	@Test(priority=10,dependsOnMethods="test_Leave_List_IconVisibility_In_QuickLaunchBoard",groups="Icon Functionality")
	public void test_Leave_List_IconFunctionality() {
		//verifying assign leave icon is working

		driver.findElement(By.xpath("//button[@title=\"Leave List\"]")).click();
		
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(3));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span//h6[text()=\"Leave\"]")));
		
		String Expected_page_Title="Leave";
		String Actual_Page_Title = driver.findElement(By.xpath("//span//h6[text()=\"Leave\"]")).getText();
		
		String Expected_Page_Section = "Leave List";
		
		String Actual_Page_Section = driver.findElement(By.xpath("//ul//li//a[@class=\"oxd-topbar-body-nav-tab-item\" and text()=\"Leave List\"]")).getText(); 
		
		Assert.assertEquals(Actual_Page_Title, Expected_page_Title);
		Assert.assertEquals(Actual_Page_Section,Expected_Page_Section);
		
		// back to Dashboard Page
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[8]/a")).click();
		
	}
	
	@Test(priority=11,dependsOnMethods="test_Quick_Launch_BoardVisibility",groups="Icon Visibility")
	public void test_Timesheets_IconVisibility_In_QuickLaunchBoard() {
		//verifying the board is visible on dashboard
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(3));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//p[text()=\"Timesheets\"]")));
		boolean status = driver.findElement(By.xpath("//button[@title=\"Timesheets\"]")).isDisplayed();
		boolean status1 = driver.findElement(By.xpath("//p[text()=\"Timesheets\"]")).isDisplayed();
		
		Assert.assertTrue(status,"Board is not visiable");
		Assert.assertTrue(status1,"Text is not visiable");
		
		
	}
	
	@Test(priority=12,dependsOnMethods="test_Timesheets_IconVisibility_In_QuickLaunchBoard",groups="Icon Functionality")
	public void test_Timesheets_IconFunctionality() {
		//verifying assign leave icon is working

		driver.findElement(By.xpath("//button[@title=\"Timesheets\"]")).click();
		
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(3));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span//h6[text()=\"Time\"]")));
		
		String Expected_page_Title="Time";
		String Actual_Page_Title = driver.findElement(By.xpath("//span//h6[text()=\"Time\"]")).getText();
		
		String Expected_Page_Section = "Timesheets";
		
		String Actual_Page_Section = driver.findElement(By.xpath("//ul//li//span[@class=\"oxd-topbar-body-nav-tab-item\"]")).getText(); 
		
		String Expected_Page_Section_name = "Select Employee";
		
		String Actual_Page_Section_name = driver.findElement(By.xpath("//div//h6[@class=\"oxd-text oxd-text--h6 orangehrm-main-title\"]")).getText(); 
		
		
		Assert.assertEquals(Actual_Page_Title, Expected_page_Title);
		Assert.assertEquals(Actual_Page_Section,Expected_Page_Section);
		Assert.assertEquals(Actual_Page_Section_name, Expected_Page_Section_name);
		
		// back to Dashboard Page
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[8]/a")).click();
		
	}
	
	@Test(priority=13,dependsOnMethods="test_Quick_Launch_BoardVisibility",groups="Icon Visibility")
	public void test_Apply_Leave_IconVisibility_In_QuickLaunchBoard() {
		//verifying the board is visible on dashboard
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(3));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//p[text()=\"Apply Leave\"]")));
		boolean status = driver.findElement(By.xpath("//button[@title=\"Apply Leave\"]")).isDisplayed();
		boolean status1 = driver.findElement(By.xpath("//p[text()=\"Apply Leave\"]")).isDisplayed();
		
		Assert.assertTrue(status,"Board is not visiable");
		Assert.assertTrue(status1,"Text is not visiable");
		
		
	}
	
	@Test(priority=14,dependsOnMethods="test_Apply_Leave_IconVisibility_In_QuickLaunchBoard",groups="Icon Functionality")
	public void test_Apply_Leave_IconFunctionality() {
		//verifying assign leave icon is working

		driver.findElement(By.xpath("//button[@title=\"Leave List\"]")).click();
		
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(3));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span//h6[text()=\"Leave\"]")));
		
		String Expected_page_Title="Leave";
		String Actual_Page_Title = driver.findElement(By.xpath("//span//h6[text()=\"Leave\"]")).getText();
		
		String Expected_Page_Section = "Apply";
		
		String Actual_Page_Section = driver.findElement(By.xpath("//ul//li//a[@class=\"oxd-topbar-body-nav-tab-item\" and text()=\"Apply\"]")).getText(); 
		
		Assert.assertEquals(Actual_Page_Title, Expected_page_Title);
		Assert.assertEquals(Actual_Page_Section,Expected_Page_Section);
		
		// back to Dashboard Page
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[8]/a")).click();
		
	}
	
	
	@Test(priority=14,dependsOnMethods="test_Quick_Launch_BoardVisibility",groups="Icon Visibility")
	public void test_My_Leave_IconVisibility_In_QuickLaunchBoard() {
		//verifying the board is visible on dashboard
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(3));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//p[text()=\"My Leave\"]")));
		boolean status = driver.findElement(By.xpath("//button[@title=\"My Leave\"]")).isDisplayed();
		boolean status1 = driver.findElement(By.xpath("//p[text()=\"My Leave\"]")).isDisplayed();
		
		Assert.assertTrue(status,"Board is not visiable");
		Assert.assertTrue(status1,"Text is not visiable");
		
		
	}
	
	@Test(priority=15,dependsOnMethods="test_My_Leave_IconVisibility_In_QuickLaunchBoard",groups="Icon Functionality")
	public void test_My_Leave_IconFunctionality() {
		//verifying assign leave icon is working

		driver.findElement(By.xpath("//button[@title=\"My Leave\"]")).click();
		
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(3));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span//h6[text()=\"Leave\"]")));
		
		String Expected_page_Title="Leave";
		String Actual_Page_Title = driver.findElement(By.xpath("//span//h6[text()=\"Leave\"]")).getText();
		
		String Expected_Page_Section = "My Leave";
		
		String Actual_Page_Section = driver.findElement(By.xpath("//ul//li//a[@class=\"oxd-topbar-body-nav-tab-item\" and text()=\"My Leave\"]")).getText(); 
		
		Assert.assertEquals(Actual_Page_Title, Expected_page_Title);
		Assert.assertEquals(Actual_Page_Section,Expected_Page_Section);
		
		// back to Dashboard Page
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[8]/a")).click();
		
	}
	
	
	@Test(priority=16,dependsOnMethods="test_Quick_Launch_BoardVisibility",groups="Icon Visibility")
	public void test_My_Timesheet_IconVisibility_In_QuickLaunchBoard() {
		//verifying the board is visible on dashboard
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(3));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//p[text()=\"My Timesheet\"]")));
		boolean status = driver.findElement(By.xpath("//button[@title=\"My Timesheet\"]")).isDisplayed();
		boolean status1 = driver.findElement(By.xpath("//p[text()=\"My Timesheet\"]")).isDisplayed();
		
		Assert.assertTrue(status,"Board is not visiable");
		Assert.assertTrue(status1,"Text is not visiable");
		
		
	}
	
	@Test(priority=17,dependsOnMethods="test_My_Timesheet_IconVisibility_In_QuickLaunchBoard",groups="Icon Functionality")
	public void test_My_Timesheet_IconFunctionality() {
		//verifying assign leave icon is working

		driver.findElement(By.xpath("//button[@title=\"My Timesheet\"]")).click();
		
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(3));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span//h6[text()=\"Time\"]")));
		
		String Expected_page_Title="Time";
		String Actual_Page_Title = driver.findElement(By.xpath("//span//h6[text()=\"Time\"]")).getText();
		
		String Expected_Page_Section = "Timesheets";
		
		String Actual_Page_Section = driver.findElement(By.xpath("//ul//li//span[@class=\"oxd-topbar-body-nav-tab-item\"]")).getText(); 
		
		String Expected_Page_Section_name = "My Timesheet";
		
		String Actual_Page_Section_name = driver.findElement(By.xpath("//div//h6[@class=\"oxd-text oxd-text--h6 orangehrm-main-title\"]")).getText(); 
		
		
		Assert.assertEquals(Actual_Page_Title, Expected_page_Title);
		Assert.assertEquals(Actual_Page_Section,Expected_Page_Section);
		Assert.assertEquals(Actual_Page_Section_name, Expected_Page_Section_name);
		
		// back to Dashboard Page
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[8]/a")).click();
		
	}
	                                            
	@Test(priority=18,dependsOnMethods="test_DashboardNavigation",groups="Board Visibility")
	public void test_Buzz_Latest_Posts_BoardVisibility() {
		//verifying the board is visible on dashboard
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(3));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//p[text()=\"Buzz Latest Posts\"]")));
		boolean status = driver.findElement(By.xpath("//p[text()=\"Buzz Latest Posts\"]")).isDisplayed();
		Assert.assertTrue(status,"Board is not visiable");
		
		
	}
	

	@Test(priority=19,dependsOnMethods="test_DashboardNavigation",groups="Board Visibility")
	public void test_Employees_on_Leave_Today_BoardVisibility() {
		//verifying the board is visible on dashboard
		boolean status = driver.findElement(By.xpath("//p[text()=\"Employees on Leave Today\"]")).isDisplayed();
		Assert.assertTrue(status,"Board is not visiable");
		
		
	}

	@Test(priority=20,dependsOnMethods="test_DashboardNavigation",groups="Board Visibility")
	public void test_Employee_Distribution_by_Sub_Unit_BoardVisibility() {
		//verifying the board is visible on dashboard
		boolean status = driver.findElement(By.xpath("//p[text()=\"Employee Distribution by Sub Unit\"]")).isDisplayed();
		Assert.assertTrue(status,"Board is not visiable");
		
		
	}	
	
	
	@Test(priority=21,dependsOnMethods="test_Employee_Distribution_by_Sub_Unit_BoardVisibility",groups="Pie Chart Visibility")
	public void test_PieChart_Visibility_Within_Employee_Distribution_by_Sub_Unit_Board() {
		//verifying the pie chart is visible on dashboard
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(3));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div[6]/div/div[2]/div/div/canvas")));
		boolean status = driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div[6]/div/div[2]/div/div/canvas")).isDisplayed();
		Assert.assertTrue(status,"Pie Chart is not visiable");
		
		
	}
	
	@Test(priority=22,dependsOnMethods="test_DashboardNavigation",groups="Board Visibility")
	public void test_Employee_Distribution_by_Location_BoardVisibility() {
		//verifying the board is visible on dashboard
		
		boolean status = driver.findElement(By.xpath("//p[text()=\"Employee Distribution by Location\"]")).isDisplayed();
		Assert.assertTrue(status,"Board is not visiable");
		
		
	}
	
	

	
	@Test(priority=23,dependsOnMethods="test_Employee_Distribution_by_Location_BoardVisibility",groups="Pie Chart Visibility")
	public void test_PieChart_Visibility_Within_Employee_Distribution_by_Location_Board() {
		//verifying the pie chart is visible on dashboard
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(3));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div[7]/div/div[2]/div/div/canvas")));
		boolean status = driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div[7]/div/div[2]/div/div/canvas")).isDisplayed();
		Assert.assertTrue(status,"Pie Chart is not visiable");
		
		
	}
	
	
	
	@Test(priority=24,groups="Toggle bar")
	public void test_ToggleBar_Functionality() {
		//verifying the Toggle bar is visible on dashboard
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(3));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/div/div/button")));
		boolean status = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/div/div/button")).isDisplayed();
		Assert.assertTrue(status,"Toggle bar icon  not visiable");
		//clicking on the toggle bar
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/div/div/button")).click();
		
		String Expected_Toggol_ClassName="oxd-input oxd-input--active toggled";
		
		String Actual_Toggle_ClassName = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/div/div/input")).getAttribute("class");
		
		Assert.assertEquals(Actual_Toggle_ClassName, Expected_Toggol_ClassName);
		
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/div/div/button")).click();
	}
	
	@Test(priority=25,groups="Menu Item in Sidepanel")
	public void test_SearchBar_Functionality_in_Sidepanel() {
		//verifying the Menu item is visible on dashboard
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(3));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/div/div/input")));
		boolean status = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/div/div/input")).isDisplayed();
		
		//clicking on the Search bar
		WebElement Searchbar = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/div/div/input"));
		
		Searchbar.click();
		Searchbar.sendKeys("d");
		
		String Expected_MenuItem_that_willshow_Name="Admin Dashboard Directory";
		WebDriverWait wait2 = new WebDriverWait(driver,Duration.ofSeconds(3));
		wait2.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul")));
		String Actual_MenuItem_that_isshowing_Name = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul")).getText();
		String Actual_MenuItem_that_isshowing_Name1 = Actual_MenuItem_that_isshowing_Name.replace("\n", " ");
		Assert.assertEquals(Actual_MenuItem_that_isshowing_Name1, Expected_MenuItem_that_willshow_Name);
		
		Assert.assertTrue(status,"Search bar  not visiable");
		
		
	}
	
	
	@Test(priority=26,groups="Menu Item in Sidepanel")
	public void test_Admin_MenuItem_Functionality() {
		//verifying the Menu item is visible on dashboard
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(3));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[1]/a")));
		boolean status = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[1]/a")).isDisplayed();
		
		//clicking on the Admin Menu item
		WebElement admin = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[1]/a"));
		
		admin.click();

		//Check page title
		String Expected_pageTitle_afterredirectto_the_page="Admin";
		WebDriverWait wait2 = new WebDriverWait(driver,Duration.ofSeconds(3));
		wait2.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[1]/span/h6[1]")));
		String Actual_pageTitle_afterredirectto_the_page = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[1]/span/h6[1]")).getText();

		Assert.assertEquals(Actual_pageTitle_afterredirectto_the_page, Expected_pageTitle_afterredirectto_the_page);
		Assert.assertTrue(driver.getCurrentUrl().equals("https://opensource-demo.orangehrmlive.com/web/index.php/admin/viewSystemUsers"));
		Assert.assertTrue(status,"Admin menu item  not visiable");
		//back to the dashboard
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[8]/a")).click();
		
	}
	
	@Test(priority=27,groups="Menu Item in Sidepanel")
	public void test_PIM_MenuItem_Functionality() {
		//verifying the Menu item is visible on dashboard
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(3));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[2]/a")));
		boolean status = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[2]/a")).isDisplayed();
		
		//clicking on the PIM Menu item
		WebElement PIM = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[2]/a"));
		
		PIM.click();

		//Check page title
		String Expected_pageTitle_afterredirectto_the_page="PIM";
		WebDriverWait wait2 = new WebDriverWait(driver,Duration.ofSeconds(3));
		wait2.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[1]/span/h6[1]")));
		String Actual_pageTitle_afterredirectto_the_page = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[1]/span/h6[1]")).getText();

		Assert.assertEquals(Actual_pageTitle_afterredirectto_the_page, Expected_pageTitle_afterredirectto_the_page);
		Assert.assertTrue(driver.getCurrentUrl().equals("https://opensource-demo.orangehrmlive.com/web/index.php/pim/viewEmployeeList"));
		Assert.assertTrue(status,"PIM menu item  not visiable");
		//back to the dashboard page
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[8]/a")).click();
		
	}
	
	@Test(priority=28,groups="Menu Item in Sidepanel")
	public void test_Leave_MenuItem_Functionality() {
		//verifying the Menu item is visible on dashboard
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(3));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[3]/a")));
		boolean status = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[3]/a")).isDisplayed();
		
		//clicking on the Leave Menu item
		WebElement Leave = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[3]/a"));
		
		Leave.click();

		//Check page title
		String Expected_pageTitle_afterredirectto_the_page="Leave";
		WebDriverWait wait2 = new WebDriverWait(driver,Duration.ofSeconds(3));
		wait2.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[1]/span/h6[1]")));
		String Actual_pageTitle_afterredirectto_the_page = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[1]/span/h6[1]")).getText();

		Assert.assertEquals(Actual_pageTitle_afterredirectto_the_page, Expected_pageTitle_afterredirectto_the_page);
		Assert.assertTrue(driver.getCurrentUrl().equals("https://opensource-demo.orangehrmlive.com/web/index.php/leave/viewLeaveList"));
		Assert.assertTrue(status,"Leave menu item  not visiable");
		//back to the dashboard page
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[8]/a")).click();
		
	}
	
	@Test(priority=29,groups="Menu Item in Sidepanel")
	public void test_Time_MenuItem_Functionality() {
		//verifying the Menu item is visible on dashboard
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(3));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[4]/a")));
		boolean status = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[4]/a")).isDisplayed();
		
		//clicking on the Time Menu item
		WebElement Time = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[4]/a"));
		
		Time.click();

		//Check page title
		String Expected_pageTitle_afterredirectto_the_page="Time";
		WebDriverWait wait2 = new WebDriverWait(driver,Duration.ofSeconds(3));
		wait2.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[1]/span/h6[1]")));
		String Actual_pageTitle_afterredirectto_the_page = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[1]/span/h6[1]")).getText();

		Assert.assertEquals(Actual_pageTitle_afterredirectto_the_page, Expected_pageTitle_afterredirectto_the_page);
		Assert.assertTrue(driver.getCurrentUrl().equals("https://opensource-demo.orangehrmlive.com/web/index.php/time/viewEmployeeTimesheet"));
		Assert.assertTrue(status,"Time menu item  not visiable");
		//back to the dashboard page
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[8]/a")).click();
		
	}
	
	@Test(priority=30,groups="Menu Item in Sidepanel")
	public void test_Recruitment_MenuItem_Functionality() {
		//verifying the Menu item is visible on dashboard
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(3));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[5]/a")));
		boolean status = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[5]/a")).isDisplayed();
		
		//clicking on the Recruitment Menu item
		WebElement Recruitment = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[5]/a"));
		
		Recruitment.click();

		//Check page title
		String Expected_pageTitle_afterredirectto_the_page="Recruitment";
		WebDriverWait wait2 = new WebDriverWait(driver,Duration.ofSeconds(3));
		wait2.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[1]/span/h6[1]")));
		String Actual_pageTitle_afterredirectto_the_page = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[1]/span/h6[1]")).getText();

		Assert.assertEquals(Actual_pageTitle_afterredirectto_the_page, Expected_pageTitle_afterredirectto_the_page);
		Assert.assertTrue(driver.getCurrentUrl().equals("https://opensource-demo.orangehrmlive.com/web/index.php/recruitment/viewCandidates"));
		Assert.assertTrue(status,"Recruitment menu item  not visiable");
		//back to the dashboard page
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[8]/a")).click();
		
	}
	
	@Test(priority=31,groups="Menu Item in Sidepanel")
	public void test_My_Info_MenuItem_Functionality() {
		//verifying the Menu item is visible on dashboard
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(3));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[6]/a")));
		boolean status = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[6]/a")).isDisplayed();
		
		//clicking on the My Info Menu item
		WebElement My_Info = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[6]/a"));
		
		My_Info.click();

		//Check page title
		String Expected_pageTitle_afterredirectto_the_page="PIM";
		WebDriverWait wait2 = new WebDriverWait(driver,Duration.ofSeconds(3));
		wait2.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[1]/span/h6[1]")));
		String Actual_pageTitle_afterredirectto_the_page = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[1]/span/h6[1]")).getText();

		Assert.assertEquals(Actual_pageTitle_afterredirectto_the_page, Expected_pageTitle_afterredirectto_the_page);
		Assert.assertTrue(driver.getCurrentUrl().equals("https://opensource-demo.orangehrmlive.com/web/index.php/pim/viewPersonalDetails/empNumber/7"));
		Assert.assertTrue(status,"My Info menu item  not visiable");
		//back to the dashboard page
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[8]/a")).click();
		
	}
	
	@Test(priority=32,groups="Menu Item in Sidepanel")
	public void test_Performance_MenuItem_Functionality() {
		//verifying the Menu item is visible on dashboard
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(3));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[7]/a")));
		boolean status = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[7]/a")).isDisplayed();
		
		//clicking on the Performance Menu item
		WebElement Performance = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[7]/a"));
		
		Performance.click();

		//Check page title
		String Expected_pageTitle_afterredirectto_the_page="Performance";
		WebDriverWait wait2 = new WebDriverWait(driver,Duration.ofSeconds(3));
		wait2.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[1]/span/h6[1]")));
		String Actual_pageTitle_afterredirectto_the_page = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[1]/span/h6[1]")).getText();

		Assert.assertEquals(Actual_pageTitle_afterredirectto_the_page, Expected_pageTitle_afterredirectto_the_page);
		Assert.assertTrue(driver.getCurrentUrl().equals("https://opensource-demo.orangehrmlive.com/web/index.php/performance/searchEvaluatePerformanceReview"));
		Assert.assertTrue(status,"Performance menu item  not visiable");
		//back to the dashboard page
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[8]/a")).click();
		
	}
	
	@Test(priority=33,groups="Menu Item in Sidepanel")
	public void test_Directory_MenuItem_Functionality() {
		//verifying the Menu item is visible on dashboard
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(3));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[9]/a")));
		boolean status = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[9]/a")).isDisplayed();
		
		//clicking on the Directory Menu item
		WebElement Directory = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[9]/a"));
		
		Directory.click();

		//Check page title
		String Expected_pageTitle_afterredirectto_the_page="Directory";
		WebDriverWait wait2 = new WebDriverWait(driver,Duration.ofSeconds(3));
		wait2.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[1]/span/h6[1]")));
		String Actual_pageTitle_afterredirectto_the_page = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[1]/span/h6[1]")).getText();

		Assert.assertEquals(Actual_pageTitle_afterredirectto_the_page, Expected_pageTitle_afterredirectto_the_page);
		Assert.assertTrue(driver.getCurrentUrl().equals("https://opensource-demo.orangehrmlive.com/web/index.php/directory/viewDirectory"));
		Assert.assertTrue(status,"Directory menu item  not visiable");
		//back to the dashboard page
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[8]/a")).click();
		
	}
	
	@Test(priority=34,groups="Menu Item in Sidepanel")
	public void test_Maintenance_MenuItem_Functionality() {
		//verifying the Menu item is visible on dashboard
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(3));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[10]/a")));
		boolean status = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[10]/a")).isDisplayed();
		
		//clicking on the Maintenance Menu item
		WebElement Maintenance = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[10]/a"));
		
		Maintenance.click();

		Assert.assertTrue(driver.getCurrentUrl().equals("https://opensource-demo.orangehrmlive.com/web/index.php/maintenance/purgeEmployee"));
		Assert.assertTrue(status,"Maintenance menu item  not visiable");
		//back to the dashboard page
		driver.navigate().back();	
	}
	
	@Test(priority=35,groups="Menu Item in Sidepanel")
	public void test_Claim_MenuItem_Functionality() {
		//verifying the Menu item is visible on dashboard
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(3));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[11]/a")));
		boolean status = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[11]/a")).isDisplayed();
		
		//clicking on the Claim Menu item
		WebElement Claim = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[11]/a"));
		
		Claim.click();

		//Check page title
		String Expected_pageTitle_afterredirectto_the_page="Claim";
		WebDriverWait wait2 = new WebDriverWait(driver,Duration.ofSeconds(3));
		wait2.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[1]/span/h6[1]")));
		String Actual_pageTitle_afterredirectto_the_page = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[1]/span/h6[1]")).getText();

		Assert.assertEquals(Actual_pageTitle_afterredirectto_the_page, Expected_pageTitle_afterredirectto_the_page);
		Assert.assertTrue(driver.getCurrentUrl().equals("https://opensource-demo.orangehrmlive.com/web/index.php/claim/viewAssignClaim"));
		Assert.assertTrue(status,"Claim menu item  not visiable");
		//back to the dashboard page
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[8]/a")).click();
		
	}

	@Test(priority=36,groups="Menu Item in Sidepanel")
	public void test_Buzz_MenuItem_Functionality() {
		//verifying the Menu item is visible on dashboard
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(3));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[12]/a")));
		boolean status = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[12]/a")).isDisplayed();
		
		//clicking on the Buzz Menu item
		WebElement Buzz = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[12]/a"));
		
		Buzz.click();

		//Check page title
		String Expected_pageTitle_afterredirectto_the_page="Buzz";
		WebDriverWait wait2 = new WebDriverWait(driver,Duration.ofSeconds(3));
		wait2.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[1]/span/h6[1]")));
		String Actual_pageTitle_afterredirectto_the_page = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[1]/span/h6[1]")).getText();

		Assert.assertEquals(Actual_pageTitle_afterredirectto_the_page, Expected_pageTitle_afterredirectto_the_page);
		Assert.assertTrue(driver.getCurrentUrl().equals("https://opensource-demo.orangehrmlive.com/web/index.php/buzz/viewBuzz"));
		Assert.assertTrue(status,"Buzz menu item  not visiable");
		//back to the dashboard page
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[8]/a")).click();
		
	}
	
	@Test(priority=37,groups="Menu Item in Sidepanel")
	public void test_SearchBar_Functionality_in_Sidepanel_While_Toggled() {
		//verifying the Menu item is visible on dashboard
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(3));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/div/div/button")));
		//clicled on the toggole bar icon
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/div/div/button")).click();
		
		boolean status = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/div/div")).isDisplayed();
		
		//clicking on the Search bar
		WebElement Searchbar = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/div/div"));
		
		Searchbar.click();
		Searchbar.sendKeys("d");
		
		String Expected_MenuItem_that_willshow_Name="Admin Dashboard Directory";
		WebDriverWait wait2 = new WebDriverWait(driver,Duration.ofSeconds(3));
		wait2.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul")));
		String Actual_MenuItem_that_isshowing_Name = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul")).getText();
		String Actual_MenuItem_that_isshowing_Name1 = Actual_MenuItem_that_isshowing_Name.replace("\n", " ");
		Assert.assertEquals(Actual_MenuItem_that_isshowing_Name1, Expected_MenuItem_that_willshow_Name);
		
		Assert.assertTrue(status,"Search bar  not visiable");
		
		
	}

	@AfterClass
	public void tearDown() {

		driver.quit();
	}
	
}
