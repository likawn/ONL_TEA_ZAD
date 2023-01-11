package mystore02;

import mystore.*;
import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class myStorePurchaseTest {

    private WebDriver driver;

    @Before
    public void setup(){
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver =new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://mystore-testlab.coderslab.pl/");

    }

    @Test
    public void shouldDiscountEquals20() {
        MainPage mainPage = new MainPage(driver);
        mainPage.goToLoginPage();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("lidia.testerska@test.test", "Aa123456");
        YourAccountPage yourAccountPage = new YourAccountPage(driver);
        yourAccountPage.goBackToMainPage();
        mainPage.goToHummingBirdSweaterOffer();
        SweaterOfferPage sweaterOfferPage = new SweaterOfferPage(driver);
        Assert.assertEquals("-20%", sweaterOfferPage.getDiscountAmount());
    }

    @Test
    public void shouldPurchase(){
        MainPage mainPage = new MainPage(driver);
        mainPage.goToLoginPage();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("lidia.testerska@test.test", "Aa123456");
        YourAccountPage yourAccountPage = new YourAccountPage(driver);
        yourAccountPage.goBackToMainPage();
        mainPage.goToHummingBirdSweaterOffer();
        SweaterOfferPage sweaterOfferPage = new SweaterOfferPage(driver);
        sweaterOfferPage.chooseSize("M");
        sweaterOfferPage.chooseQuantity("5");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        Assert.assertTrue(sweaterOfferPage.checkIfAlertTextIsCorrect());
        sweaterOfferPage.goToCart();
        CartPage cartPage=new CartPage(driver);
        cartPage.goToOrderForm();
        OrderFormPage orderFormPage=new OrderFormPage(driver);
        orderFormPage.confirmAddress();
        orderFormPage.confirmDeliveryMethod();
        orderFormPage.checkPayByCheckOption();
        orderFormPage.acceptTermsAndCondition();
        orderFormPage.confirmOrder();
        OrderConfirmationPage orderConfirmationPage=new OrderConfirmationPage(driver);
        Assert.assertTrue(orderConfirmationPage.checkIfConfirmationTextIsCorrect());

    }

    @After
    public void tearDown() throws IOException {
        File scrFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File("C:\\Users\\lidia\\Projekty\\Screenshots\\ss.jpg"));
        driver.quit();
        }



}
