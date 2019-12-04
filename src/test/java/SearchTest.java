import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class SearchTest {

    @Test
    public void searchTest(){
        System.setProperty("webdriver.chrome.driver","resources/chromedriver");
        WebDriver driver = new ChromeDriver();

        driver.get("http://testfasttrackit.info/selenium-test/catalogsearch/result/?q=NECKLACE");
        String items = driver.findElement(By.cssSelector(".category-products > .toolbar .amount strong")).getText();

        String finalString = items.replace(" Item(s)","").trim();
        int finalNumber =  Integer.parseInt(finalString);
        List<WebElement> myListOfElements = driver.findElements(By.cssSelector(".products-grid .item"));

        Assert.assertEquals(myListOfElements.size(), finalNumber);
        driver.quit();
    }
}
