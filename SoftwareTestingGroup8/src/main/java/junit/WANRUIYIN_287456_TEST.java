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

/**
 * This class contains 10 test cases, four test cases to test submit button while
 * six test cases to test save button in the travelling claim form
 * 
 * @author WAN RUI YIN 287456
 *
 */
public class WANRUIYIN_287456_TEST {
    static WebDriver driver; // Declaring WebDriver instance
    
    /**
     * Before class, open the Google Chrome, locate to the FIMS website and login using ENTRY3
     * @throws InterruptedException
     */
    @BeforeClass
    public static void beforeClass() throws InterruptedException {
        System.out.println("Before Class");
        System.setProperty("webdiver.chrome.driver", "C:\\Users\\User\\Selenium WebDriver\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver(); // Initialize WebDriver
        
        driver.get("https://fimsclone.kerisi.my/"); // Open website
        System.out.println(driver.getTitle());
        Thread.sleep(2000);
        
		// Find email and password elements by ID
		driver.findElement(By.xpath("/html/body/div/div[2]/form/div[2]/input")).sendKeys("ENTRY3");
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("/html/body/div/div[2]/form/div[4]/input")).sendKeys("qwertyuiop");
		Thread.sleep(2000);
		
		// Click SIGNIN BUTTON
		driver.findElement(By.xpath("/html/body/div/div[2]/form/input")).click();
		System.out.println("Log in successful");
		
		Thread.sleep(5000);

    }
    
    /**
     * Before each test cases, the webpage need to be directed to the Travelling Claim Form first
     * Directory: Menu > Portal > Travelling > Travelling Claim Form
     * @throws InterruptedException
     */
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
        driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[2]/ul/li[7]/ul/li[13]/a")).click();
        System.out.println("Travelling");
        Thread.sleep(2000);
        
        // Select Travelling Claim Form in the submenu
        driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[2]/ul/li[7]/ul/li[13]/ul/li[2]/a")).click();
        System.out.println("Form");
        Thread.sleep(2000);
        
        // Select ok button in the notification
        driver.findElement(By.xpath("/html/body/div[21]/div/div/div[3]/button")).click();
        System.out.println("OK");
        Thread.sleep(5000);
               
        //Clear original option
        driver.findElement(By.xpath("//*[@id=\"inputArea_tcm_month\"]/div/div[1]/span/span[1]")).click();
        driver.findElement(By.xpath("//*[@id=\"inputArea_tcm_month\"]/div/div[2]/span/span[1]")).click();
        System.out.println("x");
        Thread.sleep(5000);
    }
  
    /**
     * Test Case 1
     * Method FIMS_11_01 is the first test case for save button in travelling claim form
     * Menu > Portal > Travelling > Travelling Claim Form
     * No input for four dropdown buttons
     * Month = "", Year = "", TransportRegNo = "", TravellingRequest = ""
     * @throws InterruptedException
     */
    @Test
    public void FIMS_11_01() throws InterruptedException {
        System.out.println("Test 1");
        
        // Click Save button
        driver.findElement(By.xpath("/html/body/div[4]/form/div/div[5]/div/div/a[2]")).click();
        System.out.println("Save");
        Thread.sleep(2000);
        
        // Get the error message after clicking Save Button.
        String actualValue = driver.findElement(By.xpath("/html/body/div[21]/div/div/div[2]")).getText();
        System.out.println(actualValue);        
        
        // Define expected string output
        String expectedValue = "You need at least 1 claim before saving";
        
        // Click ok button for error message
        driver.findElement(By.xpath("/html/body/div[21]/div/div/div[3]/button")).click();
        System.out.println("Error ok");
        Thread.sleep(2000);
        
        // Assert to verify whether Expected Value is equal to Actual Value
        Assert.assertEquals("Error message mismatch", expectedValue, actualValue);
    }
  
    /**
     * Test Case 2
     * Method FIMS_11_02 is the second test case for save button in travelling claim form
     * Menu > Portal > Travelling > Travelling Claim Form
     * Correct input for Month using options selection
     * Month - Select January as input, Year = "", TransportRegNo = "", TravellingRequest = ""
     * @throws InterruptedException
     */
    @Test
    public void FIMS_11_02() throws InterruptedException {
        System.out.println("Test 2");
        
        // Select Claim For Month dropdown
        driver.findElement(By.xpath("/html/body/div[4]/form/div/div[1]/div[2]/div[8]/div/div[1]/span/span[2]/span/span[2]/b")).click();
        System.out.println("Month");
        Thread.sleep(2000);
        
        // Select Claim For Month January
        driver.findElement(By.xpath("/html/body/span/span/span[2]/ul/li[1]")).click();
        System.out.println("January");
        Thread.sleep(2000);
        
        // Click Save button
        driver.findElement(By.xpath("/html/body/div[4]/form/div/div[5]/div/div/a[2]")).click();
        System.out.println("Save");
        Thread.sleep(2000);
        
        // Get the error message after clicking Save Button.
        String actualValue = driver.findElement(By.xpath("/html/body/div[21]/div/div/div[2]")).getText();
        System.out.println(actualValue);        
        
        // Define expected string output
        String expectedValue = "You need at least 1 claim before saving";
        
        // Click ok button for error message
        driver.findElement(By.xpath("/html/body/div[21]/div/div/div[3]/button")).click();
        System.out.println("Error ok");
        Thread.sleep(2000);
        
        // Assert to verify whether Expected Value is equal to Actual Value
        Assert.assertEquals("Error message mismatch", expectedValue, actualValue);
    }
    
    /**
     * Test Case 3
     * Method FIMS_11_03 is the third test case for save button in travelling claim form
     * Menu > Portal > Travelling > Travelling Claim Form
     * Correct input for Month using search
     * Month - Search April as input, Year = "", TransportRegNo = "", TravellingRequest = ""
     * @throws InterruptedException
     */
    @Test
    public void FIMS_11_03() throws InterruptedException {
        System.out.println("Test 3");
        
        // Select Claim For Month dropdown
        driver.findElement(By.xpath("/html/body/div[4]/form/div/div[1]/div[2]/div[8]/div/div[1]/span/span[2]/span/span[2]/b")).click();
        System.out.println("Month");
        Thread.sleep(2000);
        
        // Type "April" to Search Claim For Month April
        driver.findElement(By.xpath("/html/body/span/span/span[1]/input")).sendKeys("April");
        System.out.println("April type");
        Thread.sleep(2000);
        
        // Select Claim For Month April
        driver.findElement(By.xpath("/html/body/span/span/span[2]/ul/li")).click();
        System.out.println("April click");
        Thread.sleep(2000);
        
        // Click Save button
        driver.findElement(By.xpath("/html/body/div[4]/form/div/div[5]/div/div/a[2]")).click();
        System.out.println("Save");
        Thread.sleep(2000);
        
        // Get the error message after clicking Save Button.
        String actualValue = driver.findElement(By.xpath("/html/body/div[21]/div/div/div[2]")).getText();
        System.out.println(actualValue);        
        
        // Define expected string output
        String expectedValue = "You need at least 1 claim before saving";
        
        // Click ok button for error message
        driver.findElement(By.xpath("/html/body/div[21]/div/div/div[3]/button")).click();
        System.out.println("Error ok");
        Thread.sleep(2000);
        
        // Assert to verify whether Expected Value is equal to Actual Value
        Assert.assertEquals("Error message mismatch", expectedValue, actualValue);
    }
    
    /**
     * Test Case 4
     * Method FIMS_11_04 is the fourth test case for save button in travelling claim form
     * Menu > Portal > Travelling > Travelling Claim Form
     * Correct input for Year using options selection
     * Month = "", Year = 2023, TransportRegNo = "", TravellingRequest = ""
     * @throws InterruptedException
     */
    @Test
    public void FIMS_11_04() throws InterruptedException {
        System.out.println("Test 4");
        
        // Select Claim For Year dropdown
        driver.findElement(By.xpath("/html/body/div[4]/form/div/div[1]/div[2]/div[8]/div/div[2]/span/span[2]/span")).click();
        System.out.println("Year");
        Thread.sleep(2000);
        
        // Select Claim For Year 2023
        driver.findElement(By.xpath("/html/body/span/span/span[2]/ul/li[1]")).click();
        System.out.println("2023");
        Thread.sleep(2000);
        
        // Click Save button
        driver.findElement(By.xpath("/html/body/div[4]/form/div/div[5]/div/div/a[2]")).click();
        System.out.println("Save");
        Thread.sleep(2000);
        
        // Get the error message after clicking Save Button.
        String actualValue = driver.findElement(By.xpath("/html/body/div[21]/div/div/div[2]")).getText();
        System.out.println(actualValue);        
        
        // Define expected string output
        String expectedValue = "You need at least 1 claim before saving";
        
        // Click ok button for error message
        driver.findElement(By.xpath("/html/body/div[21]/div/div/div[3]/button")).click();
        System.out.println("Error ok");
        Thread.sleep(2000);
        
        // Assert to verify whether Expected Value is equal to Actual Value
        Assert.assertEquals("Error message mismatch", expectedValue, actualValue);
    }
    
    /**
     * Test Case 5
     * Method FIMS_11_05 is the fifth test case for save button in travelling claim form
     * Menu > Portal > Travelling > Travelling Claim Form
     * Correct input for Month and Year using options selection
     * Month - Select January as input, Year = 2023, TransportRegNo = "", TravellingRequest = ""
     * @throws InterruptedException
     */
    @Test
    public void FIMS_11_05() throws InterruptedException {
        System.out.println("Test 5");
        
        // Select Claim For Month dropdown
        driver.findElement(By.xpath("/html/body/div[4]/form/div/div[1]/div[2]/div[8]/div/div[1]/span/span[2]/span/span[2]/b")).click();
        System.out.println("Month");
        Thread.sleep(2000);
        
        // Select Claim For Month January
        driver.findElement(By.xpath("/html/body/span/span/span[2]/ul/li[1]")).click();
        System.out.println("January");
        Thread.sleep(2000);
        
        // Select Claim For Year dropdown
        driver.findElement(By.xpath("/html/body/div[4]/form/div/div[1]/div[2]/div[8]/div/div[2]/span/span[2]/span")).click();
        System.out.println("Year");
        Thread.sleep(2000);
        
        // Select Claim For Year 2023
        driver.findElement(By.xpath("/html/body/span/span/span[2]/ul/li[1]")).click();
        System.out.println("2023");
        Thread.sleep(2000);
        
        // Click Save button
        driver.findElement(By.xpath("/html/body/div[4]/form/div/div[5]/div/div/a[2]")).click();
        System.out.println("Save");
        Thread.sleep(2000);
        
        // Get the error message after clicking Save Button.
        String actualValue = driver.findElement(By.xpath("/html/body/div[21]/div/div/div[2]")).getText();
        System.out.println(actualValue);        
        
        // Define expected string output
        String expectedValue = "You need at least 1 claim before saving";
        
        // Click ok button for error message
        driver.findElement(By.xpath("/html/body/div[21]/div/div/div[3]/button")).click();
        System.out.println("Error ok");
        Thread.sleep(2000);
        
        // Assert to verify whether Expected Value is equal to Actual Value
        Assert.assertEquals("Error message mismatch", expectedValue, actualValue);
    }
    
    /**
     * Test Case 6
     * Method FIMS_11_06 is the fifth test case for save button in travelling claim form
     * Menu > Portal > Travelling > Travelling Claim Form
     * Correct input for Month using search and Year using options selection
     * Month - Search April as input, Year = 2023, TransportRegNo = "", TravellingRequest = ""
     * @throws InterruptedException
     */
    @Test
    public void FIMS_11_06() throws InterruptedException {
        System.out.println("Test 6");
        
        // Select Claim For Month dropdown
        driver.findElement(By.xpath("/html/body/div[4]/form/div/div[1]/div[2]/div[8]/div/div[1]/span/span[2]/span/span[2]/b")).click();
        System.out.println("Month");
        Thread.sleep(2000);
        
        // Type "April" to Search Claim For Month April
        driver.findElement(By.xpath("/html/body/span/span/span[1]/input")).sendKeys("April");
        System.out.println("April type");
        Thread.sleep(2000);
        
        // Select Claim For Month April
        driver.findElement(By.xpath("/html/body/span/span/span[2]/ul/li")).click();
        System.out.println("April click");
        Thread.sleep(2000);
        
        // Select Claim For Year dropdown
        driver.findElement(By.xpath("/html/body/div[4]/form/div/div[1]/div[2]/div[8]/div/div[2]/span/span[2]/span")).click();
        System.out.println("Year");
        Thread.sleep(2000);
        
        // Select Claim For Year 2023
        driver.findElement(By.xpath("/html/body/span/span/span[2]/ul/li[1]")).click();
        System.out.println("2023");
        Thread.sleep(2000);
        
        // Click Save button
        driver.findElement(By.xpath("/html/body/div[4]/form/div/div[5]/div/div/a[2]")).click();
        System.out.println("Save");
        Thread.sleep(2000);
        
        // Get the error message after clicking Save Button.
        String actualValue = driver.findElement(By.xpath("/html/body/div[21]/div/div/div[2]")).getText();
        System.out.println(actualValue);        
        
        // Define expected string output
        String expectedValue = "You need at least 1 claim before saving";
        
        // Click ok button for error message
        driver.findElement(By.xpath("/html/body/div[21]/div/div/div[3]/button")).click();
        System.out.println("Error ok");
        Thread.sleep(2000);
        
        // Assert to verify whether Expected Value is equal to Actual Value
        Assert.assertEquals("Error message mismatch", expectedValue, actualValue);
    }
    
    /**
     * Test Case 7
     * Method FIMS_12_01 is the first test case for submit button in travelling claim form
     * Menu > Portal > Travelling > Travelling Claim Form
     * No input for four dropdown buttons
     * Month = "", Year = "", TransportRegNo = "", TravellingRequest = ""
     * @throws InterruptedException
     */
    @Test
    public void FIMS_12_01() throws InterruptedException {
        System.out.println("Test 7");
        
        // Click Submit button
        driver.findElement(By.xpath("/html/body/div[4]/form/div/div[5]/div/div/a[3]")).click();
        System.out.println("Submit");
        Thread.sleep(2000);
        
        // Get the error message after clicking Submit Button.
        String actualValue = driver.findElement(By.xpath("/html/body/div[21]/div/div/div[2]")).getText();
        System.out.println(actualValue);        
        
        // Define expected string output
        String expectedValue = "Please check header";
        
        // Click ok button for error message
        driver.findElement(By.xpath("/html/body/div[21]/div/div/div[3]/button")).click();
        System.out.println("Error ok");
        Thread.sleep(2000);
        
        // Assert to verify whether Expected Value is equal to Actual Value
        Assert.assertEquals("Error message mismatch", expectedValue, actualValue);
    }
  
    /**
     * Test Case 8
     * Method FIMS_12_02 is the second test case for submit button in travelling claim form
     * Menu > Portal > Travelling > Travelling Claim Form
     * Correct input for Month using options selection
     * Month - Select January as input, Year = "", TransportRegNo = "", TravellingRequest = ""
     * @throws InterruptedException
     */
    @Test
    public void FIMS_12_02() throws InterruptedException {
        System.out.println("Test 8");
        
        // Select Claim For Month dropdown
        driver.findElement(By.xpath("/html/body/div[4]/form/div/div[1]/div[2]/div[8]/div/div[1]/span/span[2]/span/span[2]/b")).click();
        System.out.println("Month");
        Thread.sleep(2000);
        
        // Select Claim For Month January
        driver.findElement(By.xpath("/html/body/span/span/span[2]/ul/li[1]")).click();
        System.out.println("January");
        Thread.sleep(2000);
        
        // Click Submit button
        driver.findElement(By.xpath("/html/body/div[4]/form/div/div[5]/div/div/a[3]")).click();
        System.out.println("Submit");
        Thread.sleep(2000);
        
        // Get the error message after clicking Submit Button.
        String actualValue = driver.findElement(By.xpath("/html/body/div[21]/div/div/div[2]")).getText();
        System.out.println(actualValue);        
        
        // Define expected string output
        String expectedValue = "Please check header";
        
        // Click ok button for error message
        driver.findElement(By.xpath("/html/body/div[21]/div/div/div[3]/button")).click();
        System.out.println("Error ok");
        Thread.sleep(2000);
        
        // Assert to verify whether Expected Value is equal to Actual Value
        Assert.assertEquals("Error message mismatch", expectedValue, actualValue);
    }
    
    /**
     * Test Case 9
     * Method FIMS_12_03 is the third test case for submit button in travelling claim form
     * Menu > Portal > Travelling > Travelling Claim Form
     * Correct input for Month using search
     * Month - Search April as input, Year = "", TransportRegNo = "", TravellingRequest = ""
     * @throws InterruptedException
     */
    @Test
    public void FIMS_12_03() throws InterruptedException {
        System.out.println("Test 9");
        
        // Select Claim For Month dropdown
        driver.findElement(By.xpath("/html/body/div[4]/form/div/div[1]/div[2]/div[8]/div/div[1]/span/span[2]/span/span[2]/b")).click();
        System.out.println("Month");
        Thread.sleep(2000);
        
        // Type "April" to Search Claim For Month April
        driver.findElement(By.xpath("/html/body/span/span/span[1]/input")).sendKeys("April");
        System.out.println("April type");
        Thread.sleep(2000);
        
        // Select Claim For Month April
        driver.findElement(By.xpath("/html/body/span/span/span[2]/ul/li")).click();
        System.out.println("April click");
        Thread.sleep(2000);
        
        // Click Submit button
        driver.findElement(By.xpath("/html/body/div[4]/form/div/div[5]/div/div/a[3]")).click();
        System.out.println("Submit");
        Thread.sleep(2000);
        
        // Get the error message after clicking Submit Button.
        String actualValue = driver.findElement(By.xpath("/html/body/div[21]/div/div/div[2]")).getText();
        System.out.println(actualValue);        
        
        // Define expected string output
        String expectedValue = "Please check header";
        
        // Click ok button for error message
        driver.findElement(By.xpath("/html/body/div[21]/div/div/div[3]/button")).click();
        System.out.println("Error ok");
        Thread.sleep(2000);
        
        // Assert to verify whether Expected Value is equal to Actual Value
        Assert.assertEquals("Error message mismatch", expectedValue, actualValue);
    }
    
    /**
     * Test Case 10
     * Method FIMS_12_04 is the fourth test case for submit button in travelling claim form
     * Menu > Portal > Travelling > Travelling Claim Form
     * Correct input for Year using options selection
     * Month = "", Year = 2023, TransportRegNo = "", TravellingRequest = ""
     * @throws InterruptedException
     */
    @Test
    public void FIMS_12_04() throws InterruptedException {
        System.out.println("Test 10");
        
        // Select Claim For Year dropdown
        driver.findElement(By.xpath("/html/body/div[4]/form/div/div[1]/div[2]/div[8]/div/div[2]/span/span[2]/span")).click();
        System.out.println("Year");
        Thread.sleep(2000);
        
        // Select Claim For Year 2023
        driver.findElement(By.xpath("/html/body/span/span/span[2]/ul/li[1]")).click();
        System.out.println("2023");
        Thread.sleep(2000);
        
        // Click Submit button
        driver.findElement(By.xpath("/html/body/div[4]/form/div/div[5]/div/div/a[3]")).click();
        System.out.println("Submit");
        Thread.sleep(2000);
        
        // Get the error message after clicking Submit Button.
        String actualValue = driver.findElement(By.xpath("/html/body/div[21]/div/div/div[2]")).getText();
        System.out.println(actualValue);        
        
        // Define expected string output
        String expectedValue = "Please check header";
        
        // Click ok button for error message
        driver.findElement(By.xpath("/html/body/div[21]/div/div/div[3]/button")).click();
        System.out.println("Error ok");
        Thread.sleep(2000);
        
        // Assert to verify whether Expected Value is equal to Actual Value
        Assert.assertEquals("Error message mismatch", expectedValue, actualValue);
    }
    
    /**
     * After each test cases, 
     * @throws InterruptedException
     */
    @After
    public void after() throws InterruptedException {
        System.out.println("After Test Case");
        
        // Click back button
        driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/back")).click();
        System.out.println("Back to menu");
        Thread.sleep(2000);
    }
    
    @AfterClass
    public static void afterClass() throws InterruptedException {
        System.out.println("After Class");
        
        // Select Logout Dropdown Button
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/a")).click();
        Thread.sleep(2000);
        
        // Click Logout Button
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div/a")).click();
        Thread.sleep(2000);
        
        // Click OK to Confirm Logout
        driver.findElement(By.xpath("/html/body/div[18]/div/div/div[3]/button[2]")).click();
        Thread.sleep(2000);
        
        System.out.println("Logout Successful");
        
        // Close WebDriver instance
        if (driver != null) {
            driver.quit();
        }
    }
}
