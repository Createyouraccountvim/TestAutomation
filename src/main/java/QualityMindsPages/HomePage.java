package QualityMindsPages;

import driver.BaseDriver;
import element.Button;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    private WebDriver driver = BaseDriver.getDriver();

    private Button kontakt;
    private Button kontaktAnfahrt;
    private Button portfolio;
    private Button portfolioSubmenuWAandMobile;

    public HomePage() {
        kontakt = new Button(By.xpath("(//a[text()='Kontakt'])[1]"));
        kontaktAnfahrt = new Button(By.xpath("//a[text()='Kontakt & Anfahrt']"));
        portfolio = new Button(By.xpath("(//a[text()='Portfolio'])[1]"));
        portfolioSubmenuWAandMobile = new Button(By.xpath("(//*[text()='Web, Automation & Mobile Testing'])[1]"));
    }

    public HomePage openHomePage() {
        driver.get("https://qualityminds.de");
        return this;
    }

    public KontaktPage clickKontakt() {
        kontakt.click();
        return new KontaktPage();
    }

    public KontaktPage clicKontaktAnfahrt() {
        kontaktAnfahrt.click();
        return new KontaktPage();
    }

    public void hoverPortfolio() {
        portfolio.hover();
    }

    public TeamPageWamTestingPage clickPortfolioSubmenuWAandMobile() {
        portfolioSubmenuWAandMobile.click();
        return new TeamPageWamTestingPage();
    }
}