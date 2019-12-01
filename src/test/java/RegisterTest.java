import org.apache.commons.lang3.RandomStringUtils;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.Random;

public class RegisterTest {

    @Test
    public void validRegisterTest()  {
        String userEmail = RandomStringUtils.randomAlphanumeric(7) + "@testFastTrackIt.com";
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver");
        WebDriver driver = new ChromeDriver();

        driver.get("http://testfasttrackit.info/selenium-test/home-decor/bed-bath.html");
        Select sortByElement = new Select(driver.findElement(By.cssSelector(".category-products > .toolbar select[title='Sort By']")));
        sortByElement.selectByIndex(2);

        Assert.assertTrue(driver.findElement(By.cssSelector(".category-products > .toolbar option[value*='price']"))
                .getAttribute("selected").contains("true"));
    }



}
