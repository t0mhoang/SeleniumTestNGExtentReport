package Pages;

import Tests.SeleniumTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.testng.Assert;

import java.io.IOException;

import static Tests.SeleniumTest.driver;
import static Tests.SeleniumTest.*;

public class ProductsPage {

    public static String formalShoes_xpath = "/html/body/div[2]/center/h2";
    public static String sportShoes_xpath = "/html/body/div[3]/center/h2";
    public static String sneakers_xpath = "/html/body/div[4]/center/h2";

    public static String formalShoesdropdown_xpath = "/html/body/div[2]/center/div/i[1]";
    public static String sportShoesdropdown_xpath = "/html/body/div[3]/center/div/i[1]";
    public static String sneakersdropdown_xpath = "/html/body/div[4]/center/div/i[1]";

    public static String formalShoes_firstShoeName = "/html/body/div[2]/table/tbody/tr[1]/td[1]";
    public static String sportsShoes_firstShoeName = "/html/body/div[3]/table/tbody/tr[1]/td[1]";
    public static String sneakers_firstShoeName = "/html/body/div[4]/table/tbody/tr[1]/td[1]";
//Title Methods
//    public static void formalShoes_verifyTitle(){   //THIS IS FAIL SAFE METHOD FOR EXTENT REPORTS, SINCE ASSERT IS ABOVE IF/ELSE
//        String expectedTitleFS = "Formal ShoesPurposelyPutThisHereToFailThisTestAddedElseToIfStatement";
//        String actualTitleFS = driver.findElement(By.xpath(formalShoes_xpath)).getText();
//        Assert.assertEquals(actualTitleFS, expectedTitleFS, "Formal Shoes NOT Found!");
//        if(expectedTitleFS.equals(actualTitleFS)){
//            test.log(Status.PASS, "Test passed for title verification of Formal Shoes");
//        } else {
//            test.log(Status.FAIL, "Test failed for title verification of Formal Shoes");
//        }
//    }
//public static void formalShoes_verifyTitle() throws IOException { //Fail Safe in console, capture fail in ExtentReport
//    String expectedTitleFS = "Formal ShoesPurposelyPutThisHereToFailThisTestAddedElseToIfStatement";
//    String actualTitleFS = driver.findElement(By.xpath(formalShoes_xpath)).getText();
//    if (expectedTitleFS.equals(actualTitleFS)) {
//        test.pass("Test passed for title verification of Formal Shoes",
//                MediaEntityBuilder.createScreenCaptureFromPath(capture(driver)).build());
//    } else {
//        test.fail("Test failed for title verification of Formal Shoes. Expected: "
//                        + expectedTitleFS + " but got: " + actualTitleFS,
//                MediaEntityBuilder.createScreenCaptureFromPath(capture(driver)).build());
//    }
//}
public static void formalShoes_verifyTitle() throws IOException {
    String expectedTitleFS = "Formal ShoesPurposelyPutThisHereToFailThisTestAddedElseToIfStatement";
    String actualTitleFS = driver.findElement(By.xpath(formalShoes_xpath)).getText();
    if (expectedTitleFS.equals(actualTitleFS)) {
        test.pass("Test passed for Formal Shoes", MediaEntityBuilder.createScreenCaptureFromPath(SeleniumTest.capture(driver)).build());
    } else {
//        test.fail("Test failed for Formal Shoes. Expected: " + expectedTitleFS + " but got: " + actualTitleFS, MediaEntityBuilder.createScreenCaptureFromPath(SeleniumTest.capture(driver)).build());
        test.fail("Test failed for Formal Shoes", MediaEntityBuilder.createScreenCaptureFromPath(SeleniumTest.captureElementOnly(driver, By.xpath(formalShoes_xpath))
                ).build());

        //Force TestNG to mark test as FAIL
        throw new AssertionError("Formal Shoes title mismatch. Expected: " + expectedTitleFS + " but got: " + actualTitleFS);
    }
}

//public static void formalShoes_verifyTitle() {
//    String expectedTitleFS = "Formal ShoesPurposelyPutThisHereToFailThisTestAddedElseToIfStatement";
//    String actualTitleFS = driver.findElement(By.xpath(formalShoes_xpath)).getText();
//
//    try {
//        Assert.assertEquals(actualTitleFS, expectedTitleFS, "Formal Shoes NOT Found!");
//        test.log(Status.PASS, "Test passed for title verification of Formal Shoes");
//    } catch (AssertionError e) {
//        test.log(Status.FAIL, "Test failed for title verification of Formal Shoes. Expected: "
//                + expectedTitleFS + " but got: " + actualTitleFS);
//        throw e; // rethrow so TestNG still marks test as failed
//    }
//}





    public static void sportsShoes_verifyTitle(){
        String expectedTitleSS = "Sports Shoes";
        String actualTitleSS = driver.findElement(By.xpath(sportShoes_xpath)).getText();
        Assert.assertEquals(actualTitleSS, expectedTitleSS, "Sports Shoes NOT Found!");
        if(expectedTitleSS.equals(actualTitleSS)){
            test.log(Status.PASS, "Test passed for title verification of Sports Shoes");
        }
    }
    public static void sneakers_verifyTitle(){
        String expectedTitleS = "Sneakers";
        String actualTitleS = driver.findElement(By.xpath(sneakers_xpath)).getText();
        Assert.assertEquals(actualTitleS, expectedTitleS, "Sneakers NOT Found!");
        if(expectedTitleS.equals(actualTitleS)){
            test.log(Status.PASS, "Test passed for title verificaton of Sneakers");
        }
    }

//DropDown methods
    public static void formalShoes_firstShoe_verify(){
        String expectedFirstFormalShoe = "   Classic Cheltenham";
        driver.findElement(By.xpath(formalShoesdropdown_xpath)).click();
        String actualFirstFormalShoe = driver.findElement(By.xpath(formalShoes_firstShoeName)).getText();
        Assert.assertEquals(actualFirstFormalShoe, expectedFirstFormalShoe);
        if(expectedFirstFormalShoe.equals(actualFirstFormalShoe)){
            test.log(Status.PASS, "Test passed for first shoe name of Formal Shoe i.e Classic Cheltenham");
        }

    }
    public static void sportsShoes_firstShoe_verify(){
        String expectedFirstSportsShoe = "   Ultimate";
        driver.findElement(By.xpath(sportShoesdropdown_xpath)).click();
        String actualFirstSportsShoe = driver.findElement(By.xpath(sportsShoes_firstShoeName)).getText();
        Assert.assertEquals(actualFirstSportsShoe, expectedFirstSportsShoe);
        if(expectedFirstSportsShoe.equals(actualFirstSportsShoe)){
            test.log(Status.PASS, "Test passed for first shoe name of Sports Shoe i.e Ultimate");
        }
    }
    public static void sneakers_firstShoe_verify(){
        String expectedFirstSneakers = "   Archivo";
        driver.findElement(By.xpath(sneakersdropdown_xpath)).click();
        String actualFirstSneaker = driver.findElement(By.xpath(sneakers_firstShoeName)).getText();
        Assert.assertEquals(actualFirstSneaker, expectedFirstSneakers);
        if(expectedFirstSneakers.equals(actualFirstSneaker)){
            test.log(Status.PASS, "Test passed for first shoe name of Sneakers i.e Archivo");
        }
    }

}
