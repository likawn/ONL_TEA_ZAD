package mystore.steps;


import io.cucumber.java.en.And;
import mystore.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;


public class myStoreSteps {
    private WebDriver driver;

    @Given("an open browser on page {string}")
    public void openBrowser(String url){
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);
    }

    @And("user logged into account with {} and {}")
    public void logIntoMyStore(String email, String password){
        MainPage mainPage =new MainPage(driver);
        mainPage.goToLoginPage();
        LoginPage loginPage= new LoginPage(driver);
        loginPage.login(email, password);
    }
    @When("user adds new address: {}, {}, {}, {}, {}")
    public void addingNewAddress(String alias, String address, String city, String zipCode, String phoneNr){
        YourAccountPage yourAccountPage=new YourAccountPage(driver);
        yourAccountPage.goToAddressesPage();
        AddressesPage addressesPage=new AddressesPage(driver);
        addressesPage.goToNewAddressFormPage();
        NewAddressPage newAddressPage= new NewAddressPage(driver);
        newAddressPage.fillAndSaveNewAddressForm(alias, address, city, zipCode, phoneNr);
    }
    @Then("message about successful adding address is displayed")
    public void shouldAddingNewAddressBeSuccessfull(){
        AddressesPage addressesPage= new AddressesPage(driver);
        assertEquals("Address successfully added!", addressesPage.getAlertText());
    }

    @And("added address {}, {}, {}, {}, {} is displayed correctly")
    public void checkIfAddressAddedCorrectly(String alias, String address, String city, String zipCode, String phoneNr){
        AddressesPage addressesPage=new AddressesPage(driver);
        String addressToCheck= addressesPage.getAddedAddressText();
        Assert.assertTrue(addressToCheck.contains(alias) & addressToCheck.contains(address) & addressToCheck.contains(city) & addressToCheck.contains(zipCode) & addressToCheck.contains(phoneNr));
    }

    @And("user deletes added address")
    public void deleteAddedAddress(){
        AddressesPage addressesPage= new AddressesPage(driver);
        addressesPage.deleteLastAddress();
    }

    @Then("message about successful deleting address is displayed")
    public void checkIfMessageAboutSuccesfullDeletingIsDisplayed(){
        AddressesPage addressesPage = new AddressesPage(driver);
        assertEquals("Address successfully deleted!", addressesPage.getAlertText());

    }

    @Then("deleted address with {}, {}, {}, {}, {} is not displayed")
    public void checkIfDeletedAddressIsNotDisplayed(String alias, String address, String city, String zipCode, String phoneNr){
        AddressesPage addressesPage=new AddressesPage(driver);
        String addressToCheck= addressesPage.getAddedAddressText();
        Assert.assertFalse(addressToCheck.contains(alias) & addressToCheck.contains(address) & addressToCheck.contains(city) & addressToCheck.contains(zipCode) & addressToCheck.contains(phoneNr));

    }
    @And("user has added address")
    public void checkIfUserAddressesArePreparedForTest(){
        YourAccountPage yourAccountPage=new YourAccountPage(driver);
        yourAccountPage.goToAddressesPage();
        AddressesPage addressesPage=new AddressesPage(driver);
        try{
            boolean nrOfAddressesIsEnough = addressesPage.getNrOfAddresses() <= 1;
            }
        catch (Exception e){
            System.out.println("Test Data is not prepared for test");
        }
        Assert.assertTrue(addressesPage.getNrOfAddresses()>1);
    }

    @And("close the browser")
    public void closeBrowser(){
        driver.close();
    }


}
