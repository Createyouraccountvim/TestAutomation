package tests;

import QualityMindsPages.HomePage;
import QualityMindsPages.TeamPageWamTestingPage;
import api.ApiBase;
import driver.BaseDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import testBase.BaseTest;

import java.io.IOException;


public class Suite1 extends BaseTest {

    private final String expectedEmail = "hello@qualityminds.de";
    private final String expectedHref = "https://qualityminds.de/app/uploads/2018/11/Find-The-Mobile-Bug-Session.pdf";

    @Test
    void tc1() {
        HomePage homePage = new HomePage();
        Assert.assertTrue(homePage.openHomePage().clickKontakt().isEmailAdressFound(expectedEmail), "Email not found in source");
        String urlAfterClickKontakt = BaseDriver.getDriver().getCurrentUrl();
        BaseDriver.getDriver().navigate().back();
        homePage.clicKontaktAnfahrt();
        String urlAfterClickKontaktAnfahrt = BaseDriver.getDriver().getCurrentUrl();
        Assert.assertEquals(urlAfterClickKontakt, urlAfterClickKontaktAnfahrt, "Pages are not the same");
    }

    @Test
    void tc2() {
        HomePage homePage2 = new HomePage();
        homePage2.openHomePage().hoverPortfolio();
        TeamPageWamTestingPage teamWamTestingPage = homePage2.clickPortfolioSubmenuWAandMobile();
        Assert.assertTrue(teamWamTestingPage.isPortfolioHighlighted(), "Portfoilio is NOT highlighted");
        teamWamTestingPage.clickMobileTab();
        Assert.assertEquals(teamWamTestingPage.getHrefFromFlyerButton(), expectedHref, "Download link is wrong");
    }

    @Test
    void checkResponseCodeWhenPdfDownloading() throws IOException {
        int expectedStatusCode = 200;
        Assert.assertEquals(ApiBase.checkGetStatusCode(expectedHref), expectedStatusCode, "Wrong status code");
    }
}

