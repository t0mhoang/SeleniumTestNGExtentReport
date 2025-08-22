package Tests;

import Pages.HomePage;
import Pages.ProductsPage;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.apache.commons.io.FileUtils;
import java.io.File;
import java.io.IOException;

public class SeleniumTest {

    public static WebDriver driver;

    static ExtentReports report;
    public static ExtentTest test;
    static ExtentReports extent = new ExtentReports();


    @BeforeSuite
    public static void Setup() throws InterruptedException {
        driver = new ChromeDriver();
        driver.get("https://anupdamoda.github.io/AceOnlineShoePortal/index.html");
        ExtentSparkReporter spark = new ExtentSparkReporter("target/spark.html");
        extent.attachReporter(spark);
        HomePage.click_hambuger_menu();
        Thread.sleep(2000);
        HomePage.click_onlineProducts_link();
    }

    public static String capture(WebDriver driver) throws IOException {
        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File Dest = new File("src/main/resources/ExecImages/" + System.currentTimeMillis() +".png");
        String errfilepath = Dest.getAbsolutePath();
        FileUtils.copyFile(srcFile, Dest);
        return errfilepath;
    }
    public static String captureElementOnly(WebDriver driver, By locator) throws IOException {
        WebElement element = driver.findElement(locator);
        File srcFile = element.getScreenshotAs(OutputType.FILE);
        File destFile = new File("src/main/resources/ExecImages/" + System.currentTimeMillis() + ".png");
        FileUtils.copyFile(srcFile, destFile);
        return destFile.getAbsolutePath();
    }


    @Test
    void validateTitles_OnlineProducts() throws IOException, InterruptedException {
        test = extent.createTest("Validate Shoe Titles on Products Page", "This test validates that the different ShoeTypes are Correct in Online Products Page");
        ProductsPage.formalShoes_verifyTitle(); //Negative Test
        ProductsPage.sportsShoes_verifyTitle();
        ProductsPage.sneakers_verifyTitle();
        extent.flush();
    }

    @Test
    void validateFirstFormalShoes() {
        test = extent.createTest("Validate First Formal ShoeName", "This test validates first formal shoes on Products Page");
        ProductsPage.formalShoes_firstShoe_verify();
    }

    @Test
    void validateFirstSportsShoe() {
        test = extent.createTest("Validate First Sports ShoeName", "This test validates first sports shoes on Products Page");
        ProductsPage.sportsShoes_firstShoe_verify();
    }

    @AfterSuite
    public static void cleanup(){
        extent.flush();
    }
}
