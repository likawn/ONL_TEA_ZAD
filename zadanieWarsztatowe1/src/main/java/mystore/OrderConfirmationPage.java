package mystore;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderConfirmationPage {
    private WebDriver driver;

    public OrderConfirmationPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//section[@id='content-hook_order_confirmation']//h3[contains(@class, 'card-title')]")
    private WebElement confirmationAlert;


    public String getConfirmationText(){
        return confirmationAlert.getText();
    }

    public boolean checkIfConfirmationTextIsCorrect(){
        return(getConfirmationText().contains("YOUR ORDER IS CONFIRMED"));
    }
}
