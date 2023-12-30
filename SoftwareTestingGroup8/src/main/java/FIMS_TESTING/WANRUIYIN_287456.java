package FIMS_TESTING;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WANRUIYIN_287456 {

	public static void main(String[] args) {
		System.setProperty("webdiver.chrome.driver", "C:\\Users\\User\\Selenium WebDriver\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://fimsclone.kerisi.my/ ");
        System.out.println(driver.getTitle());
        //driver.quit();
	}
}
