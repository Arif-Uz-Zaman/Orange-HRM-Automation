package com.test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTestNG {
	
    WebDriver driver;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\\\Driver\\\\chromedriver-win64\\\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    
    @BeforeMethod
    public void gotologinpage(){
    	driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }

    @Test (priority=1,groups="Valid Login")
    public void testValidLogin() {
        loginTest(driver, "Admin", "admin123");
        // Assertions for successful login
        Assert.assertTrue(driver.getCurrentUrl().equals("https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index"));
        
        //logout from home page
        WebElement dropdown = driver.findElement(By.xpath("//span[@class=\"oxd-userdropdown-tab\"]"));
        dropdown.click();
        driver.findElement(By.xpath("//a[@class=\"oxd-userdropdown-link\" and @href=\"/web/index.php/auth/logout\"]")).click();
    }

    @Test (priority=2,groups="Invalid Login")
    public void testlogin_InvalidUsername_And_ValidPassword() {
        loginTest(driver, "s@gmail.com", "admin123");
        // Assertions for unsuccessful login
        Assert.assertTrue(driver.getCurrentUrl().equals("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"));
    }
    @Test (priority=3,groups="Invalid Login")
    public void testlogin_InvalidUsername_And_InvalidPassword() {
    	 loginTest(driver, "admin123", "admin");
         // Assertions for unsuccessful login
    	 Assert.assertTrue(driver.getCurrentUrl().equals("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"));
    }
    @Test (priority=4,groups="Invalid Login")
    public void testlogin_ValidUsername_And_InvalidPassword() {
    	 loginTest(driver, "Admin", "admin");
         // Assertions for unsuccessful login
    	 Assert.assertTrue(driver.getCurrentUrl().equals("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"));
    }
    @Test (priority=5,groups="Invalid Login")
    public void testLogin_EmptyPassword() {
    	loginTest(driver, "Admin", "");
        // Assertions for invalid login attempts
        Assert.assertTrue(driver.getCurrentUrl().equals("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"));
        
        // check require text displayed
        String text1="Required";
        String text = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[2]/div/span")).getText();
        Assert.assertEquals(text, text1);
        
    }
    @Test (priority=6,groups="Invalid Login")
    public void testLogin_EmptyUsername() {
    	loginTest(driver, "", "admin123");
        // Assertions for invalid login attempts
        Assert.assertTrue(driver.getCurrentUrl().equals("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"));
        
        // check require text displayed
        String text1="Required";
        String text = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[1]/div/span")).getText();
        Assert.assertEquals(text, text1);
        
    }
    @Test (priority=7,groups="Invalid Login")
    public void testLogin_EmptyUsername_And_Password() {
    	loginTest(driver, "", "");
        // Assertions for invalid login attempts
        Assert.assertTrue(driver.getCurrentUrl().equals("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"));
        
        // check require text displayed
        String text1="Required";
        String text = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[2]/div/span")).getText();
        Assert.assertEquals(text, text1);
        
        String text2 = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[1]/div/span")).getText();
        Assert.assertEquals(text2, text1);
    }
    
    
    
    @Test(priority=8,groups="Aleart Message")
    public void testAlertMessage_InvalidUsername() {
    	loginTest(driver, "aadmin", "admin123");
    	
    	// Assertions for invalid login attempts
        Assert.assertTrue(driver.getCurrentUrl().equals("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"));
    	
        //check error message pop up
    	String Expected_error_message="Invalid credentials";
        String Actual_error_message = driver.findElement(By.xpath("//div[@class='orangehrm-login-error']//div//div")).getText();
        Assert.assertEquals(Actual_error_message, Expected_error_message);
    }

    @Test(priority=9,groups="Aleart Message")
    public void testAlertMessage_InvalidPassword() {
        loginTest(driver, "Admin", "admin093");
        // Assertions for invalid login attempts
        Assert.assertTrue(driver.getCurrentUrl().equals("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"));
    	
        //check error message pop up
    	String Expected_error_message="Invalid credentials";
        String Actual_error_message = driver.findElement(By.xpath("//div[@class='orangehrm-login-error']//div//div")).getText();
        Assert.assertEquals(Actual_error_message, Expected_error_message);
  	
    }
    
    @Test(priority=10,groups="Alternative of Login button")
    public void testEnterKeyAsLogin() {
    	
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    	wait.until(ExpectedConditions.elementToBeClickable(By.name("username")));
        driver.findElement(By.name("username")).sendKeys(Keys.ENTER);
        
        // check require text displayed
        String text1="Required";
        String text = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[2]/div/span")).getText();
        Assert.assertEquals(text, text1);
        
        String text2 = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[1]/div/span")).getText();
        Assert.assertEquals(text2, text1);
         
  	
    }

    
    @Test(priority=11,groups="Redirect Links")
    public void testForgotPasswordRedirect() {
    	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
    	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class=\"orangehrm-login-forgot\"]//p")));
    	driver.findElement(By.xpath("//div[@class=\"orangehrm-login-forgot\"]//p")).click();
    	
    	//check if it redirected to the reset password page
    	Assert.assertTrue(driver.getCurrentUrl().equals("https://opensource-demo.orangehrmlive.com/web/index.php/auth/requestPasswordResetCode"));
    	
    }


    // Add remaining test methods here

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

    // Your loginTest and messageCheck methods here
    public static void loginTest(WebDriver driver, String username, String password) {
       
    	
        // Locate email/phone and password fields
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    	wait.until(ExpectedConditions.elementToBeClickable(By.name("username")));
        WebElement emailPhoneField = driver.findElement(By.name("username"));
        emailPhoneField.click(); // Ensure the field is focused
        emailPhoneField.clear();
        WebElement passwordField = driver.findElement(By.name("password"));

        // Enter the provided credentials
        emailPhoneField.sendKeys(username);
        passwordField.sendKeys(password);

        // Locate and click on the login button
        WebElement loginButton = driver.findElement(By.xpath("//button[@type=\"submit\"]"));
        loginButton.click();

        // Wait for the login process to complete
        try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			
		}
        
        System.out.print("( Username used == "+username+ " Password used == " + password +"  ) Result:  ");
        
        // Verify login success or failure based on the redirected URL
        if (driver.getCurrentUrl().equals("https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index") && username=="Admin" && password=="admin123" ) {
            System.out.println("Login successful!");
        }
        else if(driver.getCurrentUrl().equals("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login")) {
            System.out.println("Login failed!");
         
        }
        else {
        	System.out.println("Invalid Login!");
        	
        }

        
        
   
    }   
}
