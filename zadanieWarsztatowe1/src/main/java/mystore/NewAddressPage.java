package mystore;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewAddressPage {
    private WebDriver driver;

    public NewAddressPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id="field-alias")
    private WebElement aliasInput;

    @FindBy(id="field-address1")
    private WebElement addressInput;

    @FindBy(id="field-city")
    private WebElement cityInput;

    @FindBy(id="field-postcode")
    private WebElement zipCodeInput;

    @FindBy(id="field-phone")
    private WebElement phoneInput;

    @FindBy(xpath = "//button[contains(@class, 'form-control-submit')]")
    private WebElement saveButton;

    public void fillAndSaveNewAddressForm(String alias, String address, String city, String zipCode, String phoneNr){
        aliasInput.sendKeys(alias);
        addressInput.sendKeys(address);
        cityInput.sendKeys(city);
        zipCodeInput.sendKeys(zipCode);
        phoneInput.sendKeys(phoneNr);
        saveButton.click();
    }
}
