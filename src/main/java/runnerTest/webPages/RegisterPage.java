package runnerTest.webPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilis.BasePage;

public class RegisterPage extends ElementUtil{

By clickApi = By.xpath("//a[contains(text(),'Dark Sky API')]");
By logBtn = By.xpath("//a[text()='Log In']");
By userName = By.xpath("//input[@id='email']");
By password= By.id("password");
By submitBtn = By.xpath("//button[@type='submit']");
By errorMessage= By.xpath("//div[contains(text(),'Username and password do not match')]");
//WebDriverWait wait = new WebDriverWait(BasePage.get(), 15);


public void clickAPIAndLogin() throws InterruptedException {
   Thread.sleep(5000);
    clickOn(clickApi);
    Thread.sleep(5000);
    clickOn(logBtn);
}



public void enterUserName(String user){
    sendValue(userName,user);

}

public void enterPassword(String pass){
        sendValue(password,pass);

    }

public void clickSubmitBtn(){

    clickOn(submitBtn);
}

public String errorMessage(){
    return getTextFromElement(errorMessage);
}

}
