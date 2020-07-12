import org.junit.Assert;
import Utils.BaseDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Project11 extends BaseDriver {
    public static void main(String[] args) throws InterruptedException {
//        Navigate to website http://a.testaddressbook.com/sign_in
        driver.get("http://a.testaddressbook.com/sign_in");

//        Enter the username and password
        WebElement userNameInput = driver.findElement(By.id("session_email"));
        userNameInput.sendKeys("sharifzodah@gmail.com");

        WebElement passwordInput = driver.findElement(By.id("session_password"));
        passwordInput.sendKeys("Qwertyu2020@@##");

//        Click on sign in button
        WebElement signInpButton = driver.findElement(By.cssSelector("input[name='commit']"));
        signInpButton.click();

//        Click on Addresses
        WebElement addressesLink = driver.findElement(By.linkText("Addresses"));
        addressesLink.click();

//        Click on new address button
        Thread.sleep(1000);
        WebElement newAddress = driver.findElement(By.linkText("New Address"));
        newAddress.click();

//        Enter the first name "Fernando"
        Thread.sleep(1000);
        WebElement firstNameInput = driver.findElement(By.cssSelector("input[id='address_first_name']"));
        firstNameInput.sendKeys("Fernando");

//         Enter the last name  "Torres"
//        Thread.sleep(2000);
        WebElement lastNameInput = driver.findElement(By.cssSelector("input[id='address_last_name']"));
        lastNameInput.sendKeys("Torres");

//        Enter the address 1 "Anfield Rd"
        WebElement address1 = driver.findElement(By.cssSelector("input[id='address_street_address']"));
        address1.sendKeys("Anfield Rd");
//        Enter the address 2 "Anfield"
        WebElement address2 = driver.findElement(By.cssSelector("input[id='address_secondary_address']"));
        address2.sendKeys("Anfield");
//        Enter the city "Liverpool"
        WebElement city_address = driver.findElement(By.cssSelector("input[id='address_city']"));
        city_address.sendKeys("Liverpool");

//        Choose the random option from the state dropdown
        WebElement state_address = driver.findElement(By.cssSelector("select[id='address_state']"));
        Select selectState = new Select(state_address);
        List<WebElement>listOfStates = selectState.getOptions();
        Random rnd = new Random();
        int randomIndex = rnd.nextInt(listOfStates.size());
        selectState.selectByIndex(randomIndex);

//        Enter the Zipcode "L4 0TH"
        WebElement zipCode = driver.findElement(By.cssSelector("input[id='address_zip_code']"));
        zipCode.sendKeys("L4 0TH");

//        Click on United States
        WebElement countryRadio = driver.findElement(By.cssSelector("input[id='address_country_us']"));
        countryRadio.click();

//        Enter the birthday "03/20/1984"
        WebElement birthDate = driver.findElement(By.cssSelector("input[id='address_birthday']"));
        birthDate.sendKeys("03/20/1984");

//        Enter the age "36"
        WebElement ageInput = driver.findElement(By.cssSelector("input[id='address_age']"));
        ageInput.sendKeys("36");

//        Enter the WebSite "https://www.google.com/"
        WebElement webSiteInput = driver.findElement(By.cssSelector("input[id='address_website']"));
        webSiteInput.sendKeys("https://www.google.com/");

//        Enter the phone "8625747878"
        WebElement phoneInput = driver.findElement(By.cssSelector("input[id='address_phone']"));
        phoneInput.sendKeys("8625747878");

//        Click on Climbing and Dancing
        driver.findElement(By.cssSelector("input[id='address_interest_climb']")).click();
        driver.findElement(By.cssSelector("input[id='address_interest_dance']")).click();

//        Enter the Note "Never Back Down"
        WebElement noteInput = driver.findElement(By.cssSelector("textarea[id='address_note']"));
        noteInput.sendKeys("Never Back Down");

//        Click on Create Address button
        WebElement createAddressButton = driver.findElement(By.name("commit"));
        createAddressButton.click();

//        Verify the first name as "Fernando"
         String actualInput = driver.findElement(By.cssSelector("span[data-test='first_name']")).getText();
        Assert.assertEquals("Fernando", actualInput);

//        Verify the last name as "Torres"
        actualInput = driver.findElement(By.cssSelector("span[data-test='last_name']")).getText();
        Assert.assertEquals("Torres", actualInput);

//        Click on Edit button
        driver.findElement(By.cssSelector("a[data-test='edit']")).click();
        Thread.sleep(1000);

//        Change the first name as "Peter"
        WebElement newFirstName = driver.findElement(By.cssSelector("input[id='address_first_name']"));
        newFirstName.clear();
        newFirstName.sendKeys("Peter");

//        Change the last name as "Crouch"
        WebElement newLastName = driver.findElement(By.cssSelector("input[id='address_last_name']"));
        newLastName.clear();
        newLastName.sendKeys("Crouch");

//        Click on Update address
        driver.findElement(By.cssSelector("input[value='Update Address']")).click();
        Thread.sleep(1000);

//        Verify the first name as "Peter"
        actualInput = driver.findElement(By.cssSelector("span[data-test='first_name']")).getText();
        Assert.assertEquals("Peter", actualInput);
//        Verify the last name as "Crouch"
        actualInput = driver.findElement(By.cssSelector("span[data-test='last_name']")).getText();
        Assert.assertEquals("Crouch", actualInput);

//        Click on Addresses
        driver.findElement(By.linkText("Addresses")).click();
        Thread.sleep(1000);

//        Click on Destroy
        WebElement destroyLink = driver.findElement(By.linkText("Destroy"));
        destroyLink.click();

//        Address should be removed
        driver.switchTo().alert().accept();

    }
}
