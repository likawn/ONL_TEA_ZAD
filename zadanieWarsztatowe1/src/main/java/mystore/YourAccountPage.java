package mystore;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class YourAccountPage {
    private WebDriver driver;

    public YourAccountPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@class='account']")
    private WebElement myCustomerAccountButton;
    @FindBy(id="addresses-link")
    private WebElement addressesButton;

    @FindBy(id="_desktop_logo")
    private WebElement logoButton;

    public boolean checkIfSuccessfullLogin(){
        return myCustomerAccountButton.isDisplayed();
    }

    public void goToAddressesPage(){
        addressesButton.click();
    }

    public void goBackToMainPage(){
        logoButton.click();
    }


}
