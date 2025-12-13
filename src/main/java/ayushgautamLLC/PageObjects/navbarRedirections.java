package ayushgautamLLC.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class navbarRedirections {

    WebDriver driver;

    public navbarRedirections(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath="//div[normalize-space()='Mobile']")
    WebElement mobile;

    @FindBy(xpath="//a[@href='/jiohome/']")
    WebElement home;

    @FindBy(xpath="//a[@href='/business/']")
    WebElement business;

    @FindBy(xpath="//a[@href='/help/home/']")
    WebElement support;

    public void clickMobile() { mobile.click(); }

    public void clickHome() { home.click(); }

    public void clickBusiness() { business.click(); }

    public void clickSupport() { support.click(); }

    public String getTitle() { return driver.getTitle(); }
}
