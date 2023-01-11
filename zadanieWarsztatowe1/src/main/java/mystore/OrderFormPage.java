package mystore;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OrderFormPage {
    private WebDriver driver;

    public OrderFormPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[contains(@name, 'confirm')]")
    private WebElement confirmAddressButton;

    @FindBy(xpath = "//button[contains(@name, 'confirmDeliveryOption')]")
    private WebElement confirmDeliveryMethodButton;

    @FindBy(xpath="//div[@id='payment-option-1-container']/span")
    private WebElement payByCheckOption;

    @FindBy(id = "conditions_to_approve[terms-and-conditions]")
    private WebElement termsAndConditionsCheckbox;

    @FindBy(xpath = "//button[contains(text(), 'Place')]")
    private WebElement placeOrderButton;

    public void confirmAddress(){
        confirmAddressButton.click();
    }

    public void confirmDeliveryMethod(){
        confirmDeliveryMethodButton.click();
    }

    public void checkPayByCheckOption(){
        payByCheckOption.click();
        }

    public void acceptTermsAndCondition(){
        termsAndConditionsCheckbox.click();
    }

    public void confirmOrder(){
        placeOrderButton.click();
    }


}
