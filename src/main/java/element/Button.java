package element;

import org.openqa.selenium.By;

public class Button extends BaseElement {

    public Button(By locator) {
        super(locator);
    }

    public void click(){
        waitUntilClickable().click();
    }
}
