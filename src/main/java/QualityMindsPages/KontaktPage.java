package QualityMindsPages;

import driver.BaseDriver;

public class KontaktPage {


    public boolean isEmailAdressFound(String emailAdress) {
        return BaseDriver.getDriver().getPageSource().contains(emailAdress) == true ? true : false;
    }


}
