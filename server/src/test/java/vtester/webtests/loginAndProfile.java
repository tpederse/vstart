package vtester.webtests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by badboypedersen on 26/02/2017.
 */
public class loginAndProfile {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        driver.get("http://localhost:8081");
        // Alternatively the same thing can be done like this
        // driver.navigate().to("http://www.google.com");

        // Find the text input element by its name
        //WebElement element = driver.findElement(By.id("username-input"));
        String text = driver.findElement(By.className("lead")).getText();
        System.out.println(text);

        // Enter something to search for
        //element.sendKeys("myUsername");


        (new WebDriverWait(driver, 100)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                System.out.println(d.getPageSource());
                return d.findElements(By.id("loginButton")).size()>0;
            }
        });
        // Check the title of the page
        driver.findElement(By.id("loginbutton"));



        System.out.println("Page title is: " + driver.getTitle());

        // Google's search is rendered dynamically with JavaScript.
        // Wait for the page to load, timeout after 10 seconds
        (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getTitle().toLowerCase().startsWith("cheese!");
            }
        });

        // Should see: "cheese! - Google Search"
        System.out.println("Page title is: " + driver.getTitle());

        //Close the browser
        driver.quit();
    }
}
