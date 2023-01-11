package mystore;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class SweaterOfferPage {
    private WebDriver driver;

    public SweaterOfferPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//li[contains(@class, 'product-flag')]")
    private WebElement discountFlag;

    @FindBy(id = "group_1")
    private WebElement dropDownSize;

    @FindBy(id="quantity_wanted")
    private WebElement quantityInput;

    @FindBy(xpath = "//button[contains(@class, 'add')]")
    private WebElement addToCartButton;

    @FindBy(xpath = "//div[contains(@class, 'modal-header')]")
    private WebElement modalAlert;

    @FindBy(xpath = "//a[contains(text(), 'Proceed')]")
    private WebElement proceedToCheckout;

    public String getDiscountAmount(){
        return discountFlag.getText();
    }

    public void chooseSize(String size){
        dropDownSize.click();
        List<WebElement> sizeOptions=driver.findElements(By.xpath("//*[contains(@class, 'form-control-select')]/option"));
        switch (size){
            case "S":
                sizeOptions.get(0).click();
                break;
            case "M":
                sizeOptions.get(1).click();
                break;
            case "L":
                sizeOptions.get(2).click();
                break;
            case "XL":
                sizeOptions.get(3).click();
        }
    }

    public void chooseQuantity(String quantity){
        quantityInput.clear();
        quantityInput.sendKeys(quantity);
        quantityInput.sendKeys(Keys.ENTER);
    }

//    public void addProductToCart(){
//        WebElement addToCartButton1=driver.findElement(By.xpath("//button[contains(@class, 'add')]"));
//        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
//        wait.until(ExpectedConditions.elementToBeClickable(addToCartButton1));
//        addToCartButton1.click();
//    }

    public String getAlertText(){
        WebElement continueShoppingButton=driver.findElement(By.xpath("//div[contains(@class, 'cart-content-btn')]/button"));
        WebElement modalAlert1=driver.findElement(By.id("myModalLabel"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(continueShoppingButton));
        wait.until(ExpectedConditions.visibilityOf(modalAlert1));
        return modalAlert1.getText();
    }

    public boolean checkIfAlertTextIsCorrect(){
        return(getAlertText().contains("Product successfully added to your shopping cart"));
    }

    public void goToCart(){
        proceedToCheckout.click();
    }

}
