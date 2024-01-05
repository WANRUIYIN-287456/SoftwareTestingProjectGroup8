package junit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import java.util.concurrent.TimeUnit;

public class V2 {
    static WebDriver driver; // Declaring WebDriver instance
    
    @BeforeClass
    public static void beforeClass() throws InterruptedException {
        System.out.println("Before Class");
        System.setProperty("webdiver.chrome.driver", "C:\\Users\\User\\Selenium WebDriver\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver(); // Initialize WebDriver
        
        driver.get("https://fimsclone.kerisi.my/"); // Open website
        System.out.println(driver.getTitle());
        Thread.sleep(5000);
        
		// Find email and password elements by ID
		driver.findElement(By.xpath("/html/body/div/div[2]/form/div[2]/input")).sendKeys("ENTRY3");
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("/html/body/div/div[2]/form/div[4]/input")).sendKeys("qwertyuiop");
		Thread.sleep(5000);
		
		// Click SIGNIN BUTTON
		driver.findElement(By.xpath("/html/body/div/div[2]/form/input")).click();
		System.out.println("Log in successful");
		
		Thread.sleep(5000);

    }
    
    @Before
    public void before() throws InterruptedException {
        System.out.println("Before Test Case");
        // Select Menu button
        driver.findElement(By.xpath("/html/body/div[1]/div[1]/a[2]")).click();
        System.out.println("Menu");
        Thread.sleep(2000);
        
        // Select Portal in the Menu
        driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[2]/ul/li[7]/a")).click();
        System.out.println("Portal");
		Thread.sleep(2000);
        
        // Select Travelling in the submenu
        driver.findElement(By.id("list_menu_id_2509")).click();
        System.out.println("Travelling");
        Thread.sleep(2000);
        
        // Select Travelling Claim Form in the submenu
        driver.findElement(By.xpath("//*[@id=\"menu_id_2839\"]")).click();
        System.out.println("Form");
        Thread.sleep(2000);
        
        // Select ok button in the notification
        driver.findElement(By.xpath("/html/body/div[21]/div/div/div[3]/button")).click();
        System.out.println("OK");
        Thread.sleep(2000);
    }
    
    /**
     * Test Case 1
     * Method testSubmit_01 is the first test case for submit button in travelling claim form
     * Menu > Portal > Travelling > Travelling Claim Form
     * No input for four dropdown buttons
     * Month = "", Year = "", TeansportRegNo = "", TreavellingRequest = ""
     * @throws InterruptedException
     */
    @Test
    public void testSubmit_01() throws InterruptedException {
        System.out.println("Test 1_V2");
        
        //Clear original option
        driver.findElement(By.xpath("//*[@id=\"inputArea_tcm_month\"]/div/div[1]/span/span[1]")).click();
        driver.findElement(By.xpath("//*[@id=\"inputArea_tcm_month\"]/div/div[2]/span/span[1]")).click();
        System.out.println("x");
        Thread.sleep(5000);
        
        // Click Submit button
        driver.findElement(By.xpath("/html/body/div[4]/form/div/div[5]/div/div/a[3]")).click();
        System.out.println("Submit");
        Thread.sleep(5000);
        
        // Get the error message after clicking Submit Button.
        String actualValue = driver.findElement(By.xpath("/html/body/div[21]/div/div/div[2]")).getText();
        System.out.println(actualValue);        
        
        // Define expected string output
        String expectedValue = "Please check header";
        
        // Click ok button for error message
        driver.findElement(By.xpath("/html/body/div[21]/div/div/div[3]/button")).click();
        System.out.println("Error ok");
        Thread.sleep(5000);
        
        // Assert to verify whether Expected Value is equal to Actual Value
        Assert.assertEquals("Error message mismatch", expectedValue, actualValue);
    }
  
    @After
    public void after() throws InterruptedException {
        System.out.println("After Test Case");
        
        // Click back button
        driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/back")).click();
        System.out.println("Back to menu");
        Thread.sleep(5000);
        
    }
    
    @AfterClass
    public static void afterClass() {
        System.out.println("After Class");
        // Close WebDriver instance
        if (driver != null) {
            driver.quit();
        }
    }
}
