package mystore;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AddressesPage {

    private WebDriver driver;

    public AddressesPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath="//a[@href='https://mystore-testlab.coderslab.pl/index.php?controller=address']")
    private WebElement createNewAddress;

    @FindBy(className = "alert-success")
    private WebElement alertAboutSuccess;

    public void goToNewAddressFormPage(){
        createNewAddress.click();
    }

    public boolean isAlertAboutSuccessDisplayed(){
        return alertAboutSuccess.isDisplayed();
    }

    public String getAlertText(){
        return alertAboutSuccess.getText();
    }

    public String getAddedAddressText(){
        List<WebElement> addedAddresses = driver.findElements(By.xpath("//div[@class='address-body']"));
        String lastAddedAddress = addedAddresses.get(addedAddresses.size()-1).getText();
        return lastAddedAddress;
    }

    public void deleteLastAddress(){
        List<WebElement> deleteButtons=driver.findElements(By.xpath("//a[contains(@href, 'delete=1')]"));
        deleteButtons.get(deleteButtons.size()-1).click();
    }

    public int getNrOfAddresses(){
        List<WebElement> addedAddresses = driver.findElements(By.xpath("//div[@class='address-body']"));
        return(addedAddresses.size());
    }

}
