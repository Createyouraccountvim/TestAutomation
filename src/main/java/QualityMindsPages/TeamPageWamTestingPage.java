package QualityMindsPages;

import element.Button;
import org.openqa.selenium.By;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class TeamPageWamTestingPage {

    private Button portfolio;
    private Button mobileTab;
    private Button flyerFindTheBugSession;
    private final String urlFlyerPdfDownload = "https://qualityminds.de/app/uploads/2018/11/Find-The-Mobile-Bug-Session.pdf";

    public TeamPageWamTestingPage() {
        portfolio = new Button(By.xpath("//*[@id='top-menu']//*[contains(@class,'current-menu-ancestor')]//a[text()='Portfolio']"));
        mobileTab = new Button(By.xpath("//*[@id='team-tab-three-title-desktop']"));
        flyerFindTheBugSession = new Button(By.xpath("//*[text()='Flyer Find the Bug Session']"));
    }

    public boolean isPortfolioHighlighted() {
        return portfolio.isDisplayed();
    }

    public void clickMobileTab() {
        mobileTab.click();
    }

    public String getHrefFromFlyerButton() {
        return flyerFindTheBugSession.getAttribute("href");
    }

}
