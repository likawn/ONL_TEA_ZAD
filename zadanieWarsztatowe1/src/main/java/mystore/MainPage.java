package mystore;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {
    private WebDriver driver;

    public MainPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);

    }

    @FindBy(xpath = "//div/a[@href='https://mystore-testlab.coderslab.pl/index.php?controller=my-account']")
    private WebElement signInButton;

    @FindBy(xpath = "//*[contains(text(), 'Hummingbird printed sweater')]")
    private WebElement hummingbirdSweaterTile;

    public void goToLoginPage(){
        signInButton.click();
    }

    public void goToHummingBirdSweaterOffer(){
        hummingbirdSweaterTile.click();
    }

}
