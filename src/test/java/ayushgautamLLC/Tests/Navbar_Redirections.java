package ayushgautamLLC.Tests;

import org.testng.Assert;

import org.testng.annotations.Test;

import ayushgautamLLC.Base.BaseTest;
import ayushgautamLLC.PageObjects.navbarRedirections;

public class Navbar_Redirections extends BaseTest {

    @Test
    public void verifyNavbarLinks() {

        navbarRedirections nav = new navbarRedirections(driver);

        // MOBILE
        nav.clickMobile();
        Assert.assertTrue(nav.getTitle().contains("Mobile"));
        driver.navigate().back();

        // HOME
        nav.clickHome();
        Assert.assertTrue(nav.getTitle().contains("JioHome"));
        driver.navigate().back();

        // BUSINESS
        nav.clickBusiness();
        Assert.assertTrue(nav.getTitle().contains("Business"));
        driver.navigate().back();

        // SUPPORT
        nav.clickSupport();
        Assert.assertTrue(nav.getTitle().contains("Support"));
        driver.navigate().back();
    }
}
